/*
1018. Silver 4 - 체스판 다시 칠하기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           112537	    55785     44641	         49.786%


    문제
        지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
        체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
        보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.


    출력
        첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.


    예제 입력 1
        8 8
        WBWBWBWB
        BWBWBWBW
        WBWBWBWB
        BWBBBWBW
        WBWBWBWB
        BWBWBWBW
        WBWBWBWB
        BWBWBWBW
    예제 출력 1
        1

    예제 입력 2
        10 13
        BBBBBBBBWBWBW
        BBBBBBBBBWBWB
        BBBBBBBBWBWBW
        BBBBBBBBBWBWB
        BBBBBBBBWBWBW
        BBBBBBBBBWBWB
        BBBBBBBBWBWBW
        BBBBBBBBBWBWB
        WWWWWWWWWWBWB
        WWWWWWWWWWBWB
    예제 출력 2
        12

    예제 입력 3
        8 8
        BWBWBWBW
        WBWBWBWB
        BWBWBWBW
        WBWBWBWB
        BWBWBWBW
        WBWBWBWB
        BWBWBWBW
        WBWBWBWB
    예제 출력 3
        0

    예제 입력 4
        9 23
        BBBBBBBBBBBBBBBBBBBBBBB
        BBBBBBBBBBBBBBBBBBBBBBB
        BBBBBBBBBBBBBBBBBBBBBBB
        BBBBBBBBBBBBBBBBBBBBBBB
        BBBBBBBBBBBBBBBBBBBBBBB
        BBBBBBBBBBBBBBBBBBBBBBB
        BBBBBBBBBBBBBBBBBBBBBBB
        BBBBBBBBBBBBBBBBBBBBBBB
        BBBBBBBBBBBBBBBBBBBBBBW
    예제 출력 4
        31

    예제 입력 5
        10 10
        BBBBBBBBBB
        BBWBWBWBWB
        BWBWBWBWBB
        BBWBWBWBWB
        BWBWBWBWBB
        BBWBWBWBWB
        BWBWBWBWBB
        BBWBWBWBWB
        BWBWBWBWBB
        BBBBBBBBBB
    예제 출력 5
        0

    예제 입력 6
        8 8
        WBWBWBWB
        BWBWBWBW
        WBWBWBWB
        BWBBBWBW
        WBWBWBWB
        BWBWBWBW
        WBWBWWWB
        BWBWBWBW
    예제 출력 6
        2

    예제 입력 7
        11 12
        BWWBWWBWWBWW
        BWWBWBBWWBWW
        WBWWBWBBWWBW
        BWWBWBBWWBWW
        WBWWBWBBWWBW
        BWWBWBBWWBWW
        WBWWBWBBWWBW
        BWWBWBWWWBWW
        WBWWBWBBWWBW
        BWWBWBBWWBWW
        WBWWBWBBWWBW
    예제 출력 7
        15


    알고리즘 분류
        브루트포스 알고리즘
*/


// 메모리 : 14376KB
// 시간 : 132ms
// 코드 길이 : 4344B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 체스판의 세로 길이 (8 ≤ N ≤ 50)
    static int M; // 체스판의 가로 길이 (8 ≤ M ≤ 50)
    static char board[][]; // 체스판의 해당 인덱스의 정사각형이 칠해진 색을 저장하는 배열  // B : 검은색, W : 흰색
    static int minCount; // 지민이가 다시 칠해야 하는 정사각형의 최소 개수

    public static int paint(int row, int column, char leftTop) { // 체스판을 칠하는 메서드
        char left = leftTop; // 해당 행의 맨 왼쪽 색
        char prev = leftTop; // 현재 인덱스 바로 전 인덱스의 정사각형이 칠해진 색
        int count = 0; // 해당 체스판을 체스판처럼 칠하기 위해 지민이가 다시 칠해야 하는 정사각형의 개수

        for (int r = row, rowRange = row + 8; r < rowRange; r++) {
            if (prev == 'B') { // 이전 행의 맨 오른쪽 색이 검은색일 경우
                left = 'B'; // 다음 행의 맨 왼쪽 색은 검은색
            }
            else if (prev == 'W') { // 이전 행의 맨 오른쪽 색이 흰색일 경우
                left = 'W'; // 다음 행의 맨 왼쪽 색은 흰색
            }

            for (int c = column, columnRange = column + 8; c < columnRange; c++) {
                if (c == column) { // 현재 인덱스가 해당 행의 맨 왼쪽일 경우
                    if (left == 'B') { // 해당 행의 맨 왼쪽 색이 검은색일 경우
                        prev = 'W'; // 현재 인덱스의 정사각형을 검은색으로 칠해야 하므로 바로 전 인덱스의 정사각형이 칠해진 색을 흰색으로 변경
                    }
                    else if (left == 'W') { // 해당 행의 맨 왼쪽 색이 흰색일 경우
                        prev = 'B'; // 현재 인덱스의 정사각형을 흰색으로 칠해야 하므로 바로 전 인덱스의 정사각형이 칠해진 색을 검은색으로 변경
                    }
                }

                if (prev == 'B') { // 바로 전 인덱스의 정사각형이 검은색으로 칠해졌을 경우
                    if (board[r][c] != 'W') { // 현재 인덱스의 정사각형이 흰색으로 칠해지지 않았을 경우
                        count += 1; // 지민이가 다시 칠해야 하는 정사각형의 개수 증가
                    }

                    prev = 'W';
                }
                else if (prev == 'W') { // 바로 전 인덱스의 정사각형이 흰색으로 칠해졌을 경우
                    if (board[r][c] != 'B') { // 현재 인덱스의 정사각형이 검은색으로 칠해지지 않았을 경우
                        count += 1; // 지민이가 다시 칠해야 하는 정사각형의 개수 증가
                    }

                    prev = 'B';
                }
            }
        }

        return count;
    }

    public static void make() { // 주어진 보드에서 8 × 8 크기의 체스판을 만드는 메서드
        for (int n = 0; n < N - 8 + 1; n++) {
            for (int m = 0; m < M - 8 + 1; m++) {
                for (int l = 0; l < 2; l++) { // 맨 왼쪽 위의 사각형을 검은색으로 칠할 경우와 흰색으로 칠할 경우 모두 검사
                    if (l == 0) {
                        minCount = Math.min(minCount, paint(n, m, 'B'));
                    }
                    else {
                        minCount = Math.min(minCount, paint(n, m, 'W'));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        minCount = Integer.MAX_VALUE;
        make();

        System.out.println(minCount);
    }
}
