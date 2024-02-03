/*
10987. Bronze 4 - 모음의 개수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           10256	    8454      7840	         83.761%


    문제
        알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 모음(a, e, i, o, u)의 개수를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 단어가 주어진다. 단어의 길이는 1보다 크거나 같고, 100보다 작거나 같으며, 알파벳 소문자로만 이루어져 있다.


    출력
        첫째 줄에 모음의 개수를 출력한다.


    예제 입력 1
        baekjoon
    예제 출력 1
        4


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14176KB
// 시간 : 124ms
// 코드 길이 : 833B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static ArrayList<Character> vowel; // 모음(a, e, i, o, u)이 저장된 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String word = bf.readLine(); // 알파벳 소문자로만 이루어진 단어

        vowel = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

        int vowelNum = 0; // 단어에 포함된 모음의 개수
        for (int w = 0, len = word.length(); w < len; w++) {
            if (vowel.contains(word.charAt(w))) {
                vowelNum += 1;
            }
        }

        System.out.println(vowelNum);
    }
}
