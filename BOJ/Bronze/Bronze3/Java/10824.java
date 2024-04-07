/*
10824. Bronze 3 - 네 수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           30189	    13647     11943	         45.601%


    문제
        네 자연수 A, B, C, D가 주어진다. 이때, A와 B를 붙인 수와 C와 D를 붙인 수의 합을 구하는 프로그램을 작성하시오.
        두 수 A와 B를 합치는 것은 A의 뒤에 B를 붙이는 것을 의미한다. 즉, 20과 30을 붙이면 2030이 된다.


    입력
        첫째 줄에 네 자연수 A, B, C, D가 주어진다. (1 ≤ A, B, C, D ≤ 1,000,000)


    출력
        A와 B를 붙인 수와 C와 D를 붙인 수의 합을 출력한다.


    예제 입력 1
        10 20 30 40
    예제 출력 1
        4060


    알고리즘 분류
        수학
        구현
        문자열
        사칙연산
*/


// 메모리 : 14268KB
// 시간 : 128ms
// 코드 길이 : 554B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        long AB = Long.parseLong(token.nextToken() + token.nextToken());
        long CD = Long.parseLong(token.nextToken() + token.nextToken());

        System.out.println(AB + CD);
    }
}
