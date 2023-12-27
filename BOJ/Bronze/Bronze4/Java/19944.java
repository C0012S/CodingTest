/*
19944. Bronze 4 - 뉴비의 기준은 뭘까?

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    512 MB           6964	    4601      4233	         66.788%


    문제
        2020 INPC는 IGRUS 뉴비들을 위해 열리는 대회입니다. 하지만 영수 할아버지나 인용 할아버지와 같이 14학번이지만 마음만은 뉴비인 어르신들 때문에 대회장이 TLE들의 파티가 되자 뉴비의 기준을 정의하기로 하였습니다.
        INPC 운영진들은 고심 끝에 뉴비를 1학년 혹은 2학년인 학생으로 정의 내렸고 뉴비를 정의하는 김에 올드비와 TLE도 정의 내리기로 하였습니다. 올드비는 N학년 이하이면서 뉴비가 아닌 학생으로 정의하기로 하였고 TLE은 뉴비도 아니고 올드비도 아닌 학생으로 정의하였습니다.
        N과 M이 주어졌을 때, M학년이 뉴비인지 올드비인지 TLE인지 구별해 주세요.


    입력
        양의 정수 N과 M이 공백을 사이에 두고 주어집니다.


    출력
        M학년이 뉴비라면 NEWBIE!를, 올드비라면 OLDBIE!를 TLE이라면 TLE!을 출력합니다.


    제한
        3 ≤ N ≤ 1,000
        1 ≤ M ≤ 1,000


    예제 입력 1
        3 1
    예제 출력 1
        NEWBIE!

    예제 입력 2
        3 5
    예제 출력 2
        TLE!

    예제 입력 3
        3 3
    예제 출력 3
        OLDBIE!


    힌트
        TLE은 Time Limit Exceeded의 약자입니다.


    알고리즘 분류
        구현
*/


// 메모리 : 14308KB
// 시간 : 136ms
// 코드 길이 : 781B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void distinguish(int n, int m) {
        if (m < 3) {
            System.out.println("NEWBIE!");
        }
        else if (m <= n) {
            System.out.println("OLDBIE!");
        }
        else {
            System.out.println("TLE!");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        distinguish(N, M);
    }
}
