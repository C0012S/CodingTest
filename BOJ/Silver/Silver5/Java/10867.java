/*
10867. Silver 5 - 중복 빼고 정렬하기

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    1 초         256 MB           17948      10279      8717           57.360%


    문제
        N개의 정수가 주어진다. 이때, N개의 정수를 오름차순으로 정렬하는 프로그램을 작성하시오. 같은 정수는 한 번만 출력한다.


    입력
        첫째 줄에 수의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다.


    출력
        첫째 줄에 수를 오름차순으로 정렬한 결과를 출력한다. 이때, 같은 수는 한 번만 출력한다.


    예제 입력 1
        10
        1 4 2 3 1 4 2 3 1 2
    예제 출력 1
        1 2 3 4


    알고리즘 분류
        정렬
*/


// 메모리 : 25836KB
// 시간 : 444ms
// 코드 길이 : 855B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 수의 개수 N (1 ≤ N ≤ 100,000)

        StringTokenizer token = new StringTokenizer(bf.readLine());
        Set<Integer> set = new HashSet<>(); // Set은 중복을 허용하지 않는다.
        for (int n = 0; n < N; n++) {
            set.add(Integer.parseInt(token.nextToken()));
        }

        ArrayList<Integer> arrayList = new ArrayList<>(set);
        Collections.sort(arrayList); // 오름차순 정렬

        for (Integer num : arrayList) {
            System.out.print(num + " ");
        }
    }
}
