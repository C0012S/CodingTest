/*
1157. Bronze 1 - 단어 공부

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           244419	    97854     77544	         39.666%


    문제
        알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.


    입력
        첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.


    출력
        첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.


    예제 입력 1
        Mississipi
    예제 출력 1
        ?

    예제 입력 2
        zZa
    예제 출력 2
        Z

    예제 입력 3
        z
    예제 출력 3
        Z

    예제 입력 4
        baaa
    예제 출력 4
        A


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 21032KB
// 시간 : 300ms
// 코드 길이 : 1112B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String word = bf.readLine().toUpperCase(); // 단어

        int alphabet[] = new int[26]; // 해당 인덱스의 알파벳이 사용되는 횟수를 저장하는 배열 // 알파벳의 개수는 26 개
        for (int w = 0; w < word.length(); w++) {
            alphabet[word.charAt(w) - 'A'] += 1; // 알파벳의 사용 횟수 추가
        }

        int maxNum = 0; // 가장 많이 사용된 알파벳의 사용 횟수
        char maxAlphabet = '?'; // 가장 많이 사용된 알파벳
        for (int m = 0; m < alphabet.length; m++) {
            if (maxNum < alphabet[m]) {
                maxNum = alphabet[m];
                maxAlphabet = (char) (m + 'A');
            }
            else if (maxNum == alphabet[m]){
                maxAlphabet = '?';
            }
        }

        System.out.println(maxAlphabet);
    }
}
