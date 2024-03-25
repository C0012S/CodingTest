/*
Lv. 1 #12906 - 같은 숫자는 싫어

    문제 설명
        배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
            · arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
            · arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.

        배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.


    제한사항
        · 배열 arr의 크기 : 1,000,000 이하의 자연수
        · 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수


    입출력 예
        arr	                answer
        [1,1,3,3,0,1,1]	    [1,3,0,1]
        [4,4,4,3,3]	        [4,3]


    입출력 예 설명
        입출력 예 #1,2
        문제의 예시와 같습니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.06ms, 33.6MB)
        테스트 2 〉	통과 (0.13ms, 33.6MB)
        테스트 3 〉	통과 (0.19ms, 33.5MB)
        테스트 4 〉	통과 (0.18ms, 33.7MB)
        테스트 5 〉	통과 (0.19ms, 33.6MB)
        테스트 6 〉	통과 (0.20ms, 33.6MB)
        테스트 7 〉	통과 (0.14ms, 33.6MB)
        테스트 8 〉	통과 (0.18ms, 33.5MB)
        테스트 9 〉	통과 (0.13ms, 33.6MB)
        테스트 10 〉	통과 (0.13ms, 33.6MB)
        테스트 11 〉	통과 (0.19ms, 33.6MB)
        테스트 12 〉	통과 (0.13ms, 33.4MB)
        테스트 13 〉	통과 (0.13ms, 33.6MB)
        테스트 14 〉	통과 (0.13ms, 33.6MB)
        테스트 15 〉	통과 (0.13ms, 33.4MB)
        테스트 16 〉	통과 (0.16ms, 33.7MB)
        테스트 17 〉	통과 (0.06ms, 33.6MB)

    효율성  테스트
        테스트 1 〉	통과 (60.85ms, 82.9MB)
        테스트 2 〉	통과 (92.14ms, 82.9MB)
        테스트 3 〉	실패 (시간 초과)
        테스트 4 〉	통과 (65.17ms, 83.2MB)

    채점 결과
        정확성: 71.9
        효율성: 21.1
        합계: 93.0 / 100.0
*/


// 오답
// 시간 초과

function solution(arr)
{
    var answer = [];
    for (let i = 0, len = arr.length; i < len; i++) {
        if ((answer.length === 0) || (answer.at(-1) !== arr[i])) {
            answer.push(arr[i]);
        }
    }

    return answer;
}