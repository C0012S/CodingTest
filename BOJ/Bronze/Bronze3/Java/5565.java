/*
5565. Bronze 3 - 영수증

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           15521	    13515     12514	         87.978%


    문제
        새 학기를 맞아 상근이는 책을 10권 구입했다. 상근이는 의욕이 너무 앞서서 가격을 조사하지 않고 책을 구입했다. 이제 각 책의 가격을 알아보려고 한다.
        하지만, 영수증에는 얼룩이 묻어있었고, 상근이는 책 10권 중 9권의 가격만 읽을 수 있었다.
        책 10권의 총 가격과 가격을 읽을 수 있는 9권 가격이 주어졌을 때, 가격을 읽을 수 없는 책의 가격을 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 10권의 총 가격이 주어진다. 둘째 줄부터 9개 줄에는 가격을 읽을 수 있는 책 9권의 가격이 주어진다. 책의 가격은 10,000이하인 양의 정수이다.


    출력
        첫째 줄에 가격을 읽을 수 없는 책의 가격을 출력한다.


    예제 입력 1
        9850
        1050
        800
        420
        380
        600
        820
        2400
        1800
        980
    예제 출력 1
        600


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14112KB
// 시간 : 120ms
// 코드 길이 : 457B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cost = Integer.parseInt(bf.readLine());

        for (int c = 0; c < 9; c++) {
            cost -= Integer.parseInt(bf.readLine());
        }

        System.out.println(cost);
    }
}
