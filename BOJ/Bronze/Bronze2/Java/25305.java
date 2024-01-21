/*
25305. Bronze 2 - 커트라인

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    1024 MB          31288	    20383     18675	         66.099%


    문제
        2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 N명의 학생들이 응시했다.
        이들 중 점수가 가장 높은 k명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
        커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.


    입력
        첫째 줄에는 응시자의 수 N과 상을 받는 사람의 수 k가 공백을 사이에 두고 주어진다.
        둘째 줄에는 각 학생의 점수 x가 공백을 사이에 두고 주어진다.


    출력
        상을 받는 커트라인을 출력하라.


    제한
        · 1 ≤ N ≤ 1000
        · 1 ≤ k ≤ N
        · 0 ≤ x ≤ 10000


    예제 입력 1
        5 2
        100 76 85 93 98
    예제 출력 1
        98

    시험 응시자들 가운데 1등은 100점, 2등은 98점, 3등은 93점이다. 2등까지 상을 받으므로 커트라인은 98점이다.


    알고리즘 분류
        구현
        정렬
*/


// 메모리 : 14380KB
// 시간 : 132ms
// 코드 길이 : 767B
// 정답

package BOJ.Bronze.Bronze2.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(bf.readLine());
        int score[] = new int[N];
        for (int n = 0; n < N; n++) {
            score[n] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(score);
        System.out.println(score[N - k]);
    }
}
