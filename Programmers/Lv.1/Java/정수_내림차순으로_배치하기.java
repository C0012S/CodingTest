/*
Lv. 1 #12933 - 정수 내림차순으로 배치하기

    문제 설명
        함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.


    제한 조건
        · n은 1이상 8000000000 이하인 자연수입니다.


    입출력 예
        n	        return
        118372	    873211
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (2.09ms, 78.7MB)
        테스트 2 〉	통과 (2.39ms, 81.8MB)
        테스트 3 〉	통과 (1.66ms, 77.7MB)
        테스트 4 〉	통과 (1.69ms, 73.9MB)
        테스트 5 〉	통과 (2.84ms, 72.1MB)
        테스트 6 〉	통과 (1.93ms, 78MB)
        테스트 7 〉	통과 (2.54ms, 76.2MB)
        테스트 8 〉	통과 (2.08ms, 74.5MB)
        테스트 9 〉	통과 (2.01ms, 71.8MB)
        테스트 10 〉	통과 (2.02ms, 67.7MB)
        테스트 11 〉	통과 (1.94ms, 78.8MB)
        테스트 12 〉	통과 (1.76ms, 77.5MB)
        테스트 13 〉	통과 (1.57ms, 77.3MB)
        테스트 14 〉	통과 (1.80ms, 79.5MB)
        테스트 15 〉	통과 (1.51ms, 74.3MB)
        테스트 16 〉	통과 (2.21ms, 86MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

import java.util.*;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        int len = str.length();
        Character nums[] = new Character[len];

        for (int i = 0; i < len; i++) {
            nums[i] = str.charAt(i);
        }
        Arrays.sort(nums, Collections.reverseOrder());

        String answerStr = "";
        for (Character num : nums) {
            answerStr += String.valueOf(num);
        }

        return Long.parseLong(answerStr);
    }
}