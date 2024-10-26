/*
3226. Bronze 1 - 전화 요금

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           1940	    905       808	         50.850%


    문제
        7:00부터 19:00까지 전화 요금은 1분에 10원이다.
        19:00부터 7:00까지 전화 요금은 1분에 5원이다.
        상근이가 전화를 건 시간과 통화 시간이 모두 주어졌을 때, 전화 요금을 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 상근이가 건 전화의 수 N이 주어진다. (1 ≤ N ≤ 100)
        다음 N개 줄에는 상근이가 건 전화에 대한 정보가 HH:MM DD와 같은 형식으로 주어진다.
        HH:MM은 전화를 건 시간이며, DD는 통화 시간이다. DD는 최대 60이며, MM과 DD사이에는 공백이 하나 주어진다.
        만약 시나 분이 한자리 숫자라면, 앞에 0이 하나 주어진다.
        시간은 00:00부터 23:59까지이다.


    출력
        총 전화 요금을 출력한다.


    예제 입력 1
        2
        11:02 11
        15:30 01
    예제 출력 1
        120

    예제 입력 2
        3
        20:05 12
        06:45 30
        13:08 15
    예제 출력 2
        435

    예제 입력 3
        5
        00:00 05
        06:47 35
        11:30 18
        18:33 60
        23:59 22
    예제 출력 3
        1035


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14236KB
// 시간 : 104ms
// 코드 길이 : 2324B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int charge; // 총 전화 요금

    public static void calculate(String date[], int time) { // 상근이가 전화를 건 시간과 통화 시간에 따라 전화 요금을 구하는 메서드
        int startHour = Integer.parseInt(date[0]); // 상근이가 전화 건 시간의 시
        int startMinute = Integer.parseInt(date[1]); // 상근이가 전화 건 시간의 분
        int endHour = startHour; // 상근이가 전화를 종료한 시간의 시
        int endMinute = startMinute + time; // 상근이가 전화를 종료한 시간의 분

        // 전화 종료 시간 계산
        if (endMinute >= 60) {
            endHour += 1;
            endMinute -= 60;

            if (endHour >= 24) {
                endHour = 0;
            }
        }

        if ((endHour == 7 || endHour == 19) && (startMinute >= endMinute) && (endMinute != 0)) { // 요금이 변경되는 시간에 전화 중일 때
            if (endHour == 7) { // 7 시 넘어서 전화 중일 경우
                charge += 5 * (time - endMinute) + 10 * endMinute;
            }
            else if (endHour == 19) { // 19 시 넘어서 전화 중일 경우
                charge += 10 * (time - endMinute) + 5 * endMinute;
            }
        }
        else { // 요금이 변경되지 않는 시간에 전화 중일 때
            if ((startHour >= 7) && (startHour <= 18)) {
                charge += 10 * time;
            }
            else {
                charge += 5 * time;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 상근이가 건 전화의 수 (1 ≤ N ≤ 100)

        StringTokenizer token;
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(bf.readLine());
            String date[] = token.nextToken().split(":"); // 상근이가 전화를 건 시간
            int time = Integer.parseInt(token.nextToken()); // 상근이의 통화 시간

            calculate(date, time);
        }

        System.out.println(charge);
    }
}
