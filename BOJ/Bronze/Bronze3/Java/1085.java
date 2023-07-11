/*
1085. Bronze 3 - 직사각형에서 탈출

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           83001	    53426     47079	        64.544%


    문제
        한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 x, y, w, h가 주어진다.


    출력
        첫째 줄에 문제의 정답을 출력한다.


    제한
        1 ≤ w, h ≤ 1,000
        1 ≤ x ≤ w-1
        1 ≤ y ≤ h-1
        x, y, w, h는 정수


    예제 입력 1
        6 2 10 3
    예제 출력 1
        1

    예제 입력 2
        1 1 5 5
    예제 출력 2
        1

    예제 입력 3
        653 375 1000 1000
    예제 출력 3
        347

    예제 입력 4
        161 181 762 375
    예제 출력 4
        161


    알고리즘 분류
        수학
        기하학
*/


// 메모리 : 14156KB
// 시간 : 124ms
// 코드 길이 : 1539B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int x = Integer.parseInt(token.nextToken()); // 현재 있는 위치의 x 좌표
        int y = Integer.parseInt(token.nextToken()); // 현재 있는 위치의 y 좌표
        int w = Integer.parseInt(token.nextToken()); // 오른쪽 위 꼭짓점의 x 좌표 w
        int h = Integer.parseInt(token.nextToken()); // 오른쪽 위 꼭짓점의 y 좌표 h

        int diffX = w - x > x ? x : w - x; // x 좌표의 차이  // 오른쪽 위 꼭짓점의 x 좌표와의 차이가 왼쪽 아래 꼭짓점(0, 0)의 x 좌표와의 차이보다 크면 왼쪽 아래 꼭짓점의 x 좌표와의 차이 x, 아닐 경우 오른쪽 위 꼭짓점의 x 좌표와의 차이 w - x
        int diffY = h - y > y ? y : h - y; // y 좌표의 차이  // 오른쪽 위 꼭짓점의 y 좌표와의 차이가 왼쪽 아래 꼭짓점(0, 0)의 y 좌표와의 차이보다 크면 왼쪽 아래 꼭짓점의 y 좌표와의 차이 y, 아닐 경우 오른쪽 위 꼭짓점의 y 좌표와의 차이 h - y

        System.out.println(diffX > diffY ? diffY : diffX); // x 좌표의 차이와 y 좌표의 차이 중 작은 값이 직사각형의 경계선까지 가는 거리의 최솟값
    }
}
