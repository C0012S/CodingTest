/*
2338. Bronze 5 - 긴자리 계산

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           31193	    13423     12526	         50.612%


    문제
        두 수 A, B를 입력받아, A+B, A-B, A×B를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 A가, 둘째 줄에 B가 주어진다. 각각의 수는 10진수로 1,000자리를 넘지 않으며 양수와 음수가 모두 주어질 수 있다.


    출력
        첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A×B를 출력한다. 각각을 출력할 때, 답이 0인 경우를 제외하고는 0으로 시작하게 해서는 안 된다(1을 01로 출력하면 안 된다는 의미).


    예제 입력 1
        1
        -1
    예제 출력 1
        0
        2
        -1


    알고리즘 분류
        수학
        사칙연산
        임의 정밀도 / 큰 수 연산
*/


// 메모리 : 14896KB
// 시간 : 136ms
// 코드 길이 : 648B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BigInteger A = new BigInteger(bf.readLine()); // 1,000 자리를 넘지 않는 10 진수 A
        BigInteger B = new BigInteger(bf.readLine()); // 1,000 자리를 넘지 않는 10 진수 B

        System.out.println(A.add(B)); // A + B
        System.out.println(A.subtract(B)); // A - B
        System.out.println(A.multiply(B)); // A × B
    }
}
