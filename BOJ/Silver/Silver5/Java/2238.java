/*
2238. Silver 5 - 경매

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           1644	    616       505	         43.460%


    문제
        경매는 여러 사람이 하나의 물건을 사려고 할 때, 각 사람이 원하는 가격을 제시하면 그 중 가장 높은 가격으로 물건을 팔게 되는 방식이다. 이러한 고전적인 경매 방식은 꽤 널리 쓰이는데, 최근에는 인터넷 쇼핑몰에서 반대의 경매 방식을 택하기도 한다. 즉, 여러 사람이 가격을 제시하면, 그 중 가장 낮은 가격으로 물건을 팔게 되는 방식도 쓰인다.
        하지만 이럴 경우, 모든 사람들이 1원에 물건을 사겠다고 하는 사태가 발생할 수 있다. 따라서 같은 가격을 제시한 사람이 둘 이상일 경우에는 무효로 하는 방식이 쓰인다. 하지만 모든 가격을 여러 사람이 제시하는 경우도 있을 수 있기 때문에, 다음과 같은 방식으로 경매 당첨자를 선택하기로 한다.
        우선 가장 적은 수의 사람이 제시한 가격을 찾는다. 이러한 경우가 여럿 있다면, 가장 낮은 가격으로 물건을 팔게 된다. 이때, 그 가격을 제시한 사람들 중에서 가장 먼저 제시한 사람이 물건을 살 수 있게 된다.
        각각의 사람들이 제시한 가격이 주어졌을 때, 경매에 낙찰(당첨)되는 사람을 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 두 정수 U(1 ≤ U ≤ 10,000), N(1 ≤ N ≤ 100,000)이 주어진다. U는 금액의 상한이고, N은 경매에 참여한 회수이다. 다음 N개의 줄에는 사람 이름 S(공백 없는 알파벳 대소문자 10자 이하)와, 그 사람이 제시한 가격 P(1 ≤ P ≤ U, 정수)이 경매에 참여한(가격을 제시한) 순서대로 주어진다.


    출력
        첫째 줄에 낙찰된 사람의 이름과 그 가격을 출력한다.


    예제 입력 1
        10 4
        Lew 10
        CD 5
        Fe 5
        CD 7
    예제 출력 1
        CD 7


    알고리즘 분류
        구현
*/


// 메모리 : 38872KB
// 시간 : 360ms
// 코드 길이 : 2178B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int U = Integer.parseInt(token.nextToken()); // 금액의 상한 (1 ≤ U ≤ 10000)
        int N = Integer.parseInt(token.nextToken()); // 경매에 참여한 회수 (1 ≤ N ≤ 100000)

        Map<Integer, String> priceMap = new HashMap<>(); // key 가격을 최초로 제시한 사람을 저장하는 HashMap
        int priceNum[] = new int[U + 1]; // 해당 인덱스의 가격을 제시한 사람의 수
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(bf.readLine());
            String S = token.nextToken(); // 경매에 참여한 사람 (공백 없는 알파벳 대소문자 10 자 이하)
            int P = Integer.parseInt(token.nextToken()); // 경매에 참여한 사람이 제시한 가격 (1 ≤ P ≤ U, 정수)

            if (P <= U) {
                if (priceNum[P] == 0) { // 해당 가격을 제시한 사람이 없을 경우
                    priceMap.put(P, S);
                }

                priceNum[P] += 1; // 해당 가격을 제시한 사람의 수 추가
            }
        }

        int minPriceNum = Integer.MAX_VALUE; // 가격을 제시한 사람의 수 중 가장 적은 사람의 수
        for (int peopleNum : priceNum) {
            if (peopleNum != 0) {
                minPriceNum = Math.min(minPriceNum, peopleNum);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int u = 1; u <= U; u++) {
            if (priceNum[u] == minPriceNum) { // 가장 적은 수의 사람이 제시한 가격 중 제일 낮은 가격을 가장 먼저 제시했을 경우
                sb.append(priceMap.get(u)); // 낙찰된 사람의 이름
                sb.append(" ");
                sb.append(u); // 낙찰된 가격

                break;
            }
        }

        System.out.println(sb);
    }
}
