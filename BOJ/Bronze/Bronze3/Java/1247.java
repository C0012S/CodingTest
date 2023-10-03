/*
1247. Bronze 3 - 부호

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    256 MB           14922	    4764      4187	         36.498%


    문제
        N개의 정수가 주어지면, 이 정수들의 합 S의 부호를 구하는 프로그램을 작성하시오.


    입력
        총 3개의 테스트 셋이 주어진다. 각 테스트 셋의 첫째 줄에는 N(1 ≤ N ≤ 100,000)이 주어지고, 둘째 줄부터 N개의 줄에 걸쳐 각 정수가 주어진다. 주어지는 정수의 절댓값은 9223372036854775807보다 작거나 같다.


    출력
        총 3개의 줄에 걸쳐 각 테스트 셋에 대해 N개의 정수들의 합 S의 부호를 출력한다. S=0이면 "0"을, S>0이면 "+"를, S<0이면 "-"를 출력하면 된다.


    예제 입력 1
        3
        0
        0
        0
        10
        1
        2
        4
        8
        16
        32
        64
        128
        256
        -512
        6
        9223372036854775807
        9223372036854775806
        9223372036854775805
        -9223372036854775807
        -9223372036854775806
        -9223372036854775804
    예제 출력 1
        0
        -
        +


    알고리즘 분류
        수학
        사칙연산
        임의 정밀도 / 큰 수 연산
*/


// 메모리 : 118636KB
// 시간 : 784ms
// 코드 길이 : 930B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int s = 0; s < 3; s++) {
            int N = Integer.parseInt(bf.readLine()); // 정수의 개수 N (1 ≤ N ≤ 100,000)

            BigInteger S = new BigInteger("0");
            for (int n = 0; n < N; n++) {
                S = S.add(new BigInteger(bf.readLine())); // N 개의 정수들의 합 S
            }

            if (S.compareTo(BigInteger.ZERO) == 0) {
                System.out.println(0);
            }
            else if (S.compareTo(BigInteger.ZERO) > 0) {
                System.out.println("+");
            }
            else {
                System.out.println("-");
            }
        }
    }
}
