/*
3058. Bronze 3 - 짝수를 찾아라

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           8711	    6102      5652	         71.481%


    문제
        7개의 자연수가 주어질 때, 이들 중 짝수인 자연수들을 모두 골라 그 합을 구하고, 고른 짝수들 중 최솟값을 찾는 프로그램을 작성하시오.
        예를 들어, 7개의 자연수 13, 78, 39, 42, 54, 93, 86가 주어지면 이들 중 짝수는 78, 42, 54, 86이므로 그 합은 78 + 42 + 54 + 86 = 260 이 되고, 42 < 54 < 78 < 86 이므로 짝수들 중 최솟값은 42가 된다.


    입력
        입력은 T개의 테스트 데이터로 구성된다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 각 테스트 데이터는 한 줄로 구성되어 있고, 7개의 자연수가 공백으로 구분되어 있다. 입력으로 주어지는 자연수는 1보다 크거나 같고, 100보다 작거나 같다. 7개의 자연수 중 적어도 하나는 짝수이다.


    출력
        각 테스트 데이터에 대해, 7개 자연수 중 짝수의 합과 최솟값을 공백으로 구분하여 한 줄에 하나씩 출력한다.


    예제 입력 1
        2
        1 2 3 4 5 6 7
        13 78 39 42 54 93 86
    예제 출력 1
        12 2
        260 42


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14736KB
// 시간 : 148ms
// 코드 길이 : 1012B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(bf.readLine());

            int sum = 0;
            int minNum = Integer.MAX_VALUE;
            for (int i = 0; i < 7; i++) {
                int num = Integer.parseInt(token.nextToken());
                if (num % 2 == 0) {
                    sum += num;
                    minNum = Math.min(minNum, num);
                }
            }

            sb.append(sum);
            sb.append(" ");
            sb.append(minNum);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
