/*
11382. Bronze 5 - 꼬마 정민

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    512 MB           150562	    61122     55976	         41.254%


    문제
        꼬마 정민이는 이제 A + B 정도는 쉽게 계산할 수 있다. 이제 A + B + C를 계산할 차례이다!


    입력
        첫 번째 줄에 A, B, C (1 ≤ A, B, C ≤ 1012)이 공백을 사이에 두고 주어진다.


    출력
        A+B+C의 값을 출력한다.


    예제 입력 1
        77 77 7777
    예제 출력 1
        7931


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14140KB
// 시간 : 120ms
// 코드 길이 : 566B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(token.nextToken());
        long B = Long.parseLong(token.nextToken());
        long C = Long.parseLong(token.nextToken());

        System.out.println(A + B + C);
    }
}
