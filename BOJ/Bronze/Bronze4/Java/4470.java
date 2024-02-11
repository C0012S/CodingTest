/*
4470. Bronze 4 - 줄번호

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           10583	    6170      5714	         60.211%


    문제
        텍스트에서 줄을 입력받은 뒤, 줄 번호를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 줄의 수 N이 주어진다. 둘째 줄부터 N개의 줄에 각 줄의 내용이 주어진다. 각 줄에 있는 글자의 개수는 50글자를 넘지 않는다.


    출력
        각 문장의 앞에 줄 번호를 추가한 뒤 출력한다. 줄 번호는 1번부터 시작한다. 줄번호를 추가하는 형식은 출력 예제를 참고하면 된다.


    예제 입력 1
        5
        Lionel Cosgrove
        Alice
        Columbus and Tallahassee
        Shaun and Ed
        Fido
    예제 출력 1
        1. Lionel Cosgrove
        2. Alice
        3. Columbus and Tallahassee
        4. Shaun and Ed
        5. Fido


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14140KB
// 시간 : 124ms
// 코드 길이 : 582B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 줄의 수

        StringBuilder sb = new StringBuilder();
        for (int n = 1; n <= N; n++) {
            sb.append(n);
            sb.append(". ");
            sb.append(bf.readLine());
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
