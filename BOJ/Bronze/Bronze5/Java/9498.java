/*
9498. Bronze 5 - 시험 성적

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           374598	    204455    172200	     54.893%


    문제
        시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 시험 점수가 주어진다. 시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.


    출력
        시험 성적을 출력한다.


    예제 입력 1
        100
    예제 출력 1
        A


    알고리즘 분류
        구현
*/


// 메모리 : 14336KB
// 시간 : 120ms
// 코드 길이 : 834B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int score;

    public static void printScore() {
        StringBuilder sb = new StringBuilder();

        if (score >= 90 && score <= 100) {
            sb.append("A");
        }
        else if (score >= 80) {
            sb.append("B");
        }
        else if (score >= 70) {
            sb.append("C");
        }
        else if (score >= 60) {
            sb.append("D");
        }
        else {
            sb.append("F");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        score = Integer.parseInt(bf.readLine());

        printScore();
    }
}
