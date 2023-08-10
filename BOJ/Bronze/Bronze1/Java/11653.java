/*
11653. Bronze 1 - 소인수분해

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           94776	    51445     39915	        52.921%


    문제
        정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.


    입력
        첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.


    출력
        N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.


    예제 입력 1
        72
    예제 출력 1
        2
        2
        2
        3
        3

    예제 입력 2
        3
    예제 출력 2
        3

    예제 입력 3
        6
    예제 출력 3
        2
        3

    예제 입력 4
        2
    예제 출력 4
        2

    예제 입력 5
        9991
    예제 출력 5
        97
        103


    알고리즘 분류
        수학
        정수론
        소수 판정


    채점 및 기타 정보
        이 문제의 채점 우선 순위는 2이다.
*/


// 메모리 : 14260KB
// 시간 : 160ms
// 코드 길이 : 689B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 정수 N (1 ≤ N ≤ 10,000,000)

    public static void primeFactorization() { // 소인수 분해
        int divider = 2;
        while (N != 1) {
            while (N % divider == 0) {
                N /= divider;

                System.out.println(divider);
            }

            divider += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        primeFactorization();
    }
}
