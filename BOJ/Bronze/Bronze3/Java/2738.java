/*
2738. Bronze 3 - 행렬 덧셈

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           77997	    41142     35903	         53.437%


    문제
        N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.


    입력
        첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.


    출력
        첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.


    예제 입력 1
        3 3
        1 1 1
        2 2 2
        0 1 0
        3 3 3
        4 4 4
        5 5 100
    예제 출력 1
        4 4 4
        6 6 6
        5 6 100


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 15896KB
// 시간 : 176ms
// 코드 길이 : 1212B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int matrix[][];

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                sb.append(matrix[r][c]);
                sb.append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        matrix = new int[N][M];
        for (int i = 0; i < 2; i++) {
            for (int n = 0; n < N; n++) {
                token = new StringTokenizer(bf.readLine());
                for (int m = 0; m < M; m++) {
                    matrix[n][m] += Integer.parseInt(token.nextToken());
                }
            }
        }

        print();
    }
}
