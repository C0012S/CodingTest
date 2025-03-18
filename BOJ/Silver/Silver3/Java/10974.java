/*
10974. Silver 3 - 모든 순열

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           33652	    22100     16947	         66.563%


    문제
        N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.


    출력
        첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.


    예제 입력 1
        3
    예제 출력 1
        1 2 3
        1 3 2
        2 1 3
        2 3 1
        3 1 2
        3 2 1


    알고리즘 분류
        브루트포스 알고리즘
        백트래킹
*/


// 메모리 : 22172KB
// 시간 : 236ms
// 코드 길이 : 1539B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 순열을 이루는 숫자 중 최댓값을 가지는 수
    static boolean[] isSelected; // 순열 만들 때, 인덱스의 수 선택 여부를 저장하는 배열
    static int[] selection; // 만들어진 순열을 저장하는 배열
    static StringBuilder sb;

    public static void print() { // 만들어진 순열을 출력하는 메서드
        for (int s = 0; s < N; s++) {
            sb.append(selection[s]);
            sb.append(" ");
        }

        sb.append("\n");
    }

    public static void make(int selectedNumber) { // 순열을 구하고, 사전 순으로 출력하는 메서드
        if (selectedNumber >= N) { // 숫자를 N 개 이상 선택했을 경우
            print(); // 만들어진 순열 출력

            return;
        }

        for (int n = 1; n <= N; n++) {
            if (!isSelected[n]) {
                isSelected[n] = true;
                selection[selectedNumber] = n;
                make(selectedNumber + 1);
                isSelected[n] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        isSelected = new boolean[N + 1];
        selection = new int[N];
        sb = new StringBuilder();
        make(0);

        System.out.println(sb);
    }
}
