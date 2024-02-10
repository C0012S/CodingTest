/*
10039. Bronze 4 - 평균 점수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           70862	    44336     40056	         63.431%


    문제
        상현이가 가르치는 아이폰 앱 개발 수업의 수강생은 원섭, 세희, 상근, 숭, 강수이다.
        어제 이 수업의 기말고사가 있었고, 상현이는 지금 학생들의 기말고사 시험지를 채점하고 있다. 기말고사 점수가 40점 이상인 학생들은 그 점수 그대로 자신의 성적이 된다. 하지만, 40점 미만인 학생들은 보충학습을 듣는 조건을 수락하면 40점을 받게 된다. 보충학습은 거부할 수 없기 때문에, 40점 미만인 학생들은 항상 40점을 받게 된다
        학생 5명의 점수가 주어졌을 때, 평균 점수를 구하는 프로그램을 작성하시오.


    입력
        입력은 총 5줄로 이루어져 있고, 원섭이의 점수, 세희의 점수, 상근이의 점수, 숭이의 점수, 강수의 점수가 순서대로 주어진다.
        점수는 모두 0점 이상, 100점 이하인 5의 배수이다. 따라서, 평균 점수는 항상 정수이다.


    출력
        첫째 줄에 학생 5명의 평균 점수를 출력한다.


    예제 입력 1
        10
        65
        100
        30
        95
    예제 출력 1
        68


    힌트
        숭과 원섭이는 40점 미만이고, 보충학습에 참여할 예정이기 때문에 40점을 받게 된다. 따라서, 점수의 합은 340점이고, 평균은 68점이 된다.


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 14124KB
// 시간 : 116ms
// 코드 길이 : 643B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(bf.readLine()); // 0 점 이상 100 점 이하인 5의 배수의 점수

            if (score < 40) { // 점수가 40 점 미만일 경우
                score = 40;
            }

            sum += score;
        }

        System.out.println(sum / 5); // 평균 점수
    }
}
