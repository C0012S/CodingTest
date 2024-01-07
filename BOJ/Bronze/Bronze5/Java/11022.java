/*
11022. Bronze 5 - A+B - 8

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           187306	    127089    112844	     68.540%


    문제
        두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 테스트 케이스의 개수 T가 주어진다.
        각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)


    출력
        각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.


    예제 입력 1
        5
        1 1
        2 3
        3 4
        9 8
        5 2
    예제 출력 1
        Case #1: 1 + 1 = 2
        Case #2: 2 + 3 = 5
        Case #3: 3 + 4 = 7
        Case #4: 9 + 8 = 17
        Case #5: 5 + 2 = 7


    비슷한 문제
        1000번. A+B
        1001번. A-B
        1008번. A/B
        2558번. A+B - 2
        10950번. A+B - 3
        10951번. A+B - 4
        10952번. A+B - 5
        10953번. A+B - 6
        10998번. A×B
        11021번. A+B - 7
        15740번. A+B - 9
        15792번. A/B - 2


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14144KB
// 시간 : 124ms
// 코드 길이 : 1049B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    public static void calculate(int index, int a, int b) {
        sb.append("Case ");
        sb.append("#");
        sb.append(index);
        sb.append(": ");
        sb.append(a);
        sb.append(" + ");
        sb.append(b);
        sb.append(" = ");
        sb.append(a + b);
        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        StringTokenizer token;
        sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            token = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());

            calculate(t, A, B);
        }

        System.out.println(sb);
    }
}
