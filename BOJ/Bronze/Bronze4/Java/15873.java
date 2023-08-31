/*
15873. Bronze 4 - 공백 없는 A+B

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    0.5 초	    512 MB           8939	    4300      3944	         49.798%


    문제
        자연수 A, B가 주어지면 A+B를 구하는 프로그램을 작성하시오.


    입력
        자연수 A, B (0 < A, B ≤ 10)가 첫 번째 줄에 주어진다. 단, 두 수의 사이에는 공백이 주어지지 않는다. 두 수의 앞에 불필요한 0이 붙는 경우는 없다.


    출력
        첫 번째 줄에 A+B의 값을 출력한다.


    예제 입력 1
        37
    예제 출력 1
        10

    예제 입력 2
        102
    예제 출력 2
        12


    알고리즘 분류
        수학
        사칙연산
        많은 조건 분기
*/


// 메모리 : 14260KB
// 시간 : 124ms
// 코드 길이 : 1057B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String numString = bf.readLine(); // 공백 없이 입력된 자연수 A, B의 문자열

        int A; // 자연수 A (0 < A ≤ 10)
        int B; // 자연수 B (0 < B ≤ 10)
        if (numString.charAt(1) == '0') { // 입력된 문자열의 두 번째 수가 0일 경우
            A = 10;
            B = Integer.parseInt(numString.substring(2)); // 입력된 문자열의 세 번째부터 마지막(네 번째)까지의 값을 가지는 수
        }
        else { // 입력된 문자열의 두 번째 수가 0이 아닐 경우
            A = numString.charAt(0) - '0';
            B = Integer.parseInt(numString.substring(1)); // 입력된 문자열의 두 번째부터 마지막(네 번째)까지의 값을 가지는 수
        }

        System.out.println(A + B);
    }
}
