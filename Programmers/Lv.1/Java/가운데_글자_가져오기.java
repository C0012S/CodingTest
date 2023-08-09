/*
Lv. 1 - 가운데 글자 가져오기

    문제 설명
        단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.


    재한사항
        · s는 길이가 1 이상, 100이하인 스트링입니다.


    입출력 예
        s	        return
        "abcde"	    "c"
        "qwer"	    "we"
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.01ms, 74.9MB)
        테스트 2 〉	통과 (0.02ms, 75.6MB)
        테스트 3 〉	통과 (0.02ms, 73.3MB)
        테스트 4 〉	통과 (0.02ms, 74.3MB)
        테스트 5 〉	통과 (0.02ms, 74.4MB)
        테스트 6 〉	통과 (0.01ms, 65.7MB)
        테스트 7 〉	통과 (0.01ms, 73.2MB)
        테스트 8 〉	통과 (0.03ms, 76.3MB)
        테스트 9 〉	통과 (0.02ms, 72.5MB)
        테스트 10 〉	통과 (0.01ms, 72.9MB)
        테스트 11 〉	통과 (0.02ms, 85.4MB)
        테스트 12 〉	통과 (0.02ms, 75.8MB)
        테스트 13 〉	통과 (0.02ms, 70.5MB)
        테스트 14 〉	통과 (0.02ms, 76MB)
        테스트 15 〉	통과 (0.02ms, 78MB)
        테스트 16 〉	통과 (0.02ms, 73.2MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    public String solution(String s) {
        int strLength = s.length(); // 단어 s의 길이
        int mid = strLength / 2; // 단어 s의 가운데 글자의 순서

        if (strLength % 2 == 0) { // 짝수일 경우
            return s.substring(mid - 1, mid + 1);
        }
        else {
            return s.substring(mid, mid + 1);
        }
    }
}
