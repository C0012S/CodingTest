/*
2083. Bronze 4 - 럭비 클럽

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           10182	    5738      5402	         58.155%


    문제
        올 골드 럭비 클럽의 회원들은 성인부 또는 청소년부로 분류된다.
        나이가 17세보다 많거나, 몸무게가 80kg 이상이면 성인부이다. 그 밖에는 모두 청소년부이다. 클럽 회원들을 올바르게 분류하라.


    입력
        각 줄은 이름과 두 자연수로 이루어진다. 두 자연수는 순서대로 나이와 몸무게를 나타낸다. 입력의 마지막 줄은 # 0 0 이다. 이 입력은 처리하지 않는다.
        이름은 알파벳 대/소문자로만 이루어져 있고, 길이는 10을 넘지 않는다.


    출력
        입력 받은 각 회원에 대해 이름과 분류를 출력한다. 성인부 회원이면 'Senior', 청소년부 회원이면 'Junior'를 출력한다.


    예제 입력 1
        Joe 16 34
        Bill 18 65
        Billy 17 65
        Sam 17 85
        # 0 0
    예제 출력 1
        Joe Junior
        Bill Senior
        Billy Junior
        Sam Senior


    알고리즘 분류
        구현
*/


// 메모리 : 14000KB
// 시간 : 120ms
// 코드 길이 : 1142B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String name;
    static int age;
    static int weight;
    static StringBuilder sb;

    public static void classify() {
        sb.append(name);
        sb.append(" ");

        if ((age > 17) || (weight >= 80)) {
            sb.append("Senior");
        }
        else {
            sb.append("Junior");
        }

        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token;
        sb = new StringBuilder();
        while (true) {
            token = new StringTokenizer(bf.readLine());
            name = token.nextToken();
            age = Integer.parseInt(token.nextToken());
            weight = Integer.parseInt(token.nextToken());

            if ((name.equals("#")) && (age == 0) && (weight == 0)) {
                break;
            }

            classify();
        }

        System.out.println(sb);
    }
}
