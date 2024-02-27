/*
1427. Silver 5 - 소트인사이드

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           93184	    60779     50348	         65.529%


    문제
        배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.


    입력
        첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.


    출력
        첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.


    예제 입력 1
        2143
    예제 출력 1
        4321

    예제 입력 2
        999998999
    예제 출력 2
        999999998

    예제 입력 3
        61423
    예제 출력 3
        64321

    예제 입력 4
        500613009
    예제 출력 4
        965310000


    알고리즘 분류
        문자열
        정렬
*/


// 메모리 : 14240KB
// 시간 : 124ms
// 코드 길이 : 810B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String N = bf.readLine(); // 정렬하려고 하는 수

        int len = N.length();
        int numArr[] = new int[len];
        for (int s = 0; s < len; s++) {
            numArr[s] = N.charAt(s) - '0';
        }

        Arrays.sort(numArr); // 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        for (int p = len - 1; p >= 0; p--) { // 오름차순으로 정렬한 자리수를 마지막부터 출력
            sb.append(numArr[p]);
        }

        System.out.println(sb);
    }
}
