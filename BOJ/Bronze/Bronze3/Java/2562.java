/*
2562. Bronze 3 - 최댓값

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           305482	    140650    116441	     45.522%


    문제
        9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
        예를 들어, 서로 다른 9개의 자연수
            3, 29, 38, 12, 57, 74, 40, 85, 61
        이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.


    입력
        첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.


    출력
        첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.


    예제 입력 1
        3
        29
        38
        12
        57
        74
        40
        85
        61
    예제 출력 1
        85
        8


    알고리즘 분류
        구현
*/


// 메모리 : 14128KB
// 시간 : 120ms
// 코드 길이 : 702B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int maxNum = 0;
        int maxOrder = 0;
        for (int i = 1; i <= 9; i++) {
            int nowNum = Integer.parseInt(bf.readLine());

            if (maxNum < nowNum) {
                maxNum = nowNum;
                maxOrder = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxNum);
        sb.append("\n");
        sb.append(maxOrder);

        System.out.println(sb);
    }
}
