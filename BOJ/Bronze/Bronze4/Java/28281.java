/*
28281. Bronze 4 - 선물

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    1024 MB          1307	    873       835	         69.468%


    문제
        N일 뒤는 동원이의 생일이다. 축하해 주자!
        준원이는 동원이에게 생일 선물로 양말을 2X개 선물하려 한다. 양말은 시장에서 살 것이다. 연속한 이틀에 걸쳐서, 준원이는 매일 시장에서 양말을 X개씩 사서 트럭에 담아올 것이다.
        시장에서 양말의 가격은 날마다 다를 수 있다. 오늘부터 i번째 날에, 양말은 하나에 A_i원이다.
        동원이의 생일까지 N일 남았다! 남은 N일 가운데 연속한 이틀에 걸쳐 양말 2X개를 사는 데 드는 최소 비용은?


    입력
        첫째 줄에 N과 X가 공백을 사이에 두고 주어진다.
        둘째 줄에 N일간 양말의 가격 A_1, A_2, ···, A_N이 공백을 사이에 두고 주어진다.


    출력
        연속한 이틀에 걸쳐 하루에 양말을 X개씩 구매하는 방법으로, 양말 2X개를 사는 데 드는 최소 비용을 출력한다.


    제한
        · 2 ≤ N ≤ 100000
        · 1 ≤ X ≤ 1000000
        · 1 ≤ A_i ≤ 1000 (1 ≤ i ≤ N)


    예제 입력 1
        5 10
    9 2 5 7 6
    예제 출력 1
        70

    1번째 날과 2번째 날에 양말을 각각 10개씩 사면 총 9 × 10 + 2 × 10 = 110원이 든다.
    2번째 날과 3번째 날에 양말을 각각 10개씩 사면 총 2 × 10 + 5 × 10 = 70원이 든다.
    3번째 날과 4번째 날에 양말을 각각 10개씩 사면 총 5 × 10 + 7 × 10 = 120원이 든다.
    4번째 날과 5번째 날에 양말을 각각 10개씩 사면 총 7 × 10 + 6 × 10 = 130원이 든다.
    가능한 위 네 가지 경우 중 비용이 최소가 되는 경우는 2번째 날과 3번째 날에 양말을 사는 경우이며, 최소 비용은 70원이다.

    예제 입력 2
        7 142857
    22 35 9 12 25 19 10
    예제 출력 2
        2999997

    예제 2에서는 3번째 날과 4번째 날에 양말을 살 때 최소 비용으로 양말을 살 수 있다.


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 24188KB
// 시간 : 300ms
// 코드 길이 : 1002B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int X;
    static int cost[];

    public static void calculateMinCost() {
        int minCost = (cost[0] + cost[1]) * X;
        for (int n = 1; n < N - 1; n++) {
            minCost = Math.min(minCost, (cost[n] + cost[n + 1]) * X);
        }

        System.out.println(minCost);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken());

        cost = new int[N];
        token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(token.nextToken());
        }

        calculateMinCost();
    }
}
