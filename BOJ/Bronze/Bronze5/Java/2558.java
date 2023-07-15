/*
2558. Bronze 5 - A+B - 2

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           95606	    68180     61269	         72.785%


    문제
        두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 A, 둘째 줄에 B가 주어진다. (0 < A, B < 10)


    출력
        첫째 줄에 A+B를 출력한다.


    예제 입력 1
        1
        2
    예제 출력 1
        3


    비슷한 문제
        1000번. A+B
        1001번. A-B
        1008번. A/B
        10950번. A+B - 3
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


    채점 및 기타 정보
        이 문제의 채점 우선 순위는 2이다.
*/


// 메모리 : 14268KB
// 시간 : 132ms
// 코드 길이 : 402B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(bf.readLine());
        int B = Integer.parseInt(bf.readLine());

        System.out.println(A + B);
    }
}
