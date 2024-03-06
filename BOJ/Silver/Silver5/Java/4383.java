/*
4383. Silver 5 - 점프는 즐거워

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           2862	    657       497	         25.579%


    문제
        Jolly jumper라 불리는 수열이 있다. 길이가 1인 수열은 무조건 Jolly jumper이고, 길이가 2이상일 때는 n개의 연속된 두 수의 차의 절댓값이 1부터 n-1까지 모두 나와야 Jolly jumper라고 한다. 예를 들어
            1 4 2 3

        이것은 Jolly jumper인데, 두 수의 차의 절댓값이 각각 3,2,1이기 때문이다. 하여튼 조건을 충족하면 어느 수열이든 Jolly jumper라 할 수 있다. 이제 각 케이스마다 Jolly jumper인지를 판별하자.


    입력
        각 줄의 첫 수로 n이 주어진다.(n < 3000) 그 다음에는 n개의 수가 주어진다.


    출력
        각 줄마다 Jolly 인지 Not jolly 인지 출력한다.


    예제 입력 1
        4 1 4 2 3
        5 1 4 2 -1 6
    예제 출력 1
        Jolly
        Not jolly


    알고리즘 분류
        구현
*/


// 메모리 : 18012KB
// 시간 : 216ms
// 코드 길이 : 1802B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n; // Jolly jumper 수열을 만들 수의 개수 (n < 3000)
    static boolean jollyJumper[]; // Jolly jumper 수열의 수의 등장 여부를 저장하는 배열
    static StringBuilder sb;

    public static void calculate(String inputNumber[]) { // n 개의 연속된 두 수의 차의 절댓값을 구하고 해당 절댓값이 Jolly jumper 수열의 수인지 체크하는 메서드
        n = Integer.parseInt(inputNumber[0]);
        jollyJumper = new boolean[n];
        for (int j = 1; j < n; j++) {
            int nowNum = Integer.parseInt(inputNumber[j]);
            int nextNum = Integer.parseInt(inputNumber[j + 1]);

            int abs = Math.abs(nowNum - nextNum);
            if (abs < n) {
                jollyJumper[abs] = true;
            }
        }
    }

    public static void check() { // Jolly jumper 수열인지 체크하는 메서드
        for (int c = 1; c < n; c++) {
            if (!jollyJumper[c]) {
                sb.append("Not jolly");
                return;
            }
        }

        sb.append("Jolly");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        while (true) {
            String str = bf.readLine();
            if (str == null || str.isEmpty()) {
                break;
            }

            String inputNumber[] = str.split("\\s+");
            if (inputNumber.length == 0) {
                continue;
            }

            calculate(inputNumber);
            check();
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
