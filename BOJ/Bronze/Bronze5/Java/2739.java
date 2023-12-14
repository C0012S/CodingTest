/*
2739. Bronze 5 - 구구단

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           393709	    197534    164929	     50.750%


    문제
        N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.


    입력
        첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 9보다 작거나 같다.


    출력
        출력형식과 같게 N*1부터 N*9까지 출력한다.


    예제 입력 1
        2
    예제 출력 1
        2 * 1 = 2
        2 * 2 = 4
        2 * 3 = 6
        2 * 4 = 8
        2 * 5 = 10
        2 * 6 = 12
        2 * 7 = 14
        2 * 8 = 16
        2 * 9 = 18


    알고리즘 분류
        수학
        구현
*/


// 메모리 : 14068KB
// 시간 : 124ms
// 코드 길이 : 709B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void multiplication() {
        StringBuilder sb = new StringBuilder();
        for (int n = 1; n <= 9; n++) {
            sb.append(N);
            sb.append(" * ");
            sb.append(n);
            sb.append(" = ");
            sb.append(N * n);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        multiplication();
    }
}
