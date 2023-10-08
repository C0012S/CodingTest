/*
16204. Bronze 4 - 카드 뽑기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    512 MB           4179	    3237      2860	         78.206%


    문제
        앞 면에 O와 X가 적혀있는 카드 N개가 있다. N개의 카드 중 M개의 카드의 앞면에는 O가 한 개 적혀있고, 나머지 N-M개의 카드의 앞면에는 X가 한 개 적혀있다. 카드의 뒷 면은 두 종류의 카드 모두 같은 모양이라 구분할 수 없다.
        카드의 뒷 면에 O나 X를 하나씩 적으려고 한다. 이 때, O는 K개, X는 N-K개 적으려고 한다.
        앞 면과 뒷 면에 같은 모양이 적혀있는 카드의 최대 개수를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 N, M, K가 주어진다. (1 ≤ N ≤ 1,000,000, 0 ≤ M, K ≤ N)


    출력
        첫째 줄에 앞 면과 뒷 면에 같은 모양이 적혀있는 카드의 최대 개수를 출력한다.


    예제 입력 1
        4 3 2
    예제 출력 1
        3

    예제 입력 2
        10 0 10
    예제 출력 2
        0

    예제 입력 3
        5 3 3
    예제 출력 3
        5

    예제 입력 4
        7 5 2
    예제 출력 4
        4


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14328KB
// 시간 : 128ms
// 코드 길이 : 776B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken()); // 카드 개수 N (1 ≤ N ≤ 1,000,000)
        int M = Integer.parseInt(token.nextToken()); // 카드의 뒷 면에 적으려는 O의 개수 M (0 ≤ M ≤ N)
        int K = Integer.parseInt(token.nextToken()); // 카드의 뒷 면에 적으려는 X의 개수 K (0 ≤ K ≤ N)

        System.out.println(Math.min(M, K) + Math.min(N - M, N - K));
    }
}
