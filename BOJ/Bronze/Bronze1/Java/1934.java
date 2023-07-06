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


// 메모리 : 15092KB
// 시간 : 192ms
// 코드 길이 : 1078B
// 정답

package BOJ.Bronze.Bronze1.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1934 {
    public static int gcd(int bigNum, int smallNum) { // 유클리드 호제법
        if (smallNum == 0) {
            return bigNum;
        }
        else {
            return gcd(smallNum, bigNum % smallNum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        StringTokenizer token;
        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(bf.readLine());

            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());

            int greatestCommonDivisor = gcd(Math.max(A, B), Math.min(A, B)); // 최대 공약수
            int leastCommonMultiple = A * B / greatestCommonDivisor; // 최소 공배수

            System.out.println(leastCommonMultiple);
        }
    }
}
