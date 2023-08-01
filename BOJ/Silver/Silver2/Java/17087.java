/*
17087. Silver 2 - 숨바꼭질 6

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    1 초         512 MB           8893       4390       3496           48.434%


    문제
        수빈이는 동생 N명과 숨바꼭질을 하고 있다. 수빈이는 현재 점 S에 있고, 동생은 A_1, A_2, ..., A_N에 있다.
        수빈이는 걸어서 이동을 할 수 있다. 수빈이의 위치가 X일때 걷는다면 1초 후에 X + D나 X - D로 이동할 수 있다. 수빈이의 위치가 동생이 있는 위치와 같으면, 동생을 찾았다고 한다.
        모든 동생을 찾기위해 D의 값을 정하려고 한다. 가능한 D의 최댓값을 구해보자.


    입력
        첫째 줄에 N(1 ≤ N ≤ 10^5)과 S(1 ≤ S ≤ 10^9)가 주어진다. 둘째 줄에 동생의 위치 A_i(1 ≤ A_i ≤ 10^9)가 주어진다. 동생의 위치는 모두 다르며, 수빈이의 위치와 같지 않다.


    출력
        가능한 D값의 최댓값을 출력한다.


    예제 입력 1
        3 3
        1 7 11
    예제 출력 1
        2

    예제 입력 2
        3 81
        33 105 57
    예제 출력 2
        24

    예제 입력 3
        1 1
        1000000000
    예제 출력 3
        999999999


    알고리즘 분류
        수학
        정수론
        유클리드 호제법
*/


// 메모리 : 25996KB
// 시간 : 356ms
// 코드 길이 : 2326B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 수빈이의 동생의 수 N (1 ≤ N ≤ 10^5)
    static int broLocations[]; // 수빈이의 현재 위치에서 수빈이의 동생들의 위치를 가기 위해 걸리는 길이를 저장하는 배열
    static int D; // 수빈이가 이동할 수 있는 길이

    public static int gcd(int bigNum, int smallNum) { // 유클리드 호제법  // GCD(Greatest Common Divisor) : 최대 공약수
        if (smallNum == 0) {
            return bigNum;
        }
        else {
            return gcd(smallNum, bigNum % smallNum);
        }
    }

    public static void calculateMaxMoveLength() { // 수빈이가 동생들을 찾기 위해 수빈이가 이동할 수 있는 길이들의 최댓값을 구하는 함수  // 수빈이가 이동해야 하는 길이들의 최대 공약수를 구하면 된다.
        if (N > 1) { // 동생의 수가 1 명보다 많을 경우
            D = gcd(Math.max(broLocations[0], broLocations[1]), Math.min(broLocations[0], broLocations[1]));
            for (int c = 2; c < N; c++) {
                D = gcd(Math.max(D, broLocations[c]), Math.min(D, broLocations[c])); // A와 B의 최대 공약수와 C의 최대 공약수를 구하면 A, B, C의 최대 공약수이다. 그러므로 이전의 최대 공약수로 구한 값과 수빈이가 이동해야 하는 길이들 중 하나의 최대 공약수를 구한다.
            }
        }
        else {
            D = Math.abs(broLocations[0]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        int S = Integer.parseInt(token.nextToken()); // 현재 수빈이의 위치 (1 ≤ S ≤ 10^9)

        broLocations = new int[N];
        token = new StringTokenizer(bf.readLine());
        for (int n = 0; n < N; n++) {
            broLocations[n] = Math.abs(Integer.parseInt(token.nextToken()) - S); // 동생의 위치 Ai(1 ≤ Ai ≤ 10^9)
        }

        calculateMaxMoveLength();
        System.out.println(D);
    }
}
