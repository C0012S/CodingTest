/*
6588. Silver 1 - 골드바흐의 추측

    시간 제한     메모리 제한     제출        정답        맞힌 사람      정답 비율
    0.5 초       256 MB        74197      13804      9388          22.757%


    문제
        1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.
            · 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.

        예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.
        이 추측은 아직도 해결되지 않은 문제이다.
        백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.


    입력
        입력은 하나 또는 그 이상의 테스트 케이스로 이루어져 있다. 테스트 케이스의 개수는 100,000개를 넘지 않는다.
        각 테스트 케이스는 짝수 정수 n 하나로 이루어져 있다. (6 ≤ n ≤ 1000000)
        입력의 마지막 줄에는 0이 하나 주어진다.


    출력
        각 테스트 케이스에 대해서, n = a + b 형태로 출력한다. 이때, a와 b는 홀수 소수이다. 숫자와 연산자는 공백 하나로 구분되어져 있다. 만약, n을 만들 수 있는 방법이 여러 가지라면, b-a가 가장 큰 것을 출력한다. 또, 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에는 "Goldbach's conjecture is wrong."을 출력한다.


    예제 입력 1
        8
        20
        42
        0
    예제 출력 1
        8 = 3 + 5
        20 = 3 + 17
        42 = 5 + 37


    알고리즘 분류
        수학
        정수론
        소수 판정
        에라토스테네스의 체
*/


// 코드 길이 : 2734B
// 시간 초과
// 오답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N; // 짝수 정수 n의 범위는 6 ≤ n ≤ 1000000이므로 소수를 구할 때, 1000000을 최대 범위로 지정
    static boolean primeNumber[]; // 소수 판단 배열  // true : 소수 X, false : 소수 O
    static ArrayList<Integer[]> resultList; // 짝수 정수 n을 두 홀수 소수의 합으로 나타낼 수 있는 두 홀수 소수의 배열 리스트

    public static void eratosthenesSieve() { // 에라토스테네스의 체
        for (int p = 2; p <= Math.sqrt(N); p++) {
            for (int r = (int) Math.pow(p, 2); r <= N; r += p) {
                primeNumber[r] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = 1000000;
        primeNumber = new boolean[N + 1];
        primeNumber[0] = true;
        primeNumber[1] = true;
        eratosthenesSieve(); // 에라토스테네스의 체 적용

        while (true) {
            int n = Integer.parseInt(bf.readLine()); // 짝수 정수 n (6 ≤ n ≤ 1000000)

            if (n == 0) {
                break;
            }

            resultList = new ArrayList<>();
            for (int i = 2; i < n; i++) {
                if (!primeNumber[i]) { // 해당 수가 소수라면
                    int a = i; // 해당 수를 a로 지정
                    int b = n - i; // n = a + b

                    if (!primeNumber[b]) { // b도 소수라면
                        resultList.add(new Integer[] {a, b});
                    }
                }
            }

            if (!resultList.isEmpty()) {
                int maxDiff = resultList.get(0)[1] - resultList.get(0)[0]; // b - a의 최댓값
                int maxIndex = 0; // b - a가 가장 큰 resultList 인덱스
                for (int x = 0, size = resultList.size(); x < size; x++) { // n을 만들 수 있는 방법이 여러 가지라면 b - a가 가장 큰 a와 b를 구한다.
                    int diff = resultList.get(x)[1] - resultList.get(x)[0];
                    maxDiff = Math.max(diff, maxDiff);

                    if (diff == maxDiff) {
                        maxIndex = x;
                    }
                }

                System.out.println(n + " = " + resultList.get(maxIndex)[0] + " + " + resultList.get(maxIndex)[1]); // n = a + b
            }
            else { // 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
