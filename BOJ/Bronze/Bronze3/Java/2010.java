/*
2010. Bronze 3 - 플러그

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    256 MB           23176	    12677     11197	         56.176%


    문제
        선영이의 집에는 콘센트를 꽂을 수 있는 플러그가 하나밖에 없다. 선영이는 많은 컴퓨터를 가지고 있는데, 컴퓨터의 전원 문제는 어떻게 해결하는 것일까?
        하나의 플러그가 있고, N개의 멀티탭이 있다. 각 멀티탭은 몇 개의 플러그로 이루어져 있다고 한다. 최대 몇 대의 컴퓨터를 전원에 연결할 수 있을까?


    입력
        첫째 줄에 멀티탭의 개수 N이 주어진다. (1 ≤ N ≤ 500,000) 이어서 둘째 줄부터 N개의 줄에 걸쳐 각 멀티탭이 몇 개의 플러그를 꽂을 수 있도록 되어 있는지를 나타내는 자연수가 주어진다. 이 자연수는 1,000을 넘지 않는다.


    출력
        첫째 줄에 최대로 전원에 연결될 수 있는 컴퓨터의 수를 출력한다.


    예제 입력 1
        3
        1
        1
        1
    예제 출력 1
        1

    예제 입력 2
        2
        5
        8
    예제 출력 2
        12


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 41008KB
// 시간 : 284ms
// 코드 길이 : 670B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 멀티탭의 개수 (1 ≤ N ≤ 500000)

        int computerNum = 0; // 최대로 전원에 연결될 수 있는 컴퓨터의 수
        for (int n = 0; n < N; n++) {
            computerNum += Integer.parseInt(bf.readLine()); // 각 멀티탭이 꽂을 수 있는 플러그의 개수
        }

        System.out.println(computerNum - (N - 1));
    }
}
