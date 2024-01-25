/*
1267. Bronze 3 - 핸드폰 요금

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           22601	    10877     9666	         48.774%


    문제
        동호는 새악대로 T 통신사의 새 핸드폰 옴머나를 샀다. 새악대로 T 통신사는 동호에게 다음 두 가지 요금제 중 하나를 선택하라고 했다.
            1. 영식 요금제
            2. 민식 요금제

        영식 요금제는 30초마다 10원씩 청구된다. 이 말은 만약 29초 또는 그 보다 적은 시간 통화를 했으면 10원이 청구된다. 만약 30초부터 59초 사이로 통화를 했으면 20원이 청구된다.
        민식 요금제는 60초마다 15원씩 청구된다. 이 말은 만약 59초 또는 그 보다 적은 시간 통화를 했으면 15원이 청구된다. 만약 60초부터 119초 사이로 통화를 했으면 30원이 청구된다.
        동호가 저번 달에 새악대로 T 통신사를 이용할 때 통화 시간 목록이 주어지면 어느 요금제를 사용 하는 것이 저렴한지 출력하는 프로그램을 작성하시오.


    입력
        동호가 저번 달에 이용한 통화의 개수 N이 주어진다. N은 20보다 작거나 같은 자연수이다. 둘째 줄에 통화 시간 N개가 주어진다. 통화 시간은 10,000보다 작거나 같은 자연수이다.


    출력
        첫째 줄에 싼 요금제의 이름을 출력한다. 그 후에 공백을 사이에 두고 요금이 몇 원 나오는지 출력한다. 만약 두 요금제의 요금이 모두 같으면 영식을 먼저 쓰고 민식을 그 다음에 쓴다.
        영식은 Y로, 민식은 M으로 출력한다.


    예제 입력 1
        3
        40 40 40
    예제 출력 1
        M 45

    영식: 20 + 20 + 20 = 60
    민식: 15 + 15 + 15 = 45

    예제 입력 2
        3
        61 61 61
    예제 출력 2
        Y M 90

    예제 입력 3
        2
        61 10
    예제 출력 3
        Y 40

    영식: 30 + 10 = 40
    민식: 30 + 15 = 45

    예제 입력 4
        2
        60 65
    예제 출력 4
        Y M 60

    영식: 30 + 30 = 60
    민식: 30 + 30 = 60


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 14088KB
// 시간 : 120ms
// 코드 길이 : 1018B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int Y = 0;
        int M = 0;
        StringTokenizer token = new StringTokenizer(bf.readLine());
        for (int n = 0; n < N; n++) {
            int time = Integer.parseInt(token.nextToken());

            Y += ((time / 30) + 1) * 10;
            M += ((time / 60) + 1) * 15;
        }

        StringBuilder sb = new StringBuilder();
        if (Y < M) {
            sb.append("Y ");
            sb.append(Y);
        }
        else if (Y == M) {
            sb.append("Y ");
            sb.append("M ");
            sb.append(Y);
        }
        else {
            sb.append("M ");
            sb.append(M);
        }

        System.out.println(sb);
    }
}
