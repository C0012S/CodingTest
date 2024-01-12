/*
5717. Bronze 4 - 상근이의 친구들

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           12378	    9583      9156	         78.809%


    문제
        상근이의 남자 친구의 수와 여자 친구의 수가 주어졌을 때, 친구는 총 몇 명인지 구하는 프로그램을 작성하시오.


    입력
        입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 두 정수 M과 F로 이루어져 있으며, 각각은 상근이의 남자 친구의 수와 여자 친구의 수이다. (1 ≤ M, F ≤ 5)
        입력의 마지막 줄에는 0이 두 개 주어진다.


    출력
        각 테스트 케이스마다 상근이의 친구의 수를 출력한다.


    예제 입력 1
        2 2
        2 3
        5 5
        1 1
        0 0
    예제 출력 1
        4
        5
        10
        2


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 13984KB
// 시간 : 120ms
// 코드 길이 : 905B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int boyNum;
    static int girlNum;
    static StringBuilder sb;

    public static void calculate() {
        sb.append(boyNum + girlNum);
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token;
        sb = new StringBuilder();
        while (true) {
            token = new StringTokenizer(bf.readLine());
            boyNum = Integer.parseInt(token.nextToken());
            girlNum = Integer.parseInt(token.nextToken());

            if ((boyNum == 0) && (girlNum == 0)) {
                break;
            }

            calculate();
        }

        System.out.println(sb);
    }
}
