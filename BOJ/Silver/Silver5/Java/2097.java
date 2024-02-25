/*
2097. Silver 5 - 조약돌

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           1762	    651       525	         40.261%


    문제
        당신은 N개의 조약돌을 가지고 있다. 이 조약돌을 좌표평면의 격자점 위에 아무렇게나 떨어뜨렸다. 격자점이란, x좌표와 y좌표 모두가 정수인 지점을 말한다. 이를테면 (1, 1)이나 (0, -9)는 격자점이며, (-2, 3.5)이나 (π, 7.14)는 격자점이 아니다.
        모든 조약돌을 포함하는 가장 작은 직사각형을 생각할 수 있다. 예를 들어 세 개의 조약돌을 (2,4), (4, 8), (5,5)에 떨어뜨렸다면, 이 세 조약돌을 모두 포함하는 가장 작은 직사각형은 가로 3, 세로 4인 직사각형이다. 이 경우 직사각형의 둘레는 14가 된다. 직사각형의 가로와 세로 길이는 반드시 1 이상이어야 한다.
        조약돌의 개수 N이 주어졌을 때, 조약돌을 좌표평면의 격자점에 적절히 떨어뜨려서 모든 조약돌을 포함하는 직사각형의 둘레를 최소로 하는 프로그램을 작성하시오.


    입력
        첫째 줄에 조약돌의 개수 N(1 ≤ n ≤ 500,000,000)이 주어진다.


    출력
        첫째 줄에 최소 둘레를 출력한다.


    예제 입력 1
        5
    예제 출력 1
        6

    예제 입력 2
        14
    예제 출력 2
        12


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 14300KB
// 시간 : 128ms
// 코드 길이 : 804B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 조약돌의 개수 (1 ≤ N ≤ 500000000)

        int r = (int) Math.sqrt(N);
        int square = (int) Math.pow(r, 2);
        if (N <= 2) {
            System.out.println(4);
        }
        else if (N > square) {
            if (N > (r * (r + 1))) {
                System.out.println(4 * r);
            }
            else {
                System.out.println(2 * (r + (r - 1)));
            }
        }
        else {
            System.out.println(4 * (r - 1));
        }
    }
}
