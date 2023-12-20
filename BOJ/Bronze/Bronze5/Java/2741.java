/*
2741. Bronze 5 - N 찍기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           263018	    146697    124759	     56.984%


    문제
        자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.


    출력
        첫째 줄부터 N번째 줄 까지 차례대로 출력한다.


    예제 입력 1
        5
    예제 출력 1
        1
        2
        3
        4
        5


    비슷한 문제
        2742번. 기찍 N


    알고리즘 분류
        구현
*/


// 메모리 : 17928KB
// 시간 : 216ms
// 코드 길이 : 577B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void printN() {
        StringBuilder sb = new StringBuilder();
        for (int n = 1; n <= N; n++) {
            sb.append(n);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        printN();
    }
}
