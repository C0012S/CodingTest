/*
4458. Bronze 3 - 첫 글자를 대문자로

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           12766	    6313      5658	         51.483%


    문제
        문장을 읽은 뒤, 줄의 첫 글자를 대문자로 바꾸는 프로그램을 작성하시오.


    입력
        첫째 줄에 줄의 수 N이 주어진다. 다음 N개의 줄에는 문장이 주어진다. 각 문장에 들어있는 글자의 수는 30을 넘지 않는다. 모든 줄의 첫 번째 글자는 알파벳이다.


    출력
        각 줄의 첫글자를 대문자로 바꾼뒤 출력한다.


    예제 입력 1
        5
        powdered Toast Man
        skeletor
        Electra Woman and Dyna Girl
        she-Ra Princess of Power
        darth Vader
    예제 출력 1
        Powdered Toast Man
        Skeletor
        Electra Woman and Dyna Girl
        She-Ra Princess of Power
        Darth Vader


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14012KB
// 시간 : 120ms
// 코드 길이 : 631B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            String sentence = bf.readLine();

            sb.append(sentence.substring(0, 1).toUpperCase());
            sb.append(sentence.substring(1));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
