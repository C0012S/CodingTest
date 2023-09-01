/*
5532. Bronze 4 - 방학 숙제

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           17104	    10760     9655	         63.847%


    문제
        상근이는 초등학교에 다닐 때, 방학 숙제를 남들보다 먼저 미리 하고 남은 기간을 놀았다. 방학 숙제는 수학과 국어 문제 풀기이다.
        방학은 총 L일이다. 수학은 총 B페이지, 국어는 총 A페이지를 풀어야 한다. 상근이는 하루에 국어를 최대 C페이지, 수학을 최대 D페이지 풀 수 있다.
        상근이가 겨울 방학동안 숙제를 하지 않고 놀 수 있는 최대 날의 수를 구하는 프로그램을 작성하시오.


    입력
        한 줄에 하나씩 총 다섯 줄에 걸쳐 L, A, B, C, D가 주어진다. (2 ≤ L ≤ 40, 1 ≤ A, B ≤ 1000, 1 ≤ C, D ≤ 100)
        항상 방학 숙제를 방학 기간내에 다 할 수 있는 경우만 입력으로 주어진다.


    출력
        첫째 줄에 상근이가 놀 수 있는 날의 최댓값을 출력한다.


    예제 입력 1
        20
        25
        30
        6
        8
    예제 출력 1
        15

    예제 입력 2
        15
        32
        48
        4
        6
    예제 출력 2
        7


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 14064KB
// 시간 : 124ms
// 코드 길이 : 1399B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(bf.readLine()); // 방학 기간 (2 ≤ L ≤ 40)
        int A = Integer.parseInt(bf.readLine()); // 국어 총 페이지 수 (1 ≤ A ≤ 1000)
        int B = Integer.parseInt(bf.readLine()); // 수학 총 페이지 수 (1 ≤ B ≤ 1000)
        int C = Integer.parseInt(bf.readLine()); // 상근이가 하루에 풀 수 있는 국어 총 페이지 수 (1 ≤ C ≤ 100)
        int D = Integer.parseInt(bf.readLine()); // 상근이가 하루에 풀 수 있는 수학 총 페이지 수 (1 ≤ D ≤ 100)

        int koreanDay; // 상근이가 최대한 빨리 국어를 풀 수 있는 날의 수
        int mathDay; // 상근이가 최대한 빨리 수학을 풀 수 있는 날의 수
        if (A % C == 0) {
            koreanDay = A / C;
        }
        else {
            koreanDay = A / C + 1;
        }

        if (B % D == 0) {
            mathDay = B / D;
        }
        else {
            mathDay = B / D + 1;
        }

        System.out.println(L - Math.max(koreanDay, mathDay)); // 상근이가 겨울 방학동안 숙제를 하지 않고 놀 수 있는 최대 날의 수
    }
}
