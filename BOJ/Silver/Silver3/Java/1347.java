/*
1347. Silver 3 - 미로 만들기

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    2 초         128 MB           3142       1671       1419           54.682%


    문제
        홍준이는 미로 안의 한 칸에 남쪽을 보며 서있다. 미로는 직사각형 격자모양이고, 각 칸은 이동할 수 있거나, 벽을 포함하고 있다. 모든 행과 열에는 적어도 하나의 이동할 수 있는 칸이 있다. 홍준이는 미로에서 모든 행과 열의 이동할 수 있는 칸을 걸어다녔다. 그러면서 자신의 움직임을 모두 노트에 쓰기로 했다. 홍준이는 미로의 지도를 자기 노트만을 이용해서 그리려고 한다.
        입력으로 홍준이가 적은 내용을 나타내는 문자열이 주어진다. 각 문자 하나는 한 번의 움직임을 말한다. ‘F’는 앞으로 한 칸 움직인 것이고, ‘L'과 ’R'은 방향을 왼쪽 또는 오른쪽으로 전환한 것이다. 즉, 90도를 회전하면서, 위치는 그대로인 것이다.


    입력
        첫째 줄에 홍준이가 적은 내용의 길이가 주어진다. 길이는 0보다 크고, 50보다 작다. 둘째 줄에 홍준이가 적은 내용이 내용이 주어진다.


    출력
        첫째 줄에 미로 지도를 출력한다. ‘.’은 이동할 수 있는 칸이고, ‘#’는 벽이다.


    예제 입력 1
        5
        RRFRF
    예제 출력 1
        ..
        .#

    예제 입력 2
        6
        LFFRFF
    예제 출력 2
        ...
        ##.
        ##.

    예제 입력 3
        14
        LFLFRRFLFRRFLF
    예제 출력 3
        #.#
        ...
        #.#

    예제 입력 4
        19
        FLFRFFRFFFRFFRFLFLL
    예제 출력 4
        #..#
        ....
        .##.
        ....

    예제 입력 5
        31
        FRFFFFFFLLFRFFFFFLLFRFFFFLFFLFF
    예제 출력 5
        ######.
        .......
        #.#####
        #.#...#
        #.###.#
        #.....#
        #.#####


    알고리즘 분류
        구현
        시뮬레이션
*/


// 메모리 : 14364KB
// 시간 : 128ms
// 코드 길이 : 3648B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int maze[][]; // 홍준이가 적은 미로의 내용을 저장하는 2 차원 배열  // 0 : 벽, 1 : 이동할 수 있는 칸
    static int maxRow = 49; // 미로의 행의 최대 인덱스
    static int minRow = 49; // 미로의 행의 최소 인덱스
    static int maxColumn = 49; // 미로의 열이 최대 인덱스
    static int minColumn = 49; // 미로의 열의 최소 인덱스

    public static void printMaze() { // 홍준이가 적은 미로의 지도를 출력하는 함수
        StringBuilder sb = new StringBuilder();

        for (int r = minRow; r <= maxRow; r++) { // 미로의 행의 최소 인덱스부터 미로의 행의 최대 인덱스까지
            for (int c = minColumn; c <= maxColumn; c++) { // 미로의 열의 최소 인덱스부터 미로의 열의 최대 인덱스까지
                if (maze[r][c] == 1) {
                    sb.append("."); // 이동할 수 있는 칸
                }
                else {
                    sb.append("#"); // 벽
                }
            }

            sb.append("\n"); // 줄 바꿈
        }

        System.out.println(sb); // 홍준이가 적은 미로의 지도 출력
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 홍준이가 적은 미로의 지도의 길이

        int x = 49; // 현재 위치의 행의 인덱스
        int y = 49; // 현재 위치의 열의 인덱스
        maze = new int[100][100]; // 홍준이가 적은 미로의 내용을 저장하는 배열의 행과 열의 크기를 모두 100으로 지정하여 초기화  // 현재 홍준이의 위치를 배열의 가운데로 지정했을 때, 어느 방향으로 움직일지 모르므로 홍준이가 적을 미로의 지도의 최대 길이만큼 상, 하, 좌, 우 방향에 해당 길이만큼 길이를 설정한다.
        maze[x][y] = 1; // 현재 위치는 이동할 수 있으므로 1 저장

        int dx[] = {1, 0, -1, 0}; // 행의 방향 : 하, 좌, 상, 우
        int dy[] = {0, -1, 0, 1}; // 열의 방향 : 하, 좌, 상, 우
        int direction = 0; // 방향 인덱스

        String mazeHistory = bf.readLine(); // 홍준이가 적은 미로의 지도의 내용
        for (int n = 0; n < N; n++) { // 홍준이가 적은 미로의 지도의 내용을 순서대로 검사
            char history = mazeHistory.charAt(n); // 홍준이가 적은 미로의 지도의 n 번째 내용 검사

            if (history == 'L') { // 'L'일 경우 : 방향을 왼쪽으로 전환
                if (direction == 0) {
                    direction = 3;
                }
                else {
                    direction -= 1;
                }
            }
            else if (history == 'R') { // 'R'일 경우 : 방향을 오른쪽으로 전환
                direction = (direction + 1) % 4;
            }
            else if (history == 'F') { // 'F'일 경우 : 앞으로 한 칸 움직임
                x = x + dx[direction]; // 움직일 위치의 행의 인덱스
                y = y + dy[direction]; // 움직일 위치의 열의 인덱스

                maze[x][y] = 1; // 이동할 수 있는 칸으로 표시
            }

            maxRow = Math.max(maxRow, x);
            minRow = Math.min(minRow, x);
            maxColumn = Math.max(maxColumn, y);
            minColumn = Math.min(minColumn, y);
        }

        printMaze();
    }
}
