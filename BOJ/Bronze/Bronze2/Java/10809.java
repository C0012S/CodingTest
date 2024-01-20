/*
10809. Bronze 2 - 알파벳 찾기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           210352	    112376    92518	         53.178%


    문제
        알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.


    출력
        각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
        만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.


    예제 입력 1
        baekjoon
    예제 출력 1
        1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14284KB
// 시간 : 124ms
// 코드 길이 : 1322B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String S; // 알파벳 소문자로만 이루어져 있고, 길이가 100을 넘지 않는 단어
    static int alphabet[]; // 해당 인덱스의 알파벳이 처음 등장하는 위치를 저장하는 배열  // 0 : a, 1 : b, 2 : c, ..., 25 : z

    public static void print() { // 각각의 알파벳이 처음 등장하는 위치를 출력하는 메서드
        StringBuilder sb = new StringBuilder();
        for (int position : alphabet) {
            sb.append(position);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    public static void find() { // 각각의 알파벳이 처음 등장하는 위치를 찾고 출력하는 메서드
        Arrays.fill(alphabet, -1);

        for (int s = 0, len = S.length(); s < len; s++) {
            int index = S.charAt(s) - 'a';
            if (alphabet[index] == -1) {
                alphabet[index] = s;
            }
        }

        print();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        S = bf.readLine();

        alphabet = new int[26];
        find();
    }
}
