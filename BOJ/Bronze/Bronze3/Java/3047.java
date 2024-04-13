/*
3047. Bronze 3 - ABC

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           9177	    5842      5383	         65.383%


    문제
        세 수 A, B, C가 주어진다. A는 B보다 작고, B는 C보다 작다.
        세 수 A, B, C가 주어졌을 때, 입력에서 주어진 순서대로 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 세 수 A, B, C가 주어진다. 하지만, 순서는 A, B, C가 아닐 수도 있다. 세 수는 100보다 작거나 같은 자연수이다. 둘째 줄에는 A, B, C로 이루어진 세 글자가 주어지며, 이 순서대로 출력하면 된다.


    출력
        주어진 세 수를 주어진 출력 순서대로 출력하면 된다.


    예제 입력 1
        1 5 3
        ABC
    예제 출력 1
        1 3 5

    예제 입력 2
        6 4 2
        CAB
    예제 출력 2
        6 2 4


    알고리즘 분류
        구현
*/


// 메모리 : 14224KB
// 시간 : 120ms
// 코드 길이 : 844B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int numArr[] = new int[3];
        for (int i = 0; i < 3; i++) {
            numArr[i] = Integer.parseInt(token.nextToken());
        }

        String order = bf.readLine();

        Arrays.sort(numArr); // 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        for (int o = 0; o < 3; o++) {
            sb.append(numArr[order.charAt(o) - 'A']);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
