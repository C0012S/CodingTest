/*
1075. Bronze 2 - 나누기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           20904	    11453     10114	        57.086%


    문제
        두 정수 N과 F가 주어진다. 지민이는 정수 N의 가장 뒤 두 자리를 적절히 바꿔서 N을 F로 나누어 떨어지게 만들려고 한다. 만약 가능한 것이 여러 가지이면, 뒤 두 자리를 가능하면 작게 만들려고 한다.
        예를 들어, N=275이고, F=5이면, 답은 00이다. 200이 5로 나누어 떨어지기 때문이다. N=1021이고, F=11이면, 정답은 01인데, 1001이 11로 나누어 떨어지기 때문이다.


    입력
        첫째 줄에 N, 둘째 줄에 F가 주어진다. N은 100보다 크거나 같고, 2,000,000,000보다 작거나 같은 자연수이다. F는 100보다 작거나 같은 자연수이다.


    출력
        첫째 줄에 마지막 두 자리를 모두 출력한다. 한자리이면 앞에 0을 추가해서 두 자리로 만들어야 한다.


    예제 입력 1
        1000
        3
    예제 출력 1
        02

    예제 입력 2
        2000000000
        100
    예제 출력 2
        00

    예제 입력 3
        23442
        75
    예제 출력 3
        00

    예제 입력 4
        428392
        17
    예제 출력 4
        15

    예제 입력 5
        32442
        99
    예제 출력 5
        72


    알고리즘 분류
        수학
        브루트포스 알고리즘
*/


// 메모리 : 14200KB
// 시간 : 128ms
// 코드 길이 : 865B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 정수 N (100 ≤ N ≤ 2,000,000,000)
        int F = Integer.parseInt(bf.readLine()); // 정수 F (0 < F ≤ 100)

        N -= (N % 100); // N의 뒤의 두 자리 수를 00으로 바꿔 준다.
        while (N % F != 0) {
            N++;
        }

        String stringNum = String.valueOf(N); // 정수 N을 문자열로 변환
        System.out.println(stringNum.substring(stringNum.length() - 2)); // N의 뒤의 두 자리 수만 바꿔서 만든 N이 F로 나누어 떨어지는 수들 중 가장 작은 수의 마지막 두 자리
    }
}
