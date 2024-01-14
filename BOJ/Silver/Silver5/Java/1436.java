/*
1436. Silver 5 - 영화감독 숌

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           91768	    52675     42553	         57.094%


    문제
        666은 종말을 나타내는 수라고 한다. 따라서, 많은 블록버스터 영화에서는 666이 들어간 제목을 많이 사용한다. 영화감독 숌은 세상의 종말 이라는 시리즈 영화의 감독이다. 조지 루카스는 스타워즈를 만들 때, 스타워즈 1, 스타워즈 2, 스타워즈 3, 스타워즈 4, 스타워즈 5, 스타워즈 6과 같이 이름을 지었고, 피터 잭슨은 반지의 제왕을 만들 때, 반지의 제왕 1, 반지의 제왕 2, 반지의 제왕 3과 같이 영화 제목을 지었다. 하지만 숌은 자신이 조지 루카스와 피터 잭슨을 뛰어넘는다는 것을 보여주기 위해서 영화 제목을 좀 다르게 만들기로 했다.
        종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수를 말한다. 제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다. 따라서, 숌은 첫 번째 영화의 제목은 "세상의 종말 666", 두 번째 영화의 제목은 "세상의 종말 1666"와 같이 이름을 지을 것이다. 일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 수) 와 같다.
        숌이 만든 N번째 영화의 제목에 들어간 수를 출력하는 프로그램을 작성하시오. 숌은 이 시리즈를 항상 차례대로 만들고, 다른 영화는 만들지 않는다.


    입력
        첫째 줄에 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.


    출력
        첫째 줄에 N번째 영화의 제목에 들어간 수를 출력한다.


    예제 입력 1
        2
    예제 출력 1
        1666

    예제 입력 2
        3
    예제 출력 2
        2666

    예제 입력 3
        6
    예제 출력 3
        5666

    예제 입력 4
        187
    예제 출력 4
        66666

    예제 입력 5
        500
    예제 출력 5
        166699


    알고리즘 분류
        브루트포스 알고리즘
*/


// 메모리 : 149196KB
// 시간 : 556ms
// 코드 길이 : 1290B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 영화감독 숌이 만든 영화의 순서  // 10000보다 작거나 같은 자연수

    public static void title(int num, int titleNum) { // 영화감독 숌이 만든 N 번째 영화의 제목에 들어간 수를 구하는 메서드  // title(영화의 순서, 영화의 제목에 들어간 N 번째로 작은 종말의 수)
        if (num >= N) {
            System.out.println(titleNum);
            return;
        }

        while (true) {
            titleNum += 1;
            String titleNumStr = String.valueOf(titleNum);

            for (int s = 0, len = titleNumStr.length() - 3 + 1; s < len; s++) {
                if (((titleNumStr.charAt(s) - '0') == 6) && ((titleNumStr.charAt(s + 1) - '0') == 6) && ((titleNumStr.charAt(s + 2) - '0') == 6)) { // 6이 연속으로 3 번 들어갈 경우
                    title(num + 1, titleNum);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        title(1, 666);
    }
}
