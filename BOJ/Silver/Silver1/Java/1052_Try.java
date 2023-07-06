/*
1052. Silver 1 - 물병

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    512 MB           11196	    4291      3310	         38.827%


    문제
        지민이는 N개의 물병을 가지고 있다. 각 물병에는 물을 무한대로 부을 수 있다. 처음에 모든 물병에는 물이 1리터씩 들어있다. 지민이는 이 물병을 또 다른 장소로 옮기려고 한다. 지민이는 한 번에 K개의 물병을 옮길 수 있다. 하지만, 지민이는 물을 낭비하기는 싫고, 이동을 한 번보다 많이 하기는 싫다. 따라서, 지민이는 물병의 물을 적절히 재분배해서, K개를 넘지 않는 비어있지 않은 물병을 만들려고 한다.
        물은 다음과 같이 재분배 한다.
            · 먼저 같은 양의 물이 들어있는 물병 두 개를 고른다. 그 다음에 한 개의 물병에 다른 한 쪽에 있는 물을 모두 붓는다. 이 방법을 필요한 만큼 계속 한다.

        이런 제약 때문에, N개로 K개를 넘지않는 비어있지 않은 물병을 만드는 것이 불가능할 수도 있다. 다행히도, 새로운 물병을 살 수 있다. 상점에서 사는 물병은 물이 1리터 들어있다.

        예를 들어, N=3이고, K=1일 때를 보면, 물병 3개로 1개를 만드는 것이 불가능하다. 한 병을 또다른 병에 부으면, 2리터가 들어있는 물병 하나와, 1리터가 들어있는 물병 하나가 남는다. 만약 상점에서 한 개의 물병을 산다면, 2리터가 들어있는 물병 두 개를 만들 수 있고, 마지막으로 4리터가 들어있는 물병 한 개를 만들 수 있다.


    입력
        첫째 줄에 N과 K가 주어진다. N은 107보다 작거나 같은 자연수이고, K는 1,000보다 작거나 같은 자연수이다.


    출력
        첫째 줄에 상점에서 사야하는 물병의 최솟값을 출력한다. 만약 정답이 없을 경우에는 -1을 출력한다.


    예제 입력 1
        3 1
    예제 출력 1
        1

    예제 입력 2
        13 2
    예제 출력 2
        3

    예제 입력 3
        1000000 5
    예제 출력 3
        15808


    알고리즘 분류
        수학
        그리디 알고리즘
        비트마스킹
*/


// 코드 길이 : 2156B
// 시간 초과
// 오답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 처음 지민이가 갖고 있는 물병의 개수 N
    static int K; // 한 번에 옮길 수 있는 물병의 개수 K
    static int water[]; // water[물의 양] : 물의 양을 담고 있는 물병의 개수
    static int waterBottleNum; // 현재 물이 담겨 있는 물병의 전체 개수
    static int maxWater = 1; // 현재 있는 물의 양의 최댓값
    static int buy; // 상점에서 사야 하는 물병의 개수

    public static int calculateBottle() {
        if (N <= K) {
            return 0;
        }

        while (waterBottleNum > K) {
            if (water[1] <= 1) { // 1L 물병 구매
                water[1] += 1;
                buy += 1;
                waterBottleNum += 1;
            }

            for (int i = 1; i <= maxWater; i++) {
                int waterNum = water[i]; // 해당 물의 양의 물병의 개수

                if (waterNum >= 2) { // 같은 물의 양의 물병이 있을 경우 (해당 물의 양의 물병의 개수가 2 개 이상일 경우, 같은 물의 양의 물병이 있다고 판단해 물을 분배하는 과정 수행)
                    water[i] = waterNum % 2; // waterNum % 2 : 물을 합치고 남은 물병 개수
                    water[i * 2] += waterNum / 2; // waterNum / 2 : 물을 합쳐서 생긴 물병의 개수

                    maxWater = Math.max(maxWater, i * 2);
                    waterBottleNum = (waterBottleNum - waterNum) + water[i] + waterNum / 2;
                }
            }
        }

        return buy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        water = new int[N * 2];
        water[1] = N;
        waterBottleNum = N;

        System.out.println(calculateBottle());
    }
}
