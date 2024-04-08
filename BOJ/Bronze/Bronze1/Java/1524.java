/*
1524. Bronze 1 - 세준세비

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           2424	    1068      852	         48.299%


    문제
        세준이와 세비는 온라인 게임을 즐겨한다. 이 온라인 게임에서는 군대를 서로 키울 수 있다. 세준이는 N명의 병사를 키웠고, 세비는 M명의 병사를 키웠다.
        이제 서로 전쟁을 하려고 한다.
        전쟁은 여러 번의 전투로 이루어진다. 각 전투에서 살아있는 병사중 제일 약한 병사가 죽는다. 만약 제일 약한 병사가 여러 명이고, 제일 약한 병사가 모두 같은 편에 있다면, 그 중에 한 명이 임의로 선택되어 죽는다. 하지만, 제일 약한 병사가 여러 명이고, 양 편에 모두 있다면, 세비의 제일 약한 병사 중 한 명이 임의로 선택되어 죽는다.
        전쟁은 한 명의 병사를 제외하고 모두 죽었을 때 끝난다. 전쟁의 승자를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 100보다 작거나 같다. 각 테스트 케이스는 다음과 같이 이루어져 있다. 첫째 줄에 N과 M이 들어오고, 둘째 줄에는 세준이의 병사들의 힘이 들어오고, 셋째 줄에는 세비의 병사들의 힘이 들어온다. 힘은 정수이고, 이 값이 클수록 강하고, 작을수록 약하다.
        각 테스트 케이스는 줄 바꿈으로 구분되어 있다.


    출력
        각 테스트 케이스에 대해서 한 줄에 하나씩 차례대로 승자를 출력한다. 세준이가 이기면 S를 세비가 이기면 B를 둘다 아닐 경우에는 C를 출력한다.


    제한
        · 1 ≤ N, M ≤ 1,000,000
        · 병사들의 힘은 300,000,000보다 작거나 같은 자연수이다.


    예제 입력 1
        2

        1 1
        1
        1

        3 2
        1 3 2
        5 5
    예제 출력 1
        S
        B


    알고리즘 분류
        구현
        정렬
*/


// 메모리 : 66820KB
// 시간 : 520ms
// 코드 길이 : 1313B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            bf.readLine();

            token = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());
            int sMax = 0;
            int bMax = 0;

            token = new StringTokenizer(bf.readLine());
            for (int n = 0; n < N; n++) {
                sMax = Math.max(sMax, Integer.parseInt(token.nextToken()));
            }

            token = new StringTokenizer(bf.readLine());
            for (int m = 0; m < M; m++) {
                bMax = Math.max(bMax, Integer.parseInt(token.nextToken()));
            }

            if (sMax >= bMax) {
                sb.append("S");
            }
            else {
                sb.append("B");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
