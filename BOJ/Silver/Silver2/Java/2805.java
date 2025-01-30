/*
2805. Silver 2 - 나무 자르기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           229556	    68913     42755	         26.659%


    문제
        상근이는 나무 M미터가 필요하다. 근처에 나무를 구입할 곳이 모두 망해버렸기 때문에, 정부에 벌목 허가를 요청했다. 정부는 상근이네 집 근처의 나무 한 줄에 대한 벌목 허가를 내주었고, 상근이는 새로 구입한 목재절단기를 이용해서 나무를 구할것이다.
        목재절단기는 다음과 같이 동작한다. 먼저, 상근이는 절단기에 높이 H를 지정해야 한다. 높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다. 그 다음, 한 줄에 연속해있는 나무를 모두 절단해버린다. 따라서, 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다. 예를 들어, 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자. 상근이가 높이를 15로 지정했다면, 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고, 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다. (총 7미터를 집에 들고 간다) 절단기에 설정할 수 있는 높이는 양의 정수 또는 0이다.
        상근이는 환경에 매우 관심이 많기 때문에, 나무를 필요한 만큼만 집으로 가져가려고 한다. 이때, 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 나무의 수 N과 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다. (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)
        둘째 줄에는 나무의 높이가 주어진다. 나무의 높이의 합은 항상 M보다 크거나 같기 때문에, 상근이는 집에 필요한 나무를 항상 가져갈 수 있다. 높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.


    출력
        적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.


    예제 입력 1
        4 7
        20 15 10 17
    예제 출력 1
        15

    예제 입력 2
        5 20
        4 42 40 26 46
    예제 출력 2
        36


    알고리즘 분류
        이분 탐색
        매개 변수 탐색
*/


// 메모리 : 123448KB
// 시간 : 1100ms
// 코드 길이 : 2585B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; // 나무의 수 (1 ≤ N ≤ 1000000)
    static int M; // 집으로 가져가려고 하는 나무의 길이 (1 ≤ M ≤ 2000000000)
    static long[] tree; // 각 나무의 높이를 저장하는 배열
    static long maxHeight; // 나무의 높이가 가장 높은 나무의 높이
    static long heightSum; // 절단기를 이용하여 가져가는 나무의 높이

    public static void calculate(long height) { // 절단기를 이용하여 가져가는 나무의 높이를 구하는 메서드
        heightSum = 0;
        for (int n = 0; n < N; n++) {
            if (tree[n] - height > 0) { // 절단기를 이용하여 절단할 수 있는 나무일 경우
                heightSum += (tree[n] - height);
            }
        }
    }

    public static void find() { // 적어도 M 미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 메서드
        Arrays.sort(tree); // 나무의 높이 정렬

        long left = 0; // 절단기에 설정할 수 있는 높이의 하한선
        long right = maxHeight; // 절단기에 설정할 수 있는 높이의 상한선

        while (left <= right) {
            long mid = (left + right) / 2; // 절단기에 설정할 수 있는 높이의 하한선과 상한선의 중간 값

            calculate(mid); // 절단기를 이용하여 가져가는 나무의 높이 계산

            if (heightSum < M) { // 절단기를 이용하여 가져가는 나무의 높이가 M 미터 미만일 경우
                right = mid - 1;
            }
            else { // 절단기를 이용하여 가져가는 나무의 높이가 M 미터 이상일 경우
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        tree = new long[N];
        maxHeight = Long.MIN_VALUE;
        token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(token.nextToken());

            maxHeight = Math.max(maxHeight, tree[i]);
        }

        find();
    }
}
