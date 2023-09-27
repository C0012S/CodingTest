/*
Lv. 1 #76501 - 음양 더하기

    문제 설명
        어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.


    제한사항
        · absolutes의 길이는 1 이상 1,000 이하입니다.
            · absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
        · signs의 길이는 absolutes의 길이와 같습니다.
            · signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.


    입출력 예
        absolutes	    signs	                result
        [4,7,12]	    [true,false,true]	    9
        [1,2,3]	        [false,false,true]	    0


    입출력 예 설명
        입출력 예 #1
            · signs가 [true,false,true] 이므로, 실제 수들의 값은 각각 4, -7, 12입니다.
            · 따라서 세 수의 합인 9를 return 해야 합니다.

        입출력 예 #2
            · signs가 [false,false,true] 이므로, 실제 수들의 값은 각각 -1, -2, 3입니다.
            · 따라서 세 수의 합인 0을 return 해야 합니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.06ms, 69.2MB)
        테스트 2 〉	통과 (0.07ms, 74.9MB)
        테스트 3 〉	통과 (0.04ms, 85.5MB)
        테스트 4 〉	통과 (0.04ms, 77.9MB)
        테스트 5 〉	통과 (0.07ms, 78MB)
        테스트 6 〉	통과 (0.05ms, 75.2MB)
        테스트 7 〉	통과 (0.06ms, 76MB)
        테스트 8 〉	통과 (0.05ms, 73.5MB)
        테스트 9 〉	통과 (0.06ms, 74.3MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0; // 실제 정수들의 합

        for (int n = 0; n < absolutes.length; n++) {
            if (signs[n]) { // signs[n]가 참일 경우  // absolutes[n]의 실제 정수가 양수일 경우
                answer += absolutes[n];
            }
            else { // signs[n]가 거짓일 경우  // absolutes[n]의 실제 정수가 음수일 경우
                answer -= absolutes[n];
            }
        }

        return answer;
    }
}