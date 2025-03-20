/*
1937. Gold 3 - 욕심쟁이 판다

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    256 MB           50696	    16748     11104	         30.142%


    문제
        n × n의 크기의 대나무 숲이 있다. 욕심쟁이 판다는 어떤 지역에서 대나무를 먹기 시작한다. 그리고 그 곳의 대나무를 다 먹어 치우면 상, 하, 좌, 우 중 한 곳으로 이동을 한다. 그리고 또 그곳에서 대나무를 먹는다. 그런데 단 조건이 있다. 이 판다는 매우 욕심이 많아서 대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다.
        이 판다의 사육사는 이런 판다를 대나무 숲에 풀어 놓아야 하는데, 어떤 지점에 처음에 풀어 놓아야 하고, 어떤 곳으로 이동을 시켜야 판다가 최대한 많은 칸을 방문할 수 있는지 고민에 빠져 있다. 우리의 임무는 이 사육사를 도와주는 것이다. n × n 크기의 대나무 숲이 주어져 있을 때, 이 판다가 최대한 많은 칸을 이동하려면 어떤 경로를 통하여 움직여야 하는지 구하여라.


    입력
        첫째 줄에 대나무 숲의 크기 n(1 ≤ n ≤ 500)이 주어진다. 그리고 둘째 줄부터 n+1번째 줄까지 대나무 숲의 정보가 주어진다. 대나무 숲의 정보는 공백을 사이로 두고 각 지역의 대나무의 양이 정수 값으로 주어진다. 대나무의 양은 1,000,000보다 작거나 같은 자연수이다.


    출력
        첫째 줄에는 판다가 이동할 수 있는 칸의 수의 최댓값을 출력한다.


    예제 입력 1
        4
        14 9 12 10
        1 11 5 4
        7 15 2 13
        6 3 16 8
    예제 출력 1
        4


    알고리즘 분류
        다이나믹 프로그래밍
        그래프 이론
        그래프 탐색
        깊이 우선 탐색
*/


// 메모리 : 37228KB
// 시간 : 444ms
// 코드 길이 : 2858B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 대나무 숲의 크기
    static int[][] forest; // 대나무 숲의 정보를 저장하는 배열
    static int[][] maxRoute; // 해당 인덱스의 좌표에서 출발하여 이동할 수 있는 칸의 수의 최댓값을 저장하는 배열
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우

    public static boolean check(int x, int y) { // 해당 좌표가 대나무 숲 범위 내의 좌표인지 구하는 메서드
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        }

        return false;
    }

    public static int move(int x, int y) { // 판다가 (x, y) 좌표에서 출발했을 때, 이동할 수 있는 칸의 수의 최댓값을 구하는 메서드
        if (maxRoute[x][y] == 0) { // 해당 좌표에서 출발하여 이동할 수 있는 칸의 수의 최댓값을 아직 구하지 않았을 경우
            maxRoute[x][y] = 1;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d]; // 판다가 이동할 지역의 x 좌표
                int ny = y + dy[d]; // 판다가 이동할 지역의 y 좌표

                if (check(nx, ny) && (forest[nx][ny] > forest[x][y])) { // 판다가 이동할 지역의 좌표가 대나무 숲 범위 내의 좌표이고, 판다가 이동할 지역에 있는 대나무가 판다가 이동하기 전 현재의 지역에 있는 대나무보다 많을 경우
                    maxRoute[x][y] = Math.max(maxRoute[x][y], move(nx, ny) + 1); // 판다가 (x, y) 좌표에서 출발했을 때, 이동할 수 있는 칸의 수의 최댓값 갱신
                }
            }
        }

        return maxRoute[x][y];
    }

    public static void find() { // 판다가 이동할 수 있는 칸의 수의 최댓값을 구하고, 출력하는 메서드
        int maxCount = 1; // 판다가 이동할 수 있는 칸의 수의 최댓값
        maxRoute = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                maxCount = Math.max(maxCount, move(r, c));
            }
        }

        System.out.println(maxCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        StringTokenizer token;
        forest = new int[N][N];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        find();
    }
}
