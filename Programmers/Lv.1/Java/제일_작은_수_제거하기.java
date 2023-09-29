/*
Lv. 1 #12935 - 제일 작은 수 제거하기

    문제 설명
        정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.


    제한 조건
        · arr은 길이 1 이상인 배열입니다.
        · 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.


    입출력 예
        arr	            return
        [4,3,2,1]	    [4,3,2]
        [10]	        [-1]
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (2.43ms, 104MB)
        테스트 2 〉	통과 (0.05ms, 75.8MB)
        테스트 3 〉	통과 (0.07ms, 77.4MB)
        테스트 4 〉	통과 (0.04ms, 76MB)
        테스트 5 〉	통과 (0.05ms, 75.5MB)
        테스트 6 〉	통과 (0.10ms, 74.6MB)
        테스트 7 〉	통과 (0.15ms, 82.4MB)
        테스트 8 〉	통과 (0.03ms, 73.9MB)
        테스트 9 〉	통과 (0.02ms, 72.6MB)
        테스트 10 〉	통과 (0.03ms, 78.8MB)
        테스트 11 〉	통과 (0.04ms, 72.7MB)
        테스트 12 〉	통과 (0.03ms, 72.2MB)
        테스트 13 〉	통과 (0.04ms, 93MB)
        테스트 14 〉	통과 (0.06ms, 80.1MB)
        테스트 15 〉	통과 (0.05ms, 69.9MB)
        테스트 16 〉	통과 (0.07ms, 82.5MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    public int[] solution(int[] arr) {
        int size = arr.length;

        if (size == 1) {
            return new int[] {-1};
        }

        int minNum = arr[0];
        for (int i = 1; i < size; i++) {
            minNum = Math.min(minNum, arr[i]);
        }

        int index = 0;
        int[] answer = new int[size - 1];
        for (int j = 0; j < size; j++) {
            if (minNum == arr[j]) {
                continue;
            }

            answer[index++] = arr[j];
        }

        return answer;
    }
}