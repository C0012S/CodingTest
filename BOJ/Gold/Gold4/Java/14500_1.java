/*
14500. Gold 4 - 테트로미노

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    512 MB           100816	    39222     25564	         36.581%


    문제
        폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.
            · 정사각형은 서로 겹치면 안 된다.
            · 도형은 모두 연결되어 있어야 한다.
            · 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.

        정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.
            [그림은 문제에서 참고]

        아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
        테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
        테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.


    입력
        첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
        둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.


    출력
        첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.


    예제 입력 1
        5 5
        1 2 3 4 5
        5 4 3 2 1
        2 3 4 5 6
        6 5 4 3 2
        1 2 1 2 1
    예제 출력 1
        19

    예제 입력 2
        4 5
        1 2 3 4 5
        1 2 3 4 5
        1 2 3 4 5
        1 2 3 4 5
    예제 출력 2
        20

    예제 입력 3
        4 10
        1 2 1 2 1 2 1 2 1 2
        2 1 2 1 2 1 2 1 2 1
        1 2 1 2 1 2 1 2 1 2
        2 1 2 1 2 1 2 1 2 1
    예제 출력 3
        7


    알고리즘 분류
        구현
        브루트포스 알고리즘
*/


// 메모리 : 31176KB
// 시간 : 496ms
// 코드 길이 : 3907B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 종이의 세로 크기 (4 ≤ N ≤ 500)
    static int M; // 종이의 가로 크기 (4 ≤ M ≤ 500)
    static int[][] paper; // 종이에 쓰여 있는 수를 저장하는 배열
    static int[][][] tetrominoes = {{{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // 하늘색 테트로미노
                                    {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
                                    {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // 노란색 테트로미노
                                    {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // 주황색 테트로미노
                                    {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
                                    {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
                                    {{0, 2}, {1, 0}, {1, 1}, {1, 2}},
                                    {{0, 0}, {0, 1}, {1, 0}, {2, 0}},
                                    {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
                                    {{0, 1}, {1, 1}, {2, 0}, {2, 1}},
                                    {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
                                    {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // 연두색 테트로미노
                                    {{0, 1}, {0, 2}, {1, 0}, {1, 1}},
                                    {{0, 1}, {1, 0}, {1, 1}, {2, 0}},
                                    {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
                                    {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // 핑크색 테트로미노
                                    {{0, 1}, {1, 0}, {1, 1}, {2, 1}},
                                    {{0, 1}, {1, 0}, {1, 1}, {1, 2}},
                                    {{0, 0}, {1, 0}, {1, 1}, {2, 0}}}; // 다섯 가지의 테트로미노를 회전하거나 대칭시켜 만들 수 있는 테트로미노

    public static boolean check(int x, int y) { // 해당 좌표가 종이 범위 내의 좌표인지 검사하는 메서드
        if (x >= 0 && x < N && y >= 0 && y < M) {
            return true;
        }

        return false;
    }

    public static void find() { // 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 구하고 출력하는 메서드
        int maxSum = Integer.MIN_VALUE; // 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                for (int[][] tetromino : tetrominoes) {
                    int sum = 0; // 현재 테트로미노가 놓인 칸에 쓰인 수들의 합

                    for (int t = 0; t < 4; t++) {
                        int nx = tetromino[t][0] + n; // 현재 테트로미노가 이동할 x 좌표
                        int ny = tetromino[t][1] + m; // 현재 테트로미노가 이동할 y 좌표

                        if (!check(nx, ny)) { // 현재 테트로미노가 이동할 좌표가 종이 범위 내가 아닐 경우
                            break;
                        }

                        sum += paper[nx][ny];
                    }

                    maxSum = Math.max(maxSum, sum);
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

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        find();
    }
}
