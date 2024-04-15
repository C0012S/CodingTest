/*
25494. Bronze 4 - 단순한 문제 (Small)

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    1024 MB          2871	    2247      1990	         79.760%


    문제
        세 양의 정수 a, b, c가 주어질 때, 다음 조건을 만족하는 정수 쌍 (x, y, z)의 개수를 구하시오.
            · 1 ≤ x ≤ a
            · 1 ≤ y ≤ b
            · 1 ≤ z ≤ c
            · (x mod y) = (y mod z) = (z mod x)

        (A mod B)는 A를 B로 나눈 나머지를 의미한다.


    입력
        첫째 줄에 테스트 케이스의 수 T가 주어진다. (1 ≤ T ≤ 100)
        다음 T개의 각 줄에는 세 정수 a, b, c가 공백으로 구분되어 주어진다. (1 ≤ a, b, c ≤ 60)


    출력
        한 줄에 하나씩 정답을 출력한다.


    예제 입력 1
        2
        1 2 3
        3 2 4
    예제 출력 1
        1
        2

    첫 번째 예시에서 조건을 만족하는 쌍은 (1, 1, 1)이다.
    두 번째 예시에서 조건을 만족하는 쌍은 (1, 1, 1)과 (2, 2, 2)이다.


    알고리즘 분류
        수학
        브루트포스 알고리즘
        사칙연산
*/


// 메모리 : 14180KB
// 시간 : 120ms
// 코드 길이 : 905B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수 (1 ≤ T ≤ 100)

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            int answer = Math.min(Math.min(a, b), c);
            sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
