/*
1406. Silver 2 - 에디터

    시간 제한	                    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    0.3 초 (하단 참고)            512 MB           99987	    27744     18489	        26.523%


    문제
        한 줄로 된 간단한 에디터를 구현하려고 한다. 이 편집기는 영어 소문자만을 기록할 수 있는 편집기로, 최대 600,000글자까지 입력할 수 있다.
        이 편집기에는 '커서'라는 것이 있는데, 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다. 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
        이 편집기가 지원하는 명령어는 다음과 같다.
            L	    커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
            D	    커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
            B	    커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                    삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
            P $	    $라는 문자를 커서 왼쪽에 추가함

        초기에 편집기에 입력되어 있는 문자열이 주어지고, 그 이후 입력한 명령어가 차례로 주어졌을 때, 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성하시오. 단, 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.


    입력
        첫째 줄에는 초기에 편집기에 입력되어 있는 문자열이 주어진다. 이 문자열은 길이가 N이고, 영어 소문자로만 이루어져 있으며, 길이는 100,000을 넘지 않는다. 둘째 줄에는 입력할 명령어의 개수를 나타내는 정수 M(1 ≤ M ≤ 500,000)이 주어진다. 셋째 줄부터 M개의 줄에 걸쳐 입력할 명령어가 순서대로 주어진다. 명령어는 위의 네 가지 중 하나의 형태로만 주어진다.


    출력
        첫째 줄에 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 출력한다.


    예제 입력 1
        abcd
        3
        P x
        L
        P y
    예제 출력 1
        abcdyx

    예제 입력 2
        abc
        9
        L
        L
        L
        L
        L
        P x
        L
        B
        P y
    예제 출력 2
        yxabc

    예제 입력 3
        dmih
        11
        B
        B
        P x
        L
        B
        B
        B
        P y
        D
        D
        P z
    예제 출력 3
        yxz


    알고리즘 분류
        자료 구조
        스택
        연결 리스트


    시간 제한
        Java 8: 2 초
        Java 8 (OpenJDK): 2 초
        Kotlin (JVM): 2 초
        C# 6.0 (Mono): 2 초
        C# 3.0 (Mono): 2 초
        VB.NET 2.0 (Mono): 2 초
        VB.NET 4.0 (Mono): 2 초
*/


// 메모리 : 129744KB
// 시간 : 692ms
// 코드 길이 : 2448B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sentence = bf.readLine();
        int N = sentence.length(); // 초기에 편집기에 입력되어 있는 문자열의 길이

        Stack<String> leftStack = new Stack<>(); // 커서를 기준으로 왼쪽 스택과 오른쪽 스택 구분
        Stack<String> rightStack = new Stack<>();
        for (int s = 0; s < N; s++) {
            leftStack.push(sentence.substring(s, s + 1));
        }

        int M = Integer.parseInt(bf.readLine()); // 입력할 명령어의 개수
        StringTokenizer token;
        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(bf.readLine());
            String command = token.nextToken(); // 명령어

            switch (command) {
                case "L": // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D": // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B": // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)  // 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case "P": // 명령어 뒤의 문자를 커서 왼쪽에 추가함
                    leftStack.push(token.nextToken());
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}
