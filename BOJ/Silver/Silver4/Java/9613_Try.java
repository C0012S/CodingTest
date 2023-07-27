/*
9613. Silver 4 - GCD 합

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           32812	    13295     10889	         41.317%


    문제
        양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 테스트 케이스의 개수 t (1 ≤ t ≤ 100)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있다. 각 테스트 케이스는 수의 개수 n (1 < n ≤ 100)가 주어지고, 다음에는 n개의 수가 주어진다. 입력으로 주어지는 수는 1,000,000을 넘지 않는다.


    출력
        각 테스트 케이스마다 가능한 모든 쌍의 GCD의 합을 출력한다.


    예제 입력 1
        3
        4 10 20 30 40
        3 7 5 12
        3 125 15 25
    예제 출력 1
        70
        3
        35


    알고리즘 분류
        수학
        정수론
        유클리드 호제법
*/


// 코드 길이 : 1427B
// 오답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int gcd(int bigNum, int smallNum) { // 유클리드 호제법  // GCD(Greatest Common Divisor) : 최대 공약수
        if (smallNum == 0) {
            return bigNum;
        }
        else {
            return gcd(smallNum, bigNum % smallNum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수

        StringTokenizer token;
        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(token.nextToken()); // 양의 정수의 개수
            int nums[] = new int[N]; // 양의 정수 배열
            int sum = 0; // 가능한 모든 쌍의 GCD의 합

            for (int n = 0; n < N; n++) {
                nums[n] = Integer.parseInt(token.nextToken());
            }

            for (int a = 0; a < N; a++) { // 가능한 모든 쌍의 GCD의 합 계산
                for (int b = a + 1; b < N; b++) {
                    sum += gcd(Math.max(nums[a], nums[b]), Math.min(nums[a], nums[b]));
                }
            }

            System.out.println(sum);
        }
    }
}
