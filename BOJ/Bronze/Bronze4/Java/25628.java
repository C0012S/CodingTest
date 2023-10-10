/*
25628. Bronze 4 - 햄버거 만들기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    512 MB           2622	    1998      1913	         76.704%


    문제
        햄버거 가게에서 일하는 종현이는 햄버거를 만드는 일을 하고 있다. 가게에는 햄버거 빵이 A개, 햄버거 패티가 B개 있는데, 이 빵과 패티를 가지고 최대한 햄버거를 많이 만드려고 한다. 햄버거를 만드는 과정은 아주 간단한 세 단계로 이루어져 있다.
            1. 그릇 위에 빵을 놓는다.
            2. 빵 위에 패티를 올린다.
            3. 패티 위에 다시 빵을 올려서 햄버거를 완성시킨다.

        햄버거 빵 A개와 햄버거 패티 B개로 만들 수 있는 햄버거의 최대 개수는 얼마일까? 단, 햄버거 빵은 위에 놓는 빵과 아래에 놓는 빵의 구분이 없으며, 남는 빵이나 패티가 있어도 된다.


    입력
        첫째 줄에 햄버거 빵의 개수와 햄버거 패티의 개수를 의미하는 A, B (1 ≤ A, B ≤ 100)가 주어진다.


    출력
        만들 수 있는 햄버거의 최대 개수를 출력한다.


    예제 입력 1
        6 3
    예제 출력 1
        3

    예제 입력 2
        5 4
    예제 출력 2
        2

    예제 입력 3
        1 7
    예제 출력 3
        0


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 14240KB
// 시간 : 128ms
// 코드 길이 : 763B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(token.nextToken()); // 햄버거 빵의 개수 A (1 ≤ A ≤ 100)
        int B = Integer.parseInt(token.nextToken()); // 햄버거 패티의 개수 B (1 ≤ B ≤ 100)

        int hamburgerNum = 0;
        while (A >= 2 && B >= 1) {
            A -= 2;
            B -= 1;
            hamburgerNum += 1;
        }

        System.out.println(hamburgerNum);
    }
}
