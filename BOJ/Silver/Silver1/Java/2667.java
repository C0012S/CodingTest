/*
2667. Silver 1 - 단지번호붙이기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           228469	    105415    66863	         44.009%


    문제
        <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
            0 1 1 0 1 0 0       0 1 1 0 2 0 0
            0 1 1 0 1 0 1       0 1 1 0 2 0 2
            1 1 1 0 1 0 1       1 1 1 0 2 0 2
            0 0 0 0 1 1 1       0 0 0 0 2 2 2
            0 1 0 0 0 0 0       0 3 0 0 0 0 0
            0 1 1 1 1 1 0       0 3 3 3 3 3 0
            0 1 1 1 0 0 0       0 3 3 3 0 0 0
               <그림 1>             <그림 2>


    입력
        첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.


    출력
        첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.


    예제 입력 1
        7
        0110100
        0110101
        1110101
        0000111
        0100000
        0111110
        0111000
    예제 출력 1
        3
        7
        8
        9


    알고리즘 분류
        그래프 이론
        그래프 탐색
        너비 우선 탐색
        깊이 우선 탐색
        격자 그래프
        플러드 필
*/


// 메모리 : 14284KB
// 시간 : 104ms
// 코드 길이 : 3269B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; // 지도의 크기 (5 ≤ N ≤ 25)
    static int[][] map; // 지도의 정보를 저장하는 배열
    static boolean[][] isChecked; // 해당 좌표의 검사 여부를 저장하는 배열
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static ArrayList<Integer> houseNumList; // 각 단지 내 집의 수를 저장하는 리스트

    public static boolean check(int x, int y) { // 해당 좌표가 지도 범위 내의 좌표인지 검사하는 메서드
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        }

        return false;
    }

    public static void count(int x, int y) { // 단지 내 집의 수를 구하는 메서드
        Queue<int[]> queue = new ArrayDeque<>();

        isChecked[x][y] = true;
        queue.offer(new int[] {x, y});
        int houseNum = 0; // 단지 내 집의 수

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            houseNum += 1;

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (check(nx, ny) && !isChecked[nx][ny]) { // 다음에 검사할 좌표가 지도 범위 내의 좌표이고, 검사하지 않은 좌표일 경우
                    isChecked[nx][ny] = true;

                    if (map[nx][ny] == 1) { // 다음에 검사할 좌표에 집이 있을 경우
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        houseNumList.add(houseNum);
    }

    public static void print() { // 총 단지 수와 각 단지 내의 집의 수를 출력하는 메서드
        StringBuilder sb = new StringBuilder();

        sb.append(houseNumList.size()); // 총 단지 수

        for (Integer houseNum : houseNumList) {
            sb.append("\n");
            sb.append(houseNum);
        }

        System.out.println(sb);
    }

    public static void find() { // 총 단지 수와 각 단지 내 집의 수를 구하는 메서드
        isChecked = new boolean[N][N];
        houseNumList = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!isChecked[r][c] && (map[r][c] == 1)) { // 해당 좌표가 검사하지 않은 좌표이고, 해당 좌표에 집이 있을 경우
                    count(r, c); // 해당 좌표가 속한 단지 내 집의 수를 구한다.
                }
            }
        }

        Collections.sort(houseNumList); // 각 단지 내의 집의 수를 오름차순으로 정렬

        print();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        find();
    }
}
