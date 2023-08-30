/*
11720. Bronze 4 - 숫자의 합

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           219909	    120960    100200	     55.580%


    문제
        N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.


    출력
        입력으로 주어진 숫자 N개의 합을 출력한다.


    예제 입력 1
        1
        1
    예제 출력 1
        1

    예제 입력 2
        5
        54321
    예제 출력 2
        15

    예제 입력 3
        25
        7000000000000000000000000
    예제 출력 3
        7

    예제 입력 4
        11
        10987654321
    예제 출력 4
        46


    알고리즘 분류
        수학
        구현
        문자열
*/


// 메모리 : 14260KB
// 시간 : 124ms
// 코드 길이 : 636B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 숫자의 개수 N (1 ≤ N ≤ 100)
        String num = bf.readLine(); // 공백 없이 주어진 숫자 N 개의 문자열

        int sum = 0; // 입력으로 주어진 숫자 N 개의 합
        for (int n = 0; n < N; n++) {
            sum += num.charAt(n) - '0';
        }

        System.out.println(sum);
    }
}
