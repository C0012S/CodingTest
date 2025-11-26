/*
1715. Gold 4 - 카드 정렬하기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           88256	    32650     24937	         36.008%


    문제
        정렬된 두 묶음의 숫자 카드가 있다고 하자. 각 묶음의 카드의 수를 A, B라 하면 보통 두 묶음을 합쳐서 하나로 만드는 데에는 A+B 번의 비교를 해야 한다. 이를테면, 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요하다.
        매우 많은 숫자 카드 묶음이 책상 위에 놓여 있다. 이들을 두 묶음씩 골라 서로 합쳐나간다면, 고르는 순서에 따라서 비교 횟수가 매우 달라진다. 예를 들어 10장, 20장, 40장의 묶음이 있다면 10장과 20장을 합친 뒤, 합친 30장 묶음과 40장을 합친다면 (10 + 20) + (30 + 40) = 100번의 비교가 필요하다. 그러나 10장과 40장을 합친 뒤, 합친 50장 묶음과 20장을 합친다면 (10 + 40) + (50 + 20) = 120 번의 비교가 필요하므로 덜 효율적인 방법이다.
        N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100,000) 이어서 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다. 숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수이다.


    출력
        첫째 줄에 최소 비교 횟수를 출력한다.


    예제 입력 1
        3
        10
        20
        40
    예제 출력 1
        100


    알고리즘 분류
        자료 구조
        그리디 알고리즘
        우선순위 큐
*/


// 메모리 : 25912KB
// 시간 : 344ms
// 코드 길이 : 1334B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N; // 숫자 카드 묶음의 개수 (1 ≤ N ≤ 100000)
    static PriorityQueue<Integer> cardQueue; // 각 카드 묶음의 카드의 수를 저장하는 우선 순위 큐

    public static void find() { // 주어진 카드 묶음들을 하나의 카드 묶음으로 만들 때 필요한 비교 횟수의 최솟값을 구하는 메서드
        int allCount = 0; // 모든 카드 묶음을 합치기 위해 필요한 카드의 비교 횟수

        while (cardQueue.size() >= 2) {
            int cardNum = cardQueue.poll() + cardQueue.poll(); // 두 카드 묶음을 합쳐서 만든 카드의 수 (== 두 카드 묶음을 합치기 위해 카드를 비교한 횟수)

            allCount += cardNum;
            cardQueue.offer(cardNum);
        }

        System.out.println(allCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        cardQueue = new PriorityQueue<>();
        for (int n = 0; n < N; n++) {
            cardQueue.offer(Integer.parseInt(bf.readLine()));
        }

        find();
    }
}
