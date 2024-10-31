/*
2146. Gold 3 - 다리 만들기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    192 MB           47420	    18097     11347	         34.862%


    문제
        여러 섬으로 이루어진 나라가 있다. 이 나라의 대통령은 섬을 잇는 다리를 만들겠다는 공약으로 인기몰이를 해 당선될 수 있었다. 하지만 막상 대통령에 취임하자, 다리를 놓는다는 것이 아깝다는 생각을 하게 되었다. 그래서 그는, 생색내는 식으로 한 섬과 다른 섬을 잇는 다리 하나만을 만들기로 하였고, 그 또한 다리를 가장 짧게 하여 돈을 아끼려 하였다.

        이 나라는 N×N크기의 이차원 평면상에 존재한다. 이 나라는 여러 섬으로 이루어져 있으며, 섬이란 동서남북으로 육지가 붙어있는 덩어리를 말한다. 다음은 세 개의 섬으로 이루어진 나라의 지도이다.
            [그림은 문제에서 참고]

        위의 그림에서 색이 있는 부분이 육지이고, 색이 없는 부분이 바다이다. 이 바다에 가장 짧은 다리를 놓아 두 대륙을 연결하고자 한다. 가장 짧은 다리란, 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리를 말한다. 다음 그림에서 두 대륙을 연결하는 다리를 볼 수 있다.
            [그림은 문제에서 참고]

        물론 위의 방법 외에도 다리를 놓는 방법이 여러 가지 있으나, 위의 경우가 놓는 다리의 길이가 3으로 가장 짧다(물론 길이가 3인 다른 다리를 놓을 수 있는 방법도 몇 가지 있다).
        지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.


    입력
        첫 줄에는 지도의 크기 N(100이하의 자연수)가 주어진다. 그 다음 N줄에는 N개의 숫자가 빈칸을 사이에 두고 주어지며, 0은 바다, 1은 육지를 나타낸다. 항상 두 개 이상의 섬이 있는 데이터만 입력으로 주어진다.


    출력
        첫째 줄에 가장 짧은 다리의 길이를 출력한다.


    예제 입력 1
        10
        1 1 1 0 0 0 0 1 1 1
        1 1 1 1 0 0 0 0 1 1
        1 0 1 1 0 0 0 0 1 1
        0 0 1 1 1 0 0 0 0 1
        0 0 0 1 0 0 0 0 0 1
        0 0 0 0 0 0 0 0 0 1
        0 0 0 0 0 0 0 0 0 0
        0 0 0 0 1 1 0 0 0 0
        0 0 0 0 1 1 1 0 0 0
        0 0 0 0 0 0 0 0 0 0
    예제 출력 1
        3


    알고리즘 분류
        그래프 이론
        그래프 탐색
        너비 우선 탐색
*/


// 메모리 : 295440KB
// 시간 : 1776ms
// 코드 길이 : 4569B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 지도의 크기 N (1 ≤ N ≤ 100)
    static int world[][]; // 지도의 정보를 저장하는 배열
    static int dx[] = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int dy[] = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static boolean isChecked[][]; // 각 좌표의 검사 여부를 저장하는 배열

    public static boolean check(int x, int y) { // 해당 좌표가 지도 범위 내의 좌표인지 검사하는 메서드
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        }

        return false;
    }

    public static void classify(int x, int y, int index) { // index의 값을 가진 섬인지 구분하는 메서드
        Queue<int[]> queue = new ArrayDeque<>();

        world[x][y] = index;
        queue.offer(new int[] {x, y});
        while (!queue.isEmpty()) {
            int now[] = queue.poll(); // 현재 좌표

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (check(nx, ny) && world[nx][ny] == 1) { // 다음 좌표가 지도 범위 내의 좌표이고, 섬일 경우
                    world[nx][ny] = index;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }

    public static void findIsland() { // 지도에 존재하는 섬을 구분하는 메서드
        int index = 2;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (world[x][y] == 1) {
                    classify(x, y, index);

                    index += 1;
                }
            }
        }
    }

    public static int calculateNowMinDistance(int x, int y, int index) { // index의 값을 가진 섬의 (x, y) 좌표에서 다른 섬까지 다리를 놓을 경우, 가장 짧은 다리의 길이를 구하는 메서드
        Queue<int[]> queue = new ArrayDeque<>();
        int nowMinDistance = Integer.MAX_VALUE; // (x, y) 좌표에서 다른 섬까지 놓은 다리 길이의 최솟값

        queue.offer(new int[] {x, y, 0});
        while (!queue.isEmpty()) {
            int now[] = queue.poll(); // 현재 좌표와 현재 좌표까지 놓아진 다리의 길이

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (check(nx, ny) && (world[nx][ny] != index)) { // 다음 좌표가 지도 범위 내의 좌표이고, 다리의 시작 좌표와 다른 섬일 경우
                    if (!isChecked[nx][ny]) { // 검사하지 않은 좌표일 경우
                        if (world[nx][ny] != 0) { // 다른 섬일 경우
                            nowMinDistance = Math.min(nowMinDistance, now[2]); // 현재까지 가장 짧은 다리의 길이와 현재까지 놓아진 다리의 길이를 비교하여 가장 짧은 다리의 길이 갱신
                        }
                        else { // 바다일 경우
                            isChecked[nx][ny] = true;
                            queue.offer(new int[] {nx, ny, now[2] + 1});
                        }
                    }
                }
            }
        }

        return nowMinDistance;
    }

    public static void calculateMinDistance() { // 가장 짧은 다리의 길이를 구하는 메서드
        int minDistance = Integer.MAX_VALUE; // 가장 짧은 다리의 길이

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (world[r][c] != 0) { // 바다가 아닐 경우
                    isChecked = new boolean[N][N];
                    minDistance = Math.min(minDistance, calculateNowMinDistance(r, c, world[r][c]));
                }
            }
        }

        System.out.println(minDistance);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        world = new int[N][N];
        StringTokenizer token;
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 0; j < N; j++) {
                world[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        findIsland();
        calculateMinDistance();
    }
}
