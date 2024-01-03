/*
10871. Bronze 5 - X보다 작은 수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           292357	    159609    129285	     54.333%


    문제
        정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
        둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.


    출력
        X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.


    예제 입력 1
        10 5
        1 10 4 9 2 3 8 5 7 6
    예제 출력 1
        1 4 2 3


    알고리즘 분류
        구현
*/


// 메모리 : 15296KB
// 시간 : 164ms
// 코드 길이 : 886B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int X;
    static StringBuilder sb;

    public static void compare(int x) {
        if (x < X) {
            sb.append(x);
            sb.append(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(bf.readLine());
        sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            compare(Integer.parseInt(token.nextToken()));
        }

        System.out.println(sb);
    }
}
