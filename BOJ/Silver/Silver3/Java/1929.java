/*
1929. Silver 3 - 소수 구하기

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    2 초         256 MB           243076     70091      49274          26.951%


    문제
        M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.


    출력
        한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.


    예제 입력 1
        3 16
    예제 출력 1
        3
        5
        7
        11
        13


    알고리즘 분류
        수학
        정수론
        소수 판정
        에라토스테네스의 체


    채점 및 기타 정보
        이 문제의 채점 우선 순위는 2이다.
*/


// 메모리 : 29812KB
// 시간 : 916ms
// 코드 길이 : 1311B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 자연수 N
    static boolean primeNumber[]; // 소수 판단 배열  // true : 소수 X, false : 소수 O

    public static void eratosthenesSieve() { // 에라토스테네스의 체
        for (int p = 2; p <= Math.sqrt(N); p++) {
            if (primeNumber[p]) {
                continue;
            }

            for (int r = (int) Math.pow(p, 2); r <= N; r += p) {
                primeNumber[r] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(token.nextToken()); // 자연수 M
        N = Integer.parseInt(token.nextToken());

        primeNumber = new boolean[N + 1];
        primeNumber[0] = true;
        primeNumber[1] = true;

        eratosthenesSieve(); // 에라토스테네스의 체 적용
        for (int b = M; b <= N; b++) { // M 이상 N 이하의 수
            if (!primeNumber[b]) {
                System.out.println(b); // 소수 출력
            }
        }
    }
}
