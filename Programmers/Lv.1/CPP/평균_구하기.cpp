/*
Lv. 1 #12944 - 평균 구하기

    문제 설명
        정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.


    제한사항
        · arr은 길이 1 이상, 100 이하인 배열입니다.
        · arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.


    입출력 예
        arr	            return
        [1,2,3,4]	    2.5
        [5,5]	        5
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.01ms, 3.74MB)
        테스트 2 〉	통과 (0.01ms, 4.2MB)
        테스트 3 〉	통과 (0.01ms, 4.17MB)
        테스트 4 〉	통과 (0.01ms, 4.24MB)
        테스트 5 〉	통과 (0.01ms, 4.27MB)
        테스트 6 〉	통과 (0.01ms, 4.2MB)
        테스트 7 〉	통과 (0.01ms, 3.67MB)
        테스트 8 〉	통과 (0.01ms, 4.13MB)
        테스트 9 〉	통과 (0.01ms, 3.82MB)
        테스트 10 〉	통과 (0.01ms, 3.65MB)
        테스트 11 〉	통과 (0.01ms, 4.15MB)
        테스트 12 〉	통과 (0.01ms, 4.13MB)
        테스트 13 〉	통과 (0.01ms, 4.15MB)
        테스트 14 〉	통과 (0.01ms, 3.87MB)
        테스트 15 〉	통과 (0.01ms, 3.77MB)
        테스트 16 〉	통과 (0.01ms, 4.2MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

#include <vector>

using namespace std;

double solution(vector<int> arr) {
    double num = arr.size();
    double sum = 0;
    for (int a = 0; a < num; a++) {
        sum += arr[a];
    }

    double average = sum / num;

    return average;
}