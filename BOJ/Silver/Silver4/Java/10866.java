/*
10866. Silver 4 - 덱

    시간 제한	                    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    0.5 초 (추가 시간 없음)	    256 MB           69217	    38106     32196	        56.072%


    문제
        정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
        명령은 총 여덟 가지이다.
            · push_front X: 정수 X를 덱의 앞에 넣는다.
            · push_back X: 정수 X를 덱의 뒤에 넣는다.
            · pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            · pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            · size: 덱에 들어있는 정수의 개수를 출력한다.
            · empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
            · front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            · back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.


    입력
        첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.


    출력
        출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.


    예제 입력 1
        15
        push_back 1
        push_front 2
        front
        back
        size
        empty
        pop_front
        pop_back
        pop_front
        size
        empty
        pop_back
        push_front 3
        empty
        front
    예제 출력 1
        2
        1
        2
        0
        2
        1
        -1
        0
        1
        -1
        0
        3

    예제 입력 2
        22
        front
        back
        pop_front
        pop_back
        push_front 1
        front
        pop_back
        push_back 2
        back
        pop_front
        push_front 10
        push_front 333
        front
        back
        pop_back
        pop_back
        push_back 20
        push_back 1234
        front
        back
        pop_back
        pop_back
    예제 출력 2
        -1
        -1
        -1
        -1
        1
        1
        2
        2
        333
        10
        10
        333
        20
        1234
        1234
        20


    알고리즘 분류
        구현
        자료 구조
        덱
*/


// 메모리 : 19892KB
// 시간 : 416ms
// 코드 길이 : 3719B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> queue;

    public static void fromBackToFront() { // 큐의 마지막 원소를 맨 앞으로 보내는 함수
        for (int f = 0; f < queue.size() - 1; f++) { // 큐의 마지막 원소를 제외하고 첫 번째 원소부터 마지막 전의 원소까지 반복
            queue.offer(queue.poll()); // 큐에서 제거한 후 다시 추가
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 명령의 수 N

        queue = new ArrayDeque<>();
        StringTokenizer token;
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(bf.readLine());
            String command = token.nextToken();

            switch (command) {
                case "push_front": // 정수 X를 덱의 앞에 추가
                    queue.offer(Integer.parseInt(token.nextToken()));

                    fromBackToFront();
                    break;
                case "push_back": // 정수 X를 덱의 뒤에 추가
                    queue.offer(Integer.parseInt(token.nextToken()));
                    break;
                case "pop_front": // 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력  // 만약 덱에 들어 있는 정수가 없는 경우에는 -1을 출력
                    if (!queue.isEmpty()) {
                        System.out.println(queue.poll());
                    }
                    else {
                        System.out.println(-1);
                    }
                    break;
                case "pop_back": // 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력  // 만약 덱에 들어 있는 정수가 없는 경우에는 -1을 출력
                    if (!queue.isEmpty()) {
                        fromBackToFront();

                        System.out.println(queue.poll());
                    }
                    else {
                        System.out.println(-1);
                    }
                    break;
                case "size": // 덱에 들어 있는 정수의 개수를 출력
                    System.out.println(queue.size());
                    break;
                case "empty": // 덱이 비어 있으면 1 출력, 아니면 0 출력
                    if (queue.isEmpty()) {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                    break;
                case "front": // 덱의 가장 앞에 있는 정수를 출력  // 만약 덱에 들어 있는 정수가 없는 경우에는 -1을 출력
                    if (!queue.isEmpty()) {
                        System.out.println(queue.peek());
                    }
                    else {
                        System.out.println(-1);
                    }
                    break;
                case "back": // 덱의 가장 뒤에 있는 정수를 출력  // 만약 덱에 들어 있는 정수가 없는 경우에는 -1을 출력
                    if (!queue.isEmpty()) {
                        fromBackToFront();

                        System.out.println(queue.peek());
                        queue.offer(queue.poll());
                    }
                    else {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}
