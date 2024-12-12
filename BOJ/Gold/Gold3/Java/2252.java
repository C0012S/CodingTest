/*
2252. Gold 3 - 줄 세우기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           57990	    34503     22950	         57.428%


    문제
        N명의 학생들을 키 순서대로 줄을 세우려고 한다. 각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다. 그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.
        일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.


    입력
        첫째 줄에 N(1 ≤ N ≤ 32,000), M(1 ≤ M ≤ 100,000)이 주어진다. M은 키를 비교한 횟수이다. 다음 M개의 줄에는 키를 비교한 두 학생의 번호 A, B가 주어진다. 이는 학생 A가 학생 B의 앞에 서야 한다는 의미이다.
        학생들의 번호는 1번부터 N번이다.


    출력
        첫째 줄에 학생들을 앞에서부터 줄을 세운 결과를 출력한다. 답이 여러 가지인 경우에는 아무거나 출력한다.


    예제 입력 1
        3 2
        1 3
        2 3
    예제 출력 1
        1 2 3

    예제 입력 2
        4 2
        4 2
        3 1
    예제 출력 2
        4 2 3 1


    알고리즘 분류
        그래프 이론
        위상 정렬
        방향 비순환 그래프
*/


// 메모리 : 46256KB
// 시간 : 420ms
// 코드 길이 : 2962B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 학생들의 수 (1 ≤ N ≤ 32000)
    static int M; // 키를 비교한 횟수 (1 ≤ M ≤ 100000)
    static ArrayList<Integer>[] student; // 학생들의 키를 비교한 정보를 저장하는 그래프 (index 번호의 학생이 student[index]의 원소인 학생들의 번호보다 앞에 선다.)
    static int[] indegree; // 키를 비교하여 각 학생의 앞에 서야 하는 학생의 수(진입 차수 정보)를 저장하는 배열
    static StringBuilder sb;

    public static void lineUp() { // 학생들의 키를 비교하여 학생들을 앞에서부터 줄을 세운 대로 정렬한 후, 결과를 출력하는 메서드
        Queue<Integer> queue = new ArrayDeque<>(); // 키를 비교하여 줄을 세울 학생들을 저장하는 큐
        for (int n = 1; n <= N; n++) {
            if (indegree[n] == 0) { // 해당 학생의 앞에 서야 하는 학생의 수가 0일 경우
                queue.offer(n);
            }
        }

        sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int nowNode = queue.poll(); // 현재 줄을 세울 학생
            sb.append(nowNode);
            sb.append(" ");

            for (int nextNode : student[nowNode]) { // 현재 학생이 앞에 서야 하는 학생들에 대하여
                indegree[nextNode] -= 1; // 해당 학생의 앞에 서야 하는 학생의 수 감소

                if (indegree[nextNode] == 0) { // 해당 학생의 앞에 서야 하는 학생의 수가 0일 경우
                    queue.offer(nextNode);
                }
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        student = new ArrayList[N + 1];
        for (int s = 1; s <= N; s++) {
            student[s] = new ArrayList<>();
        }

        indegree = new int[N + 1];
        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(bf.readLine());

            int A = Integer.parseInt(token.nextToken()); // 키를 비교한 학생들 중 앞에 서야 하는 학생의 번호 A
            int B = Integer.parseInt(token.nextToken()); // 키를 비교한 학생들 중 뒤에 서야 하는 학생의 번호 B

            student[A].add(B); // 학생 A가 앞에 서야 하는 학생들의 번호 리스트에 번호 B 추가
            indegree[B] += 1; // 학생 B의 앞에 서야 하는 학생의 수 증가
        }

        lineUp();
    }
}
