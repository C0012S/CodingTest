/*
Lv. 1 #12944 - 평균 구하기

    문제 설명
        정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.


    제한사항
        · arr은 길이 1 이상, 100 이하인 배열입니다.
        · arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.


    입출력 예
        arr	            return
        [1,2,3,4]	    2.5
        [5,5]	        5
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.02ms, 75.6MB)
        테스트 2 〉	통과 (0.03ms, 73.8MB)
        테스트 3 〉	통과 (0.03ms, 75.6MB)
        테스트 4 〉	통과 (0.02ms, 73.6MB)
        테스트 5 〉	통과 (0.02ms, 71MB)
        테스트 6 〉	통과 (0.05ms, 75.2MB)
        테스트 7 〉	통과 (0.03ms, 74.7MB)
        테스트 8 〉	통과 (0.03ms, 76.8MB)
        테스트 9 〉	통과 (0.02ms, 77.1MB)
        테스트 10 〉	통과 (0.06ms, 73.3MB)
        테스트 11 〉	통과 (0.03ms, 67.7MB)
        테스트 12 〉	통과 (0.04ms, 74.4MB)
        테스트 13 〉	통과 (0.03ms, 77.9MB)
        테스트 14 〉	통과 (0.03ms, 70.9MB)
        테스트 15 〉	통과 (0.04ms, 74.1MB)
        테스트 16 〉	통과 (0.04ms, 78.4MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    public double solution(int[] arr) {
        double num = arr.length;
        double sum = 0;
        for (int a = 0; a < num; a++) {
            sum += arr[a];
        }

        double average = sum / num;
        return average;
    }
}