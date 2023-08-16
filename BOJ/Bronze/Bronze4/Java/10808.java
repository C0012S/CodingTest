/*
10808. Bronze 4 - 알파벳 개수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           42875	    29161     23670	         68.800%


    문제
        알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.


    출력
        단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.


    예제 입력 1
        baekjoon
    예제 출력 1
        1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14204KB
// 시간 : 128ms
// 코드 길이 : 787B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String S = bf.readLine(); // 단어 S
        int alphabet[] = new int[26]; // 해당 인덱스의 알파벳이 사용되는 횟수를 저장하는 배열 // 알파벳의 개수는 26 개

        for (int w = 0; w < S.length(); w++) {
            alphabet[S.charAt(w) - 'a'] += 1; // 해당 알파벳의 개수 카운트
        }

        String alphabetNum = Arrays.toString(alphabet);
        System.out.println(alphabetNum.substring(1, alphabetNum.length() - 1).replace(",", ""));
    }
}
