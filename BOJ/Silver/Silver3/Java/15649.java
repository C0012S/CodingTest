/*
15649. Silver 3 - N과 M (1)

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    1 초         512 MB           100706     64092      41217          62.701%


    문제
        자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
            · 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열


    입력
        첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)


    출력
        한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
        수열은 사전 순으로 증가하는 순서로 출력해야 한다.


    예제 입력 1
        3 1
    예제 출력 1
        1
        2
        3

    예제 입력 2
        4 2
    예제 출력 2
        1 2
        1 3
        1 4
        2 1
        2 3
        2 4
        3 1
        3 2
        3 4
        4 1
        4 2
        4 3

    예제 입력 3
        4 4
    예제 출력 3
        1 2 3 4
        1 2 4 3
        1 3 2 4
        1 3 4 2
        1 4 2 3
        1 4 3 2
        2 1 3 4
        2 1 4 3
        2 3 1 4
        2 3 4 1
        2 4 1 3
        2 4 3 1
        3 1 2 4
        3 1 4 2
        3 2 1 4
        3 2 4 1
        3 4 1 2
        3 4 2 1
        4 1 2 3
        4 1 3 2
        4 2 1 3
        4 2 3 1
        4 3 1 2
        4 3 2 1


    알고리즘 분류
        백트래킹
*/


// 메모리 : 22648KB
// 시간 : 276ms
// 코드 길이 : 1661B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 전체 수의 개수 (M ≤ N ≤ 8)
    static int M; // 선택할 수의 개수 (1 ≤ M ≤ N)
    static boolean isSelected[]; // 해당 인덱스 순서의 수의 선택 여부를 저장하는 배열
    static int selection[]; // 선택된 수의 인덱스를 선택된 순서대로 저장하는 배열
    static StringBuilder sb;

    public static void permutation(int n, int r) { // 순열 메서드
        if (r == M) { // 수를 원하는 만큼 선택했을 경우
            for (int i = 0; i < M; i++) {
                sb.append(selection[i] + 1);
                sb.append(" ");
            }

            sb.append("\n");

            return;
        }

        for (int j = n; j < N; j++) {
            if (isSelected[j]) { // 이미 선택된 수일 경우
                continue;
            }

            isSelected[j] = true;
            selection[r] = j; // 선택된 수의 인덱스 저장
            permutation(n, r + 1);
            isSelected[j] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        isSelected = new boolean[N];
        selection = new int[M];
        sb = new StringBuilder();
        permutation(0, 0);

        System.out.println(sb);
    }
}
