/*
Lv. 1 #12912 - 두 정수 사이의 합

    문제 설명
        두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
        예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.


    제한 조건
        · a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
        · a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
        · a와 b의 대소관계는 정해져있지 않습니다.


    입출력 예
        a	b	return
        3	5	12
        3	3	3
        5	3	12
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.47ms, 71MB)
        테스트 2 〉	통과 (0.13ms, 70MB)
        테스트 3 〉	통과 (0.10ms, 70.1MB)
        테스트 4 〉	통과 (23.73ms, 75.3MB)
        테스트 5 〉	통과 (13.69ms, 76.8MB)
        테스트 6 〉	통과 (8.87ms, 82.7MB)
        테스트 7 〉	통과 (9.16ms, 76.3MB)
        테스트 8 〉	통과 (11.73ms, 76.4MB)
        테스트 9 〉	통과 (9.39ms, 74MB)
        테스트 10 〉	통과 (3.76ms, 77.2MB)
        테스트 11 〉	통과 (0.33ms, 72.8MB)
        테스트 12 〉	통과 (0.52ms, 77.3MB)
        테스트 13 〉	통과 (0.27ms, 76.3MB)
        테스트 14 〉	통과 (0.08ms, 72MB)
        테스트 15 〉	통과 (0.22ms, 78.4MB)
        테스트 16 〉	통과 (0.24ms, 80.6MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    public long solution(int a, int b) {
        if (a == b) {
            return a;
        }
        else {
            long sum = 0;
            for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
                sum += i;
            }

            return sum;
        }
    }
}
