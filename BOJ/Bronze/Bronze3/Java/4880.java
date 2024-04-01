/*
4880. Bronze 3 - 다음수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           5304	    3090      2846	         60.348%


    문제
        등차수열(AP)은 인접한 두 수의 차이(공차)가 일정한 수열이다. 예를 들어, 3, 5, 7, 9, 11, 13, ...은 차이가 2로 일정한 등차수열이다. 이 문제에서 등차수열의 공차는 항상 0이 아닌 정수이다.
        등비수열(GP)는 각 항이 그 앞과 일정한 비(공비)를 가지는 수열이다. 예를 들어, 2, 6, 18, 54, ...은 공비가 3인 등비수열이다. 이 문제에서 등비수열의 공비는 항상 0이 아닌 정수이다.
        어떤 수열의 연속한 세개의 숫자가 주어졌을 때, 이 수열이 등차수열인지 등비수열인지를 알아낸 뒤, 다음 항을 구하는 프로그램을 작성하시오.


    입력
        입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 수열의 연속하는 세 정수 a1, a2, a3이 한 줄에 주어진다. (-10,000 < a1, a2, a3 < 10,000) a1, a2, a3은 서로 같지 않다.
        입력의 마지막 줄에는 0이 세 개 주어진다.


    출력
        각 테스트 케이스에 대해서, 등차수열이면 AP를, 등비수열이면 GP를 출력한 뒤, 다음 항을 출력한다. 모든 입력은 항상 등차수열이나 등비수열이다.


    예제 입력 1
        4 7 10
        2 6 18
        0 0 0
    예제 출력 1
        AP 13
        GP 54


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 14296KB
// 시간 : 128ms
// 코드 길이 : 1067B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        while (true) {
            token = new StringTokenizer(bf.readLine());
            int num1 = Integer.parseInt(token.nextToken());
            int num2 = Integer.parseInt(token.nextToken());
            int num3 = Integer.parseInt(token.nextToken());

            if (num1 == 0 && num2 == 0 && num3 == 0) {
                break;
            }

            if (num3 - num2 == num2 - num1) {
                sb.append("AP ");
                sb.append(num3 + (num3 - num2));
            }
            else {
                sb.append("GP ");
                sb.append(num3 * (num3 / num2));
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
