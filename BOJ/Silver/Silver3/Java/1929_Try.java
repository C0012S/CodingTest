/*
1929. Silver 3 - 소수 구하기

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    2 초         256 MB           243076     70091      49274          26.951%


    문제
        M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.


    출력
        한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.


    예제 입력 1
        3 16
    예제 출력 1
        3
        5
        7
        11
        13


    알고리즘 분류
        수학
        정수론
        소수 판정
        에라토스테네스의 체


    채점 및 기타 정보
        이 문제의 채점 우선 순위는 2이다.
*/


// 코드 길이 : 1278B
// 시간 초과
// 오답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(token.nextToken()); // 자연수 M
        int N = Integer.parseInt(token.nextToken()); // 자연수 N

        for (int i = M; i <= N; i++) { // M부터 N까지 반복  // M부터 N까지의 자연수가 소수인지 검사
            boolean isExistFactor = false; // 인수 존재 여부  // 소수는 약수가 1과 자기 자신뿐인 자연수를 의미한다.

            for (int j = 2; j < i; j++) { // 2부터 검사할 자연수 전까지 반복
                if (i % j == 0) { // 해당 수(2부터 검사할 자연수 전까지의 수 중 하나)가 검사할 자연수의 인수라면
                    isExistFactor = true; // 인수 존재
                    break;
                }
            }

            if (!isExistFactor) { // 1과 자기 자신을 제외한 인수가 없다면
                System.out.println(i);
            }
        }
    }
}
