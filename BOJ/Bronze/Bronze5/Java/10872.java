/*
10872. Bronze 5 - 팩토리얼

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           153660	    81980     67151	        53.562%


    문제
        0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.


    출력
        첫째 줄에 N!을 출력한다.


    예제 입력 1
        10
    예제 출력 1
        3628800

    예제 입력 2
        0
    예제 출력 2
        1


    알고리즘 분류
        수학
        구현
        조합론
*/


// 메모리 : 14076KB
// 시간 : 124ms
// 코드 길이 : 565B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 0보다 크거나 같은 정수 N

        System.out.println(factorial(N));
    }
}
