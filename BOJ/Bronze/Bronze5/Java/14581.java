/*
14581. Bronze 5 - 팬들에게 둘러싸인 홍준

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    64 MB            7707	    5845      5514	         76.786%


    문제
        홍준은 참 팬이 많다. 이를 본 구사과는 BOJ 슬랙에서 이모티콘을 만들었다.
            fan     fan     fan
            fan    hongjun  fan
            fan     fan     fan

        선풍기 모양의 이모티콘은 :fan: 이고, 홍준의 이모티콘은 :(홍준의 아이디): 이다. 홍준의 아이디가 주어지면 구사과가 만든 이모티콘을 출력하는 프로그램을 작성하여라. 자세한 출력 방식은 입출력 형식을 참고하면 된다.


    입력
        첫 번째 줄에 홍준의 아이디를 입력받는다. 홍준의 아이디는 길이가 20 이하인 문자열이며, 알파벳 소문자, 알파벳 대문자, 숫자로만 이루어졌다.


    출력
        3개의 줄에 걸쳐, 팬들에게 둘러싸인 홍준의 모습을 출력한다.


    예제 입력 1
        appa
    예제 출력 1
        :fan::fan::fan:
        :fan::appa::fan:
        :fan::fan::fan:

    예제 입력 2
        h0ngjun7
    예제 출력 2
        :fan::fan::fan:
        :fan::h0ngjun7::fan:
        :fan::fan::fan:


    알고리즘 분류
        구현
*/


// 메모리 : 13988KB
// 시간 : 120ms
// 코드 길이 : 754B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String id;
    static StringBuilder sb;

    public static void fan() {
        for (int i = 0; i < 3; i++) {
            sb.append(":fan:");
        }

        sb.append("\n");
    }

    public static void print() {
        sb = new StringBuilder();

        fan();
        sb.append(":fan::");
        sb.append(id);
        sb.append("::fan:");
        sb.append("\n");
        fan();

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        id = bf.readLine();

        print();
    }
}
