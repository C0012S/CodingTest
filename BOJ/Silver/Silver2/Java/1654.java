/*
1654. Silver 2 - 랜선 자르기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           256077	    61741     41741	         21.730%


    문제
        집에서 시간을 보내던 오영식은 박성원의 부름을 받고 급히 달려왔다. 박성원이 캠프 때 쓸 N개의 랜선을 만들어야 하는데 너무 바빠서 영식이에게 도움을 청했다.
        이미 오영식은 자체적으로 K개의 랜선을 가지고 있다. 그러나 K개의 랜선은 길이가 제각각이다. 박성원은 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다. 예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm는 버려야 한다. (이미 자른 랜선은 붙일 수 없다.)
        편의를 위해 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며, 기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자. 그리고 자를 때는 항상 센티미터 단위로 정수길이만큼 자른다고 가정하자. N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다. 이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에는 오영식이 이미 가지고 있는 랜선의 개수 K, 그리고 필요한 랜선의 개수 N이 입력된다. K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수이다. 그리고 항상 K ≦ N 이다. 그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다. 랜선의 길이는 231-1보다 작거나 같은 자연수이다.


    출력
        첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다.


    예제 입력 1
        4 11
        802
        743
        457
        539
    예제 출력 1
        200


    힌트
        802cm 랜선에서 4개, 743cm 랜선에서 3개, 457cm 랜선에서 2개, 539cm 랜선에서 2개를 잘라내 모두 11개를 만들 수 있다.


    알고리즘 분류
        이분 탐색
        매개 변수 탐색
*/


// 메모리 : 17768KB
// 시간 : 164ms
// 코드 길이 : 2497B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K; // 이미 가지고 있는 랜선의 개수 (1 ≤ K ≤ 10000)
    static int N; // 필요한 랜선의 개수 (1 ≤ N ≤ 1000000)
    static long[] lan; // 각 랜선의 길이를 저장하는 배열
    static long maxLength; // 이미 가지고 있는 랜선의 길이 중 가장 긴 랜선의 길이

    public static int calculate(long length) { // 이미 가지고 있는 랜선으로 만들 수 있는 랜선의 개수를 구하는 메서드
        int sum = 0; // 랜선의 개수
        for (int k = 0; k < K; k++) {
            sum += lan[k] / length;
        }

        return sum;
    }

    public static void find() { // N 개 이상 만들 수 있는 랜선의 최대 길이를 구하는 메서드
        long right = maxLength; // 랜선의 길이의 상한선 (랜선의 길이는 해당 길이 미만이어야 한다.)
        long left = 0; // 랜선의 길이의 하한선 (랜선의 길이는 해당 길이 이상이어야 한다.)

        if (calculate(right) >= N) { // 이미 가지고 있는 랜선의 길이 중 가장 긴 랜선의 길이로 만든 랜선의 개수가 N 개 이상일 경우
            System.out.println(right); // 이미 가지고 있는 랜선의 길이 중 가장 긴 랜선의 길이가 N 개 이상 만들 수 있는 랜선의 최대 길이

            return;
        }

        while (right - left > 1) {
            long mid = left + (right - left) / 2; // 랜선의 길이의 상한선과 하한선의 중간 값
            if (calculate(mid) < N) { // 만든 랜선의 개수가 N 개 미만일 경우
                right = mid;
            }
            else { // 만든 랜선의 개수가 N 개 이상일 경우
                left = mid;
            }
        }

        System.out.println(left);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        lan = new long[K];
        maxLength = Long.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            lan[i] = Long.parseLong(bf.readLine());

            maxLength = Math.max(maxLength, lan[i]);
        }

        find();
    }
}