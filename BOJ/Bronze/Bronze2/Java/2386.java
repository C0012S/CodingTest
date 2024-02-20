/*
2386. Bronze 2 - 도비의 영어 공부

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           4718	    2676      2386	         58.943%


    문제
        꿍은 도비의 자유를 위해 영어를 가르치기로 결심했다. 하지만 도비는 바보라 ABC부터 배워야 한다.
        그래서 꿍은 영어 문장과 알파벳 하나가 주어지면 그 알파벳이 문장에서 몇 번 나타나는지를 세는 문제들을 내주었다. 하지만 도비는 마법사고 컴공도 마법사다.
        여러분은 도비를 위해 문제의 답을 알려주는 프로그램을 만들수 있을것이다!


    입력
        입력은 몇 개의 줄들로 이루어진다.
        각 줄에는 하나의 소문자와 영어 문장이 공백으로 구분되어 주어진다.
        각 문장은 길이가 1에서 250이며 입력의 마지막은 #이다.


    출력
        출력의 각 줄은 입력으로 주어진 소문자와 그 소문자 알파벳이 나타난 횟수로 이루어진다. 이때 문장에서 해당 알파벳이 소문자로 나타나던 대문자로 나타나던 모두 세야 한다.


    예제 입력 1
        g Programming Contest
        n New Zealand
        x This is quite a simple problem.
        #
    예제 출력 1
        g 2
        n 2
        x 0


    알고리즘 분류
        구현
        문자열
        브루트포스 알고리즘
*/


// 메모리 : 14192KB
// 시간 : 124ms
// 코드 길이 : 964B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;

    public static void check(String alphabet, String sentence[]) {
        int num = 0;
        for (int s = 0, len = sentence.length; s < len; s++) {
            if (alphabet.equals(sentence[s])) {
                num += 1;
            }
        }

        sb.append(alphabet);
        sb.append(" ");
        sb.append(num);
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        while (true) {
            String str = bf.readLine();

            if (str.equals("#")) {
                break;
            }

            check(String.valueOf(str.charAt(0)), str.toLowerCase().substring(2).split(""));
        }

        System.out.println(sb);
    }
}
