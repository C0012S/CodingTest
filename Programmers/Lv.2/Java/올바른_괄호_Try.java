/*
Lv. 2 #12909 - 올바른 괄호

    문제 설명
        괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
            · "()()" 또는 "(())()" 는 올바른 괄호입니다.
            · ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.

        '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.


    제한사항
        · 문자열 s의 길이 : 100,000 이하의 자연수
        · 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.


    입출력 예
        s	        answer
        "()()"	    true
        "(())()"	true
        ")()("	    false
        "(()("	    false


    입출력 예 설명
        입출력 예 #1,2,3,4
        문제의 예시와 같습니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.25ms, 71.9MB)
        테스트 2 〉	통과 (0.22ms, 73.9MB)
        테스트 3 〉	통과 (0.14ms, 79.9MB)
        테스트 4 〉	통과 (0.19ms, 77.3MB)
        테스트 5 〉	실패 (0.23ms, 74.5MB)
        테스트 6 〉	통과 (0.10ms, 78.8MB)
        테스트 7 〉	통과 (0.21ms, 74.3MB)
        테스트 8 〉	통과 (0.19ms, 73MB)
        테스트 9 〉	통과 (0.24ms, 74.8MB)
        테스트 10 〉	통과 (0.21ms, 75.2MB)
        테스트 11 〉	실패 (0.21ms, 72.2MB)
        테스트 12 〉	통과 (0.57ms, 72.1MB)
        테스트 13 〉	통과 (1.04ms, 78.5MB)
        테스트 14 〉	통과 (0.91ms, 67.1MB)
        테스트 15 〉	통과 (1.12ms, 76.9MB)
        테스트 16 〉	통과 (0.30ms, 72.4MB)
        테스트 17 〉	실패 (0.52ms, 76MB)
        테스트 18 〉	통과 (1.32ms, 75.5MB)

    효율성  테스트
        테스트 1 〉	실패 (시간 초과)
        테스트 2 〉	실패 (시간 초과)

    채점 결과
        정확성: 57.9
        효율성: 0.0
        합계: 57.9 / 100.0
*/


// 오답

package Programmers.Lv2.Java;

import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>(); // 괄호 문자를 저장하는 스택
        boolean answer = false; // 올바른 괄호 여부  // true : 올바른 괄호, false : 올바르지 않은 괄호

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i); // 현재 검사할 괄호 문자

            if (stack.isEmpty()) { // 스택이 비어 있을 경우
                if (bracket == ')') { // 오른쪽 괄호일 경우
                    return answer; // 올바르지 않은 괄호로 판별
                }

                stack.push(bracket); // 오른쪽 괄호가 아닐 경우, 스택에 추가
            }

            // 스택이 비어 있지 않을 경우
            if (bracket == '(') { // 왼쪽 괄호일 경우
                stack.push(bracket); // 스택에 추가
            }
            else if (bracket == ')') { // 오른쪽 괄호일 경우
                int prevLeftBracketNum = 0; // 이전 왼쪽 괄호의 개수
                int rightBracketNum = 1; // 이전부터 현재까지의 오른쪽 괄호의 개수

                while (!stack.isEmpty()) { // 스택이 비어 있지 않을 동안
                    char prevBracket = stack.pop(); // 이전 괄호 문자

                    if (prevBracket == '(') { // 이전 괄호가 왼쪽 괄호일 경우
                        prevLeftBracketNum += 1; // 이전 왼쪽 괄호의 개수 추가
                    }
                    else if (prevBracket == ')') { // 이전 괄호가 오른쪽 괄호일 경우
                        rightBracketNum += 1; // 오른쪽 괄호의 개수 추가
                    }
                }

                if (prevLeftBracketNum < rightBracketNum) { // 이전 왼쪽 괄호의 개수가 오른쪽 괄호의 개수보다 적을 경우
                    return answer; // 올바르지 않은 괄호로 판별
                }

                // 이전 왼쪽 괄호의 개수가 오른쪽 괄호의 개수보다 크거나 같을 경우
                if (i != s.length() - 1) { // 현재 검사할 괄호 문자가 마지막 문자가 아닐 경우
                    for (int l = 0; l < prevLeftBracketNum - rightBracketNum; l++) { // 짝지은 괄호를 제외하고 남은 왼쪽 괄호의 개수만큼
                        stack.push('('); // 스택에 왼쪽 괄호 추가
                    }
                }
            }
        }

        if (stack.isEmpty()) { // 스택이 비어 있을 경우
            answer = true; // 올바른 괄호로 판별
        }

        return answer;
    }
}