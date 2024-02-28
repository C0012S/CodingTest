/*
2744. Bronze 5 - 대소문자 바꾸기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           26674	    20099     18271	         76.403%


    문제
        영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.


    출력
        첫째 줄에 입력으로 주어진 단어에서 대문자는 소문자로, 소문자는 대문자로 바꾼 단어를 출력한다.


    예제 입력 1
        WrongAnswer
    예제 출력 1
        wRONGaNSWER


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14180KB
// 시간 : 124ms
// 코드 길이 : 717B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();

        StringBuilder sb = new StringBuilder();
        for (int s = 0, len = str.length(); s < len; s++) {
            char alphabet = str.charAt(s);
            if (Character.isUpperCase(alphabet)) {
                sb.append(Character.toLowerCase(alphabet));
            }
            else {
                sb.append(Character.toUpperCase(alphabet));
            }
        }

        System.out.println(sb);
    }
}
