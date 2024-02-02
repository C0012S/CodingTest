/*
1485. Silver 3 - 정사각형

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    1 초         512 MB           7682       2309       1940           32.523%


    문제
        네 점이 주어졌을 때, 네 점을 이용해 정사각형을 만들 수 있는지 없는지를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 네 줄로 이루어져 있으며, 점의 좌표가 한 줄에 하나씩 주어진다. 점의 좌표는 -100,000보다 크거나 같고, 100,000보다 작거나 같은 정수이다. 같은 점이 두 번 이상 주어지지 않는다.


    출력
        각 테스트 케이스마다 입력으로 주어진 네 점을 이용해서 정사각형을 만들 수 있으면 1을, 없으면 0을 출력한다.


    예제 입력 1
        2
        1 1
        1 2
        2 1
        2 2
        2 2
        3 3
        4 4
        5 5
    예제 출력 1
        1
        0


    알고리즘 분류
        정렬
        기하학
*/


// 메모리 : 16952KB
// 시간 : 172ms
// 코드 길이 : 2103B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int location[][]; // 좌표를 저장하는 배열  // 점의 좌표는 -100000보다 크거나 같고, 100000보다 작거나 같은 정수
    static long distance[]; // 각 점의 거리의 제곱 값을 저장하는 배열
    static StringBuilder sb;

    public static void calculateDistance() { // 각 점의 거리의 제곱을 계산하는 메서드
        int index = 0;
        for (int d = 0; d < 4; d++) {
            for (int c = d + 1; c < 4; c++) {
                distance[index++] = (long) Math.pow((location[d][0] - location[c][0]), 2) + (long) Math.pow((location[d][1] - location[c][1]), 2);
            }
        }
    }

    public static void distinguish() { // 주어진 점으로 정사각형을 만들 수 있는지 판별하는 메서드
        calculateDistance();

        Arrays.sort(distance);

        if (distance[0] == distance[1] && distance[1] == distance[2] && distance[2] == distance[3]
                && distance[4] == distance[5]) { // 각 변의 길이가 모두 같고, 대각선의 길이가 같을 경우
            sb.append(1);
        }
        else {
            sb.append(0);
        }

        sb.append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수 T

        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer token;
            location = new int[4][2];
            distance = new long[6];
            for (int i = 0; i < 4; i++) {
                token = new StringTokenizer(bf.readLine());
                location[i][0] = Integer.parseInt(token.nextToken());
                location[i][1] = Integer.parseInt(token.nextToken());
            }

            distinguish();
        }

        System.out.println(sb);
    }
}
