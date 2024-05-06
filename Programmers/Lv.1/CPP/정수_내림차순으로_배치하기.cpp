/*
Lv. 1 #12933 - 정수 내림차순으로 배치하기

    문제 설명
        함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.


    제한 조건
        · n은 1이상 8000000000 이하인 자연수입니다.


    입출력 예
        n	        return
        118372	    873211
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.01ms, 4.2MB)
        테스트 2 〉	통과 (0.02ms, 3.68MB)
        테스트 3 〉	통과 (0.01ms, 4.14MB)
        테스트 4 〉	통과 (0.01ms, 4.2MB)
        테스트 5 〉	통과 (0.01ms, 4.14MB)
        테스트 6 〉	통과 (0.01ms, 4.13MB)
        테스트 7 〉	통과 (0.02ms, 4.14MB)
        테스트 8 〉	통과 (0.02ms, 4.14MB)
        테스트 9 〉	통과 (0.01ms, 4.14MB)
        테스트 10 〉	통과 (0.02ms, 4.15MB)
        테스트 11 〉	통과 (0.02ms, 4.21MB)
        테스트 12 〉	통과 (0.01ms, 4.13MB)
        테스트 13 〉	통과 (0.01ms, 3.63MB)
        테스트 14 〉	통과 (0.01ms, 4.14MB)
        테스트 15 〉	통과 (0.01ms, 4.15MB)
        테스트 16 〉	통과 (0.02ms, 4.17MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

#include <string>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;

    string str = to_string(n);
    sort(str.begin(), str.end(), greater<char>());

    answer = stoll(str);

    return answer;
}