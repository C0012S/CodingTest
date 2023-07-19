/*
10950. Bronze 5 - A+B - 3

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           260199	    151457    126875	     58.378%


    문제
        두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 테스트 케이스의 개수 T가 주어진다.
        각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)


    출력
        각 테스트 케이스마다 A+B를 출력한다.


    예제 입력 1
        5
        1 1
        2 3
        3 4
        9 8
        5 2
    예제 출력 1
        2
        5
        7
        17
        7


    비슷한 문제
        1000번. A+B
        1001번. A-B
        1008번. A/B
        2558번. A+B - 2
        10951번. A+B - 4
        10952번. A+B - 5
        10953번. A+B - 6
        10998번. A×B
        11021번. A+B - 7
        11022번. A+B - 8
        15740번. A+B - 9
        15792번. A/B - 2


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14196KB
// 시간 : 132ms
// 코드 길이 : 676B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수 T

        StringTokenizer token;
        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());

            System.out.println(A + B);
        }
    }
}
