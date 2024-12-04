/*
14499. Gold 4 - 주사위 굴리기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    512 MB           55028	    25364     18569	         45.385%


    문제
        크기가 N×M인 지도가 존재한다. 지도의 오른쪽은 동쪽, 위쪽은 북쪽이다. 이 지도의 위에 주사위가 하나 놓여져 있으며, 주사위의 전개도는 아래와 같다. 지도의 좌표는 (r, c)로 나타내며, r는 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로부터 떨어진 칸의 개수이다.
              2
            4 1 3
              5
              6

        주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있으며, 놓여져 있는 곳의 좌표는 (x, y) 이다. 가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.
        지도의 각 칸에는 정수가 하나씩 쓰여져 있다. 주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
        주사위를 놓은 곳의 좌표와 이동시키는 명령이 주어졌을 때, 주사위가 이동했을 때 마다 상단에 쓰여 있는 값을 구하는 프로그램을 작성하시오.
        주사위는 지도의 바깥으로 이동시킬 수 없다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.


    입력
        첫째 줄에 지도의 세로 크기 N, 가로 크기 M (1 ≤ N, M ≤ 20), 주사위를 놓은 곳의 좌표 x, y(0 ≤ x ≤ N-1, 0 ≤ y ≤ M-1), 그리고 명령의 개수 K (1 ≤ K ≤ 1,000)가 주어진다.
        둘째 줄부터 N개의 줄에 지도에 쓰여 있는 수가 북쪽부터 남쪽으로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 주사위를 놓은 칸에 쓰여 있는 수는 항상 0이다. 지도의 각 칸에 쓰여 있는 수는 10 미만의 자연수 또는 0이다.
        마지막 줄에는 이동하는 명령이 순서대로 주어진다. 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.


    출력
        이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력한다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.


    예제 입력 1
        4 2 0 0 8
        0 2
        3 4
        5 6
        7 8
        4 4 4 1 3 3 3 2
    예제 출력 1
        0
        0
        3
        0
        0
        8
        6
        3

    예제 입력 2
        3 3 1 1 9
        1 2 3
        4 0 5
        6 7 8
        1 3 2 2 4 4 1 1 3
    예제 출력 2
        0
        0
        0
        3
        0
        1
        0
        6
        0

    예제 입력 3
        2 2 0 0 16
        0 2
        3 4
        4 4 4 4 1 1 1 1 3 3 3 3 2 2 2 2
    예제 출력 3
        0
        0
        0
        0

    예제 입력 4
        3 3 0 0 16
        0 1 2
        3 4 5
        6 7 8
        4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2
    예제 출력 4
        0
        0
        0
        6
        0
        8
        0
        2
        0
        8
        0
        2
        0
        8
        0
        2


    알고리즘 분류
        구현
        시뮬레이션
*/


// 메모리 : 14440KB
// 시간 : 112ms
// 코드 길이 : 4584B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 지도의 세로 크기 (1 ≤ N ≤ 20)
    static int M; // 지도의 가로 크기 (1 ≤ M ≤ 20)
    static int x; // 주사위를 놓은 곳의 x 좌표 (0 ≤ x ≤ N - 1)
    static int y; // 주사위를 놓은 곳의 y 좌표 (0 ≤ y ≤ M - 1)
    static int K; // 명령의 개수 (1 ≤ K ≤ 1000)
    static int[][] map; // 지도의 정보를 저장하는 배열
    static int[] dice; // 주사위 전개도의 정보를 저장하는 배열
    static int[] dx = {0, 0, -1, 1}; // 동, 서, 북, 남
    static int[] dy = {1, -1, 0, 0}; // 동, 서, 북, 남
    static StringBuilder sb;

    public static boolean check(int r, int c) { // 해당 좌표가 지도 범위 내의 좌표인지 검사하는 메서드
        if (r >= 0 && r < N && c >= 0 && c < M) {
            return true;
        }

        return false;
    }

    public static void swap(int index1, int index2) { // 주사위 전개도의 각 인덱스의 원소를 교환시키는 메서드
        int temp = dice[index1];

        dice[index1] = dice[index2];
        dice[index2] = temp;
    }

    public static void copy() { // 주사위를 굴렸을 때, 이동한 칸에 쓰여 있는 수에 따라 주사위의 바닥면에 있는 수를 복사하거나 주사위의 바닥면으로 칸에 쓰여 있는 수를 복사하고, 주사위의 윗 면에 쓰여 있는 수를 구하는 메서드
        if (map[x][y] == 0) { // 이동한 칸에 쓰여 있는 수가 0일 경우
            map[x][y] = dice[5]; // 주사위의 바닥면에 쓰여 있는 수가 칸에 복사
        }
        else { // 이동한 칸에 쓰여 있는 수가 0이 아닐 경우
            dice[5] = map[x][y]; // 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사
            map[x][y] = 0; // 칸에 쓰여 있는 수 0으로 설정
        }

        sb.append(dice[0]); // 주사위의 윗 면에 쓰여 있는 수
        sb.append("\n");
    }

    public static void east() { // 주사위를 동쪽으로 이동시키는 메서드
        swap(0, 2);
        swap(3, 0);
        swap(5, 3);

        copy();
    }

    public static void west() { // 주사위를 서쪽으로 이동시키는 메서드
        swap(2, 0);
        swap(5, 2);
        swap(3, 5);

        copy();
    }

    public static void north() { // 주사위를 북쪽으로 이동시키는 메서드
        swap(0, 1);
        swap(4, 0);
        swap(5, 4);

        copy();
    }

    public static void south() { // 주사위를 남쪽으로 이동시키는 메서드
        swap(0, 1);
        swap(1, 4);
        swap(5, 1);

        copy();
    }

    public static void move(int command) { // 명령어에 따라 주사위를 이동시키는 메서드
        int nx = x + dx[command]; // 주사위가 이동할 x 좌표
        int ny = y + dy[command]; // 주사위가 이동할 y 좌표

        if (check(nx, ny)) { // 주사위가 이동할 좌표가 지도에서 벗어나지 않을 경우
            x = nx;
            y = ny;

            switch (command) {
                case 0: // 동쪽
                    east();
                    break;

                case 1: // 서쪽
                    west();
                    break;

                case 2: // 북쪽
                    north();
                    break;

                case 3: // 남쪽
                    south();
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        x = Integer.parseInt(token.nextToken());
        y = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        dice = new int[6];
        sb = new StringBuilder();
        token = new StringTokenizer(bf.readLine());
        for (int k = 0; k < K; k++) {
            move(Integer.parseInt(token.nextToken()) - 1);
        }

        System.out.println(sb);
    }
}
