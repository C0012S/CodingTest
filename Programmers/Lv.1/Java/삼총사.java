/*
Lv. 1 #131705 - 삼총사

    문제 설명
        한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다. 이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다. 예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때, 첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다. 또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다. 따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.
        한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때, 학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.


    제한사항
        · 3 ≤ number의 길이 ≤ 13
        · -1,000 ≤ number의 각 원소 ≤ 1,000
        · 서로 다른 학생의 정수 번호가 같을 수 있습니다.


    입출력 예
        number	                    result
        [-2, 3, 0, 2, -5]	        2
        [-3, -2, -1, 0, 1, 2, 3]	5
        [-1, 1, -1, 1]	            0


    입출력 예 설명
        입출력 예 #1
            · 문제 예시와 같습니다.

        입출력 예 #2
            · 학생들의 정수 번호 쌍 (-3, 0, 3), (-2, 0, 2), (-1, 0, 1), (-2, -1, 3), (-3, 1, 2) 이 삼총사가 될 수 있으므로, 5를 return 합니다.

        입출력 예 #3
            · 삼총사가 될 수 있는 방법이 없습니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.06ms, 67.2MB)
        테스트 2 〉	통과 (0.03ms, 75.3MB)
        테스트 3 〉	통과 (0.03ms, 71.5MB)
        테스트 4 〉	통과 (0.05ms, 83.2MB)
        테스트 5 〉	통과 (0.03ms, 85.8MB)
        테스트 6 〉	통과 (0.05ms, 87MB)
        테스트 7 〉	통과 (0.06ms, 75.8MB)
        테스트 8 〉	통과 (0.05ms, 69.2MB)
        테스트 9 〉	통과 (0.06ms, 74.6MB)
        테스트 10 〉	통과 (0.06ms, 73.6MB)
        테스트 11 〉	통과 (0.03ms, 86MB)
        테스트 12 〉	통과 (0.05ms, 77.5MB)
        테스트 13 〉	통과 (0.04ms, 82.1MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    static int studentNum; // 한국중학교 학생 수
    static int answer; // 삼총사를 만들 수 있는 방법의 수

    public static void find(int[] number, int selectedNumber, int start, int sum) { // 삼총사를 만들 수 있는 방법의 수를 구하는 메서드
        if (selectedNumber >= 3) { // 한국중학교 학생 중 3 명을 선택했을 경우
            if (sum == 0) { // 번호의 합이 0일 경우
                answer += 1;
            }

            return;
        }

        for (int s = start; s < studentNum; s++) {
            find(number, selectedNumber + 1, s + 1, sum + number[s]);
        }
    }

    public int solution(int[] number) {
        studentNum = number.length;
        find(number, 0, 0, 0);

        return answer;
    }
}