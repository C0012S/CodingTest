/*
14503. Gold 5 - 로봇 청소기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    512 MB           70646	    38536     26321	         53.943%


    문제
        로봇 청소기와 방의 상태가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
        로봇 청소기가 있는 방은 N × M 크기의 직사각형으로 나타낼 수 있으며, 1 × 1 크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북 중 하나이다. 방의 각 칸은 좌표 (r, c)로 나타낼 수 있고, 가장 북쪽 줄의 가장 서쪽 칸의 좌표가 (0, 0), 가장 남쪽 줄의 가장 동쪽 칸의 좌표가 (N - 1, M - 1)이다. 즉, 좌표 (r, c)는 북쪽에서 (r + 1) 번째에 있는 줄의 서쪽에서 (c + 1) 번째 칸을 가리킨다. 처음에 빈 칸은 전부 청소되지 않은 상태이다.

        로봇 청소기는 다음과 같이 작동한다.
            1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
                1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
                1. 반시계 방향으로 90˚ 회전한다.
                2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                3. 1번으로 돌아간다.


    입력
        첫째 줄에 방의 크기 N과 M이 입력된다. (3 ≤ N, M ≤ 50) 둘째 줄에 처음에 로봇 청소기가 있는 칸의 좌표 (r, c)와 처음에 로봇 청소기가 바라보는 방향 d가 입력된다. d가 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽을 바라보고 있는 것이다.
        셋째 줄부터 N개의 줄에 각 장소의 상태를 나타내는 N × M개의 값이 한 줄에 M개씩 입력된다.
        i번째 줄의 j번째 값은 칸 (i, j)의 상태를 나타내며, 이 값이 0인 경우 (i, j)가 청소되지 않은 빈 칸이고, 1인 경우 (i, j)에 벽이 있는 것이다. 방의 가장 북쪽, 가장 남쪽, 가장 서쪽, 가장 동쪽 줄 중 하나 이상에 위치한 모든 칸에는 벽이 있다. 로봇 청소기가 있는 칸은 항상 빈 칸이다.


    출력
        로봇 청소기가 작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수를 출력한다.


    예제 입력 1
        3 3
        1 1 0
        1 1 1
        1 0 1
        1 1 1
    예제 출력 1
        1

    예제 입력 2
        11 10
        7 4 0
        1 1 1 1 1 1 1 1 1 1
        1 0 0 0 0 0 0 0 0 1
        1 0 0 0 1 1 1 1 0 1
        1 0 0 1 1 0 0 0 0 1
        1 0 1 1 0 0 0 0 0 1
        1 0 0 0 0 0 0 0 0 1
        1 0 0 0 0 0 0 1 0 1
        1 0 0 0 0 0 1 1 0 1
        1 0 0 0 0 0 1 1 0 1
        1 0 0 0 0 0 0 0 0 1
        1 1 1 1 1 1 1 1 1 1
    예제 출력 2
        57


    알고리즘 분류
        구현
        시뮬레이션
*/


// 메모리 : 14368KB
// 시간 : 108ms
// 코드 길이 : 4662B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 방의 세로 크기
    static int M; // 방의 가로 크기
    static int[] robot; // 로봇 청소기가 있는 칸의 좌표를 저장하는 배열
    static int direction; // 로봇 청소기가 바라보는 방향
    static int[][] room; // 방의 상태 정보를 저장하는 배열
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1}; // 북, 동, 남, 서
    static int count; // 로봇 청소기가 작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수

    public static boolean check(int x, int y) { // 해당 좌표가 방 범위 내의 좌표인지 검사하는 메서드
        if (x >= 0 && x < N && y >= 0 && y < M) {
            return true;
        }

        return false;
    }

    public static void clean() { // 로봇 청소기를 작동시키는 메서드
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(robot);
        while (!queue.isEmpty()) {
            int[] now = queue.poll(); // 로봇 청소기의 현재 위치

            if (room[now[0]][now[1]] == 0) { // 현재 로봇 청소기가 있는 칸이 아직 청소되지 않은 경우
                room[now[0]][now[1]] = -1; // 현재 칸 청소
                count += 1; // 청소하는 칸의 개수 증가
            }

            boolean flag = false; // 현재 칸의 주변 4 칸의 청소 여부
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d]; // 현재 칸의 주변 칸
                int ny = now[1] + dy[d]; // 현재 칸의 주변 칸

                if (check(nx, ny) && room[nx][ny] == 0) { // 현재 칸의 주변 칸이 방 범위 내의 좌표이고, 청소되지 않은 빈 칸일 경우
                    flag = true;

                    break;
                }
            }

            if (flag) { // 현재 칸의 주변 4 칸 중 청소되지 않은 빈 칸이 있는 경우
                for (int r = 0; r < 4; r++) {
                    // 반시계 방향으로 90 도 회전
                    direction -= 1;
                    if (direction < 0) {
                        direction += 4;
                    }

                    int nx = now[0] + dx[direction]; // 바라보는 방향을 기준으로 앞 쪽 칸의 x 좌표
                    int ny = now[1] + dy[direction]; // 바라보는 방향을 기준으로 앞 쪽 칸의 y 좌표
                    if (check(nx, ny) && room[nx][ny] == 0) { // 바라보는 방향을 기준으로 앞 쪽 칸이 방 범위 내의 좌표이고, 청소되지 않은 빈 칸인 경우
                        queue.offer(new int[]{now[0] + dx[direction], now[1] + dy[direction]}); // 바라보는 방향을 기준으로 한 칸 전진

                        break;
                    }
                }
            }
            else { // 현재 칸의 주변 4 칸 중 청소되지 않은 빈 칸이 없는 경우
                int nx = now[0] + dx[(direction + 2) % 4]; // 바라보는 방향을 유지한 채로 한 칸 후진한 칸의 x 좌표
                int ny = now[1] + dy[(direction + 2) % 4]; // 바라보는 방향을 유지한 채로 한 칸 후진한 칸의 y 좌표
                if (check(nx, ny) && room[nx][ny] != 1) { // 바라보는 방향을 유지한 채로 한 칸 후진한 칸이 방 범위 내의 좌표이고, 벽이 아닐 경우
                    queue.offer(new int[]{nx, ny}); // 바라보는 방향을 유지한 채로 한 칸 후진
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        robot = new int[2];
        token = new StringTokenizer(bf.readLine());
        robot[0] = Integer.parseInt(token.nextToken());
        robot[1] = Integer.parseInt(token.nextToken());
        direction = Integer.parseInt(token.nextToken());

        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        clean();
    }
}
