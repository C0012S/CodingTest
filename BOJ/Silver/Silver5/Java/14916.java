/*
14916. Silver 5 - 거스름돈

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    2 초         512 MB           18345      8405       7018           47.082%


    문제
        춘향이는 편의점 카운터에서 일한다.
        손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다. 2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다. 동전의 개수가 최소가 되도록 거슬러 주어야 한다. 거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.
        예를 들어, 거스름돈이 15원이면 5원짜리 3개를, 거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를, 거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야 동전의 개수가 최소가 된다.


    입력
        첫째 줄에 거스름돈 액수 n(1 ≤ n ≤ 100,000)이 주어진다.


    출력
        거스름돈 동전의 최소 개수를 출력한다. 만약 거슬러 줄 수 없으면 -1을 출력한다.


    예제 입력 1
        13
    예제 출력 1
        5

    예제 입력 2
        14
    예제 출력 2
        4


    알고리즘 분류
        수학
        다이나믹 프로그래밍
        그리디 알고리즘
*/


// 메모리 : 14224KB
// 시간 : 124ms
// 코드 길이 : 1664B
// Greedy Algorithm
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void calculateMinCoinNum(int n) { // 거스름돈 동전의 최소 개수를 출력하는 함수
        int fiveCoinNum = n / 5; // 5 원 짜리 동전의 개수
        int twoCoinNum = 0; // 2 원 짜리 동전의 개수
        n -= fiveCoinNum * 5; // 5 원 짜리 동전을 최대한 많이 내고 남은 금액

        int coinNum = fiveCoinNum; // 거스름돈 동전의 최소 개수
        while (n != 0) {
            twoCoinNum = n / 2; // 남은 금액에서 낼 수 있는 2 원 짜리 동전의 개수
            if (n % 2 == 0) { // 만약 남은 금액을 2 원 짜리 동전으로 모두 낼 수 있다면
                coinNum += twoCoinNum; // 낼 거스름돈 동전의 개수에 2 원 짜리 동전의 개수 추가
                break;
            }

            // 남은 금액을 2 원 짜리 동전으로 모두 낼 수 없을 경우
            fiveCoinNum -= 1; // 5 원 짜리 동전의 개수 감소
            n += 5; // 남은 금액 + 5 원
            coinNum -= 1; // 냈던 거스름돈 동전의 개수 감소

            if (fiveCoinNum < 0) { // 거슬러 줄 수 없을 경우
                coinNum = -1;
                break;
            }
        }

        System.out.println(coinNum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 거스름돈 액수 n (1 ≤ n ≤ 100,000)

        calculateMinCoinNum(n);
    }
}
