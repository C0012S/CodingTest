/*
10757. Bronze 5 - 큰 수 A+B

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           99138	    46130     40075	         49.729%


    문제
        두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)


    출력
        첫째 줄에 A+B를 출력한다.


    예제 입력 1
        9223372036854775807 9223372036854775808
    예제 출력 1
        18446744073709551615


    알고리즘 분류
        수학
        구현
        사칙연산
        임의 정밀도 / 큰 수 연산
*/


// 메모리 : 17428KB
// 시간 : 244ms
// 코드 길이 : 554B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        BigInteger A = new BigInteger(token.nextToken());
        BigInteger B = new BigInteger(token.nextToken());

        System.out.println(A.add(B));
    }
}
