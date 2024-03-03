/*
11654. Bronze 5 - 아스키 코드

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           149566	    119474    105189	     80.843%


    문제
        알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.


    입력
        알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.


    출력
        입력으로 주어진 글자의 아스키 코드 값을 출력한다.


    예제 입력 1
        A
    예제 출력 1
        65

    예제 입력 2
        C
    예제 출력 2
        67

    예제 입력 3
        0
    예제 출력 3
        48

    예제 입력 4
        9
    예제 출력 4
        57

    예제 입력 5
        a
    예제 출력 5
        97

    예제 입력 6
        z
    예제 출력 6
        122


    알고리즘 분류
        구현
*/


// 메모리 : 14288KB
// 시간 : 120ms
// 코드 길이 : 328B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println((int) bf.readLine().charAt(0));
    }
}
