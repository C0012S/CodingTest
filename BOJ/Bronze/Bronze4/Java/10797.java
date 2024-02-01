/*
10797. Bronze 4 - 10부제

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           23045	    18348     16396	         81.747%


    문제
        서울시는 6월 1일부터 교통 혼잡을 막기 위해서 자동차 10부제를 시행한다. 자동차 10부제는 자동차 번호의 일의 자리 숫자와 날짜의 일의 자리 숫자가 일치하면 해당 자동차의 운행을 금지하는 것이다. 예를 들어, 자동차 번호의 일의 자리 숫자가 7이면 7일, 17일, 27일에 운행하지 못한다. 또한, 자동차 번호의 일의 자리 숫자가 0이면 10일, 20일, 30일에 운행하지 못한다.
        여러분들은 일일 경찰관이 되어 10부제를 위반하는 자동차의 대수를 세는 봉사활동을 하려고 한다. 날짜의 일의 자리 숫자가 주어지고 5대의 자동차 번호의 일의 자리 숫자가 주어졌을 때 위반하는 자동차의 대수를 출력하면 된다.


    입력
        첫 줄에는 날짜의 일의 자리 숫자가 주어지고 두 번째 줄에는 5대의 자동차 번호의 일의 자리 숫자가 주어진다. 날짜와 자동차의 일의 자리 숫자는 모두 0에서 9까지의 정수 중 하나이다.


    출력
        주어진 날짜와 자동차의 일의 자리 숫자를 보고 10부제를 위반하는 차량의 대수를 출력한다.


    예제 입력 1
        1
        1 2 3 4 5
    예제 출력 1
        1

    예제 입력 2
        3
        1 2 3 5 3
    예제 출력 2
        2

    예제 입력 3
        5
        1 3 0 7 4
    예제 출력 3
        0


    알고리즘 분류
        구현
*/


// 메모리 : 14200KB
// 시간 : 124ms
// 코드 길이 : 632B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer token = new StringTokenizer(bf.readLine());
        int answer = 0;
        for (int d = 0; d < 5; d++) {
            if (Integer.parseInt(token.nextToken()) == N) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
