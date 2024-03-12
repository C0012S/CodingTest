/*
2476. Bronze 3 - 주사위 게임

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           21303	    11112     10135	         54.410%


    문제
        1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.
            1. 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
            2. 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
            3. 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.

        예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다. 또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다. 3개의 눈이 6, 2, 5로 주어지면 그 중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.
        N(2 ≤ N ≤ 1,000)명이 주사위 게임에 참여하였을 때, 가장 많은 상금을 받은 사람의 상금을 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에는 참여하는 사람 수 N이 주어지고 그 다음 줄부터 N개의 줄에 사람들이 주사위를 던진 3개의 눈이 빈칸을 사이에 두고 각각 주어진다.


    출력
        첫째 줄에 가장 많은 상금을 받은 사람의 상금을 출력한다.


    예제 입력 1
        3
        3 3 6
        2 2 2
        6 2 5
    예제 출력 1
        12000


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14560KB
// 시간 : 136ms
// 코드 길이 : 1524B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 참여하는 사람 수 (2 ≤ N ≤ 1000)

        StringTokenizer token;
        int maxMoney = Integer.MIN_VALUE;
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(bf.readLine());
            int dice1 = Integer.parseInt(token.nextToken()); // 주사위 눈 1
            int dice2 = Integer.parseInt(token.nextToken()); // 주사위 눈 2
            int dice3 = Integer.parseInt(token.nextToken()); // 주사위 눈 3

            int money = 0;
            if ((dice1 == dice2) && (dice2 == dice3)) { // 같은 눈이 3 개 나올 경우
                money = 10000 + (dice1 * 1000);
            }
            else if ((dice1 == dice2) || (dice1 == dice3)) { // 같은 눈이 2 개 나올 경우
                money = 1000 + (dice1 * 100);
            }
            else if (dice2 == dice3) { // 같은 눈이 2 개 나올 경우
                money = 1000 + (dice2 * 100);
            }
            else { // 모두 다른 눈이 나올 경우
                money = Math.max(dice1, Math.max(dice2, dice3)) * 100;
            }

            maxMoney = Math.max(maxMoney, money);
        }

        System.out.println(maxMoney);
    }
}
