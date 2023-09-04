/*
12789. Silver 3 - 도키도키 간식드리미

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    1 초         128 MB           9293       3427       2810           37.189%


    문제
        인하대학교 학생회에서는 중간, 기말고사 때마다 시험 공부에 지친 학우들을 위해 간식을 나눠주는 간식 드리미 행사를 실시한다. 승환이는 시험 기간이 될 때마다 간식을 받을 생각에 두근두근 설레서 시험 공부에 집중을 못 한다. 이번 중간고사에서도 역시 승환이는 설레는 가슴을 안고 간식을 받기 위해 미리 공지된 장소에 시간 맞춰 도착했다. 그런데 이게 무슨 날벼락인가! 그 곳에는 이미 모든 학생들이 모여있었고, 승환이는 마지막 번호표를 받게 되었다. 설상가상으로 몇몇 양심에 털이 난 학생들이 새치기를 거듭한 끝에 대기열의 순서마저 엉망이 되고 말았다. 간식을 나눠주고 있던 인규는 학우들의 터져 나오는 불만에 번호표 순서로만 간식을 줄 수 있다고 말했다.
        그제야 학생들이 순서대로 줄을 서려고 했지만 공간이 너무 협소해서 마음대로 이동할 수 없었다. 다행히도 대기열의 왼쪽에는 1열로 설 수 있는 공간이 존재하여 이 공간을 잘 이용하면 모두가 순서대로 간식을 받을 수 있을지도 모른다. 자칫 간식을 못 받게 될지도 모른다는 위기감을 느낀 승환이는 자신의 컴퓨터 알고리즘적 지식을 활용해 과연 모든 사람들이 순서대로 간식을 받을 수 있는지 확인하는 프로그램을 만들기로 했다. 만약 불가능 하다면 승환이는 이번 중간고사를 망치게 될 것 이고 가능하다면 힘을 얻어 중간고사를 잘 볼 수 있을지도 모른다.
        사람들은 현재 1열로 줄을 서있고, 맨 앞의 사람만 이동이 가능하다. 인규는 번호표 순서대로만 통과할 수 있는 라인을 만들어 두었다. 이 라인과 대기열의 맨 앞 사람 사이에는 한 사람씩 1열이 들어갈 수 있는 공간이 있다. 현재 대기열의 사람들은 이 공간으로 올 수 있지만 반대는 불가능하다. 승환이를 도와 프로그램을 완성하라.
        현재 간식 배부 공간을 그림으로 나타내면 다음과 같다.
            □□1□□□□□□32     □□2□□□□□□□□     345□□□□□□□□
                □               □               □
                □               3               □
                4               4               □
                5               5               □

        위 예제는 다음 그림과 같이 움직였을 때 모두가 순서대로 간식을 받을 수 있다..


    입력
        입력의 첫째 줄에는 현재 승환이의 앞에 서 있는 학생들의 수 N(1 ≤ N ≤ 1,000,자연수)이 주어진다.
        다음 줄에는 승환이 앞에 서있는 모든 학생들의 번호표(1,2,...,N) 순서가 앞에서부터 뒤 순서로 주어진다.


    출력
        승환이가 무사히 간식을 받을 수 있으면 "Nice"(따옴표는 제외)를 출력하고 그렇지 않다면 "Sad"(따옴표는 제외)를 출력한다.


    예제 입력 1
        5
        5 4 1 3 2
    예제 출력 1
        Nice


    알고리즘 분류
        자료 구조
        스택
*/


// 코드 길이 : 2390B
// 대기 공간에 서 있는 학생들의 간식 받는 순서를 순서마다 고려해 주지 못했다.
// 오답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> waitStack; // 대기 공간에 서 있는 학생의 번호표를 저장하는 스택
    static int checkSafeNum; // 대기 공간으로 가지 않고 줄 서 있는 곳에서 한 번에 간식 받는 곳으로 이동하여 간식을 받을 수 있는지 검사할 번호

    public static void canGet() { // 승환이가 무사히 간식을 받을 수 있는지 검사하는 함수
        while (!waitStack.isEmpty()) { // 대기 공간이 비어 있지 않을 동안
            if (checkSafeNum != waitStack.pop()) { // 다음 간식 받을 순서(검사 완료한 간식 받을 순서의 다음 순서)가 간식 받는 곳으로 오지 않을 경우
                System.out.println("Sad"); // 승환이는 무사히 간식을 받을 수 없다.
                return;
            }

            checkSafeNum += 1; // 다음 간식 받을 순서를 검사하도록 순서 값 증가
        }

        System.out.println("Nice"); // 승환이는 무사히 간식을 받을 수 있다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 승환이의 앞에 서 있는 학생들의 수

        StringTokenizer token = new StringTokenizer(bf.readLine());
        waitStack = new Stack<>();
        checkSafeNum = 1;
        for (int n = 0; n < N; n++) { // 승환이의 앞에 서 있는 학생들을 모두 검사
            int studentNum = Integer.parseInt(token.nextToken()); // 승환이의 앞에 서 있는 학생들 중 n 번째 순서에 서 있는 학생의 번호표

            if (studentNum == checkSafeNum) { // 학생의 번호표에 적힌 순서와 다음에 간식을 받아야 할 순서가 같을 경우
                checkSafeNum += 1; // 다음 간식 받을 순서를 검사하도록 순서 값 증가
            }
            else { // 학생의 번호표에 적힌 순서와 다음에 간식을 받아야 할 순서가 같지 않을 경우
                waitStack.push(studentNum); // 해당 학생의 번호표를 대기 공간 스택에 추가
            }
        }

        canGet();
    }
}
