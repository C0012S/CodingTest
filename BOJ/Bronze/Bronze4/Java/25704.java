/*
25704. Bronze 4 - 출석 이벤트

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    1024 MB          4386	    1668      1536	         39.005%


    문제
        쇼핑몰에서 30일간 출석 이벤트를 진행한다. 쇼핑몰의 사이트를 방문하면 1일 1회 출석 도장을 받을 수 있고, 출석 도장을 여러 개 모아서 할인 쿠폰으로 교환할 수 있다.

        출석 도장의 개수에 따라 교환할 수 있는 할인 쿠폰의 종류가 달라진다.
            · 출석 도장 5개   → 500원 할인 쿠폰
            · 출석 도장 10개 → 10% 할인 쿠폰
            · 출석 도장 15개 → 2,000원 할인 쿠폰
            · 출석 도장 20개 → 25% 할인 쿠폰

        경태가 모은 출석 도장의 개수와 구매할 물건의 가격이 주어졌을 때, 경태가 지불해야 하는 최소 금액을 구하시오. 단, 할인 쿠폰은 최대 하나만 적용 가능하다. 할인 금액이 물건의 가격보다 더 큰 경우 지불해야 하는 금액은 0원이다.


    입력
        첫째 줄에 경태가 모은 출석 도장의 개수 N이 주어진다.
        둘째 줄에 경태가 구매할 물건의 가격 P가 주어진다. P는 항상 100의 배수이다.


    출력
        첫째 줄에 정답을 출력한다.


    제한
        · 0 ≤ N ≤ 30
        · 100 ≤ P ≤ 50,000
        · 입력으로 주어지는 모든 수는 정수이다.


    예제 입력 1
        12
        50000
    예제 출력 1
        45000

    예제 입력 2
        23
        3000
    예제 출력 2
        1000


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14264KB
// 시간 : 128ms
// 코드 길이 : 1065B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 출석 도장의 개수 (0 ≤ N ≤ 30)
        int P = Integer.parseInt(bf.readLine()); // 경태가 구매할 물건의 가격 (100 ≤ P ≤ 50000)

        int price = P;
        if (N >= 5 && N < 10) {
            price = P - 500;
        }
        else if (N >= 10 && N < 15) {
            price = Math.min((int) (P * 0.9), (P - 500));
        }
        else if (N >= 15 && N < 20) {
            price = Math.min((int) (P * 0.9), (P - 2000));
            price = Math.min(price, P - 500);
        }
        else if (N >= 20) {
            price = Math.min((P - 2000), (int) (P * 0.75));
            price = Math.min(price, P - 500);
        }

        if (price < 0) {
            price = 0;
        }

        System.out.println(price);
    }
}
