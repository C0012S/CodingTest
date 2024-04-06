/*
9085. Bronze 3 - 더하기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           11518	    9157      8230	         80.371%


    문제
        10보다 작거나 같은 자연수 N개를 주면 합을 구하는 프로그램을 작성하시오.


    입력
        입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 각 테스트 케이스는 첫 줄에 자연수의 개수 N(1 ≤ N ≤ 100)이 주어지고, 그 다음 줄에는 N개의 자연수가 주어진다. 각각의 자연수 사이에는 하나씩의 공백이 있다.


    출력
        각 테스트 케이스에 대해서 주어진 자연수의 합을 한 줄에 하나씩 출력한다.


    예제 입력 1
        2
        5
        1 1 1 1 1
        7
        1 2 3 4 5 6 7
    예제 출력 1
        5
        28


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14064KB
// 시간 : 124ms
// 코드 길이 : 912B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수 (1 ≤ T ≤ 10)

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine()); // 자연수의 개수 (1 ≤ N ≤ 100)

            int sum = 0;
            token = new StringTokenizer(bf.readLine());
            for (int n = 0; n < N; n++) {
                sum += Integer.parseInt(token.nextToken());
            }

            sb.append(sum);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
