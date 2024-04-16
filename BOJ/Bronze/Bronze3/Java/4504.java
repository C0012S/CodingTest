/*
4504. Bronze 3 - 배수 찾기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           10144	    5352      4967	         53.697%


    문제
        정수 n(0 < n < 1000)과 수의 목록이 주어졌을 때, 목록에 들어있는 수가 n의 배수인지 아닌지를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 n이 주어진다. 다음 줄부터 한 줄에 한 개씩 목록에 들어있는 수가 주어진다. 이 수는 0보다 크고, 10,000보다 작다. 목록은 0으로 끝난다.


    출력
        목록에 있는 수가 n의 배수인지 아닌지를 구한 뒤 예제 출력처럼 출력한다.


    예제 입력 1
        3
        1
        7
        99
        321
        777
        0
    예제 출력 1
        1 is NOT a multiple of 3.
        7 is NOT a multiple of 3.
        99 is a multiple of 3.
        321 is a multiple of 3.
        777 is a multiple of 3.


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 14292KB
// 시간 : 132ms
// 코드 길이 : 886B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(bf.readLine());

            if (num == 0) {
                break;
            }
            else if (num % N == 0) {
                sb.append(num);
                sb.append(" is a multiple of ");
            }
            else {
                sb.append(num);
                sb.append(" is NOT a multiple of ");
            }
            sb.append(N);
            sb.append(".");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
