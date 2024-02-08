/*
3059. Bronze 3 - 등장하지 않는 문자의 합

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           6551	    3935      3587	         60.807%


    문제
        알파벳 대문자로 구성되어있는 문자열 S가 주어졌을 때, S에 등장하지 않는 알파벳 대문자의 아스키 코드 값의 합을 구하는 프로그램을 작성하시오.
        문자열 S가 “ABCDEFGHIJKLMNOPQRSTUVW” 일 때, S에 등장하지 않는 알파벳 대문자는 X, Y, Z이다. X의 아스키 코드 값은 88, Y는 89, Z는 90이므로 이 아스키 코드 값의 합은 267이다.

        알파벳 대문자의 아스키 코드 값은 다음과 같다.
            A	B	C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
            65	66	67	68	69	70	71	72	73	74	75	76	77	78	79	80	81	82	83	84	85	86	87	88	89	90


    입력
        입력은 T개의 테스트 데이터로 구성된다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 각 테스트 데이터는 한 줄로 구성되어 있고, 문자열 S가 주어진다. S는 알파벳 대문자로만 구성되어 있고, 최대 1000글자이다.


    출력
        각 테스트 데이터에 대해, 입력으로 주어진 문자열 S에 등장하지 않는 알파벳 대문자의 아스키 코드 값의 합을 한 줄에 하나씩 출력한다.


    예제 입력 1
        2
        ABCDEFGHIJKLMNOPQRSTUVW
        A
    예제 출력 1
        267
        1950


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14216KB
// 시간 : 124ms
// 코드 길이 : 1627B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int sum; // A부터 B까지의 아스키 코드 값의 합
    static boolean isSelected[]; // 해당 인덱스의 문자 방문 여부를 저장하는 배열
    static StringBuilder sb;

    public static void calculateSum() { // A부터 B까지의 아스키 코드 값의 합을 구하는 메서드
        for (int i = 65; i <= 90; i++) {
            sum += i;
        }
    }

    public static void calculateAnswer(String S) { // 알파벳 대문자로 구성되어 있는 문자열 S에 등장하지 않는 알파벳 대문자의 아스키 코드 값의 합을 구하는 메서드
        int answer = sum;
        for (int s = 0, len = S.length(); s < len; s++) {
            int now = S.charAt(s);
            if (!isSelected[now - 65]) { // 이전에 등장한 문자가 아닐 경우
                answer -= now;
                isSelected[now - 65] = true;
            }
        }

        sb.append(answer);
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수

        calculateSum();

        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            isSelected = new boolean[26];
            calculateAnswer(bf.readLine()); // 알파벳 대문자로만 구성되어 있고, 최대 1000 글자인 문자열 S
        }

        System.out.println(sb);
    }
}
