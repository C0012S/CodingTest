/*
9295. Bronze 3 - 주사위

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           7744	    5672      5313	         74.381%


    문제
        오늘은 갑자기 주사위를 던지고 싶다.
        그런데 코딩도 하고 싶다.
        그럼 같이할까?


    입력
        첫째 줄에 테스트 케이스의 개수 T가 주어진다.
        각 테스트 케이스는 한 줄로 이루어져 있으며, 주사위를 두 번 던져 나온 두 수를 입력한다.


    출력
        각 테스트 케이스마다 "Case x: "를 출력한 다음, 주사위를 두 번 던져 나온 두 수의 합을 출력한다. 테스트 케이스 번호(x)는 1부터 시작한다.


    예제 입력 1
        5
        1 2
        1 3
        3 5
        2 6
        3 4
    예제 출력 1
        Case 1: 3
        Case 2: 4
        Case 3: 8
        Case 4: 8
        Case 5: 7


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14572KB
// 시간 : 144ms
// 코드 길이 : 816B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수

        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        for (int t = 1; t <= T; t++) {
            token = new StringTokenizer(bf.readLine());
            sb.append("Case ");
            sb.append(t);
            sb.append(": ");
            sb.append(Integer.parseInt(token.nextToken()) + Integer.parseInt(token.nextToken()));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
