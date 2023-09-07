/*
Lv. 1 #12910 - 나누어 떨어지는 숫자 배열

    문제 설명
        array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
        divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.


    제한사항
        · arr은 자연수를 담은 배열입니다.
        · 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
        · divisor는 자연수입니다.
        · array는 길이 1 이상인 배열입니다.


    입출력 예
        arr	                divisor	        return
        [5, 9, 7, 10]	    5	            [5, 10]
        [2, 36, 1, 3]	    1	            [1, 2, 3, 36]
        [3,2,6]	            10	            [-1]


    입출력 예 설명
        입출력 예#1
            arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.

        입출력 예#2
            arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.

        입출력 예#3
            3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (3.24ms, 64.8MB)
        테스트 2 〉	통과 (3.47ms, 74.5MB)
        테스트 3 〉	통과 (3.76ms, 73.3MB)
        테스트 4 〉	통과 (3.12ms, 77.8MB)
        테스트 5 〉	통과 (2.76ms, 79.1MB)
        테스트 6 〉	통과 (1.35ms, 85.1MB)
        테스트 7 〉	통과 (0.09ms, 77.2MB)
        테스트 8 〉	통과 (0.03ms, 67.2MB)
        테스트 9 〉	통과 (3.01ms, 78.2MB)
        테스트 10 〉	통과 (3.31ms, 73.6MB)
        테스트 11 〉	통과 (2.76ms, 77.8MB)
        테스트 12 〉	통과 (3.46ms, 71.8MB)
        테스트 13 〉	통과 (0.19ms, 73.6MB)
        테스트 14 〉	통과 (2.77ms, 84.2MB)
        테스트 15 〉	통과 (2.73ms, 81.1MB)
        테스트 16 〉	통과 (2.78ms, 79.3MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answerList = new ArrayList<>();

        for (int a = 0; a < arr.length; a++) {
            if (arr[a] % divisor == 0) {
                answerList.add(arr[a]);
            }
        }

        if (answerList.size() == 0) {
            return new int[] {-1};
        }

        Collections.sort(answerList);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
