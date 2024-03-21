/*
2953. Bronze 3 - 나는 요리사다

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           23013	    15221     13523	         67.500%


    문제
        "나는 요리사다"는 다섯 참가자들이 서로의 요리 실력을 뽐내는 티비 프로이다. 각 참가자는 자신있는 음식을 하나씩 만들어오고, 서로 다른 사람의 음식을 점수로 평가해준다. 점수는 1점부터 5점까지 있다.
        각 참가자가 얻은 점수는 다른 사람이 평가해 준 점수의 합이다. 이 쇼의 우승자는 가장 많은 점수를 얻은 사람이 된다.
        각 참가자가 얻은 평가 점수가 주어졌을 때, 우승자와 그의 점수를 구하는 프로그램을 작성하시오.


    입력
        총 다섯 개 줄에 각 참가자가 얻은 네 개의 평가 점수가 공백으로 구분되어 주어진다. 첫 번째 참가자부터 다섯 번째 참가자까지 순서대로 주어진다. 항상 우승자가 유일한 경우만 입력으로 주어진다.


    출력
        첫째 줄에 우승자의 번호와 그가 얻은 점수를 출력한다.


    예제 입력 1
        5 4 4 5
        5 4 4 4
        5 5 4 4
        5 5 5 4
        4 4 4 5
    예제 출력 1
        4 19

    예제 입력 2
        4 4 3 3
        5 4 3 5
        5 5 2 4
        5 5 5 1
        4 4 4 4
    예제 출력 2
        2 17


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14040KB
// 시간 : 124ms
// 코드 길이 : 926B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        int maxScore = Integer.MIN_VALUE;
        int winner = 0;
        for (int p = 1; p <= 5; p++) {
            int score = 0;
            token = new StringTokenizer(bf.readLine());
            for (int s = 1; s <= 4; s++) {
                score += Integer.parseInt(token.nextToken());
            }

            if (score > maxScore) {
                maxScore = score;
                winner = p;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(winner);
        sb.append(" ");
        sb.append(maxScore);

        System.out.println(sb);
    }
}
