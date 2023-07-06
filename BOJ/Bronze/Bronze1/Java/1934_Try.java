/*
1934. Bronze 1 - 최소공배수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           61962	    34367     29324	        56.885%


    문제
        두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
        두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)


    출력
        첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.


    예제 입력 1
        3
        1 45000
        6 10
        13 17
    예제 출력 1
        45000
        30
        221


    알고리즘 분류
        수학
        정수론
        유클리드 호제법
*/


// 메모리 초과

package BOJ.Bronze.Bronze1.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1934_Try {
    static int aFactor[]; // 첫 번째 수의 인수 개수 저장 배열
    static int bFactor[]; // 두 번째 수의 인수 개수 저장 배열

    public static void primeFactorization(int num, int factor[]) { // 소인수 분해
        int n = 2;

        while (num != 1) {
            if (num % n == 0) {
                factor[n] += 1;
                num /= n;
            }
            else {
                n += 1;
            }
        }
    }

    public static void calculateLeastCommonMultiple() { // 최소 공배수 계산
        int leastCommonMultiple = 1; // 최소 공배수

        for (int i = 1; i < 45001; i++) {
            leastCommonMultiple *= Math.pow(i, aFactor[i] > bFactor[i] ? aFactor[i] : bFactor[i]);
        }

        System.out.println(leastCommonMultiple);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        StringTokenizer token;
        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(bf.readLine());

            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());

            aFactor = new int[45001];
            bFactor = new int[45001];
            primeFactorization(A, aFactor); // 첫 번째 수 소인수 분해
            primeFactorization(B, bFactor); // 두 번째 수 소인수 분해

            calculateLeastCommonMultiple(); // 두 수의 최소 공배수 계산
        }
    }
}
