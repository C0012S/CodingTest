/*
1173. Bronze 2 - 운동

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    16 MB            8648	    3649      3281	         44.488%


    문제
        영식이가 운동을 하는 과정은 1분 단위로 나누어져 있다. 매 분마다 영식이는 운동과 휴식 중 하나를 선택해야 한다.
        운동을 선택한 경우, 영식이의 맥박이 T만큼 증가한다. 즉, 영식이의 맥박이 X였다면, 1분 동안 운동을 한 후 맥박이 X+T가 되는 것이다. 영식이는 맥박이 M을 넘는 것을 원하지 않기 때문에, X+T가 M보다 작거나 같을 때만 운동을 할 수 있다. 휴식을 선택하는 경우 맥박이 R만큼 감소한다. 즉, 영식이의 맥박이 X였다면, 1분 동안 휴식을 한 후 맥박은 X-R이 된다. 맥박은 절대로 m보다 낮아지면 안된다. 따라서, X-R이 m보다 작으면 맥박은 m이 된다.
        영식이의 초기 맥박은 m이다. 운동을 N분 하려고 한다. 이때 운동을 N분하는데 필요한 시간의 최솟값을 구해보자. 운동하는 시간은 연속되지 않아도 된다.


    입력
        첫째 줄에 다섯 정수 N, m, M, T, R이 주어진다.


    출력
        첫째 줄에 운동을 N분하는데 필요한 시간의 최솟값을 출력한다.. 만약 운동을 N분 할 수 없다면 -1을 출력한다.


    제한
        · 1 ≤ N, T, R ≤ 200
        · 50 ≤ m ≤ M ≤ 200


    예제 입력 1
        5 70 120 25 15
    예제 출력 1
        10

    예제 입력 2
        100 50 100 5 200
    예제 출력 2
        109

    예제 입력 3
        1 60 70 11 11
    예제 출력 3
        -1

    예제 입력 4
        200 50 200 150 1
    예제 출력 4
        30050

    예제 입력 5
        19 89 143 17 13
    예제 출력 5
        40


    힌트
        시간	    행동	    행동을 한 후의 맥박
        1	    운동	        95
        2	    운동	        120
        3	    휴식	        105
        4	    휴식	        90
        5	    운동	        115
        6	    휴식	        100
        7	    휴식	        85
        8	    운동	        110
        9	    휴식	        95
        10	    운동	        120


    알고리즘 분류
        구현
        시뮬레이션
*/


// 메모리 : 14220KB
// 시간 : 128ms
// 코드 길이 : 1692B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 영식이가 운동할 시간
    static int m; // 영식이의 최소 맥박 및 초기 맥박
    static int M; // 영식이의 최대 맥박
    static int T; // 영식이의 맥박 증가량
    static int R; // 영식이의 맥박 감소량

    public static void exercise() {
        if (m + T > M) { // 영식이가 운동을 할 수 없을 경우
            System.out.println(-1);
            return;
        }

        int pulse = m; // 영식이의 맥박
        int exerciseTime = 0; // 영식이의 운동 시간
        int allTime = 0; // 영식이가 운동을 N 분 하는 데 필요한 시간
        while (exerciseTime < N) {
            if (pulse + T <= M) {
                pulse += T;
                exerciseTime += 1;
            }
            else {
                if (pulse - R >= m) {
                    pulse -= R;
                }
                else {
                    pulse = m;
                }
            }

            allTime += 1;
        }

        System.out.println(allTime);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        T = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        exercise();
    }
}
