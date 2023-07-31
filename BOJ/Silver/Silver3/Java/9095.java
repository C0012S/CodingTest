/*
9095. Silver 3 - 1, 2, 3 더하기

    시간 제한	                    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초 (추가 시간 없음)	        512 MB           105052	    69141     47435	         64.208%


    문제
        정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
            · 1 + 1 + 1 + 1
            · 1 + 1 + 2
            · 1 + 2 + 1
            · 2 + 1 + 1
            · 2 + 2
            · 1 + 3
            · 3 + 1

        정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.


    출력
        각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.


    예제 입력 1
        3
        4
        7
        10
    예제 출력 1
        7
        44
        274


    알고리즘 분류
        다이나믹 프로그래밍
*/


// 메모리 : 14168KB
// 시간 : 128ms
// 코드 길이 : 1967B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int d[]; // 정수 n을 1, 2, 3의 합으로 나타내는 방법의 수를 저장하는 배열

    public static void findHowToSumNum() { // n을 1, 2, 3의 합으로 나타내는 방법의 수를 계산하는 함수
        // 1 = 1
        /* 2 = 1 + 1
             = 2     */
        /* 3 = 1 + 1 + 1
             = 1 + 2
             = 2 + 1
             = 3         */
        /* 4 = 1 + 1 + 1 + 1
             = 1 + 2 + 1
             = 2 + 1 + 1
             = 3 + 1
             = 1 + 1 + 2
             = 2 + 2
             = 1 + 3         */
        /* 5 = 1 + 1 + 1 + 1 + 1
             = 1 + 2 + 1 + 1
             = 2 + 1 + 1 + 1
             = 3 + 1 + 1
             = 1 + 1 + 2 + 1
             = 2 + 2 + 1
             = 1 + 3 + 1
             = 1 + 1 + 1 + 2
             = 1 + 2 + 2
             = 2 + 1 + 2
             = 3 + 2
             = 1 + 1 + 3
             = 2 + 3             */
        /* x = (x - 1) + 1 = (x - 2) + 2 = (x - 3) + 3이므로
           x = (합이 (x - 1)이 되기 위한 경우) + 1 = (합이 (x - 2)이 되기 위한 경우) + 2 = (합이 (x - 3)이 되기 위한 경우) + 3으로 표현할 수 있다. */
        // d[x] = d[x - 1] + d[x - 2] + d[x - 3]
        d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int x = 4; x < 11; x++) {
            d[x] = d[x - 1] + d[x - 2] + d[x - 3];
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수 T

        findHowToSumNum();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(bf.readLine()); // 정수 n (n은 11보다 작은 양수)

            System.out.println(d[n]);
        }
    }
}
