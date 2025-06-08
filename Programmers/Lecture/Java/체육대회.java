/*
PCCP 모의고사 1회. #121684 - [PCCP 모의고사 1] 2번, 체육대회

    문제 설명
        당신이 다니는 학교는 매년 체육대회를 합니다. 체육대회는 여러 종목에 대해 각 반의 해당 종목 대표가 1명씩 나와 대결을 하며, 한 학생은 최대 한개의 종목 대표만 할 수 있습니다. 당신의 반에서도 한 종목당 1명의 대표를 뽑으려고 합니다. 학생들마다 각 종목에 대한 능력이 다르지만 이 능력은 수치화되어 있어 미리 알 수 있습니다. 당신의 반의 전략은 각 종목 대표의 해당 종목에 대한 능력치의 합을 최대화하는 것입니다.

        다음은 당신의 반 학생이 5명이고, 종목의 개수가 3개이며, 각 종목에 대한 학생들의 능력치가 아래 표와 같을 때, 각 종목의 대표를 뽑는 예시입니다.
                    테니스	탁구	    수영
            석환	    40	    10	    10
            영재	    20	    5	    0
            인용	    30	    30	    30
            정현	    70	    0	    70
            준모	    100	    100	    100

        테니스 대표로 준모, 탁구 대표로 인용, 수영 대표로 정현을 뽑는다면, 세 명의 각 종목에 대한 능력치의 합은 200(=100+30+70)이 됩니다.
        하지만, 테니스 대표로 석환, 탁구 대표로 준모, 수영 대표로 정현을 뽑는다면 세 명의 각 종목에 대한 능력치 합은 210(=40+100+70)이 됩니다. 이 경우가 당신의 반의 각 종목 대표의 능력치 합이 최대가 되는 경우입니다.

        당신의 반 학생들의 각 종목에 대한 능력치를 나타내는 2차원 정수 배열 ability가 주어졌을 때, 선발된 대표들의 해당 종목에 대한 능력치 합의 최대값을 return 하는 solution 함수를 완성하시오.


    제한사항
        · 1 ≤ ability의 행의 길이 = 학생 수 ≤ 10
        · 1 ≤ ability의 열의 길이 = 종목 수 ≤ ability의 행의 길이
        · 0 ≤ ability[i][j] ≤ 10,000
            · ability[i][j]는 i+1번 학생의 j+1번 종목에 대한 능력치를 의미합니다.


    입출력 예
        ability	                                                                    result
        [[40, 10, 10], [20, 5, 0], [30, 30, 30], [70, 0, 70], [100, 100, 100]]	    210
        [[20, 30], [30, 20], [20, 30]]	                                            60


    입출력 예 설명
        입출력 예 #1
            · 문제 예시와 같습니다.

        입출력 예 #2
            · 1번 학생이 2번 종목을, 2번 학생이 1번 종목의 대표로 참가하는 경우에 대표들의 해당 종목에 대한 능력치의 합이 최대가 되며, 이는 60입니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (6.09ms, 89.7MB)
        테스트 2 〉	통과 (5.60ms, 82.9MB)
        테스트 3 〉	통과 (189.23ms, 80.1MB)
        테스트 4 〉	통과 (7.41ms, 76.6MB)
        테스트 5 〉	통과 (0.60ms, 81.6MB)
        테스트 6 〉	통과 (0.05ms, 76.7MB)
        테스트 7 〉	통과 (0.50ms, 84MB)
        테스트 8 〉	통과 (186.20ms, 89.8MB)
        테스트 9 〉	통과 (4.50ms, 84MB)
        테스트 10 〉	통과 (5.08ms, 88.9MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    int allNumber; // 반 학생들의 수
    int sportsNumber; // 체육대회 종목의 수
    boolean[] isSelected; // 각 학생의 체육대회 출전 여부를 저장하는 배열
    int[] selection; // 각 종목에 출전하는 학생의 인덱스를 저장하는 배열
    int maxScore; // 선발된 대표들의 해당 종목에 대한 능력치의 합의 최댓값

    public void calculate(int[][] ability) { // 선발된 대표들의 해당 종목에 대한 능력치의 합을 계산하고, 그중 최댓값을 구하는 메서드
        int score = 0; // 체육대회 출전하는 학생들의 출전하는 종목의 능력치 합

        for (int s = 0; s < sportsNumber; s++) {
            score += ability[selection[s]][s];
        }

        maxScore = Math.max(maxScore, score); // 선발된 대표들의 해당 종목에 대한 능력치의 합의 최댓값 갱신
    }

    public void find(int[][] ability, int selectedNumber) { // 체육대회 출전하는 학생들과 그 학생들의 출전 종목을 구하는 메서드
        if (selectedNumber >= sportsNumber) { // 모든 종목의 출전 학생을 정했을 경우
            calculate(ability); // 선발된 대표들의 해당 종목에 대한 능력치의 합 계산 및 선발된 대표들의 경우의 수에 따른 능력치의 합의 최댓값 찾기

            return;
        }

        for (int n = 0; n < allNumber; n++) {
            if (!isSelected[n]) {
                isSelected[n] = true;
                selection[selectedNumber] = n;
                find(ability, selectedNumber + 1);
                isSelected[n] = false;
            }
        }
    }

    public int solution(int[][] ability) {
        allNumber = ability.length;
        sportsNumber = ability[0].length;
        isSelected = new boolean[allNumber];
        selection = new int[sportsNumber];
        maxScore = Integer.MIN_VALUE;

        find(ability, 0);

        return maxScore;
    }
}
