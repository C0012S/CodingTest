/*
2798. Bronze 2 - 블랙잭

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           166582	    82874     63450	         48.525%


    문제
        카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
        한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
        김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
        이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
        N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.


    입력
        첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
        합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.


    출력
        첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.


    예제 입력 1
        5 21
        5 6 7 8 9
    예제 출력 1
        21

    예제 입력 2
        10 500
        93 181 245 214 315 36 185 138 216 295
    예제 출력 2
        497


    알고리즘 분류
        브루트포스 알고리즘
*/


// 메모리 : 14144KB
// 시간 : 120ms
// 코드 길이 : 1850B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 카드의 개수 N (3 ≤ N ≤ 100)
    static int M; // 카드 3 장의 합이 넘지 않아야 하는 수 (10 ≤ M ≤ 300000)
    static int card[]; // 카드에 적힌 숫자를 저장하는 배열
    static int pickSum; // M을 넘지 않으면서 M에 최대한 가까운 카드 3 장의 합

    public static void pick(int startIndex) { // 3 장의 카드를 골라 카드 3 장의 합을 구하는 메서드  // pick(첫 번째로 고르는 카드의 인덱스)
        if (startIndex == N - 3 + 1) { // 3 장의 카드를 골라야 하므로 첫 번째로 고르는 카드 이후로 2 개의 카드가 더 없을 경우
            System.out.println(pickSum);
            return;
        }

        int sum = card[startIndex]; // 카드 3 장의 합
        for (int n = startIndex + 1; n < N; n++) {
            sum += card[n];
            for (int d = n + 1; d < N; d++) {
                if (sum + card[d] <= M) { // 카드 3 장의 합이 M을 넘지 않을 경우
                    pickSum = Math.max(pickSum, sum + card[d]);
                }
            }

            sum -= card[n];
        }

        pick(startIndex + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        card = new int[N];
        token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(token.nextToken());
        }

        pick(0);
    }
}
