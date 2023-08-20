/*
1748. Silver 4 - 수 이어 쓰기 1

    시간 제한	                메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    0.15 초 (하단 참고)	    128 MB           26505	    12126     10014	         48.412%


    문제
        1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
            1234567891011121314151617181920212223...

        이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.


    출력
        첫째 줄에 새로운 수의 자릿수를 출력한다.


    예제 입력 1
        5
    예제 출력 1
        5

    예제 입력 2
        15
    예제 출력 2
        21

    예제 입력 3
        120
    예제 출력 3
        252


    알고리즘 분류
        수학
        구현


    시간 제한
        Python 3: 0.5 초
        PyPy3: 0.5 초
        Python 2: 0.5 초
        PyPy2: 0.5 초
*/


// 메모리 : 14052KB
// 시간 : 124ms
// 코드 길이 : 630B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // N (1 ≤ N ≤ 100,000,000)

        int answer = 0; // 새로운 수의 자릿수
        for (int n = 0; n < String.valueOf(N).length(); n++) {
            answer += N - Math.pow(10, n) + 1; // 10^n의 자릿수가 등장하는 개수 : N - Math.pow(10, n) + 1
        }

        System.out.println(answer);
    }
}
