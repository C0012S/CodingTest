/*
2606. Silver 3 - 바이러스

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           170235	    79420     53168	         45.962%


    문제
        신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

        예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
            [그림은 문제에서 참고]

        어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.


    출력
        1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.


    예제 입력 1
        7
        6
        1 2
        2 3
        1 5
        5 2
        5 6
        4 7
    예제 출력 1
        4


    알고리즘 분류
        그래프 이론
        그래프 탐색
        너비 우선 탐색
        깊이 우선 탐색
*/


// 메모리 : 14292KB
// 시간 : 128ms
// 코드 길이 : 2200B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> computer[]; // 네트워크 상에서 서로 연결되어 있는 컴퓨터의 정보를 저장하는 그래프
    static boolean isChecked[]; // 해당 인덱스의 컴퓨터 바이러스 검사 여부를 저장하는 배열

    public static void find(int virusComputer) { // 웜 바이러스에 걸리게 되는 컴퓨터의 수를 구하고 출력하는 메서드
        Queue<Integer> queue = new ArrayDeque();

        queue.offer(virusComputer);
        int infectedComputerNum = -1; // 웜 바이러스에 걸리게 되는 컴퓨터의 수
        while (!queue.isEmpty()) {
            int nowComputer = queue.poll();

            if (!isChecked[nowComputer]) {
                infectedComputerNum += 1;
                isChecked[nowComputer] = true;

                for (int connectedComputer : computer[nowComputer]) {
                    queue.offer(connectedComputer);
                }
            }
        }

        System.out.println(infectedComputerNum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 컴퓨터의 수
        int C = Integer.parseInt(bf.readLine()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

        computer = new ArrayList[N + 1];
        for (int a = 1; a <= N; a++) {
            computer[a] = new ArrayList<>();
        }

        StringTokenizer token;
        for (int c = 0; c < C; c++) {
            token = new StringTokenizer(bf.readLine());
            int connectedComputer1 = Integer.parseInt(token.nextToken());
            int connectedComputer2 = Integer.parseInt(token.nextToken());

            computer[connectedComputer1].add(connectedComputer2);
            computer[connectedComputer2].add(connectedComputer1);
        }

        isChecked = new boolean[N + 1];
        find(1);
    }
}
