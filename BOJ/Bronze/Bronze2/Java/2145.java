/*
2145. Bronze 2 - 숫자 놀이

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           3164	    1920      1704	         64.060%


    문제
        초등학생인 도겸이는 숫자를 좋아한다. 어느 날 도겸이는 숫자 책을 보다가 간단한 놀이를 하나 생각해냈다. 숫자 놀이의 규칙은 다음과 같다.
            1. 주어진 숫자의 각 자릿수를 더한다.
            2. 결과가 한 자릿수가 될 때 까지 규칙1을 반복한다.

        예를들어, 숫자 673에 규칙을 적용해보면 결과는 7이 된다 ; 6 + 7 + 3 = 16, 1 + 6 = 7

        도겸이는 당신과 함께 숫자놀이를 하고싶어한다. 도겸이가 주는 숫자들을 풀어보자.


    입력
        각 줄에 숫자 N이 주어진다. N은 100,000보다 작은 양의 정수이다. 마지막 입력은 0이며, 0에 대한 결과는 출력하지 않는다.


    출력
        한 줄에 하나씩 한 자릿수 결과를 출력한다.


    예제 입력 1
        673
        51
        1000
        99
        0
    예제 출력 1
        7
        6
        1
        9


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 13984KB
// 시간 : 116ms
// 코드 길이 : 904B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;

    public static void game(String num) { // 숫자 놀이를 수행하는 메서드
        while (num.length() > 1) {
            int sum = 0;
            for (int i = 0, len = num.length(); i < len; i++) {
                sum += num.charAt(i) - '0';
            }

            num = String.valueOf(sum);
        }

        sb.append(num);
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        while (true) {
            String N = bf.readLine();

            if (N.equals("0")) {
                break;
            }

            game(N);
        }

        System.out.println(sb);
    }
}
