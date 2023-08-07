/*
1676. Silver 5 - 팩토리얼 0의 개수

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    2 초         128 MB           66249      31672      26388          47.571%


    문제
        N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)


    출력
        첫째 줄에 구한 0의 개수를 출력한다.


    예제 입력 1
        10
    예제 출력 1
        2

    예제 입력 2
        3
    예제 출력 2
        0


    알고리즘 분류
        수학
*/


// 메모리 : 14184KB
// 시간 : 128ms
// 코드 길이 : 1314B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 0 ≤ N ≤ 500
    public static void findZeroNum() { // N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 함수  // 0의 개수는 10의 배수일 경우 나오므로 2 * 5의 구성이 나오는 횟수를 구하면 된다.
        int twoCount = 0; // 2로 나누어지는 숫자의 개수
        int fiveCount = 0; // 5로 나누어지는 숫자의 개수

        for (int n = 1; n <= N; n++) { // 1부터 N까지 검사
            int num = n;

            while (num % 2 == 0) { // 2로 나누어질 경우
                twoCount += 1;
                num /= 2;
            }

            while (num % 5 == 0) { // 5로 나누어질 경우
                fiveCount += 1;
                num /= 5;
            }
        }

        System.out.println(Math.min(twoCount, fiveCount)); // 2와 5의 값을 가지는 쌍의 개수를 구하려면 둘의 개수 중 최솟값을 구하면 된다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        findZeroNum();
    }
}
