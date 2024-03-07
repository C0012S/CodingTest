/*
2755. Bronze 1 - 이번학기 평점은 몇점?

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           6910	    2328      2007	         35.948%


    문제
        최백준이 이번 학기에 들은 과목과 학점 그리고 성적이 주어졌을 때, 평균 평점을 계산하는 프로그램을 작성하시오.

        성적은 A+~F까지 총 13개가 있다.
            A+: 4.3, A0: 4.0, A-: 3.7
            B+: 3.3, B0: 3.0, B-: 2.7
            C+: 2.3, C0: 2.0, C-: 1.7
            D+: 1.3, D0: 1.0, D-: 0.7
            F: 0.0

        평균 평점은 각 과목의 학점*성적을 모두 더한 뒤에, 총 학점으로 나누면 된다.


    입력
        첫째 줄에, 백준이가 이번 학기에 들은 과목 수가 주어진다. 둘째 줄부터 N개의 줄에 각 과목의 과목명, 학점, 성적이 주어진다. 과목명은 알파벳 소문자와 숫자, 그리고 밑줄 (_)로만 이루어져 있으며, 최대 100글자이고, 학점은 1보다 크거나 같고, 3보다 작거나 같은 자연수이다. 성적은 문제에 설명한 13가지 중 하나이다.


    출력
        첫째 줄에 평균 평점을 소수점 셋째 자리에서 반올림해서 둘째 자리까지 출력한다. (평균 평점이 1.5이면 1.50을 출력한다.)


    예제 입력 1
        7
        General_Physics_1 3 A+
        Introduction_to_Computer_Science_and_Eng 3 B0
        Reading_And_Writing 2 C0
        English_1 3 C+
        Analytic_Geometry_and_Calculus_1 3 B+
        Fortran_Programming 3 B+
        C_Language_Programming 3 A+
    예제 출력 1
        3.28


    2754번. 학점계산
        알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14456KB
// 시간 : 132ms
// 코드 길이 : 2293B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static double grade = 0; // 각 과목의 학점 * 성적을 모두 더한 값

    public static void distinguishScore(int credit, String score) { // 해당 과목의 학점 * 성적을 계산하고 더하는 메서드
        switch (score) {
            case "A+":
                grade += credit * 4.3;
                break;
            case "A0":
                grade += credit * 4.0;
                break;
            case "A-":
                grade += credit * 3.7;
                break;
            case "B+":
                grade += credit * 3.3;
                break;
            case "B0":
                grade += credit * 3.0;
                break;
            case "B-":
                grade += credit * 2.7;
                break;
            case "C+":
                grade += credit * 2.3;
                break;
            case "C0":
                grade += credit * 2.0;
                break;
            case "C-":
                grade += credit * 1.7;
                break;
            case "D+":
                grade += credit * 1.3;
                break;
            case "D0":
                grade += credit * 1.0;
                break;
            case "D-":
                grade += credit * 0.7;
                break;
            case "F":
                grade += credit * 0.0;
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 백준이가 이번 학기에 들은 과목 수

        StringTokenizer token;
        int allCredit = 0; // 총 학점
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(bf.readLine());
            String className = token.nextToken(); // 과목명
            int credit = Integer.parseInt(token.nextToken()); // 학점
            String score = token.nextToken(); // 성적

            allCredit += credit;
            distinguishScore(credit, score);
        }

        System.out.printf("%.2f%n", grade / allCredit); // 평균 평점
    }
}
