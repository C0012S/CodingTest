/*
1463. Silver 3 - 1로 만들기

    시간 제한	                메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    0.15 초 (하단 참고)        128 MB          263677	    88400     56478	         32.597%


    문제
        정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
            1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
            2. X가 2로 나누어 떨어지면, 2로 나눈다.
            3. 1을 뺀다.

        정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.


    입력
        첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.


    출력
        첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.


    예제 입력 1
        2
    예제 출력 1
        1

    예제 입력 2
        10
    예제 출력 2
        3


    힌트
        10의 경우에 10 → 9 → 3 → 1 로 3번 만에 만들 수 있다.


    알고리즘 분류
        다이나믹 프로그래밍


    시간 제한
        Python 3: 1.5 초
        PyPy3: 0.7 초
        Python 2: 1.5 초
        PyPy2: 0.7 초
*/


// 메모리 : 18080KB
// 시간 : 140ms
// 코드 길이 : 818B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N

        // d[X] = min(d[X / 3], d[X / 2], d[X - 1]) + 1  // d[1] = 0
        int d[] = new int[N + 1];
        d[1] = 0;
        for (int n = 2; n <= N; n++) {
            d[n] = d[n - 1] + 1;

            if (n % 2 == 0) {
                d[n] = Math.min(d[n / 2] + 1, d[n]);
            }

            if (n % 3 == 0) {
                d[n] = Math.min(d[n / 3] + 1, d[n]);
            }
        }

        System.out.println(d[N]);
    }
}
