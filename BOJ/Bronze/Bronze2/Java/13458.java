/*
13458. Bronze 2 - 시험 감독

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    512 MB           100653	    31410     23425	         29.726%


    문제
        총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다. i번 시험장에 있는 응시자의 수는 Ai명이다.
        감독관은 총감독관과 부감독관으로 두 종류가 있다. 총감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명이고, 부감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 C명이다.
        각각의 시험장에 총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.
        각 시험장마다 응시생들을 모두 감시해야 한다. 이때, 필요한 감독관 수의 최솟값을 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 시험장의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
        둘째 줄에는 각 시험장에 있는 응시자의 수 Ai (1 ≤ Ai ≤ 1,000,000)가 주어진다.
        셋째 줄에는 B와 C가 주어진다. (1 ≤ B, C ≤ 1,000,000)


    출력
        각 시험장마다 응시생을 모두 감독하기 위해 필요한 감독관의 최소 수를 출력한다.


    예제 입력 1
        1
        1
        1 1
    예제 출력 1
        1

    예제 입력 2
        3
        3 4 5
        2 2
    예제 출력 2
        7

    예제 입력 3
        5
        1000000 1000000 1000000 1000000 1000000
        5 7
    예제 출력 3
        714290

    예제 입력 4
        5
        10 9 10 9 10
        7 20
    예제 출력 4
        10

    예제 입력 5
        5
        10 9 10 9 10
        7 2
    예제 출력 5
        13


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 92252KB
// 시간 : 432ms
// 코드 길이 : 1665B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 시험장의 개수 (1 ≤ N ≤ 1000000)
    static int[] A; // 각 시험장에 있는 응시자의 수 (1 ≤ A_i ≤ 1000000)
    static int B; // 총감독관이 한 시험장에서 감시할 수 있는 응시자의 수
    static int C; // 부감독관이 한 시험장에서 감시할 수 있는 응시자의 수

    public static void calculate() { // 각 시험장마다 응시생들을 모두 감시하기 위해 필요한 감독관 수의 최솟값을 구하는 메서드
        long supervisor = 0; // 각 시험장마다 응시생들을 모두 감시하기 위해 필요한 감독관 수의 최솟값
        for (int n = 0; n < N; n++) {
            supervisor += 1; // 총감독관의 수 추가
            A[n] -= B;

            if (A[n] > 0) {
                supervisor += Math.ceil((double) A[n] / C); // 부감독관의 수 추가
            }
        }

        System.out.println(supervisor);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        A = new int[N];
        StringTokenizer token = new StringTokenizer(bf.readLine());
        for (int a = 0; a < N; a++) {
            A[a] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(bf.readLine());
        B = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        calculate();
    }
}
