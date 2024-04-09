/*
1834. Bronze 1 - 나머지와 몫이 같은 수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    256 MB           12174	    6101      5159	         51.257%


    문제
        N으로 나누었을 때 나머지와 몫이 같은 모든 자연수의 합을 구하는 프로그램을 작성하시오. 예를 들어 N=3일 때, 나머지와 몫이 모두 같은 자연수는 4와 8 두 개가 있으므로, 그 합은 12이다.


    입력
        첫째 줄에 2,000,000 이하의 자연수 N이 주어진다.


    출력
        첫 줄에 구하고자 하는 수를 출력한다.


    예제 입력 1
        3
    예제 출력 1
        12

    예제 입력 2
        2000000
    예제 출력 2
        3999999999999000000


    알고리즘 분류
        수학
*/


// 메모리 : 14372KB
// 시간 : 132ms
// 코드 길이 : 453B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(bf.readLine());

        long sum = 0;
        for (int n = 1; n < N; n++) {
            sum += N * n + n;
        }

        System.out.println(sum);
    }
}
