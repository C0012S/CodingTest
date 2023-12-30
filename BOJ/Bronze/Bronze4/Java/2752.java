/*
2752. Bronze 4 - 세수정렬

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           38815	    23169     20696	         61.253%


    문제
        동규는 세수를 하다가 정렬이 하고 싶어졌다.
        정수 세 개를 생각한 뒤에, 이를 오름차순으로 정렬하고 싶어졌다.
        정수 세 개가 주어졌을 때, 가장 작은 수, 그 다음 수, 가장 큰 수를 출력하는 프로그램을 작성하시오.


    입력
        정수 세 개가 주어진다. 이 수는 1보다 크거나 같고, 1,000,000보다 작거나 같다. 이 수는 모두 다르다.


    출력
        제일 작은 수, 그 다음 수, 제일 큰 수를 차례대로 출력한다.


    예제 입력 1
        3 1 2
    예제 출력 1
        1 2 3


    알고리즘 분류
        구현
        정렬
*/


// 메모리 : 14300KB
// 시간 : 120ms
// 코드 길이 : 842B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int num[];

    public static void printSortedNum() {
        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();
        for (int p = 0; p < 3; p++) {
            sb.append(num[p]);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        num = new int[3];
        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(token.nextToken());
        }

        printSortedNum();
    }
}
