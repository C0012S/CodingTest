/*
4740. Bronze 3 - 거울, 오! 거울

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           3238	    1880      1709	         61.364%


    문제
        근하와 세용이는 주차장에서 자신들의 차 뒤에 주차된 구급차에 쓰여있는 ECNALUBMA라는 알 수없는 글자를 보고 갸우뚱하였다. 그리고 그들이 차에 탄 뒤 백미러를 통해 보고서야 그 글자가 AMBULANCE라는 것이였음을 알고는 웃음을 참을 수 없었다.
        근하와 세용이는 뒤늦게서야 각각의 문자의 위치가 거꾸로 되어버린 이 글자들을 자신들도 모르는 사이에 머릿속에서 올바른 글자가 되도록 수정작업을 하며 애를 쓰고 있었음을 깨달았다.
        이 경험을 통해 흥미를 가지게 된 근하와 세용이는, 문장을 입력하면 입력한 문장의 개별 단어들을 역순으로 배치하여 거꾸로 바뀐 문장을 출력하는 프로그램을 만들어 '거울 읽기' 연습을 하려고 마음먹었다.


    입력
        하나 또는 그 이상의 줄에 각각 ASCII 글자로 나타낼 수 있는 단어들(알파벳, 숫자, 공백, 구두점 등)로 구성된 문장을 입력한다.
        각 문장은 최소 1글자에서 최대 80글자로 이루어져 있으며, ***을 입력하면 프로그램이 종료된다.


    출력
        한 문장의 입력이 끝난 뒤 바로 입력한 문장의 글자들이 역순으로 바뀌어 배치된 문장을 출력한다.


    예제 입력 1
        AMBULANCE
        Evian
        madam, i'm adam
        ***
    예제 출력 1
        ECNALUBMA
        naivE
        mada m'i ,madam


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14052KB
// 시간 : 120ms
// 코드 길이 : 658B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String word = bf.readLine();

            if (word.equals("***")) {
                break;
            }

            for (int len = word.length(), w = len - 1; w >= 0; w--) {
                sb.append(word.charAt(w));
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
