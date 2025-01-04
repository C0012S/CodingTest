/*
17140. Gold 4 - 이차원 배열과 연산

    시간 제한	                    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    0.5 초 (추가 시간 없음)	    512 MB           23722	    11292     7546	         44.728%


    문제
        크기가 3×3인 배열 A가 있다. 배열의 인덱스는 1부터 시작한다. 1초가 지날때마다 배열에 연산이 적용된다.
            · R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
            · C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.

        한 행 또는 열에 있는 수를 정렬하려면, 각각의 수가 몇 번 나왔는지 알아야 한다. 그 다음, 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬한다. 그 다음에는 배열 A에 정렬된 결과를 다시 넣어야 한다. 정렬된 결과를 배열에 넣을 때는, 수와 등장 횟수를 모두 넣으며, 순서는 수가 먼저이다.
            예를 들어, [3, 1, 1]에는 3이 1번, 1가 2번 등장한다. 따라서, 정렬된 결과는 [3, 1, 1, 2]가 된다. 다시 이 배열에는 3이 1번, 1이 2번, 2가 1번 등장한다. 다시 정렬하면 [2, 1, 3, 1, 1, 2]가 된다.

        정렬된 결과를 배열에 다시 넣으면 행 또는 열의 크기가 달라질 수 있다. R 연산이 적용된 경우에는 가장 큰 행을 기준으로 모든 행의 크기가 변하고, C 연산이 적용된 경우에는 가장 큰 열을 기준으로 모든 열의 크기가 변한다. 행 또는 열의 크기가 커진 곳에는 0이 채워진다. 수를 정렬할 때 0은 무시해야 한다. 예를 들어, [3, 2, 0, 0]을 정렬한 결과는 [3, 2]를 정렬한 결과와 같다.
        행 또는 열의 크기가 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다.
        배열 A에 들어있는 수와 r, c, k가 주어졌을 때, A[r][c]에 들어있는 값이 k가 되기 위한 최소 시간을 구해보자.


    입력
        첫째 줄에 r, c, k가 주어진다. (1 ≤ r, c, k ≤ 100)
        둘째 줄부터 3개의 줄에 배열 A에 들어있는 수가 주어진다. 배열 A에 들어있는 수는 100보다 작거나 같은 자연수이다.


    출력
        A[r][c]에 들어있는 값이 k가 되기 위한 연산의 최소 시간을 출력한다. 100초가 지나도 A[r][c] = k가 되지 않으면 -1을 출력한다.


    예제 입력 1
        1 2 2
        1 2 1
        2 1 3
        3 3 3
    예제 출력 1
        0

    예제 입력 2
        1 2 1
        1 2 1
        2 1 3
        3 3 3
    예제 출력 2
        1

    예제 입력 3
        1 2 3
        1 2 1
        2 1 3
        3 3 3
    예제 출력 3
        2

    예제 입력 4
        1 2 4
        1 2 1
        2 1 3
        3 3 3
    예제 출력 4
        52

    예제 입력 5
        1 2 5
        1 2 1
        2 1 3
        3 3 3
    예제 출력 5
        -1

    예제 입력 6
        3 3 3
        1 1 1
        1 1 1
        1 1 1
    예제 출력 6
        2


    힌트
        배열 A의 초기값이 아래와 같은 경우를 생각해보자.
            1 2 1
            2 1 3
            3 3 3

        가장 처음에는 행의 개수 ≥ 열의 개수 이기 때문에, R 연산이 적용된다. 편의상 정렬 중간 단계는 (수, 수의 등장 횟수)로 표현한다.
            1 2 1 → (2, 1), (1, 2)         → 2 1 1 2
            2 1 3 → (1, 1), (2, 1), (3, 1) → 1 1 2 1 3 1
            3 3 3 → (3, 3)                 → 3 3

        크기가 가장 큰 행은 2번 행이고, 나머지 행의 뒤에 0을 붙여야 한다.
            2 1 1 2 0 0
            1 1 2 1 3 1
            3 3 0 0 0 0

        다음에 적용되는 연산은 행의 개수 < 열의 개수이기 때문에 C 연산이다.
                1 3 1 1 3 1
                1 1 1 1 1 1
                2 1 2 2 0 0
                1 2 1 1 0 0
                3 0 0 0 0 0
                1 0 0 0 0 0
            연산이 적용된 결과는 위와 같다.


    알고리즘 분류
        구현
        정렬
        시뮬레이션
*/


// 메모리 : 17748KB
// 시간 : 188ms
// 코드 길이 : 6520B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R; // 배열 A의 값을 구해야 하는 행
    static int C; // 배열 A의 값을 구해야 하는 열
    static int K; // 배열 A[R][C]의 값이 되기 위한 값
    static int[][] A; // 배열 A의 정보를 저장하는 배열
    static int row; // 행의 크기
    static int column; // 열의 크기

    static class Number { // 등장한 숫자의 정보를 저장하는 클래스
        int number; // 등장한 숫자
        int count; // 등장한 숫자의 등장 횟수

        public Number(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    public static void operationR() { // R 연산을 수행하는 메서드
        int nowColumn = 0; // R 연산 수행 후 배열의 최대 열의 크기

        for (int r = 0; r < row; r++) {
            HashMap<Integer, Integer> numberMap = new HashMap<>(); // 각 숫자의 등장 횟수를 저장하는 HashMap
            ArrayList<Number> numberList = new ArrayList<>(); // 등장한 숫자의 정렬을 수행하기 위해 사용할 리스트

            for (int c = 0; c < column; c++) {
                if (A[r][c] != 0) { // 배열의 값이 0이 아닐 경우
                    numberMap.put(A[r][c], numberMap.getOrDefault(A[r][c], 0) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : numberMap.entrySet()) {
                numberList.add(new Number(entry.getKey(), entry.getValue()));
            }

            numberList.sort((o1, o2) -> { // 숫자의 등장 횟수를 기준으로 오름차순 정렬, 등장 횟수가 같을 경우 등장한 숫자의 값을 기준으로 오름차순 정렬
                if (o1.count == o2.count) { // 숫자의 등장 횟수가 같을 경우
                    return o1.number - o2.number;
                }
                else { // 숫자의 등장 횟수가 다를 경우
                    return o1.count - o2.count;
                }
            });

            // 정렬된 결과 배열에 삽입
            for (int l = 0, size = numberList.size(); l < size; l++) {
                if (l >= 50) { // 열의 크기가 100을 넘어가는 경우, 처음 100 개를 제외한 나머지는 버린다.
                    break;
                }

                A[r][l * 2] = numberList.get(l).number;
                A[r][l * 2 + 1] = numberList.get(l).count;
            }

            nowColumn = Math.max(nowColumn, numberList.size() * 2); // 연산 후 열의 크기 최댓값 갱신

            for (int z = numberList.size() * 2; z < column; z++) { // 연산 후 열의 크기가 줄어들었을 경우, 연산 후 열의 크기부터 연산 전 열의 크기까지 값을 0으로 변경
                A[r][z] = 0;
            }
        }

        column = nowColumn;
    }

    public static void operationC() { // C 연산을 수행하는 메서드
        int nowRow = 0; // C 연산 수행 후 배열의 최대 열의 크기

        for (int c = 0; c < column; c++) {
            HashMap<Integer, Integer> numberMap = new HashMap<>(); // 각 숫자의 등장 횟수를 저장하는 HashMap
            ArrayList<Number> numberList = new ArrayList<>(); // 등장한 숫자의 정렬을 수행하기 위해 사용할 리스트

            for (int r = 0; r < row; r++) {
                if (A[r][c] != 0) { // 배열의 값이 0이 아닐 경우
                    numberMap.put(A[r][c], numberMap.getOrDefault(A[r][c], 0) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : numberMap.entrySet()) {
                numberList.add(new Number(entry.getKey(), entry.getValue()));
            }

            numberList.sort((o1, o2) -> { // 숫자의 등장 횟수를 기준으로 오름차순 정렬, 등장 횟수가 같을 경우 등장한 숫자의 값을 기준으로 오름차순 정렬
                if (o1.count == o2.count) { // 숫자의 등장 횟수가 같을 경우
                    return o1.number - o2.number;
                }
                else { // 숫자의 등장 횟수가 다를 경우
                    return o1.count - o2.count;
                }
            });

            // 정렬된 결과 배열에 삽입
            for (int l = 0, size = numberList.size(); l < size; l++) {
                if (l >= 50) { // 행의 크기가 100을 넘어가는 경우, 처음 100 개를 제외한 나머지는 버린다.
                    break;
                }

                A[l * 2][c] = numberList.get(l).number;
                A[l * 2 + 1][c] = numberList.get(l).count;
            }

            nowRow = Math.max(nowRow, numberList.size() * 2); // 연산 후 행의 크기 최댓값 갱신

            for (int z = numberList.size() * 2; z < row; z++) { // 연산 후 행의 크기가 줄어들었을 경우, 연산 후 행의 크기부터 연산 전 행의 크기까지 값을 0으로 변경
                A[z][c] = 0;
            }
        }

        row = nowRow;
    }

    public static void operate() { // A[R][C]의 값이 K가 되기 위한 최소 시간을 구하는 메서드
        int time = 0; // A[R][C]의 값이 K가 되기 위한 최소 시간
        row = 3;
        column = 3;

        while (A[R][C] != K) {
            if (time >= 100) { // 시간이 100 초가 지났을 경우
                time = -1;

                break;
            }

            if (row >= column) { // 행의 개수 ≥ 열의 개수
                operationR();
            }
            else { // 열의 개수 < 행의 개수
                operationC();
            }

            time += 1;
        }

        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(token.nextToken()) - 1;
        C = Integer.parseInt(token.nextToken()) - 1;
        K = Integer.parseInt(token.nextToken());

        A = new int[100][100];
        for (int i = 0; i < 3; i++) {
            token = new StringTokenizer(bf.readLine());

            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        operate();
    }
}
