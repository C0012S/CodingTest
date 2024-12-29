/*
Lv. 2 #12939 - 최댓값과 최솟값

    문제 설명
        문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
        예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.


    제한 조건
        · s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.


    입출력 예
        s	                return
        "1 2 3 4"	        "1 4"
        "-1 -2 -3 -4"	    "-4 -1"
        "-1 -1"	            "-1 -1"
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.15ms, 33.5MB)
        테스트 2 〉	통과 (0.16ms, 33.5MB)
        테스트 3 〉	통과 (0.05ms, 33.6MB)
        테스트 4 〉	통과 (0.20ms, 33.5MB)
        테스트 5 〉	통과 (0.15ms, 33.5MB)
        테스트 6 〉	통과 (0.29ms, 33.5MB)
        테스트 7 〉	통과 (0.05ms, 33.6MB)
        테스트 8 〉	통과 (0.15ms, 33.6MB)
        테스트 9 〉	통과 (0.14ms, 33.5MB)
        테스트 10 〉	통과 (0.15ms, 33.6MB)
        테스트 11 〉	통과 (0.06ms, 33.5MB)
        테스트 12 〉	통과 (0.15ms, 33.6MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

function solution(s) {
    const numArray = s.split(' ').map(Number);

    let minNum = numArray[0]; // 최솟값
    let maxNum = numArray[0]; // 최댓값
    for (let n = 1, size = numArray.length; n < size; n++) {
        minNum = Math.min(minNum, numArray[n]);
        maxNum = Math.max(maxNum, numArray[n]);
    }

    return `${minNum} ${maxNum}`;
}