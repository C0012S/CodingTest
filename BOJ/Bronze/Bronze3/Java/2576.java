/*
2576. Bronze 3 - 홀수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           35114	    19364     17042	         56.100%


    문제
        7개의 자연수가 주어질 때, 이들 중 홀수인 자연수들을 모두 골라 그 합을 구하고, 고른 홀수들 중 최솟값을 찾는 프로그램을 작성하시오.

        예를 들어, 7개의 자연수 12, 77, 38, 41, 53, 92, 85가 주어지면 이들 중 홀수는 77, 41, 53, 85이므로 그 합은
            77 + 41 + 53 + 85 = 256
            이 되고,
            41 < 53 < 77 < 85
            이므로 홀수들 중 최솟값은 41이 된다.


    입력
        입력의 첫째 줄부터 일곱 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100보다 작다.


    출력
        홀수가 존재하지 않는 경우에는 첫째 줄에 -1을 출력한다. 홀수가 존재하는 경우 첫째 줄에 홀수들의 합을 출력하고, 둘째 줄에 홀수들 중 최솟값을 출력한다.


    예제 입력 1
        12
        77
        38
        41
        53
        92
        85
    예제 출력 1
        256
        41

    예제 입력 2
        2
        4
        20
        32
        6
        10
        8
    예제 출력 2
        -1


    알고리즘 분류
        수학
        구현
*/


// 메모리 : 14156KB
// 시간 : 120ms
// 코드 길이 : 812B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int minNum = Integer.MAX_VALUE;
        for (int n = 0; n < 7; n++) {
            int num = Integer.parseInt(bf.readLine());

            if (num % 2 == 1) {
                sum += num;
                minNum = Math.min(minNum, num);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (sum == 0) {
            sb.append(-1);
        }
        else {
            sb.append(sum);
            sb.append("\n");
            sb.append(minNum);
        }

        System.out.println(sb);
    }
}
