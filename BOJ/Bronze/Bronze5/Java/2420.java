/*
2420. Bronze 5 - 사파리월드

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           57040	    26041     23438	         46.206%


    문제
        사파리월드는 인터넷으로만 존재하는 미스테리한 나라이다. 사파리월드에는 2개의 서브도메인이 seunghwan.royal.gov.sw와 kyuhyun.royal.gov.sw 이 있는데, 이것이 couple.royal.gov.sw으로 합쳐질 것이다. 그러나 도메인 관리 센터 SWNIC(센터장: 김동규)에는 엄격한 룰이 있다. 두 서브도메인을 합칠 때, 유명도의 차이가 너무 차이나지 않을 경우에만 두 서브도메인을 결혼시키는 것이다. 서브도메인의 유명도는 정수이다. 두 서브도메인의 유명도가 주어졌을 때, 그 차이를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 두 도메인의 유명도 N과 M이 주어진다. (-2,000,000,000 ≤ N, M ≤ 2,000,000,000)


    출력
        첫째 줄에 두 유명도의 차이 (|N-M|)을 출력한다.


    예제 입력 1
        -2 5
    예제 출력 1
        7


    알고리즘 분류
        수학
        구현
        사칙연산
*/


// 메모리 : 14264KB
// 시간 : 124ms
// 코드 길이 : 520B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        long N = Long.parseLong(token.nextToken());
        long M = Long.parseLong(token.nextToken());

        System.out.println(Math.abs(N - M));
    }
}
