/*
16234. Gold 4 - 인구 이동

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    512 MB           76967	    33003     19325	         39.587%


    문제
        N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다. 각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다. 인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.
        오늘부터 인구 이동이 시작되는 날이다.

        인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.
            · 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
            · 위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
            · 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
            · 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
            · 연합을 해체하고, 모든 국경선을 닫는다.

        각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
        둘째 줄부터 N개의 줄에 각 나라의 인구수가 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다. (0 ≤ A[r][c] ≤ 100)
        인구 이동이 발생하는 일수가 2,000번 보다 작거나 같은 입력만 주어진다.


    출력
        인구 이동이 며칠 동안 발생하는지 첫째 줄에 출력한다.


    예제 입력 1
        2 20 50
        50 30
        20 40
    예제 출력 1
        1

        초기 상태는 아래와 같다.
            [그림은 문제에서 참고]

        L = 20, R = 50 이기 때문에, 모든 나라 사이의 국경선이 열린다. (열린 국경선은 점선으로 표시)
            [그림은 문제에서 참고]

        연합은 하나 존재하고, 연합의 인구는 (50 + 30 + 20 + 40) 이다. 연합의 크기가 4이기 때문에, 각 칸의 인구수는 140/4 = 35명이 되어야 한다.
            [그림은 문제에서 참고]

    예제 입력 2
        2 40 50
        50 30
        20 40
    예제 출력 2
        0

        경계를 공유하는 나라의 인구 차이가 모두 L보다 작아서 인구 이동이 발생하지 않는다.

    예제 입력 3
        2 20 50
        50 30
        30 40
    예제 출력 3
        1

        초기 상태는 아래와 같다.
            [그림은 문제에서 참고]

        L = 20, R = 50이기 때문에, 아래와 같이 국경선이 열린다.
            [그림은 문제에서 참고]

        인구 수는 합쳐져있는 연합의 인구수는 (50+30+30) / 3 = 36 (소수점 버림)이 되어야 한다.
            [그림은 문제에서 참고]

    예제 입력 4
        3 5 10
        10 15 20
        20 30 25
        40 22 10
    예제 출력 4
        2

    예제 입력 5
        4 10 50
        10 100 20 90
        80 100 60 70
        70 20 30 40
        50 20 100 10
    예제 출력 5
        3


    알고리즘 분류
        구현
        그래프 이론
        그래프 탐색
        시뮬레이션
        너비 우선 탐색
*/


// 메모리 : 297332KB
// 시간 : 616ms
// 코드 길이 : 4694B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 땅의 크기
    static int L; // 두 나라의 인구 차이 하한선
    static int R; // 두 나라의 인구 차이 상한선
    static int[][] ground; // 각 나라의 인구 수를 저장하는 배열
    static boolean[][] isChecked; // 각 나라의 인구 이동 가능 여부의 체크 여부를 저장하는 배열
    static ArrayList<int[]> canMoveList; // 한 연합의 인구 이동이 가능한 나라의 좌표를 저장하는 리스트
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우

    public static boolean check(int x, int y) { // 해당 좌표가 땅 범위 내의 좌표인지 검사하는 메서드
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        }

        return false;
    }

    public static int find(int x, int y) { // 한 연합의 인구 이동이 가능한 나라를 찾고, 연합의 인구 수를 구하는 메서드
        Queue<int[]> queue = new ArrayDeque<>();
        canMoveList = new ArrayList<>();
        int sum = ground[x][y]; // 연합의 인구 수

        isChecked[x][y] = true;
        queue.offer(new int[] {x, y});
        canMoveList.add(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll(); // 인구 이동이 가능한 인접한 나라의 좌표의 기준이 되는 현재 좌표

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d]; // 인접한 나라의 x 좌표
                int ny = now[1] + dy[d]; // 인접한 나라의 y 좌표

                if (check(nx, ny) && !isChecked[nx][ny]) { // 인접한 나라의 좌표가 땅 범위 내의 좌표이고, 체크하지 않은 좌표일 경우
                    int diff = Math.abs(ground[now[0]][now[1]] - ground[nx][ny]); // 국경선을 공유하는 두 나라의 인구 차이

                    if (diff >= L && diff <= R) { // 국경선을 공유하는 두 나라의 인구 차이가 L 명 이상이고 R 명 이하일 경우
                        sum += ground[nx][ny];

                        isChecked[nx][ny] = true;
                        queue.offer(new int[] {nx, ny});
                        canMoveList.add(new int[] {nx, ny});
                    }
                }
            }
        }

        return sum;
    }

    public static boolean move() { // 인구 이동이 가능한지 구하고, 인구 이동이 가능한 나라의 인구 수를 변경하는 메서드
        boolean flag = false; // 하루 동안 인구 이동의 가능 여부

        isChecked = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!isChecked[r][c]) { // 체크한 나라가 아닐 경우
                    int sum = find(r, c); // 한 연합의 인구 수

                    if (sum != ground[r][c]) { // 한 연합의 인구 수가 체크를 시작한 나라의 인구 수와 같지 않을 경우
                        flag = true;

                        // 한 연합에 속하는 모든 나라의 인구 수를 '(연합의 인구 수) / (연합을 이루고 있는 칸의 개수)' 값으로 변경
                        for (int g = 0, num = canMoveList.size(); g < num; g++) {
                            ground[canMoveList.get(g)[0]][canMoveList.get(g)[1]] = sum / num;
                        }
                    }
                }
            }
        }

        return flag;
    }

    public static void count() { // 인구 이동이 며칠 동안 발생하는지 구하고 출력하는 메서드
        int day = 0; // 인구 이동이 발생하는 기간

        while (move()) { // 인구 이동이 가능할 경우
            day += 1;
        }

        System.out.println(day);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        ground = new int[N][N];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 0; j < N; j++) {
                ground[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        count();
    }
}
