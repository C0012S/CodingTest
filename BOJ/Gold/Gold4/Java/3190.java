/*
3190. Gold 4 - 뱀

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           82233	    35473     23903	         41.532%


    문제
        'Dummy' 라는 도스게임이 있다. 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
        게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.

        뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.
            · 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
            · 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
            · 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
            · 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.

        사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.


    입력
        첫째 줄에 보드의 크기 N이 주어진다. (2 ≤ N ≤ 100) 다음 줄에 사과의 개수 K가 주어진다. (0 ≤ K ≤ 100)
        다음 K개의 줄에는 사과의 위치가 주어지는데, 첫 번째 정수는 행, 두 번째 정수는 열 위치를 의미한다. 사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.
        다음 줄에는 뱀의 방향 변환 횟수 L 이 주어진다. (1 ≤ L ≤ 100)
        다음 L개의 줄에는 뱀의 방향 변환 정보가 주어지는데, 정수 X와 문자 C로 이루어져 있으며. 게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다는 뜻이다. X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.


    출력
        첫째 줄에 게임이 몇 초에 끝나는지 출력한다.


    예제 입력 1
        6
        3
        3 4
        2 5
        5 3
        3
        3 D
        15 L
        17 D
    예제 출력 1
        9

    예제 입력 2
        10
        4
        1 2
        1 3
        1 4
        1 5
        4
        8 D
        10 D
        11 D
        13 L
    예제 출력 2
        21

    예제 입력 3
        10
        5
        1 5
        1 3
        1 2
        1 6
        1 7
        4
        8 D
        10 D
        11 D
        13 L
    예제 출력 3
        13


    알고리즘 분류
        구현
        자료 구조
        시뮬레이션
        덱
        큐
*/


// 메모리 : 17552KB
// 시간 : 156ms
// 코드 길이 : 4056B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 보드의 크기 (2 ≤ N ≤ 100)
    static int K; // 사과의 개수 (0 ≤ K ≤ 100)
    static int L; // 뱀의 방향 변환 횟수 (1 ≤ L ≤ 100)
    static int[][] board; // 보드의 정보를 저장하는 배열
    static int direction; // 뱀의 방향
    static String[] changeTime; // 각 인덱스의 시간에 변환할 뱀의 방향 변환 정보를 저장하는 배열
    static int[] head; // 뱀의 머리가 위치한 좌표를 저장하는 배열
    static Queue<int[]> snake; // 뱀의 전체 몸이 위치한 좌표를 저장하는 배열
    static int time; // 게임의 진행 시간
    static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0}; // 우, 하, 좌, 상

    public static boolean check(int x, int y) { // 해당 좌표가 보드 범위 내의 좌표인지 검사하는 메서드
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        }

        return false;
    }

    public static void changeDirection(String C) { // 뱀의 방향을 변환하는 메서드
        if (C.equals("L")) { // 왼쪽(L)으로 90 도 방향을 회전시킬 경우
            direction -= 1;
            if (direction < 0) {
                direction += 4;
            }
        }
        else if (C.equals("D")) { // 오른쪽(D)으로 90 도 방향을 회전시킬 경우
            direction += 1;
            direction %= 4;
        }
    }

    public static void game() { // 'Dummy' 도스게임을 실행하는 메서드
        head = new int[2];
        snake = new ArrayDeque<>();

        snake.offer(new int[] {0, 0});
        while (true) {
            time += 1;

            int nx = head[0] + dx[direction]; // 뱀이 이동할 다음 칸의 x 좌표
            int ny = head[1] + dy[direction]; // 뱀이 이동할 다음 칸의 y 좌표

            if (!check(nx, ny) || snake.stream().anyMatch(e -> Arrays.equals(e, new int[] {nx, ny}))) { // 뱀이 이동할 다음 칸이 보드의 범위를 벗어나 벽과 부딪히거나, 뱀 자신의 몸과 부딪혔을 경우
                break;
            }

            snake.offer(new int[] {nx, ny}); // 뱀의 몸 길이를 늘려 머리를 이동할 다음 칸에 위치시킨다.
            head[0] = nx; // 뱀의 머리의 x 좌표 변경
            head[1] = ny; // 뱀의 머리의 y 좌표 변경

            if (board[nx][ny] == 1) { // 이동한 칸에 사과가 있을 경우
                board[nx][ny] = 0; // 이동한 칸의 사과를 없앤다.
            }
            else { // 이동한 칸에 사과가 없을 경우
                snake.poll(); // 뱀의 꼬리가 위치한 칸을 비워 준다.
            }

            if (changeTime[time] != null) { // 게임 시작 시간으로부터 time 초가 끝난 뒤, 뱀의 방향을 회전시켜야 할 경우
                changeDirection(changeTime[time]); // 뱀의 방향 변환
            }
        }

        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());

        board = new int[N][N];
        StringTokenizer token;
        for (int k = 0; k < K; k++) {
            token = new StringTokenizer(bf.readLine());
            board[Integer.parseInt(token.nextToken()) - 1][Integer.parseInt(token.nextToken()) - 1] = 1;
        }

        L = Integer.parseInt(bf.readLine());

        changeTime = new String[10001];
        for (int l = 0; l < L; l++) {
            token = new StringTokenizer(bf.readLine());

            changeTime[Integer.parseInt(token.nextToken())] = token.nextToken();
        }

        game();
    }
}
