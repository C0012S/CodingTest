/*
21921. Silver 3 - 블로그

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    512 MB           17641	    7558      6107	         41.898%


    문제
        찬솔이는 블로그를 시작한 지 벌써 N일이 지났다.

        요즘 바빠서 관리를 못 했다가 방문 기록을 봤더니 벌써 누적 방문 수가 6만을 넘었다.
            [그림은 문제에서 참고]

        찬솔이는 X일 동안 가장 많이 들어온 방문자 수와 그 기간들을 알고 싶다.
        찬솔이를 대신해서 X일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개 있는지 구해주자.


    입력
        첫째 줄에 블로그를 시작하고 지난 일수 N와 X가 공백으로 구분되어 주어진다.
        둘째 줄에는 블로그 시작 1일차부터 N일차까지 하루 방문자 수가 공백으로 구분되어 주어진다.


    출력
        첫째 줄에 X일 동안 가장 많이 들어온 방문자 수를 출력한다. 만약 최대 방문자 수가 0명이라면 SAD를 출력한다.
        만약 최대 방문자 수가 0명이 아닌 경우 둘째 줄에 기간이 몇 개 있는지 출력한다.


    제한
        · 1 ≤ X ≤ N ≤ 250,000
        · 0 ≤ 방문자 수 ≤ 8,000


    예제 입력 1
        5 2
        1 4 2 5 1
    예제 출력 1
        7
        1

    예제 입력 2
        7 5
        1 1 1 1 1 5 1
    예제 출력 2
        9
        2

    예제 입력 3
        5 3
        0 0 0 0 0
    예제 출력 3
        SAD


    알고리즘 분류
        누적 합
        슬라이딩 윈도우
*/


// 메모리 : 35276KB
// 시간 : 320ms
// 코드 길이 : 2192B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 블로그를 시작하고 지난 일수
    static int X; // 찬솔이가 구하고 싶어 하는 방문자가 들어오는 수를 구하는 일수
    static int[] visitor; // 블로그의 (인덱스 + 1) 일 차 하루 방문자 수를 저장하는 배열
    static int people; // X 일 동안 들어온 방문자 수
    static int maxPeople; // X 일 동안 가장 많이 들어온 방문자 수
    static int maxDay; // X 일 동안 가장 많이 들어온 방문자 수가 나타난 기간

    public static void print() { // 최대 방문자 수에 따른 정보를 출력하는 메서드
        StringBuilder sb = new StringBuilder();

        if (maxPeople == 0) {
            sb.append("SAD");
        }
        else {
            sb.append(maxPeople);
            sb.append("\n");
            sb.append(maxDay);
        }

        System.out.println(sb);
    }

    public static void find() { // 가장 많이 들어온 방문자 수와 기간의 개수를 구하는 메서드
        maxPeople = people;
        maxDay = 1;

        for (int n = 1, len = N - X; n <= len; n++) {
            people -= visitor[n - 1];
            people += visitor[n + X - 1];

            if (people > maxPeople) {
                maxPeople = people;
                maxDay = 1;
            }
            else if (people == maxPeople) {
                maxDay += 1;
            }
        }

        print();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken());

        visitor = new int[N];
        token = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            visitor[i] = Integer.parseInt(token.nextToken());

            if (i < X) {
                people += visitor[i];
            }
        }

        find();
    }
}
