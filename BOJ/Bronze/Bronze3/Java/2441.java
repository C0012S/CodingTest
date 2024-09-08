/*
2441. Bronze 3 - 별 찍기 - 4

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           85477	    62549     56444	         74.075%


    문제
        첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제
        하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.


    입력
        첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.


    출력
        첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.


    예제 입력 1
        5
    예제 출력 1
        *****
         ****
          ***
           **
            *


    알고리즘 분류
        구현
*/


// 메모리 : 14144KB
// 시간 : 100ms
// 코드 길이 : 725B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void printStar(int N) {
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            for (int b = 0; b < n; b++) {
                sb.append(" ");
            }

            for (int s = N; s > n; s--) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        printStar(N);
    }
}
