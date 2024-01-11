/*
10156. Bronze 4 - 과자

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           26801	    16684     15247	         62.429%


    문제
        동수는 제과점에 과자를 사러 가는데 현재 가진 돈이 모자랄 경우 부모님께 모자란 돈을 받으려고 한다. 과자 한 개의 가격이 K, 사려고 하는 과자의 개수가 N이고, 현재 가진 돈의 액수를 M이라 할 때 여러분은 동수가 부모님께 받아야 하는 모자란 돈을 계산하려고 한다.
        예를 들어, 과자 한 개의 가격이 30원, 사려고 하는 과자의 개수가 4개, 현재 동수가 가진 돈이 100원이라 할 때, 동수가 부모님께 받아야 하는 돈은 20원이다. 과자 한 개의 가격이 250원, 사려고 하는 과자의 개수가 2개, 현재 동수가 가진 돈이 140원이라 할 때, 동수가 부모님께 받아야 하는 돈은 360원이다. 과자 한 개의 가격이 20원, 사려고 하는 과자의 개수가 6개, 현재 동수가 가진 돈이 120원이라 할 때 동수가 부모님께 받아야 하는 돈은 0원이다. 과자 한 개의 가격이 20원, 사려고 하는 과자의 개수가 10개, 현재 동수가 가진 돈이 320원이라 할 때 동수가 부모님께 받아야 하는 돈은 역시 0원이다.
        과자 한 개의 가격, 사려고 하는 과자의 개수와 동수가 현재 가진 돈의 액수가 주어질 때 동수가 부모님께 받아야 하는 돈의 액수를 출력하는 프로그램을 작성하시오.


    입력
        첫 번째 줄에는 과자 한 개의 가격 K, 사려고 하는 과자의 개수 N, 현재 동수가 가진 돈 M이 각각 공백을 사이에 두고 주어진다. 단, K, N은 1,000 이하의 양의 정수이고, M은 10만 이하의 양의 정수이다. (1 ≤ K, N ≤ 1,000, 1 ≤ M ≤ 100,000이다.)


    출력
        첫 줄에 동수가 부모님께 받아야 하는 돈의 액수를 출력한다.


    예제 입력 1
        300 4 1000
    예제 출력 1
        200

    예제 입력 2
        250 2 140
    예제 출력 2
        360

    예제 입력 3
        20 6 120
    예제 출력 3
        0

    예제 입력 4
        20 10 320
    예제 출력 4
        0


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 14224KB
// 시간 : 124ms
// 코드 길이 : 957B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int N;
    static int M;

    public static void calculate() {
        int cost = K * N;
        int extraMoney = 0;
        if (cost > M) {
            extraMoney = cost - M;
        }

        System.out.println(extraMoney);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(token.nextToken()); // 과자 한 개의 가격 (1 ≤ K ≤ 1000)
        N = Integer.parseInt(token.nextToken()); // 사려고 하는 과자의 개수 (1 ≤ N ≤ 1000)
        M = Integer.parseInt(token.nextToken()); // 현재 동수가 가진 돈 (1 ≤ M ≤ 100000)

        calculate();
    }
}