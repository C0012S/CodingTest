/*
16236. Gold 3 - 아기 상어

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    512 MB           75542	    35874     22055	         44.137%


    문제
        N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.
        아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
        아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.

        아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.
            · 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
            · 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
            · 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
                · 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
                · 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.

        아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.
        아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
        공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.

        둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.
            · 0: 빈 칸
            · 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
            · 9: 아기 상어의 위치

        아기 상어는 공간에 한 마리 있다.


    출력
        첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.


    예제 입력 1
        3
        0 0 0
        0 0 0
        0 9 0
    예제 출력 1
        0

    예제 입력 2
        3
        0 0 1
        0 0 0
        0 9 0
    예제 출력 2
        3

    예제 입력 3
        4
        4 3 2 1
        0 0 0 0
        0 0 9 0
        1 2 3 4
    예제 출력 3
        14

    예제 입력 4
        6
        5 4 3 2 3 4
        4 3 2 3 4 5
        3 2 9 5 6 6
        2 1 2 3 4 5
        3 2 1 6 5 4
        6 6 6 6 6 6
    예제 출력 4
        60

    예제 입력 5
        6
        6 0 6 0 6 1
        0 0 0 0 0 2
        2 3 4 5 6 6
        0 0 0 0 0 2
        0 2 0 0 0 0
        3 9 3 0 0 1
    예제 출력 5
        48

    예제 입력 6
        6
        1 1 1 1 1 1
        2 2 6 2 2 3
        2 2 5 2 2 3
        2 2 2 4 6 3
        0 0 0 0 0 6
        0 0 0 0 0 9
    예제 출력 6
        39


    알고리즘 분류
        구현
        그래프 이론
        그래프 탐색
        시뮬레이션
        너비 우선 탐색
*/


// 메모리 : 18908KB
// 시간 : 156ms
// 코드 길이 : 6212B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; // 공간의 크기 (2 ≤ N ≤ 20)
    static int[][] space; // 공간의 아기 상어와 물고기 크기 정보를 저장하는 배열
    static boolean[][] isVisited; // 공간의 방문 여부를 저장하는 배열
    static int[] dx = {-1, 0, 0, 1}; // 상, 좌, 우, 하
    static int[] dy = {0, -1, 1, 0}; // 상, 좌, 우, 하
    static ArrayList<int[]> fishList; // 아기 상어가 먹을 수 있는 물고기 리스트
    static Shark shark; // 아기 상어의 정보

    static class Shark { // 아기 상어의 정보를 저장하는 클래스
        int x; // 아기 상어의 x 좌표
        int y; // 아기 상어의 y 좌표
        int exp; // 아기 상어가 먹은 물고기 수
        int level; // 아기 상어의 크기
        int time; // 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간

        public Shark(int x, int y, int exp, int level, int time) {
            this.x = x;
            this.y = y;
            this.exp = exp;
            this.level = level;
            this.time = time;
        }
    }

    public static boolean check(int x, int y) { // 해당 좌표가 공간 범위 내의 좌표인지 검사하는 메서드
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        }

        return false;
    }

    public static boolean decide() { // 아기 상어가 먹을 수 있는 물고기의 여부를 구하고, 먹을 수 있는 물고기가 있을 경우 아기 상어가 먹을 물고기를 정하는 메서드
        if (fishList.size() == 0) { // 아기 상어가 먹을 수 있는 물고기가 없을 경우
            return false;
        }

        fishList.sort((o1, o2) -> { // 아기 상어와 물고기와의 거리 기준으로 오름차순 정렬, 아기 상어와 물고기와의 거리가 같다면 x 좌표를 기준으로 오름차순 정렬, x 좌표도 같다면 y 좌표를 기준으로 오름차순 정렬
            if (o1[2] == o2[2]) { // 아기 상어와 물고기와의 거리가 같을 경우
                if (o1[0] == o2[0]) { // 각 물고기의 x 좌표가 같을 경우
                    return o1[1] - o2[1];
                }
                else {
                    return o1[0] - o2[0];
                }
            }
            else {
                return o1[2] - o2[2];
            }
        });

        return true;
    }

    public static boolean find(int x, int y) { // 아기 상어가 먹을 수 있는 물고기 리스트를 구하고, 아기 상어가 먹을 수 있는 물고기의 여부를 구하는 메서드
        Queue<int[]> queue = new ArrayDeque<>(); // 아기 상어가 이동할 수 있는 좌표와 해당 좌표까지 이동하는 데 걸리는 시간 배열을 저장하는 큐
        fishList = new ArrayList<>();
        isVisited = new boolean[N][N];

        queue.offer(new int[] {x, y, 0});
        isVisited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll(); // 현재 검사하고 있는 물고기의 좌표

            if (space[now[0]][now[1]] != 0 && shark.level > space[now[0]][now[1]]) { // 아기 상어가 현재 검사하고 있는 물고기를 먹을 수 있을 경우
                fishList.add(new int[] {now[0], now[1], now[2]}); // 아기 상어가 먹을 수 있는 물고기 리스트에 현재 물고기 추가

                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d]; // 아기 상어가 이동할 x 좌표
                int ny = now[1] + dy[d]; // 아기 상어가 이동할 y 좌표

                if (check(nx, ny) && !isVisited[nx][ny]) { // 아기 상어가 이동할 좌표가 공간 범위 내의 좌표이고, 아직 방문하지 않은 공간일 경우
                    if (space[nx][ny] <= shark.level) { // 아기 상어가 이동할 좌표의 공간에 존재하는 물고기 크기가 아기 상어의 크기보다 작거나 같을 경우
                        isVisited[nx][ny] = true; // 방문 여부 표시
                        queue.offer(new int[] {nx, ny, now[2] + 1}); // 이동할 수 있으므로 해당 좌표의 정보 추가
                    }
                }
            }
        }

        return decide();
    }

    public static void eat() { // 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹으면서 그 시간을 구하는 메서드
        while (find(shark.x, shark.y)) { // 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있을 때까지 반복
            int[] fish = fishList.get(0); // 아기 상어가 잡아먹을 물고기
            shark.x = fish[0];
            shark.y = fish[1];
            shark.time += fish[2];
            shark.exp += 1;

            if (shark.exp == shark.level) { // 아기 상어가 잡아먹은 물고기 수와 아기 상어의 크기가 같을 경우
                shark.exp = 0; // 아기 상어가 잡아먹은 물고기 수 초기화
                shark.level += 1; // 아기 상어의 크기 증가
            }

            space[fish[0]][fish[1]] = 0; // 아기 상어가 잡아먹은 물고기의 좌표의 공간 정보 초기화
        }

        System.out.println(shark.time);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        space = new int[N][N];
        StringTokenizer token;
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(token.nextToken());

                if (space[i][j] == 9) {
                    space[i][j] = 0; // 아기 상어의 좌표의 공간 정보 초기화
                    shark = new Shark(i, j, 0, 2, 0);
                }
            }
        }

        eat();
    }
}
