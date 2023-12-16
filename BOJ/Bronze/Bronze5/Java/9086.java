/*
9086. Bronze 5 - 문자열

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           54065	    34898     31920	         65.450%


    문제
        문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.


    입력
        입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 각 테스트 케이스는 한 줄에 하나의 문자열이 주어진다. 문자열은 알파벳 A~Z 대문자로 이루어지며 알파벳 사이에 공백은 없으며 문자열의 길이는 1000보다 작다.


    출력
        각 테스트 케이스에 대해서 주어진 문자열의 첫 글자와 마지막 글자를 연속하여 출력한다.


    예제 입력 1
        3
        ACDKJFOWIEGHE
        O
        AB
    예제 출력 1
        AE
        OO
        AB


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14100KB
// 시간 : 120ms
// 코드 길이 : 621B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void printStr(String str) {
        StringBuilder sb = new StringBuilder();

        sb.append(str.charAt(0));
        sb.append(str.charAt(str.length() - 1));

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            printStr(bf.readLine());
        }
    }
}
