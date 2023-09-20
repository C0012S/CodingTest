/*
Lv. 1 #12948 - 핸드폰 번호 가리기

    문제 설명
        프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
        전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.


    제한 조건
        · phone_number는 길이 4 이상, 20이하인 문자열입니다.


    입출력 예
        phone_number	    return
        "01033334444"	    "*******4444"
        "027778888"	        "*****8888"
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (1.97ms, 70.7MB)
        테스트 2 〉	통과 (2.18ms, 76.6MB)
        테스트 3 〉	통과 (2.64ms, 71.6MB)
        테스트 4 〉	통과 (2.27ms, 73.3MB)
        테스트 5 〉	통과 (2.85ms, 75.1MB)
        테스트 6 〉	통과 (3.03ms, 73.7MB)
        테스트 7 〉	통과 (2.24ms, 73MB)
        테스트 8 〉	통과 (2.50ms, 73.1MB)
        테스트 9 〉	통과 (1.53ms, 72.9MB)
        테스트 10 〉	통과 (1.82ms, 75.5MB)
        테스트 11 〉	통과 (2.45ms, 77.8MB)
        테스트 12 〉	통과 (2.31ms, 76.6MB)
        테스트 13 〉	통과 (1.77ms, 75.1MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int phone_number_length = phone_number.length();

        for (int p = 0; p < phone_number_length - 4; p++) {
            answer += "*";
        }

        answer += phone_number.substring(phone_number_length - 4);

        return answer;
    }
}