/*
25304. Bronze 4 - 영수증

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    1024 MB          94336	    52750     47183	         56.695%


    문제
        준원이는 저번 주에 살면서 처음으로 코스트코를 가 봤다. 정말 멋졌다. 그런데, 몇 개 담지도 않았는데 수상하게 높은 금액이 나오는 것이다! 준원이는 영수증을 보면서 정확하게 계산된 것이 맞는지 확인해보려 한다.
        영수증에 적힌,
            · 구매한 각 물건의 가격과 개수
            · 구매한 물건들의 총 금액
        을 보고, 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하는지 검사해보자.


    입력
        첫째 줄에는 영수증에 적힌 총 금액 X가 주어진다.
        둘째 줄에는 영수증에 적힌 구매한 물건의 종류의 수 N이 주어진다.
        이후 N개의 줄에는 각 물건의 가격 a와 개수 b가 공백을 사이에 두고 주어진다.


    출력
        구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하면 Yes를 출력한다. 일치하지 않는다면 No를 출력한다.


    제한
        · 1 ≤ X ≤ 1000000000
        · 1 ≤ N ≤ 100
        · 1 ≤ a ≤ 1000000
        · 1 ≤ b ≤ 10


    예제 입력 1
        260000
        4
        20000 5
        30000 2
        10000 6
        5000 8
    예제 출력 1
        Yes
    영수증에 적힌 구매할 물건들의 목록으로 계산한 총 금액은 20000 × 5 + 30000 × 2 + 10000 × 6 + 5000 × 8 = 260000원이다. 이는 영수증에 적힌 총 금액인 260000원과 일치한다.

    예제 입력 2
        250000
        4
        20000 5
        30000 2
        10000 6
        5000 8
    예제 출력 2
        No


    알고리즘 분류
        수학
        구현
        사칙연산
        메모
*/


// 메모리 : 14188KB
// 시간 : 120ms
// 코드 길이 : 1377B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int X = Integer.parseInt(bf.readLine()); // 영수증에 적힌 총 금액 X (1 ≤ X ≤ 1000000000)
        int N = Integer.parseInt(bf.readLine()); // 영수증에 적힌 구매한 물건의 종류의 수 N (1 ≤ N ≤ 100)

        int cost = 0; // 구매한 물건의 가격과 개수로 계산한 총 금액
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(token.nextToken()); // 각 물건의 가격 a (1 ≤ a ≤ 1000000)
            int b = Integer.parseInt(token.nextToken()); // 각 물건의 개수 b (1 ≤ b ≤ 10)

            cost += a * b;
        }

        if (X == cost) { // 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치할 경우
            System.out.println("Yes");
        }
        else { // 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하지 않을 경우
            System.out.println("No");
        }
    }
}
