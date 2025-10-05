/*
1749. Gold 4 - 점수따먹기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           4943	    1874      1368	         36.038%


    문제
        동주는 항상 혼자 노느라 심심하다. 하지만 혼자 놀기의 고수가 된 동주는 매일매일 게임을 개발하여 혼자놀기의 진수를 우리에게 보여준다. 어느 날 동주는 새로운 게임을 개발하였다. 바로 점수 따먹기라는 게임인데 그다지 재밌어 보이지는 않는다.
        동주가 개발한 게임은 이렇다. 일단 N*M 행렬을 그린 다음, 각 칸에 -10,000 이상 10,000 이하의 정수를 하나씩 쓴다. 그런 다음 그 행렬의 부분행렬을 그려 그 안에 적힌 정수의 합을 구하는 게임이다.
        동주가 혼자 재밌게 놀던 중 지나가는 당신을 보고 당신을 붙잡고 게임을 하자고 한다. 귀찮은 당신은 정수의 합이 최대가 되는 부분행렬을 구하여 빨리 동주에게서 벗어나고 싶다.


    입력
        첫째 줄에 N (1 < N < 200), M (1 < M < 200)이 주어진다. 그 다음 N개의 줄에 M개씩 행렬의 원소가 주어진다.


    출력
        첫째 줄에 최대의 합을 출력하라.


    예제 입력 1
        3 5
        2 3 -21 -22 -23
        5 6 -22 -23 -25
        -22 -23 4 10 2
    예제 출력 1
        16


    알고리즘 분류
        다이나믹 프로그래밍
        브루트포스 알고리즘
        누적 합
*/


// 메모리 : 21812KB
// 시간 : 1272ms
// 코드 길이 : 1564B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 행의 크기 (1 < N < 200)
    static int M; // 열의 크기 (1 < M < 200)
    static int[][] sumArray; // 누적합을 저장하는 배열

    public static void find() { // 정수의 합이 최대가 되는 부분행렬의 값을 구하는 메서드
        int maxSum = sumArray[1][1];

        for (int t = 1; t <= N; t++) {
            for (int s = 1; s <= M; s++) {
                for (int r = t; r <= N; r++) {
                    for (int c = s; c <= M; c++) {
                        maxSum = Math.max(maxSum, sumArray[r][c] - sumArray[r][s - 1] - sumArray[t - 1][c] + sumArray[t - 1][s - 1]);
                    }
                }
            }
        }

        System.out.println(maxSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        sumArray = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= M; j++) {
                sumArray[i][j] = sumArray[i - 1][j] + sumArray[i][j - 1] - sumArray[i - 1][j - 1] + Integer.parseInt(token.nextToken());
            }
        }

        find();
    }
}
