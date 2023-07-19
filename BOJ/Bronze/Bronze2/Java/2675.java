/*
2675. Bronze 2 - 문자열 반복

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           187501	    94548     80538	        50.377%


    문제
        문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
        QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.


    입력
        첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다.


    출력
        각 테스트 케이스에 대해 P를 출력한다.


    예제 입력 1
        2
        3 ABC
        5 /HTP
    예제 출력 1
        AAABBBCCC
        /////HHHHHTTTTTPPPPP


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14204KB
// 시간 : 144ms
// 코드 길이 : 935B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수 (1 ≤ T ≤ 1,000)

        StringTokenizer token;
        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(bf.readLine());

            int R = Integer.parseInt(token.nextToken()); // 반복 횟수 R (1 ≤ R ≤ 8)
            String S = token.nextToken(); // 문자열 S

            for (int s = 0; s < S.length(); s++) {
                for (int r = 0; r < R; r++) {
                    System.out.print(S.charAt(s)); // s 번째 문자 R 번 반복
                }
            }

            System.out.println();
        }
    }
}
