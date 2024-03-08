/*
3135. Silver 5 - 라디오

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           3682	    2252      2031	         62.224%


    문제
        준하는 라디오 수집광으로 신제품의 라디오가 나올때마다 흥분을 금치 못한다고 한다.

        최근 준하가 구입한 라디오는 매우 하이테크 한데, 그 라디오에는 다음과 같은 버튼이 있다.
            · 첫 번째 버튼은 주파수를 1MHz 증가시킨다.
            · 두 번째 버튼은 주파수를 1MHz 감소시킨다.
            · 나머지 N개의 버튼은 즐겨찾기 기능으로, 미리 지정된 주파수로 이동한다.

        준하는 몸이 안좋아 하루에 손가락을 몇 번 움직이지 못하기 때문에 우리의 도움이 필요하다.
        현재 주파수 A와 듣고싶은 주파수 B가 주어질 때,
        주파수 A에서 B로 갈 때 눌러야 하는 가장 적은 버튼수를 구해주자.


    입력
        첫 줄엔 정수 A와 B가 주어진다 (1 ≤ A, B < 1000, A ≠ B).
        다음 줄엔 정수 N이 주어진다 (1 ≤ N ≤ 5).
        다음 N개의 줄엔 미리 지정되어 있는 주파수가 주어진다 (주파수는 1000 보다 작다).


    출력
        주파수 A에서 B로 갈 때 눌러야 하는 버튼수의 최솟값을 출력한다.


    예제 입력 1
        100 15
        1
        15
    예제 출력 1
        1

    예제 입력 2
        88 17
        3
        18
        1
        42
    예제 출력 2
        2

    예제 입력 3
        64 120
        1
        567
    예제 출력 3
        56


    알고리즘 분류
        수학
        그리디 알고리즘
*/


// 메모리 : 14168KB
// 시간 : 124ms
// 코드 길이 : 1333B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(token.nextToken()); // 현재 주파수
        int B = Integer.parseInt(token.nextToken()); // 듣고 싶은 주파수

        int minButton = Math.abs(A - B); // 즐겨찾기 버튼을 사용하지 않고, 현재 주파수에서 듣고 싶은 주파수로 가기 위해 눌러야 하는 버튼 수

        int N = Integer.parseInt(bf.readLine()); // 미리 지정되어 있는 주파수의 개수
        for (int n = 0; n < N; n++) {
            int bookmark = Integer.parseInt(bf.readLine()); // 즐겨찾기 버튼을 이용하여 이동할 수 있는 주파수

            minButton = Math.min(minButton, Math.abs(B - bookmark) + 1); // Math.min(지금까지 현재 주파수에서 듣고 싶은 주파수로 가기 위해 눌러야 하는 버튼 수의 최솟값, 즐겨찾기 버튼을 사용하여 듣고 싶은 주파수로 가기 위해 눌러야 하는 버튼 수)
        }

        System.out.println(minButton);
    }
}
