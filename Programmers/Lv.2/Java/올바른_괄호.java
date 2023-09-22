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
        테스트 1 〉	통과 (0.11ms, 85.1MB)
        테스트 2 〉	통과 (0.15ms, 74.2MB)
        테스트 3 〉	통과 (0.17ms, 80.6MB)
        테스트 4 〉	통과 (0.16ms, 71.3MB)
        테스트 5 〉	통과 (0.14ms, 74.7MB)
        테스트 6 〉	통과 (0.17ms, 72.2MB)
        테스트 7 〉	통과 (0.16ms, 75.4MB)
        테스트 8 〉	통과 (0.13ms, 74.5MB)
        테스트 9 〉	통과 (0.14ms, 74MB)
        테스트 10 〉	통과 (0.11ms, 82.9MB)
        테스트 11 〉	통과 (0.10ms, 72.5MB)
        테스트 12 〉	통과 (0.10ms, 74.1MB)
        테스트 13 〉	통과 (0.10ms, 74.6MB)
        테스트 14 〉	통과 (0.10ms, 74.7MB)
        테스트 15 〉	통과 (0.11ms, 70.7MB)
        테스트 16 〉	통과 (0.19ms, 76.5MB)
        테스트 17 〉	통과 (0.10ms, 74MB)
        테스트 18 〉	통과 (0.16ms, 77.7MB)

    효율성  테스트
        테스트 1 〉	통과 (6.85ms, 52.8MB)
        테스트 2 〉	통과 (11.53ms, 52.9MB)

    채점 결과
        정확성: 69.5
        효율성: 30.5
        합계: 100.0 / 100.0
*/


// 정답

package Programmers.Lv2.Java;

import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>(); // 괄호 문자를 저장하는 스택
        boolean answer = false; // 올바른 괄호 여부  // true : 올바른 괄호, false : 올바르지 않은 괄호

        int bracketCount = 0; // 검사할 괄호의 개수
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i); // 현재 검사할 괄호 문자

            if (bracket == '(') { // 왼쪽 괄호일 경우
                bracketCount += 1; // 괄호의 개수 추가
            }
            else if (bracket == ')') { // 오른쪽 괄호일 경우
                bracketCount -= 1; // 괄호의 개수 감소
            }

            if (bracketCount < 0) { // 괄호의 개수가 0보다 작을 경우
                return answer; // 올바르지 않은 괄호로 판별
            }
        }

        if (bracketCount == 0) { // 검사할 괄호의 개수가 0일 경우
            answer = true; // 올바른 괄호로 판별
        }

        return answer;
    }
}