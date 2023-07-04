/*
1743. Silver 1 - 음식물 피하기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           16198	    7571      5993	         46.850%


    문제
        코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다.
        이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다.
        통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다.
        선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.


    입력
        첫째 줄에 통로의 세로 길이 N(1 ≤ N ≤ 100)과 가로 길이 M(1 ≤ M ≤ 100) 그리고 음식물 쓰레기의 개수 K(1 ≤ K ≤ N×M)이 주어진다.  그리고 다음 K개의 줄에 음식물이 떨어진 좌표 (r, c)가 주어진다.
        좌표 (r, c)의 r은 위에서부터, c는 왼쪽에서부터가 기준이다. 입력으로 주어지는 좌표는 중복되지 않는다.


    출력
        첫째 줄에 음식물 중 가장 큰 음식물의 크기를 출력하라.


    예제 입력 1
        3 4 5
        3 2
        2 2
        3 1
        2 3
        1 1
    예제 출력 1
        4


    힌트
        # . . .
        . # # .
        # # . .
        위와 같이 음식물이 떨어져있고 제일큰 음식물의 크기는 4가 된다. (인접한 것은 붙어서 크게 된다고 나와 있음. 대각선으로는 음식물 끼리 붙을수 없고 상하좌우로만 붙을수 있다.)


    알고리즘 분류
        그래프 이론
        그래프 탐색
        너비 우선 탐색
        깊이 우선 탐색
*/


// 메모리 초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 통로의 세로 길이 N
    static int M; // 통로의 가로 길이 M
    static int food[][];
    static Queue<Integer[]> queue;
    static boolean isVisited[][]; // 방문 여부
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우

    public static boolean check(int x, int y) { // 공간을 벗어나지 않고 해당 좌표에 음식물이 있을 경우, true를 반환하는 함수
        if (x < 0 || x >= N || y < 0 || y >= M || food[x][y] != 1) {
            return false;
        }

        return true;
    }

    public static int findSizeFood() { // 음식물의 크기를 구하는 함수
        int size = 0;

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            isVisited[x][y] = true;

            size += 1;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (check(nx, ny) && !isVisited[nx][ny]) { // 공간을 벗어나지 않고 해당 좌표에 음식물이 있으며 해당 좌표를 방문하지 않았을 경우
                    queue.offer(new Integer[] {nx, ny});
                    isVisited[nx][ny] = true;
                }
            }
        }

        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken()); // 음식물 쓰레기의 개수 K

        food = new int[N][M];
        for (int k = 0; k < K; k++) {
            token = new StringTokenizer(bf.readLine());
            int row = Integer.parseInt(token.nextToken());
            int column = Integer.parseInt(token.nextToken());

            food[row - 1][column - 1] = 1; // 음식물이 있을 경우 1로 표기 (음식물이 없을 경우는 0)
        }

        int maxSize = 0; // 제일 큰 음식물의 크기
        for (int r = 0; r < N; r++) { // 전체 좌표에서 음식물이 있는지 검사한 후, 음식물의 크기 계산 및 제일 큰 음식물의 크기 구하기
            for (int c = 0; c < M; c++) {
                if (food[r][c] == 1) {
                    queue = new ArrayDeque<>();
                    queue.offer(new Integer[]{r, c});
                    isVisited = new boolean[N][M];

                    maxSize = Math.max(maxSize, findSizeFood());
                }
            }
        }

        System.out.println(maxSize);
    }
}
