/*
1822. Silver 4 - 차집합

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    256 MB           9990	    4474      3608	         45.810%


    문제
        몇 개의 자연수로 이루어진 두 집합 A와 B가 있다. 집합 A에는 속하면서 집합 B에는 속하지 않는 모든 원소를 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에는 집합 A의 원소의 개수 n(A)와 집합 B의 원소의 개수 n(B)가 빈 칸을 사이에 두고 주어진다. (1 ≤ n(A), n(B) ≤ 500,000)이 주어진다. 둘째 줄에는 집합 A의 원소가, 셋째 줄에는 집합 B의 원소가 빈 칸을 사이에 두고 주어진다. 하나의 집합의 원소는 2,147,483,647 이하의 자연수이며, 하나의 집합에 속하는 모든 원소의 값은 다르다.


    출력
        첫째 줄에 집합 A에는 속하면서 집합 B에는 속하지 않는 원소의 개수를 출력한다. 다음 줄에는 구체적인 원소를 빈 칸을 사이에 두고 증가하는 순서로 출력한다. 집합 A에는 속하면서 집합 B에는 속하지 않는 원소가 없다면 첫째 줄에 0만을 출력하면 된다.


    예제 입력 1
        4 3
        2 5 11 7
        9 7 4
    예제 출력 1
        3
        2 5 11

    예제 입력 2
        3 5
        2 5 4
        1 2 3 4 5
    예제 출력 2
        0


    알고리즘 분류
        자료 구조
        정렬
        해시를 사용한 집합과 맵
        트리를 사용한 집합과 맵
*/


// 메모리 : 172288KB
// 시간 : 1592ms
// 코드 길이 : 1790B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static TreeSet<Integer> A; // 집합 A의 원소를 담는 TreeSet

    public static void compare(int element) { // 집합 A에 속하면서 집합 B에도 속하는 원소를 집합 A의 원소 TreeSet에서 제거하는 메서드
        if (A.contains(element)) {
            A.remove(element);
        }
    }

    public static void print() { // 집합 A에는 속하면서 집합 B에는 속하지 않는 원소의 개수와 구체적인 원소를 출력하는 메서드
        StringBuilder sb = new StringBuilder();

        sb.append(A.size());
        sb.append("\n");

        for (int Aelement : A) {
            sb.append(Aelement);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int ANum = Integer.parseInt(token.nextToken()); // 집합 A의 원소의 개수 n(A) (1 ≤ n(A) ≤ 500,000)
        int BNum = Integer.parseInt(token.nextToken()); // 집합 B의 원소의 개수 n(B) (1 ≤ n(B) ≤ 500,000)

        A = new TreeSet<>();
        token = new StringTokenizer(bf.readLine());
        for (int a = 0; a < ANum; a++) {
            A.add(Integer.parseInt(token.nextToken()));
        }

        token = new StringTokenizer(bf.readLine());
        for (int b = 0; b < BNum; b++) {
            int Belement = Integer.parseInt(token.nextToken()); // 집합 B의 원소
            compare(Belement);
        }

        print();
    }
}
