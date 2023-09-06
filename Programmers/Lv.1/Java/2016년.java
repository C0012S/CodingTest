/*
Lv. 1 #12901 - 2016년

    문제 설명
        2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 'SUN,MON,TUE,WED,THU,FRI,SAT' 입니다.
        예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.


    제한 조건
        · 2016년은 윤년입니다.
        · 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)


    입출력 예
        a	b	result
        5	24	"TUE"
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.02ms, 83.5MB)
        테스트 2 〉	통과 (0.04ms, 76.2MB)
        테스트 3 〉	통과 (0.01ms, 79.5MB)
        테스트 4 〉	통과 (0.02ms, 77.2MB)
        테스트 5 〉	통과 (0.02ms, 75.3MB)
        테스트 6 〉	통과 (0.01ms, 66.5MB)
        테스트 7 〉	통과 (0.01ms, 81.8MB)
        테스트 8 〉	통과 (0.02ms, 75MB)
        테스트 9 〉	통과 (0.02ms, 73.3MB)
        테스트 10 〉	통과 (0.02ms, 77MB)
        테스트 11 〉	통과 (0.02ms, 73.8MB)
        테스트 12 〉	통과 (0.02ms, 71.8MB)
        테스트 13 〉	통과 (0.01ms, 92.6MB)
        테스트 14 〉	통과 (0.02ms, 73.3MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    public String solution(int a, int b) {
        int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // (인덱스 + 1) 월의 날짜를 저장하는 배열

        int monthDay = 0; // 1 월 1 일부터 a 월 b 일까지의 날의 수
        for (int m = 0; m < a - 1; m++) { // 1 월부터 (a - 1) 월까지의 합을 구한다.
            monthDay += month[m];
        }
        monthDay += b; // 1 월부터 (a - 1) 월까지의 합 + b 일

        String day = ""; // a 월 b 일의 요일
        switch (monthDay % 7) {
            case 0:
                day = "THU";
                break;
            case 1:
                day = "FRI";
                break;
            case 2:
                day = "SAT";
                break;
            case 3:
                day = "SUN";
                break;
            case 4:
                day = "MON";
                break;
            case 5:
                day = "TUE";
                break;
            case 6:
                day = "WED";
                break;
        }

        return day;
    }
}
