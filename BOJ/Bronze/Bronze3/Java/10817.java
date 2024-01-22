/*
10817. Bronze 3 - 세 수

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           130775	    63380     55391	         49.852%


    문제
        세 정수 A, B, C가 주어진다. 이때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 세 정수 A, B, C가 공백으로 구분되어 주어진다. (1 ≤ A, B, C ≤ 100)


    출력
        두 번째로 큰 정수를 출력한다.


    예제 입력 1
        20 30 10
    예제 출력 1
        20

    예제 입력 2
        30 30 10
    예제 출력 2
        30

    예제 입력 3
        40 40 40
    예제 출력 3
        40

    예제 입력 4
        20 10 10
    예제 출력 4
        10


    알고리즘 분류
        구현
        정렬
*/


// 메모리 : 14372KB
// 시간 : 124ms
// 코드 길이 : 610B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int number[] = new int[3];
        for (int i = 0; i < 3; i++) {
            number[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(number);

        System.out.println(number[1]);
    }
}
