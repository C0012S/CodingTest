/*
20056. Gold 4 - 마법사 상어와 파이어볼

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    512 MB           24954	    10197     6294	         36.974%


    문제
        어른 상어가 마법사가 되었고, 파이어볼을 배웠다.
        마법사 상어가 크기가 N×N인 격자에 파이어볼 M개를 발사했다. 가장 처음에 파이어볼은 각자 위치에서 이동을 대기하고 있다. i번 파이어볼의 위치는 (ri, ci), 질량은 mi이고, 방향은 di, 속력은 si이다. 위치 (r, c)는 r행 c열을 의미한다.
        격자의 행과 열은 1번부터 N번까지 번호가 매겨져 있고, 1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있다.

        파이어볼의 방향은 어떤 칸과 인접한 8개의 칸의 방향을 의미하며, 정수로는 다음과 같다.
            7	0	1
            6	 	2
            5	4	3

        마법사 상어가 모든 파이어볼에게 이동을 명령하면 다음이 일들이 일어난다.
            1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
                · 이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
            2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
                1. 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
                2. 파이어볼은 4개의 파이어볼로 나누어진다.
                3. 나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
                    1. 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
                    2. 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
                    3. 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
            4. 질량이 0인 파이어볼은 소멸되어 없어진다.

        마법사 상어가 이동을 K번 명령한 후, 남아있는 파이어볼 질량의 합을 구해보자.


    입력
        첫째 줄에 N, M, K가 주어진다.
        둘째 줄부터 M개의 줄에 파이어볼의 정보가 한 줄에 하나씩 주어진다. 파이어볼의 정보는 다섯 정수 ri, ci, mi, si, di로 이루어져 있다.
        서로 다른 두 파이어볼의 위치가 같은 경우는 입력으로 주어지지 않는다.


    출력
        마법사 상어가 이동을 K번 명령한 후, 남아있는 파이어볼 질량의 합을 출력한다.


    제한
        · 4 ≤ N ≤ 50
        · 0 ≤ M ≤ N2
        · 1 ≤ K ≤ 1,000
        · 1 ≤ ri, ci ≤ N
        · 1 ≤ mi ≤ 1,000
        · 1 ≤ si ≤ 1,000
        · 0 ≤ di ≤ 7


    예제 입력 1
        4 2 1
        1 1 5 2 2
        1 4 7 1 6
    예제 출력 1
        8

    예제 입력 2
        4 2 2
        1 1 5 2 2
        1 4 7 1 6
    예제 출력 2
        8

    예제 입력 3
        4 2 3
        1 1 5 2 2
        1 4 7 1 6
    예제 출력 3
        0

    예제 입력 4
        7 5 3
        1 3 5 2 4
        2 3 5 2 6
        5 2 9 1 7
        6 2 1 3 5
        4 4 2 4 2
    예제 출력 4
        9


    알고리즘 분류
        구현
        시뮬레이션
*/


// 메모리 : 84540KB
// 시간 : 880ms
// 코드 길이 : 6631B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; // 격자의 크기
    static int M; // 파이어볼의 개수
    static int K; // 마법사 상어가 명령한 이동 횟수
    static ArrayList<int[]>[][] map; // 격자에 존재하는 파이어볼의 정보를 저장하는 배열
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}; // 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상

    public static boolean check(int x, int y) { // 해당 좌표가 격자 범위 내의 좌표인지 검사하는 메서드
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        }

        return false;
    }

    public static void move(int num) { // 파이어볼이 이동하는 메서드
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int size = map[r][c].size(); // 해당 칸에 존재하는 파이어볼의 개수

                for (int s = 0; s < size; s++) {
                    int[] nowFireBall = map[r][c].get(s);

                    if (nowFireBall[3] == num) { // 이동하기 전의 파이어볼일 경우
                        int nx = (r + nowFireBall[1] * dx[nowFireBall[2]]) % N; // 파이어볼이 이동할 x 좌표
                        int ny = (c + nowFireBall[1] * dy[nowFireBall[2]]) % N; // 파이어볼이 이동할 y 좌표

                        if (nx < 0) {
                            nx += N;
                        }
                        if (ny < 0) {
                            ny += N;
                        }

                        map[nx][ny].add(new int[] {nowFireBall[0], nowFireBall[1], nowFireBall[2], nowFireBall[3] - 1}); // 파이어볼 이동
                    }
                }

                map[r][c].removeIf(n -> n[3] == num); // 이동하기 전의 기존의 파이어볼 소멸
            }
        }
    }

    public static void fire() { // 파이어볼의 이동이 모두 끝난 뒤, 2 개 이상의 파이어볼이 있는 칸에서 일어나는 일을 수행하는 메서드
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].size() > 1) {
                    int mass = 0; // 같은 칸에 있는 파이어볼의 질량
                    int velocity = 0; // 같은 칸에 있는 파이어볼의 속력
                    boolean flag = true; // 같은 칸에 있는 파이어볼의 방향이 모두 홀수이거나 모두 짝수인지

                    int[] firstFireBall = map[r][c].get(0);
                    for (int s = 0, size = map[r][c].size(); s < size; s++) {
                        mass += map[r][c].get(s)[0];
                        velocity += map[r][c].get(s)[1];

                        if (flag) {
                            if (map[r][c].get(s)[2] % 2 != firstFireBall[2] % 2) { // 같은 칸에 있는 파이어볼의 방향이 모두 홀수가 아니거나 모두 짝수가 아닐 경우
                                flag = false;
                            }
                        }
                    }

                    mass /= 5; // 질량 : ⌊ (합쳐진 파이어볼 질량의 합) / 5 ⌋
                    velocity /= map[r][c].size(); // 속력 : ⌊ (합쳐진 파이어볼 속력의 합) / (합쳐진 파이어볼의 개수) ⌋

                    map[r][c].clear(); // 기존의 파이어볼 모두 소멸
                    if (mass != 0) { // 질량이 0이 아닐 경우
                        if (flag) { // 같은 칸에 있는 파이어볼의 방향이 모두 홀수거나 모두 짝수일 경우
                            map[r][c].add(new int[] {mass, velocity, 0, firstFireBall[3]});
                            map[r][c].add(new int[] {mass, velocity, 2, firstFireBall[3]});
                            map[r][c].add(new int[] {mass, velocity, 4, firstFireBall[3]});
                            map[r][c].add(new int[] {mass, velocity, 6, firstFireBall[3]});
                        }
                        else {
                            map[r][c].add(new int[] {mass, velocity, 1, firstFireBall[3]});
                            map[r][c].add(new int[] {mass, velocity, 3, firstFireBall[3]});
                            map[r][c].add(new int[] {mass, velocity, 5, firstFireBall[3]});
                            map[r][c].add(new int[] {mass, velocity, 7, firstFireBall[3]});
                        }
                    }
                }
            }
        }
    }

    public static void sum() { // 남아 있는 파이어볼 질량의 합을 구하고 출력하는 메서드
        int sum = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int s = 0, size = map[r][c].size(); s < size; s++) {
                    sum += map[r][c].get(s)[0];
                }
            }
        }

        System.out.println(sum);
    }

    public static void order() { // 마법사 상어가 이동을 K 번 명령한 후, 남아 있는 파이어볼 질량의 합을 구하고 출력하는 메서드
        while (K != 0) {
            move(K);
            fire();

            K -= 1;
        }

        sum();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new ArrayList[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                map[x][y] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(bf.readLine());

            int r = Integer.parseInt(token.nextToken()) - 1; // 파이어볼 위치의 행
            int c = Integer.parseInt(token.nextToken()) - 1; // 파이어볼 위치의 열
            int m = Integer.parseInt(token.nextToken()); // 파이어볼의 질량
            int s = Integer.parseInt(token.nextToken()); // 파이어볼의 속력
            int d = Integer.parseInt(token.nextToken()); // 파이어볼의 방향

            map[r][c].add(new int[] {m, s, d, K}); // 질량, 속력, 방향, 남은 이동 횟수
        }

        order();
    }
}
