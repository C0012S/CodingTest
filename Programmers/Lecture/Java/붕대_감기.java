/*
PCCP 기출문제. #242258 - [PCCP 기출 1번] 1번, 붕대 감기

    문제 설명
        어떤 게임에는 붕대 감기라는 기술이 있습니다.
        붕대 감기는 t초 동안 붕대를 감으면서 1초마다 x만큼의 체력을 회복합니다. t초 연속으로 붕대를 감는 데 성공한다면 y만큼의 체력을 추가로 회복합니다. 게임 캐릭터에는 최대 체력이 존재해 현재 체력이 최대 체력보다 커지는 것은 불가능합니다.
        기술을 쓰는 도중 몬스터에게 공격을 당하면 기술이 취소되고, 공격을 당하는 순간에는 체력을 회복할 수 없습니다. 몬스터에게 공격당해 기술이 취소당하거나 기술이 끝나면 그 즉시 붕대 감기를 다시 사용하며, 연속 성공 시간이 0으로 초기화됩니다.
        몬스터의 공격을 받으면 정해진 피해량만큼 현재 체력이 줄어듭니다. 이때, 현재 체력이 0 이하가 되면 캐릭터가 죽으며 더 이상 체력을 회복할 수 없습니다.
        당신은 붕대감기 기술의 정보, 캐릭터가 가진 최대 체력과 몬스터의 공격 패턴이 주어질 때 캐릭터가 끝까지 생존할 수 있는지 궁금합니다.
        붕대 감기 기술의 시전 시간, 1초당 회복량, 추가 회복량을 담은 1차원 정수 배열 bandage와 최대 체력을 의미하는 정수 health, 몬스터의 공격 시간과 피해량을 담은 2차원 정수 배열 attacks가 매개변수로 주어집니다. 모든 공격이 끝난 직후 남은 체력을 return 하도록 solution 함수를 완성해 주세요. 만약 몬스터의 공격을 받고 캐릭터의 체력이 0 이하가 되어 죽는다면 -1을 return 해주세요.


    제한사항
        · bandage는 [시전 시간, 초당 회복량, 추가 회복량] 형태의 길이가 3인 정수 배열입니다.
            · 1 ≤ 시전 시간 = t ≤ 50
            · 1 ≤ 초당 회복량 = x ≤ 100
            · 1 ≤ 추가 회복량 = y ≤ 100
        · 1 ≤ health ≤ 1,000
        · 1 ≤ attacks의 길이 ≤ 100
            · attacks[i]는 [공격 시간, 피해량] 형태의 길이가 2인 정수 배열입니다.
            · attacks는 공격 시간을 기준으로 오름차순 정렬된 상태입니다.
            · attacks의 공격 시간은 모두 다릅니다.
            · 1 ≤ 공격 시간 ≤ 1,000
            · 1 ≤ 피해량 ≤ 100


    입출력 예
        bandage	    health	attacks	                                result
        [5, 1, 5]	30	    [[2, 10], [9, 15], [10, 5], [11, 5]]	5
        [3, 2, 7]	20	    [[1, 15], [5, 16], [8, 6]]	            -1
        [4, 2, 7]	20	    [[1, 15], [5, 16], [8, 6]]	            -1
        [1, 1, 1]	5	    [[1, 2], [3, 2]]	                    3


    입출력 예 설명
        입출력 예 #1
            몬스터의 마지막 공격은 11초에 이루어집니다. 0초부터 11초까지 캐릭터의 상태는 아래 표와 같습니다.
                시간	    현재 체력(변화량)	연속 성공	    공격	    설명
                0	    30	            0	        X	    초기 상태
                1	    30(+0)	        1	        X	    최대 체력 이상의 체력을 가질 수 없습니다.
                2	    20(-10)	        0	        O	    몬스터의 공격으로 연속 성공이 초기화됩니다.
                3	    21(+1)	        1	        X
                4	    22(+1)	        2	        X
                5	    23(+1)	        3	        X
                6	    24(+1)	        4	        X
                7	    30(+6)	        5 → 0	    X	    5초 연속 성공해 체력을 5만큼 추가 회복하고 연속 성공이 초기화됩니다.
                8	    30(+0)	        1	        X	    최대 체력 이상의 체력을 가질 수 없습니다.
                9	    15(-15)	        0	        O	    몬스터의 공격으로 연속 성공이 초기화됩니다.
                10	    10(-5)	        0	        O	    몬스터의 공격으로 연속 성공이 초기화됩니다.
                11	    5(-5)	        0	        O	    몬스터의 마지막 공격입니다.

            몬스터의 마지막 공격 직후 캐릭터의 체력은 5입니다. 따라서 5을 return 해야 합니다.

        입출력 예 #2
            몬스터의 마지막 공격은 8초에 이루어집니다. 0초부터 8초까지 캐릭터의 상태는 아래 표와 같습니다.
                시간	    현재 체력(변화량)	연속 성공	    공격	    설명
                0	    20	            0	        X	    초기 상태
                1	    5(-15)	        0	        O	    몬스터의 공격으로 연속 성공이 초기화됩니다.
                2	    7(+2)	        1	        X
                3	    9(+2)	        2	        X
                4	    18(+9)	        3 → 0	    X	    3초 연속 성공해 체력을 7만큼 추가 회복하고 연속 성공이 초기화됩니다.
                5	    2(-16)	        0	        O	    몬스터의 공격으로 연속 성공이 초기화됩니다.
                6	    4(+2)	        1	        X
                7	    6(+2)	        2	        X
                8	    0(-6)	        0	        O	    몬스터의 마지막 공격을 받아 캐릭터의 체력이 0 이하가 됩니다.

            몬스터의 공격을 받아 캐릭터의 체력이 0 이하가 됩니다. 따라서 -1을 return 해야 합니다.

        입출력 예 #3
            몬스터의 마지막 공격은 8초에 이루어집니다. 0초부터 5초까지 캐릭터의 상태는 아래 표와 같습니다.
                시간	    현재 체력(변화량)	연속 성공	    공격	    설명
                0	    20	            0	        X	    초기 상태
                1	    5(-15)	        0	        O	    몬스터의 공격으로 연속 성공이 초기화됩니다.
                2	    7(+2)	        1	        X
                3	    9(+2)	        2	        X
                4	    11(+2)	        3	        X
                5	    -5(-16)	        0	        O	    몬스터의 공격을 받아 캐릭터의 체력이 0 이하가 됩니다.

            몬스터의 공격을 받아 캐릭터의 체력이 0 이하가 됩니다. 따라서 -1을 return 해야 합니다.

        입출력 예 #4
            몬스터의 마지막 공격은 3초에 이루어집니다. 0초부터 3초까지 캐릭터의 상태는 아래 표와 같습니다.
                시간	    현재 체력(변화량)	연속 성공	    공격	    설명
                0	    5	            0	        X	    초기 상태
                1	    3(-2)	        0	        O	    몬스터의 공격으로 연속 성공이 초기화됩니다.
                2	    5(+2)	        1 → 0	    X	    1초 연속 성공해 체력을 1만큼 추가 회복하고 연속 성공이 초기화됩니다.
                3	    3(-2)	        0	        O	    몬스터의 마지막 공격입니다.

            몬스터의 마지막 공격 직후 캐릭터의 체력은 3입니다. 따라서 3을 return 해야 합니다.
*/


/*
    정확성  테스트
        테스트 1 〉통과 (0.02ms, 85.4MB)
        테스트 2 〉통과 (0.02ms, 81MB)
        테스트 3 〉통과 (0.02ms, 87.5MB)
        테스트 4 〉통과 (0.02ms, 83.1MB)
        테스트 5 〉통과 (0.02ms, 85MB)
        테스트 6 〉통과 (0.03ms, 72.2MB)
        테스트 7 〉통과 (0.03ms, 88.8MB)
        테스트 8 〉통과 (0.02ms, 79.7MB)
        테스트 9 〉통과 (0.03ms, 73.3MB)
        테스트 10 〉통과 (0.03ms, 81MB)
        테스트 11 〉통과 (0.04ms, 85.8MB)
        테스트 12 〉통과 (0.02ms, 75MB)
        테스트 13 〉통과 (0.05ms, 72MB)
        테스트 14 〉통과 (0.05ms, 88.1MB)
        테스트 15 〉통과 (0.03ms, 75.7MB)
        테스트 16 〉통과 (0.02ms, 80.1MB)
        테스트 17 〉통과 (0.04ms, 86.1MB)
        테스트 18 〉통과 (0.03ms, 76.3MB)
        테스트 19 〉통과 (0.03ms, 85.8MB)
        테스트 20 〉통과 (0.02ms, 88.6MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    int time; // 게임 시작 후, 지난 시간
    int HP; // 게임 캐릭터의 현재 체력
    int recoveryNum; // '붕대 감기' 연속 성공 시간

    public void recover(int[] bandage, int health, int second) { // 붕대 감기 메서드
        HP += (bandage[1] * second); // second 초 동안 '붕대 감기'
        recoveryNum += (1 * second); // second 번만큼 '붕대 감기' 연속 성공 시간 추가

        if (HP > health) { // 게임 캐릭터의 현재 체력이 최대 체력보다 클 경우
            HP = health;
        }

        if (recoveryNum >= bandage[0]) { // '붕대 감기' 연속 성공 시간이 '붕대 감기' 기술의 시전 시간 이상일 경우
            HP += (bandage[2] * (second / bandage[0])); // '붕대 감기' 기술의 추가 회복량만큼 체력 회복
            if (HP > health) { // 게임 캐릭터의 현재 체력이 최대 체력보다 클 경우
                HP = health;
            }

            recoveryNum = (second % bandage[0]); // '붕대 감기' 연속 성공 시간 갱신
        }
    }

    public void calculate(int[] bandage, int health, int[] attack) { // 몬스터의 공격에 따른 게임 캐릭터의 체력을 계산하는 메서드
        if (time == attack[0]) { // 현재 시간이 몬스터가 공격한 시간과 같을 경우
            HP -= attack[1]; // 몬스터의 공격 피해량만큼 체력 감소

            if (HP <= 0) { // 게임 캐릭터의 현재 체력이 0 이하가 되어 죽을 경우
                return;
            }

            recoveryNum = 0; // '붕대 감기' 연속 성공 시간 갱신
        }
        else {
            recover(bandage, health, (attack[0] - time - 1)); // (attack[0] - time - 1) 초 동안 체력 회복
            time = attack[0]; // 현재 시간 갱신
            calculate(bandage, health, attack); // 몬스터 공격 시간에서의 게임 캐릭터 체력 계산
        }
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        HP = health;

        for (int a = 0, attackNum = attacks.length; a < attackNum; a++) {
            calculate(bandage, health, attacks[a]);

            if (HP <= 0) { // 게임 캐릭터의 현재 체력이 0 이하가 되어 죽을 경우
                return -1;
            }
        }

        return HP;
    }
}