/*
15726. Bronze 4 - 이칙연산

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           14207	    4262      3734	         30.867%


    문제
        다음과 같이 세 수가 연속해서 주어졌을 때 한 번의 곱셈 기호와 한 번의 나눗셈 기호를 이용하여 만든 식 중 가장 큰 값을 출력하는 프로그램을 작성하시오. (세 수의 순서는 변하지 않는다.)
            32 ☐ 16 ☐ 8


    입력
        첫째 줄에 세 개 정수 A, B, C(1 ≤ A, B, C ≤ 1,000,000)가 주어진다. 답은 int범위를 벗어나지 않는다.


    출력
        나올 수 있는 가장 큰 값을 출력한다. 단, 소수점 아래는 버린다. 1e-9 이하의 오차로 인해 출력이 달라지는 입력은 주어지지 않는다.


    예제 입력 1
        32 16 8
    예제 출력 1
        64


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 14176KB
// 시간 : 120ms
// 코드 길이 : 724B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        double A = Double.parseDouble(token.nextToken()); // 정수 A (1 ≤ A ≤ 1,000,000)
        double B = Double.parseDouble(token.nextToken()); // 정수 B (1 ≤ B ≤ 1,000,000)
        double C = Double.parseDouble(token.nextToken()); // 정수 C (1 ≤ C ≤ 1,000,000)

        System.out.println((int) Math.max((A * B / C), (A / B * C)));
    }
}
