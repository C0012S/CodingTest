/*
8393. Bronze 5 - 합

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           265159	    169765    143803	     64.277%


    문제
        n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.


    출력
        1부터 n까지 합을 출력한다.


    예제 입력 1
        3
    예제 출력 1
        6


    알고리즘 분류
        수학
        구현
*/


// 메모리 : 14312KB
// 시간 : 124ms
// 코드 길이 : 443B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;

    public static void calculate() {
        System.out.println(n * (n + 1) / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        calculate();
    }
}
