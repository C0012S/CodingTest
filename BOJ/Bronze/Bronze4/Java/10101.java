/*
10101. Bronze 4 - 삼각형 외우기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           34114	    19524     17874	         57.406%


    문제
        창영이는 삼각형의 종류를 잘 구분하지 못한다. 따라서 프로그램을 이용해 이를 외우려고 한다.
        삼각형의 세 각을 입력받은 다음,
            · 세 각의 크기가 모두 60이면, Equilateral
            · 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
            · 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
            · 세 각의 합이 180이 아닌 경우에는 Error
        를 출력하는 프로그램을 작성하시오.


    입력
        총 3개의 줄에 걸쳐 삼각형의 각의 크기가 주어진다. 모든 정수는 0보다 크고, 180보다 작다.


    출력
        문제의 설명에 따라 Equilateral, Isosceles, Scalene, Error 중 하나를 출력한다.


    예제 입력 1
        60
        70
        50
    예제 출력 1
        Scalene


    알고리즘 분류
        구현
        기하학
*/


// 메모리 : 14024KB
// 시간 : 120ms
// 코드 길이 : 1022B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int angle[];
    static int sum;

    public static void distinguish() {
        if (sum == 180) {
            if ((angle[0] == angle[1]) && (angle[1] == angle[2])) {
                System.out.println("Equilateral");
            }
            else if ((angle[0] == angle[1]) || (angle[1] == angle[2]) || (angle[0] == angle[2])) {
                System.out.println("Isosceles");
            }
            else {
                System.out.println("Scalene");
            }
        }
        else {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        angle = new int[3];
        for (int i = 0; i < 3; i++) {
            angle[i] = Integer.parseInt(bf.readLine());
            sum += angle[i];
        }

        distinguish();
    }
}
