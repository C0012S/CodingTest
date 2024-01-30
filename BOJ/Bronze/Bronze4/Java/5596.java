/*
5596. Bronze 4 - 시험 점수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           13638	    11037     10179	         82.374%


    문제
        대한고등학교에 재학 중인 민국이와 만세는 4과목(정보, 수학, 과학, 영어)에 대한 시험을 봤다. 민국이와 만세가 본 4과목의 점수를 입력하면, 민국이의 총점 S와 만세의 총점 T 중에서 큰 점수를 출력하는 프로그램을 작성하시오. 단, 서로 동점일 때는 민국이의 총점 S를 출력한다.


    입력
        입력은 2줄로 이루어져 있다.
        1번째 줄에는 순서대로 민국이의 정보, 수학, 과학, 영어 점수(정수형)가 있으며, 공백으로 구분되어 있다.
        2번째 줄에는 1번째 줄과 마찬가지로 순서대로 만세의 정보, 수학, 과학, 영어 점수(정수형)가 있고, 공백으로 구분되어 있다.


    출력
        문제에서 요구하는 정답을 출력한다.


    예제 입력 1
        100 80 70 60
        80 70 80 90
    예제 출력 1
        320

    예제 입력 2
        100 80 70 60
        80 70 60 100
    예제 출력 2
        310


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14148KB
// 시간 : 120ms
// 코드 길이 : 685B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int maxSum = 0;
        StringTokenizer token;
        for (int i = 0; i < 2; i++) {
            int sum = 0;
            token = new StringTokenizer(bf.readLine());
            for (int c = 0; c < 4; c++) {
                sum += Integer.parseInt(token.nextToken());
            }

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
