/*
Lv. 1 #12969 - 직사각형 별찍기

    문제 설명
        이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
        별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.


    제한 조건
        · n과 m은 각각 1000 이하인 자연수입니다.


    예시
        입력
            5 3

        출력
            *****
            *****
            *****
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (127.03ms, 64.5MB)
        테스트 2 〉	통과 (129.45ms, 65.8MB)
        테스트 3 〉	통과 (131.47ms, 68.7MB)
        테스트 4 〉	통과 (132.73ms, 67.6MB)
        테스트 5 〉	통과 (133.00ms, 64.5MB)
        테스트 6 〉	통과 (157.06ms, 66.2MB)
        테스트 7 〉	통과 (155.38ms, 66.9MB)
        테스트 8 〉	통과 (157.67ms, 64.5MB)
        테스트 9 〉	통과 (163.67ms, 72.1MB)
        테스트 10 〉	통과 (138.77ms, 67.6MB)
        테스트 11 〉	통과 (184.05ms, 68.1MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}