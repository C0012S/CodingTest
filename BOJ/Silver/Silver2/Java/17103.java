/*
17103. Silver 2 - 골드바흐 파티션

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    0.5 초	    512 MB           16294	    6378      4852	         37.312%


    문제
        · 골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.

        짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.


    입력
        첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 100)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 N은 짝수이고, 2 < N ≤ 1,000,000을 만족한다.


    출력
        각각의 테스트 케이스마다 골드바흐 파티션의 수를 출력한다.


    예제 입력 1
        5
        6
        8
        10
        12
        100
    예제 출력 1
        1
        1
        2
        1
        6


    알고리즘 분류
        수학
        정수론
        소수 판정
        에라토스테네스의 체
*/


// 메모리 : 16180KB
// 시간 : 268ms
// 코드 길이 : 1985B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int maxNum = 1000000; // 짝수 정수 N의 최댓값
    static int N; // 짝수 정수 N (2 < N ≤ 1,000,000)
    static boolean primeNumber[]; // 소수 판단 배열  // true : 소수 X, false : 소수 O

    public static void eratosthenesSieve() { // 에라토스테네스의 체
        for (int p = 2; p <= Math.sqrt(maxNum); p++) {
            for (int r = (int) Math.pow(p, 2); r <= maxNum; r += p) {
                primeNumber[r] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수

        primeNumber = new boolean[maxNum + 1]; // 0부터 1,000,000까지의 수에서 소수를 찾기 위해 소수 판단 배열의 크기를 1,000,001으로 지정
        primeNumber[0] = true;
        primeNumber[1] = true;
        eratosthenesSieve(); // 에라토스테네스의 체 적용

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(bf.readLine());
            int partition = 0; // 골드바흐 파티션의 수

            for (int n = 2; n < N; n++) {
                if (!primeNumber[n]) { // 해당 수가 소수라면
                    int num = N - n; // N = n + num

                    if (n > num) { // N = n + num이므로 n의 값이 num보다 커질 경우, 그 값은 이미 검사한 값이다.
                        break; // 두 소수의 순서만 다른 것은 같은 파티션이므로 검사 중단
                    }

                    if (!primeNumber[num]) { // num도 소수라면
                        partition += 1; // 골드바흐 파티션의 수 추가
                    }
                }
            }

            System.out.println(partition);
        }
    }
}
