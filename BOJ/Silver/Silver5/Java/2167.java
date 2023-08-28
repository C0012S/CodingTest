/*
2167. Silver 5 - 2차원 배열의 합

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           28213	    15732     12578	         57.484%


    문제
        2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.


    입력
        첫째 줄에 배열의 크기 N, M(1 ≤ N, M ≤ 300)이 주어진다. 다음 N개의 줄에는 M개의 정수로 배열이 주어진다. 배열에 포함되어 있는 수는 절댓값이 10,000보다 작거나 같은 정수이다. 그 다음 줄에는 합을 구할 부분의 개수 K(1 ≤ K ≤ 10,000)가 주어진다. 다음 K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(1 ≤ i ≤ x ≤ N, 1 ≤ j ≤ y ≤ M).


    출력
        K개의 줄에 순서대로 배열의 합을 출력한다. 배열의 합은 231-1보다 작거나 같다.


    예제 입력 1
        2 3
        1 2 4
        8 16 32
        3
        1 1 2 3
        1 2 1 2
        1 3 2 3
    예제 출력 1
        63
        2
        36


    알고리즘 분류
        구현
        누적 합
*/


// 메모리 : 46760KB
// 시간 : 732ms
// 코드 길이 : 1791B
// 누적 합 알고리즘을 이용한 풀이
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken()); // 배열의 행의 크기 N (1 ≤ N ≤ 300)
        int M = Integer.parseInt(token.nextToken()); // 배열의 열의 크기 M (1 ≤ M ≤ 300)

        int sumArray[][] = new int[N + 1][M + 1]; // sumArray[n][m] : n 행의 (n, 1)부터 (n, m)까지의 합
        for (int n = 1; n <= N; n++) {
            token = new StringTokenizer(bf.readLine());

            for (int m = 1; m <= M; m++) {
                sumArray[n][m] = sumArray[n][m - 1] + Integer.parseInt(token.nextToken());
            }
        }

        int K = Integer.parseInt(bf.readLine()); // 합을 구할 부분의 개수 K (1 ≤ K ≤ 10,000)
        for (int k = 0; k < K; k++) {
            token = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(token.nextToken()); // 정수 i (1 ≤ i ≤ x ≤ N)
            int j = Integer.parseInt(token.nextToken()); // 정수 j (1 ≤ j ≤ y ≤ M)
            int x = Integer.parseInt(token.nextToken()); // 정수 x (1 ≤ i ≤ x ≤ N)
            int y = Integer.parseInt(token.nextToken()); // 정수 y (1 ≤ j ≤ y ≤ M)

            int sumResult = 0; // (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합
            for (int r = i; r <= x; r++) {
                sumResult += sumArray[r][y] - sumArray[r][j - 1];
            }

            System.out.println(sumResult);
        }
    }
}
