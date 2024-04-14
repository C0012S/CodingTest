/*
4493. Bronze 3 - 가위 바위 보?

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           5166	    3309      2921	         66.341%


    문제
        가위 바위 보는 두 명이서 하는 게임이다. 보통 미리 정해놓은 수 만큼 게임을 하고, 많은 게임을 이긴 사람이 최종 승자가 된다.

        가위 바위 보를 한 횟수와 매번 두 명이 무엇을 냈는지가 주어졌을 때, 최종 승자를 출력하는 프로그램을 작성하시오.
        · 바위는 가위를 이긴다.
        · 가위는 보를 이긴다.
        · 보는 바위를 이긴다.


    입력
        첫째 줄에는 테스트 케이스의 개수 t(0 < t < 1000)가 주어진다. 각 테스트 케이스의 첫째 줄에는 가위 바위 보를 한 횟수 n(0 < n < 100)이 주어진다. 다음 n개의 줄에는 R, P, S가 공백으로 구분되어 주어진다. R, P, S는 순서대로 바위, 보, 가위이고 첫 번째 문자는 Player 1의 선택, 두 번째 문자는 Player 2의 선택이다.


    출력
        각 테스트 케이스에 대해서 승자를 출력한다. (Player 1 또는 Player 2) 만약, 비겼을 경우에는 TIE를 출력한다.


    예제 입력 1
        3
        2
        R P
        S R
        3
        P P
        R S
        S R
        1
        P R
    예제 출력 1
        Player 2
        TIE
        Player 1


    알고리즘 분류
        구현
*/


// 메모리 : 26616KB
// 시간 : 256ms
// 코드 길이 : 1562B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수 (0 < T < 1000)

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine()); // 가위 바위 보를 한 횟수 (0 < N < 100)

            int count = 0;
            StringTokenizer token;
            for (int n = 0; n < N; n++) {
                token = new StringTokenizer(bf.readLine());
                String p1 = token.nextToken(); // Player 1의 선택
                String p2 = token.nextToken(); // Player 2의 선택

                if (p1.equals(p2)) {
                    continue;
                }
                else if ((p1.equals("R") && p2.equals("S")) || (p1.equals("S") && p2.equals("P")) || (p1.equals("P") && p2.equals("R"))) {
                    count += 1;
                }
                else {
                    count -= 1;
                }
            }

            if (count > 0) {
                sb.append("Player 1");
            }
            else if (count < 0) {
                sb.append("Player 2");
            }
            else {
                sb.append("TIE");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
