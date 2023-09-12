/*
Lv. 1 #12919 - 서울에서 김서방 찾기

    문제 설명
        String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.


    제한 사항
        · seoul은 길이 1 이상, 1000 이하인 배열입니다.
        · seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
        · "Kim"은 반드시 seoul 안에 포함되어 있습니다.


    입출력 예
        seoul	            return
        ["Jane", "Kim"]	    "김서방은 1에 있다"
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (6.74ms, 72.4MB)
        테스트 2 〉	통과 (6.10ms, 76.8MB)
        테스트 3 〉	통과 (5.97ms, 73.2MB)
        테스트 4 〉	통과 (7.21ms, 82.5MB)
        테스트 5 〉	통과 (7.15ms, 72.7MB)
        테스트 6 〉	통과 (8.55ms, 76.2MB)
        테스트 7 〉	통과 (7.97ms, 77MB)
        테스트 8 〉	통과 (6.89ms, 74.6MB)
        테스트 9 〉	통과 (8.49ms, 79.1MB)
        테스트 10 〉	통과 (6.30ms, 77.5MB)
        테스트 11 〉	통과 (7.30ms, 75.6MB)
        테스트 12 〉	통과 (10.45ms, 77.2MB)
        테스트 13 〉	통과 (7.06ms, 83.1MB)
        테스트 14 〉	통과 (7.29ms, 74.9MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    public String solution(String[] seoul) {
        for (int x = 0; x < seoul.length; x++) {
            if (seoul[x].equals("Kim")) {
                return "김서방은 " + x + "에 있다";
            }
        }

        return "김서방은 서울에 없다";
    }
}