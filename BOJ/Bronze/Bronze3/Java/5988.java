/*
5988. Bronze 3 - 홀수일까 짝수일까

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           13811	    6221      5658	         48.475%


    문제
        짝이 없는 경재는 매일 홀로 있다보니 홀수를 판별할 수 있는 능력이 생겼다. 창식이는 경재의 말이 사실인지 그 능력을 시험해보려 한다. 창식이의 의심이 끝이 없을 것 같아 N개만 확인하기로 정했다.
        N개의 정수가 주어지면 홀수인지 짝수인지를 출력하는 프로그램을 만들어 경재의 능력을 검증할 수 있게 도와주자.


    입력
        첫 번째 줄에 숫자의 개수 N(1 <= N <= 100)이 주어진다.
        두 번째 줄부터 N+1번째 줄에 걸쳐 홀수인지 짝수인지 확인할 정수 K (1 <= K <= 10^60)가 주어진다.


    출력
        N개의 줄에 걸쳐 한 줄씩 정수 K가 홀수라면 'odd'를, 짝수라면 'even'을 출력한다.


    예제 입력 1
        2
        1024
        5931
    예제 출력 1
        even
        odd


    힌트
        1024는 2로 나누어지므로 짝수이고, 5931은 그렇지 않으므로 홀수이다.


    알고리즘 분류
        수학
        문자열
        사칙연산
        임의 정밀도 / 큰 수 연산
*/


// 메모리 : 14368KB
// 시간 : 124ms
// 코드 길이 : 773B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            BigInteger K = new BigInteger(bf.readLine());

            if (K.remainder(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 0) {
                sb.append("even");
            }
            else {
                sb.append("odd");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
