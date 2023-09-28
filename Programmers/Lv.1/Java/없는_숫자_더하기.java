/*
Lv. 1 #86051 - 없는 숫자 더하기

    문제 설명
        0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.


    제한사항
        · 1 ≤ numbers의 길이 ≤ 9
            · 0 ≤ numbers의 모든 원소 ≤ 9
            · numbers의 모든 원소는 서로 다릅니다.


    입출력 예
        numbers	                result
        [1,2,3,4,6,7,8,0]	    14
        [5,8,4,0,6,7,9]	        6


    입출력 예 설명
        입출력 예 #1
            · 5, 9가 numbers에 없으므로, 5 + 9 = 14를 return 해야 합니다.

        입출력 예 #2
            · 1, 2, 3이 numbers에 없으므로, 1 + 2 + 3 = 6을 return 해야 합니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.02ms, 71.5MB)
        테스트 2 〉	통과 (0.01ms, 72.3MB)
        테스트 3 〉	통과 (0.02ms, 75.9MB)
        테스트 4 〉	통과 (0.02ms, 77.4MB)
        테스트 5 〉	통과 (0.02ms, 72.9MB)
        테스트 6 〉	통과 (0.01ms, 74.8MB)
        테스트 7 〉	통과 (0.02ms, 69.1MB)
        테스트 8 〉	통과 (0.01ms, 77MB)
        테스트 9 〉	통과 (0.02ms, 76.4MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    public int solution(int[] numbers) {
        int answer = 45; // 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수  // 초깃값 : 0부터 9까지의 합

        for (int n = 0, size = numbers.length; n < size; n++) {
            answer -= numbers[n];
        }

        return answer;
    }
}