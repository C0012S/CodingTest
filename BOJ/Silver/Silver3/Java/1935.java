/*
1935. Silver 3 - 후위 표기식2

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    2 초         128 MB           21223      10317      8246           48.384%


    문제
        후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.


    입력
        첫째 줄에 피연산자의 개수(1 ≤ N ≤ 26) 가 주어진다. 그리고 둘째 줄에는 후위 표기식이 주어진다. (여기서 피연산자는 A~Z의 영대문자이며, A부터 순서대로 N개의 영대문자만이 사용되며, 길이는 100을 넘지 않는다) 그리고 셋째 줄부터 N+2번째 줄까지는 각 피연산자에 대응하는 값이 주어진다. 3번째 줄에는 A에 해당하는 값, 4번째 줄에는 B에 해당하는값 , 5번째 줄에는 C ...이 주어진다, 그리고 피연산자에 대응 하는 값은 100보다 작거나 같은 자연수이다.
        후위 표기식을 앞에서부터 계산했을 때, 식의 결과와 중간 결과가 -20억보다 크거나 같고, 20억보다 작거나 같은 입력만 주어진다.


    출력
        계산 결과를 소숫점 둘째 자리까지 출력한다.


    예제 입력 1
        5
        ABC*+DE/-
        1
        2
        3
        4
        5
    예제 출력 1
        6.20

    예제 입력 2
        1
        AA+A+
        1
    예제 출력 2
        3.00


    알고리즘 분류
        자료 구조
        스택
*/


// 메모리 : 14496KB
// 시간 : 144ms
// 코드 길이 : 3014B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static String[] postfixNotation; // 후위 표기식의 피연산자와 연산자를 담는 배열
    static ArrayList<String> operator = new ArrayList<>(Arrays.asList("+", "-", "*", "/")); // 연산자 리스트
    static Stack<String> stack = new Stack<>();

    public static void calculate() { // 후위 표기식 계산 함수
        for (int s = 0; s < postfixNotation.length; s++) {
            String now = postfixNotation[s]; // 현재 검사할 식의 요소

            if (operator.contains(now)) { // 연산자일 경우
                double nextNum = Double.parseDouble(stack.pop()); // 두 번째 피연산자
                double prevNum = Double.parseDouble(stack.pop()); // 첫 번째 피연산자
                double calculatedNum = 0; // 첫 번째 피연산자와 두 번째 피연산자를 연산자로 계산한 값

                if (now.equals(operator.get(0))) { // + 연산자일 경우
                    calculatedNum = prevNum + nextNum;
                    stack.push(String.format("%.2f", calculatedNum)); // %.2f : 소숫점 둘째 자리까지 출력
                }
                else if (now.equals(operator.get(1))) { // - 연산자일 경우
                    calculatedNum = prevNum - nextNum;
                    stack.push(String.format("%.2f", calculatedNum));
                }
                else if (now.equals(operator.get(2))) { // * 연산자일 경우
                    calculatedNum = prevNum * nextNum;
                    stack.push(String.format("%.2f", calculatedNum));
                }
                else if (now.equals(operator.get(3))) { // / 연산자일 경우
                    calculatedNum = prevNum / nextNum;
                    stack.push(String.format("%.2f", calculatedNum));
                }
            }
            else { // 연산자가 아닐 경우(피연산자일 경우)
                stack.push(now);
            }
        }

        System.out.println(stack.pop()); // 후위 표기식의 계산 결과
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 피연산자의 개수 (1 ≤ N ≤ 26)
        postfixNotation = bf.readLine().split("");

        for (int n = 0; n < N; n++) {
            String numString = bf.readLine(); // 각 피연산자에 대응하는 값

            for (int p = 0; p < postfixNotation.length; p++) {
                if (postfixNotation[p].equals(Character.toString('A' + n))) { // 순서에 맞는 피연산자의 값일 경우
                    postfixNotation[p] = numString; // 해당 피연산자의 값으로 변경
                }
            }
        }

        calculate(); // 후위 표기식 계산
    }
}
