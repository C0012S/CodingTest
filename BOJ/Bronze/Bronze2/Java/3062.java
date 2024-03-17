/*
3062. Bronze 2 - 수 뒤집기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           6064	    3464      3056	         59.455%


    문제
        수 124를 뒤집으면 421이 되고 이 두 수를 합하면 545가 된다. 124와 같이 원래 수와 뒤집은 수를 합한 수가 좌우 대칭이 되는지 테스트 하는 프로그램을 작성하시오.


    입력
        입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄에 하나의 정수 N(10 ≤ N ≤ 100000)이 주어진다.


    출력
        각 테스트 케이스에 대해서 원래 수와 뒤집은 수를 합한 수가 좌우 대칭이 되면 YES를 아니면 NO를 한 줄에 하나씩 출력한다.


    예제 입력 1
        4
        13
        58
        120
        5056
    예제 출력 1
        YES
        NO
        YES
        NO


    알고리즘 분류
        수학
        구현
        문자열
        사칙연산
*/


// 메모리 : 14128KB
// 시간 : 120ms
// 코드 길이 : 1494B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;

    public static void check(String numberStr) { // 입력받은 수와 입력받은 수를 뒤집은 수를 합한 수가 좌우 대칭이 되는지 검사하는 메서드
        int number = Integer.parseInt(numberStr); // 입력받은 수
        int reversedNumber = Integer.parseInt(new StringBuilder(numberStr).reverse().toString()); // 입력받은 수를 뒤집은 수

        int sumNumber = number + reversedNumber; // 입력받은 수와 입력받은 수를 뒤집은 수를 합한 수
        String sumNumberString = String.valueOf(sumNumber);
        int len = sumNumberString.length();
        for (int n = 0, size = len / 2; n < size; n++) {
            if (sumNumberString.charAt(n) != sumNumberString.charAt(len - n - 1)) {
                sb.append("NO");
                return;
            }
        }

        sb.append("YES");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수

        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String numberStr = bf.readLine(); // 입력받은 수의 문자열

            check(numberStr);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
