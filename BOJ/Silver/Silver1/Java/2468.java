/*
2468. Silver 1 - 안전 영역

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           90384	    33779     22400	         34.485%


    문제
        재난방재청에서는 많은 비가 내리는 장마철에 대비해서 다음과 같은 일을 계획하고 있다. 먼저 어떤 지역의 높이 정보를 파악한다. 그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않는 안전한 영역이 최대로 몇 개가 만들어 지는 지를 조사하려고 한다. 이때, 문제를 간단하게 하기 위하여, 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.

            어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인 2차원 배열 형태로 주어지며 배열의 각 원소는 해당 지점의 높이를 표시하는 자연수이다. 예를 들어, 다음은 N=5인 지역의 높이 정보이다.
                6	8	2	6	2
                3	2	3	4	6
                6	7	3	3	2
                7	2	5	3	6
                8	9	5	2	7
            이제 위와 같은 지역에 많은 비가 내려서 높이가 4 이하인 모든 지점이 물에 잠겼다고 하자. 이 경우에 물에 잠기는 지점을 회색으로 표시하면 다음과 같다.

                 6	 8	[2]	 6	[2]
                [3]	[2]	[3]	[4]	 6
                 6	 7	[3]	[3]	[2]
                 7	[2]	 5	[3]	 6
                 8	 9	 5	[2]	 7
            물에 잠기지 않는 안전한 영역이라 함은 물에 잠기지 않는 지점들이 위, 아래, 오른쪽 혹은 왼쪽으로 인접해 있으며 그 크기가 최대인 영역을 말한다. 위의 경우에서 물에 잠기지 않는 안전한 영역은 5개가 된다(꼭짓점으로만 붙어 있는 두 지점은 인접하지 않는다고 취급한다).
            또한 위와 같은 지역에서 높이가 6이하인 지점을 모두 잠기게 만드는 많은 비가 내리면 물에 잠기지 않는 안전한 영역은 아래 그림에서와 같이 네 개가 됨을 확인할 수 있다.

                [6]	 8	[2]	[6]	[2]
                [3]	[2]	[3]	[4]	[6]
                [6]	 7	[3]	[3]	[2]
                 7	[2]	[5]	[3]	[6]
                 8	 9	[5]	[2]	 7
            이와 같이 장마철에 내리는 비의 양에 따라서 물에 잠기지 않는 안전한 영역의 개수는 다르게 된다. 위의 예와 같은 지역에서 내리는 비의 양에 따른 모든 경우를 다 조사해 보면 물에 잠기지 않는 안전한 영역의 개수 중에서 최대인 경우는 5임을 알 수 있다.

        어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오.


    입력
        첫째 줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열의 개수를 나타내는 수 N이 입력된다. N은 2 이상 100 이하의 정수이다. 둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다. 각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다. 높이는 1이상 100 이하의 정수이다.


    출력
        첫째 줄에 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다.


    예제 입력 1
        5
        6 8 2 6 2
        3 2 3 4 6
        6 7 3 3 2
        7 2 5 3 6
        8 9 5 2 7
    예제 출력 1
        5

    예제 입력 2
        7
        9 9 9 9 9 9 9
        9 2 1 2 1 2 9
        9 1 8 7 8 1 9
        9 2 7 9 7 2 9
        9 1 8 7 8 1 9
        9 2 1 2 1 2 9
        9 9 9 9 9 9 9
    예제 출력 2
        6


    노트
        아무 지역도 물에 잠기지 않을 수도 있다.


    알고리즘 분류
        그래프 이론
        브루트포스 알고리즘
        그래프 탐색
        너비 우선 탐색
        깊이 우선 탐색
*/


// 메모리 : 36568KB
// 시간 : 340ms
// 코드 길이 : 4637B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 어떤 지역을 나타내는 2 차원 배열의 행과 열의 개수 (2 ≤ N ≤ 100)
    static int area[][]; // 어떤 지역의 해당 인덱스에 위치하는 지점의 높이를 저장하는 2 차원 배열
    static boolean isChecked[][]; // 어떤 지역의 해당 인덱스에 위치하는 지점의 검사 여부를 저장하는 2 차원 배열  // false : 검사 X, true : 검사 O
    static int dx[] = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int dy[] = {0, 0, -1, 1}; // 상, 하, 좌, 우

    public static boolean checkIndex(int x, int y) { // 어떤 지역의 범위를 벗어났는지 체크하는 함수
        if ((x >= 0) && (x < N) && (y >= 0) && (y < N)) {
            return true;
        }

        return false;
    }

    public static boolean canCheckArea(int x, int y, int height) { // 해당 지점을 검사해야 하는지 판별하는 함수
        if ((area[x][y] > height) && !isChecked[x][y]) { // 해당 지점의 높이가 비가 온 높이보다 크고, 검사하지 않았을 경우
            return true;
        }

        return false;
    }

    public static void findSafeArea(int x, int y, int height) { // 해당 지점의 안전한 영역을 구하는 함수
        Queue<int[]> queue = new ArrayDeque<>(); // 검사할 지점의 좌표를 저장하는 큐

        queue.offer(new int[] {x, y}); // 검사를 시작할 지점의 좌표를 큐에 추가
        isChecked[x][y] = true; // 검사를 시작할 지점의 좌표의 검사 여부 체크
        while (!queue.isEmpty()) { // 큐가 비어 있지 않을 동안
            int now[] = queue.poll(); // 검사할 지점의 좌표

            for (int d = 0; d < 4; d++) { // 상, 하, 좌, 우 방향에 있는 다음 지점 체크
                int nx = now[0] + dx[d]; // 다음 지점의 행의 인덱스
                int ny = now[1] + dy[d]; // 다음 지점의 열의 인덱스
                if (checkIndex(nx, ny) && canCheckArea(nx, ny, height)) { // 다음 지점이 어떤 지역의 범위를 벗어나지 않았고, 검사해야 할(해당 지점의 높이가 비가 온 높이보다 크고, 검사하지 않았을) 경우
                    queue.offer(new int[] {nx, ny}); // 다음 지점의 좌표 큐에 추가
                    isChecked[nx][ny] = true; // 다음 지점 검사 여부 체크
                }
            }
        }
    }

    public static int calculateSafeAreaNum(int height) { // 어떤 지역의 안전한 영역의 개수를 구하는 함수
        int safeArea = 0; // 장마철에 물에 잠기지 않는 안전한 영역의 개수

        for (int r = 0; r < N; r++) { // 어떤 지역의 지점마다 안전한 영역이 있는지 검사
            for (int c = 0; c < N; c++) {
                if (canCheckArea(r, c, height)) { // 해당 지점을 검사해야 할(해당 지점의 높이가 비가 온 높이보다 크고, 검사하지 않았을) 경우
                    safeArea += 1; // 안전한 영역 개수 추가

                    findSafeArea(r, c, height); // 해당 지점의 안전한 영역 구하기
                }
            }
        }

        return safeArea;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        N = Integer.parseInt(bf.readLine());

        area = new int[N][N];
        int maxHeight = 0; // 어떤 지역의 최대 높이  // 1 ≤ 어떤 지역의 높이 ≤ 100
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(token.nextToken());

                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }

        int maxSafeArea = 0; // 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수
        for (int h = 0; h < maxHeight; h++) { // 어떤 지역이 물에 다 잠긴다면 안전한 영역의 최대 개수는 0이다. 그러므로 물의 높이를 0부터 (어떤 지역의 최대 높이 - 1)까지로 설정하여 물의 높이마다 만들어지는 안전한 영역의 개수를 구한다.
            isChecked = new boolean[N][N];

            maxSafeArea = Math.max(maxSafeArea, calculateSafeAreaNum(h));
        }

        System.out.println(maxSafeArea);
    }
}
