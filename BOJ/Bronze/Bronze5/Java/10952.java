/*
10952. Bronze 5 - A+B - 5

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           248689	    130215    110920	     52.205%


    문제
        두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.


    입력
        입력은 여러 개의 테스트 케이스로 이루어져 있다.
        각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
        입력의 마지막에는 0 두 개가 들어온다.


    출력
        각 테스트 케이스마다 A+B를 출력한다.


    예제 입력 1
        1 1
        2 3
        3 4
        9 8
        5 2
        0 0
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
        10950번. A+B - 3
        10951번. A+B - 4
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


// 메모리 : 14136KB
// 시간 : 128ms
// 코드 길이 : 691B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        while (true) {
            token = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());

            if ((A == 0) && (B == 0)) {
                break;
            }
            else {
                System.out.println(A + B);
            }
        }
    }
}
