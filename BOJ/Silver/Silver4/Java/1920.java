/*
1920. Silver 4 - 수 찾기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           306238	    98239     64643	         30.607%


    문제
        N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.


    입력
        첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.


    출력
        M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.


    예제 입력 1
        5
        4 1 5 2 3
        5
        1 3 7 9 5
    예제 출력 1
        1
        1
        0
        0
        1


    알고리즘 분류
        자료 구조
        정렬
        이분 탐색
        해시를 사용한 집합과 맵
*/


// 메모리 : 44768KB
// 시간 : 612ms
// 코드 길이 : 1842B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; // 정수의 개수 (1 ≤ N ≤ 100000)
    static int[] A; // 주어진 숫자들을 저장하는 배열

    public static int find(int searchNumber) { // 이진 탐색을 활용하여 찾으려는 숫자가 배열 A에 존재하는지 찾는 메서드
        int left = 0; // 왼쪽 인덱스
        int right = N - 1; // 오른쪽 인덱스

        while (left <= right) {
            int mid = (left + right) / 2; // 중간 인덱스

            if (A[mid] > searchNumber) { // 중간값이 찾으려는 숫자보다 클 경우
                right = mid - 1;
            }
            else if (A[mid] < searchNumber) { // 중간값이 찾으려는 숫자보다 작을 경우
                left = mid + 1;
            }
            else { // 중간값이 찾으려는 숫자와 같을 경우
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        A = new int[N];
        StringTokenizer token = new StringTokenizer(bf.readLine());
        for (int a = 0; a < N; a++) {
            A[a] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(A); // 오름차순 정렬

        int M = Integer.parseInt(bf.readLine());
        token = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < M; m++) {
            sb.append(find(Integer.parseInt(token.nextToken())));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
