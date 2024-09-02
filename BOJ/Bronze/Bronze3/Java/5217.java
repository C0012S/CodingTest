/*
5217. Bronze 3 - 쌍의 합

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           6582	    3515      3192	         56.787%


    문제
        1보다 크거나 같고 12보다 작거나 같은 자연수 n이 주어졌을 때, 합이 n이 되는 두 자연수의 쌍을 찾는 프로그램을 작성하시오.
        예를 들어, 5가 주어진 경우 가능한 쌍은 1,4와 2,3이 있다. 두 수는 항상 달라야 한다. 즉, 3,3은 올바른 쌍이 아니다. 또, 첫 번째 수가 두 번째 수보다 작아야 한다.
        출력하는 쌍은 항상 사전순으로 출력해야 한다. 즉, 각 쌍의 작은 수로 비교를 해야 한다. 예를 들어 1,5는 2,4보다 사전순으로 앞선다.


    입력
        첫째 줄에 테스트 케이스의 수 (< 100)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, n이 주어진다.


    출력
        각 테스트 케이스마다 n을 만드는 쌍을 사전순으로 출력한다. n을 만드는 쌍이 없는 경우에는 아무것도 출력하지 않는다.
        예제 출력 형식을 참고해 출력한다.


    출력 형식
        정확한 출력 형식은 제출에서 언어를 Java로 설정하면 확인할 수 있다.


    예제 입력 1
        4
        2
        3
        4
        5
    예제 출력 1
        Pairs for 2:
        Pairs for 3: 1 2
        Pairs for 4: 1 3
        Pairs for 5: 1 4, 2 3


    알고리즘 분류
        구현
*/


// 메모리 : 14280KB
// 시간 : 104ms
// 코드 길이 : 1159B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n; // 두 자연수의 쌍으로 만들어야 하는 수
    static StringBuilder sb;

    public static void find() { // n을 만드는 두 자연수의 쌍을 구하고 출력하는 메서드
        sb.append("Pairs for ");
        sb.append(n);
        sb.append(": ");

        for (int p = 1, size = n / 2; p <= size; p++) {
            if (p != (n - p)) {
                if (p > 1) {
                    sb.append(", ");
                }

                sb.append(p);
                sb.append(" ");
                sb.append(n - p);
            }
        }

        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수 (T < 100)

        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(bf.readLine());

            find();
        }

        System.out.println(sb);
    }
}
