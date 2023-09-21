/*
Lv. 1 #12950 - 행렬의 덧셈

    문제 설명
        행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.


    제한 조건
        · 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.


    입출력 예
        arr1	            arr2	            return
        [[1,2],[2,3]]	    [[3,4],[5,6]]	    [[4,6],[7,9]]
        [[1],[2]]	        [[3],[4]]	        [[4],[6]]
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.03ms, 69.8MB)
        테스트 2 〉	통과 (0.05ms, 74MB)
        테스트 3 〉	통과 (0.14ms, 76.1MB)
        테스트 4 〉	통과 (0.08ms, 77.1MB)
        테스트 5 〉	통과 (0.07ms, 77.8MB)
        테스트 6 〉	통과 (0.06ms, 76.7MB)
        테스트 7 〉	통과 (0.02ms, 77.8MB)
        테스트 8 〉	통과 (0.05ms, 76.5MB)
        테스트 9 〉	통과 (0.30ms, 81.8MB)
        테스트 10 〉	통과 (0.35ms, 81.8MB)
        테스트 11 〉	통과 (0.23ms, 80.6MB)
        테스트 12 〉	통과 (0.29ms, 84.5MB)
        테스트 13 〉	통과 (0.21ms, 88.4MB)
        테스트 14 〉	통과 (0.30ms, 72.3MB)
        테스트 15 〉	통과 (0.20ms, 79.5MB)
        테스트 16 〉	통과 (0.26ms, 88.3MB)
        테스트 17 〉	통과 (6.46ms, 110MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowLength = arr1.length; // 행의 길이
        int columnLength = arr1[0].length; // 열의 길이

        int[][] answer = new int[rowLength][columnLength];
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < columnLength; c++) {
                answer[r][c] = arr1[r][c] + arr2[r][c];
            }
        }

        return answer;
    }
}