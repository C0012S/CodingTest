/*
3063. Silver 5 - 게시판

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           916	    290       254	         40.317%


    문제
        가을 축제를 맞아 영화 동아리의 상원은 과 게시판에 동아리 상영회 포스터를 붙였다. 잠시 후에 와 보니 다른 동아리 사람이 그 위에 다른 행사 포스터를 붙여 일부분이 가려서 보이지 않는 것이다. 동아리 간에는 다른 포스터를 절반 이상은 가릴 수 없도록 되어 있기에 보이는 부분의 넓이를 계산해보고 따지러 가기로 하였다. 포스터는 둘 다 직사각형이며, 게시판 벽에 평행하게 붙어있다고 하자. 각 포스터의 위치는 왼쪽 아래와 오른쪽 위 두 꼭짓점의 좌표로 주어진다.
            [그림은 문제에서 참고]


    입력
        입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄에 8개의 정수 x1, y1, x2, y2, x3, y3, x4, y4가 주어진다. 상원이 처음 붙인 포스터의 두 꼭짓점의 좌표 (x1, y1), (x2, y2)와 그 위에 덧붙은 포스터의 꼭짓점의 좌표 (x3, y3), (x4, y4) 이다. 1 ≤ x1 < x2 ≤ 10,000; 1 ≤ y1 < y2 ≤ 10,000; 1 ≤ x3 < x4 ≤ 10,000; 1 ≤ y3 < y4 ≤ 10,000의 범위를 가진다.


    출력
        각 테스트 케이스에 대해서 보이는 부분의 넓이를 한 줄에 하나씩 출력한다.


    예제 입력 1
        3
        2 3 5 8 4 7 6 10
        1 1 5 5 2 2 4 4
        2 2 4 4 1 1 5 5
    예제 출력 1
        14
        12
        0


    알고리즘 분류
        수학
        기하학
*/


// 메모리 : 15244KB
// 시간 : 160ms
// 코드 길이 : 2358B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    public static void calculate(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) { // 상원이 처음 붙인 포스터의 보이는 부분의 넓이를 구하는 메서드
        // 상원이 처음 붙인 포스터와 다른 동아리 사람이 붙인 포스터가 겹치는 부분의 왼쪽 아래 꼭짓점의 좌표와 오른쪽 위 꼭짓점의 좌표
        int leftX = Math.max(x1, x3);
        int leftY = Math.max(y1, y3);
        int rightX = Math.min(x2, x4);
        int rightY = Math.min(y2, y4);

        int myPosterArea = (x2 - x1) * (y2 - y1); // 상원이 처음 붙인 포스터의 넓이
        int area = 0; // 상원이 처음 붙인 포스터의 보이는 부분의 넓이
        if (leftX > rightX || leftY > rightY) { // 상원이 처음 붙인 포스터와 다른 동아리 사람이 붙인 포스터가 겹치지 않을 경우
            area = myPosterArea;
        }
        else {
            int midArea = (rightX - leftX) * (rightY - leftY); // 상원이 처음 붙인 포스터와 다른 동아리 사람이 붙인 포스터가 겹치는 부분의 넓이
            area = myPosterArea - midArea;
        }

        sb.append(area);
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수

        StringTokenizer token;
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());
            int x3 = Integer.parseInt(token.nextToken());
            int y3 = Integer.parseInt(token.nextToken());
            int x4 = Integer.parseInt(token.nextToken());
            int y4 = Integer.parseInt(token.nextToken());

            calculate(x1, y1, x2, y2, x3, y3, x4, y4);
        }

        System.out.println(sb);
    }
}
