/*
Lv. 2 #12914 - 멀리 뛰기

    문제 설명
        효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
            (1칸, 1칸, 1칸, 1칸)
            (1칸, 2칸, 1칸)
            (1칸, 1칸, 2칸)
            (2칸, 1칸, 1칸)
            (2칸, 2칸)

        의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.


    제한 사항
        · n은 1 이상, 2000 이하인 정수입니다.


    입출력 예
        n	result
        4	5
        3	3


    입출력 예 설명
        입출력 예 #1
            위에서 설명한 내용과 같습니다.

        입출력 예 #2
            (2칸, 1칸)
            (1칸, 2칸)
            (1칸, 1칸, 1칸)

            총 3가지 방법으로 멀리 뛸 수 있습니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.09ms, 74MB)
        테스트 2 〉	통과 (0.07ms, 69.1MB)
        테스트 3 〉	통과 (0.05ms, 76.4MB)
        테스트 4 〉	통과 (0.05ms, 84.4MB)
        테스트 5 〉	통과 (0.05ms, 77.2MB)
        테스트 6 〉	통과 (0.05ms, 88.1MB)
        테스트 7 〉	통과 (0.12ms, 78.3MB)
        테스트 8 〉	통과 (0.11ms, 81.8MB)
        테스트 9 〉	통과 (0.12ms, 70.8MB)
        테스트 10 〉	통과 (0.10ms, 93.1MB)
        테스트 11 〉	통과 (0.40ms, 85.9MB)
        테스트 12 〉	통과 (0.31ms, 83.9MB)
        테스트 13 〉	통과 (0.28ms, 89.7MB)
        테스트 14 〉	통과 (0.38ms, 89.1MB)
        테스트 15 〉	통과 (0.31ms, 84.4MB)
        테스트 16 〉	통과 (0.29ms, 81.3MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    static long[] space; // 각 인덱스의 칸까지 도달하는 방법의 가짓수를 저장하는 배열

    public static long find(int index) { // 효진이가 멀리 뛰기로 맨 끝 칸에 도달하는 방법의 가짓수를 구하는 메서드
        if (space[index] != 0) { // 이미 해당 칸까지 도달하는 방법의 가짓수를 구했을 경우
            return space[index];
        }

        return space[index] = (find(index - 2) + find(index - 1)) % 1234567; // index 칸까지 도달하는 방법의 가짓수 = (index - 2) 칸에서 2 칸을 뛰는 방법의 가짓수 + (index - 1) 칸에서 1 칸을 뛰는 방법의 가짓수
    }

    public long solution(int n) {
        space = new long[n + 1];

        if (n >= 1) {
            space[1] = 1;
        }

        if (n >= 2) {
            space[2] = 2;
        }

        return find(n);
    }
}
