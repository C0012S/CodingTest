/*
1259. Bronze 1 - 팰린드롬수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           50658	    28919     25513	         57.477%


    문제
        어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.
        수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 121, 12421 등은 팰린드롬수다. 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다. 또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.


    입력
        입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다. 입력의 마지막 줄에는 0이 주어지며, 이 줄은 문제에 포함되지 않는다.


    출력
        각 줄마다 주어진 수가 팰린드롬수면 'yes', 아니면 'no'를 출력한다.


    예제 입력 1
        121
        1231
        12421
        0
    예제 출력 1
        yes
        no
        yes


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14004KB
// 시간 : 120ms
// 코드 길이 : 826B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String distinguishPalindromeNum(String num) { // 팰린드롬수인지 판별하는 함수
        int numLength = num.length();

        for (int n = 0; n < numLength / 2; n++) {
            if (num.charAt(n) != num.charAt(numLength - n - 1)) {
                return "no";
            }
        }

        return "yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String num = bf.readLine();

            if (num.equals("0")) {
                break;
            }

            System.out.println(distinguishPalindromeNum(num));
        }
    }
}
