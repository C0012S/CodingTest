/*
17144. Gold 4 - 미세먼지 안녕!

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    512 MB           43608	    24549     16707	         55.305%


    문제
        미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다. 공기청정기의 성능을 테스트하기 위해 구사과는 집을 크기가 R×C인 격자판으로 나타냈고, 1×1 크기의 칸으로 나눴다. 구사과는 뛰어난 코딩 실력을 이용해 각 칸 (r, c)에 있는 미세먼지의 양을 실시간으로 모니터링하는 시스템을 개발했다. (r, c)는 r행 c열을 의미한다.
            [그림은 문제에서 참고]

        공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다. 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.

        1초 동안 아래 적힌 일이 순서대로 일어난다.
            1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
                · (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
                · 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
                · 확산되는 양은 Ar,c/5이고 소수점은 버린다. 즉, ⌊Ar,c/5⌋이다.
                · (r, c)에 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) 이다.

            2. 공기청정기가 작동한다.
                · 공기청정기에서는 바람이 나온다.
                · 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
                · 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
                · 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.

        다음은 확산의 예시이다.
                    [그림은 문제에서 참고]
            왼쪽과 위쪽에 칸이 없기 때문에, 두 방향으로만 확산이 일어났다.

                    [그림은 문제에서 참고]
            인접한 네 방향으로 모두 확산이 일어난다.

                    [그림은 문제에서 참고]
            공기청정기가 있는 칸으로는 확산이 일어나지 않는다.

        공기청정기의 바람은 다음과 같은 방향으로 순환한다.
            [그림은 문제에서 참고]

        방의 정보가 주어졌을 때, T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양을 구해보자.


    입력
        첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.
        둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다. 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다. -1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.


    출력
        첫째 줄에 T초가 지난 후 구사과 방에 남아있는 미세먼지의 양을 출력한다.


    예제 입력 1
        7 8 1
        0 0 0 0 0 0 0 9
        0 0 0 0 3 0 0 8
        -1 0 5 0 0 0 22 0
        -1 8 0 0 0 0 0 0
        0 0 0 0 0 10 43 0
        0 0 5 0 15 0 0 0
        0 0 40 0 0 0 20 0
    예제 출력 1
        188

        미세먼지의 확산이 일어나면 다음과 같은 상태가 된다.
            [그림은 문제에서 참고]

        공기청정기가 작동한 이후 상태는 아래와 같다.
            [그림은 문제에서 참고]

    예제 입력 2
        7 8 2
        0 0 0 0 0 0 0 9
        0 0 0 0 3 0 0 8
        -1 0 5 0 0 0 22 0
        -1 8 0 0 0 0 0 0
        0 0 0 0 0 10 43 0
        0 0 5 0 15 0 0 0
        0 0 40 0 0 0 20 0
    예제 출력 2
        188

    예제 입력 3
        7 8 3
        0 0 0 0 0 0 0 9
        0 0 0 0 3 0 0 8
        -1 0 5 0 0 0 22 0
        -1 8 0 0 0 0 0 0
        0 0 0 0 0 10 43 0
        0 0 5 0 15 0 0 0
        0 0 40 0 0 0 20 0
    예제 출력 3
        186

    예제 입력 4
        7 8 4
        0 0 0 0 0 0 0 9
        0 0 0 0 3 0 0 8
        -1 0 5 0 0 0 22 0
        -1 8 0 0 0 0 0 0
        0 0 0 0 0 10 43 0
        0 0 5 0 15 0 0 0
        0 0 40 0 0 0 20 0
    예제 출력 4
        178

    예제 입력 5
        7 8 5
        0 0 0 0 0 0 0 9
        0 0 0 0 3 0 0 8
        -1 0 5 0 0 0 22 0
        -1 8 0 0 0 0 0 0
        0 0 0 0 0 10 43 0
        0 0 5 0 15 0 0 0
        0 0 40 0 0 0 20 0
    예제 출력 5
        172

    예제 입력 6
        7 8 20
        0 0 0 0 0 0 0 9
        0 0 0 0 3 0 0 8
        -1 0 5 0 0 0 22 0
        -1 8 0 0 0 0 0 0
        0 0 0 0 0 10 43 0
        0 0 5 0 15 0 0 0
        0 0 40 0 0 0 20 0
    예제 출력 6
        71

    예제 입력 7
        7 8 30
        0 0 0 0 0 0 0 9
        0 0 0 0 3 0 0 8
        -1 0 5 0 0 0 22 0
        -1 8 0 0 0 0 0 0
        0 0 0 0 0 10 43 0
        0 0 5 0 15 0 0 0
        0 0 40 0 0 0 20 0
    예제 출력 7
        52

    예제 입력 8
        7 8 50
        0 0 0 0 0 0 0 9
        0 0 0 0 3 0 0 8
        -1 0 5 0 0 0 22 0
        -1 8 0 0 0 0 0 0
        0 0 0 0 0 10 43 0
        0 0 5 0 15 0 0 0
        0 0 40 0 0 0 20 0
    예제 출력 8
        46


    알고리즘 분류
        구현
        시뮬레이션
*/


// 메모리 : 33612KB
// 시간 : 332ms
// 코드 길이 : 5727B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int R; // 격자판의 행의 수 (6 ≤ R ≤ 50)
    static int C; // 격자판의 열의 수 (6 ≤ C ≤ 50)
    static int T; // 공기청정기를 작동시킬 시간 초 (1 ≤ T ≤ 1000)
    static int[][] map; // 집에 있는 공기청정기와 미세먼지에 대한 정보를 저장하는 배열
    static ArrayList<int[]> robot; // 공기청정기의 위치를 저장하는 리스트
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[][] spreadedMap; // 아직 미세먼지가 확산되지 않은 좌표에 다른 좌표에 의하여 확산된 미세먼지의 양을 저장하는 배열

    public static boolean check(int x, int y) { // 해당 좌표가 집 범위 내의 좌표인지 검사하는 메서드
        if (x >= 0 && x < R && y >= 0 && y < C) {
            return true;
        }

        return false;
    }

    public static void spread() { // 1 초 동안 미세먼지를 확산하는 메서드
        spreadedMap = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != 0 && map[r][c] != -1) {
                    int dust = map[r][c] / 5; // 인접한 좌표로 확산될 미세먼지의 양
                    int count = 0; // 미세먼지가 확산된 좌표의 수

                    for (int d = 0; d < 4; d++) {
                        int nx = r + dx[d]; // 미세먼지가 확산될 좌표의 행
                        int ny = c + dy[d]; // 미세먼지가 확산될 좌표의 열

                        if (check(nx, ny) && map[nx][ny] != -1) { // 미세먼지가 확산될 좌표가 집 범위 내의 좌표이고, 공기청정기가 설치되어 있지 않은 칸일 경우
                            if (nx < r || ny < c) { // 미세먼지가 확산될 좌표가 이미 미세먼지를 확산한 좌표일 경우
                                map[nx][ny] += dust;
                            }
                            else { // 미세먼지가 확산될 좌표가 미세먼지를 확산하는지에 대해 검사하지 않은 좌표일 경우
                                spreadedMap[nx][ny] += dust;
                            }

                            count += 1;
                        }
                    }

                    map[r][c] -= (dust * count); // 미세먼지를 확산한 좌표에 남은 미세먼지의 양 계산
                }

                map[r][c] += spreadedMap[r][c]; // 미세먼지를 확산하는지 검사 후, 해당 좌표에 확산된 미세먼지의 양 추가
            }
        }
    }

    public static void clean() { // 1 초 동안 공기청정기를 작동하는 메서드
        // 위쪽 공기청정기 작동
        int[] topRobot = robot.get(0); // 위쪽 공기청정기 좌표
        for (int tu = 1; tu < topRobot[0]; tu++) { // 위 → 아래
            map[topRobot[0] - tu][0] = map[topRobot[0] - tu - 1][0];
        }

        for (int tr = 0; tr < C - 1; tr++) { // 우 → 좌
            map[0][tr] = map[0][tr + 1];
        }

        for (int td = 0; td < topRobot[0]; td++) { // 아래 → 위
            map[td][C - 1] = map[td + 1][C - 1];
        }

        for (int tl = C - 1; tl > 1; tl--) { // 좌 → 우
            map[topRobot[0]][tl] = map[topRobot[0]][tl - 1];
        }
        map[topRobot[0]][1] = 0;

        // 아래쪽 공기청정기 작동
        int[] bottomRobot = robot.get(1);
        for (int bd = bottomRobot[0] + 1; bd < R - 1; bd++) { // 아래 → 위
            map[bd][0] = map[bd + 1][0];
        }

        for (int br = 0; br < C - 1; br++) { // 우 → 좌
            map[R - 1][br] = map[R - 1][br + 1];
        }

        for (int bu = R - 1; bu > bottomRobot[0]; bu--) { // 위 → 아래
            map[bu][C - 1] = map[bu - 1][C - 1];
        }

        for (int bl = C - 1; bl > 1; bl--) { // 좌 → 우
            map[bottomRobot[0]][bl] = map[bottomRobot[0]][bl - 1];
        }
        map[bottomRobot[0]][1] = 0;
    }

    public static void find() { // 방에 남아 있는 미세먼지의 양을 구하고 출력하는 메서드
        int sum = 0; // 방에 남아 있는 미세먼지의 양
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] != -1) {
                    sum += map[x][y];
                }
            }
        }

        System.out.println(sum);
    }

    public static void operate() { // T 초가 지난 후 방에 남아 있는 미세먼지의 양을 구하고 출력하는 메서드
        while (T != 0) {
            spread();
            clean();

            T -= 1;
        }

        find();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        T = Integer.parseInt(token.nextToken());

        map = new int[R][C];
        robot = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());

                if (map[i][j] == -1) {
                    robot.add(new int[] {i, j});
                }
            }
        }

        operate();
    }
}
