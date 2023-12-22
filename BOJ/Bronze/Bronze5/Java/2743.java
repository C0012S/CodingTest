/*
2743. Bronze 5 - 단어 길이 재기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           63346	    50368     45641	         80.726%


    문제
        알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.


    출력
        첫째 줄에 입력으로 주어진 단어의 길이를 출력한다.


    예제 입력 1
        pulljima
    예제 출력 1
        8


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14168KB
// 시간 : 120ms
// 코드 길이 : 347B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();

        System.out.println(str.length());
    }
}
