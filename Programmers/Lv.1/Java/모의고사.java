/*
Lv. 1 #42840 - [완전탐색] 모의고사

    문제 설명
        수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
            1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
            2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
            3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.


    제한 조건
        · 시험은 최대 10,000 문제로 구성되어있습니다.
        · 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
        · 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.


    입출력 예
        answers	return
        [1,2,3,4,5]	[1]
        [1,3,2,4,2]	[1,2,3]


    입출력 예 설명
        입출력 예 #1
            · 수포자 1은 모든 문제를 맞혔습니다.
            · 수포자 2는 모든 문제를 틀렸습니다.
            · 수포자 3은 모든 문제를 틀렸습니다.

            따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

        입출력 예 #2
            · 모든 사람이 2문제씩을 맞췄습니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (2.86ms, 75.3MB)
        테스트 2 〉	통과 (1.83ms, 78.1MB)
        테스트 3 〉	통과 (2.10ms, 74.3MB)
        테스트 4 〉	통과 (2.74ms, 78.6MB)
        테스트 5 〉	통과 (2.12ms, 77.1MB)
        테스트 6 〉	통과 (2.33ms, 76.2MB)
        테스트 7 〉	통과 (3.15ms, 65.3MB)
        테스트 8 〉	통과 (2.32ms, 73MB)
        테스트 9 〉	통과 (5.44ms, 82MB)
        테스트 10 〉	통과 (2.80ms, 75.4MB)
        테스트 11 〉	통과 (3.61ms, 77.7MB)
        테스트 12 〉	통과 (3.39ms, 74.9MB)
        테스트 13 〉	통과 (2.01ms, 77.6MB)
        테스트 14 〉	통과 (3.83ms, 77.2MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

import java.util.*;

class Solution {
    static int[] people1Pattern = {1, 2, 3, 4, 5}; // 1 번 수포자가 찍는 방식
    static int[] people2Pattern = {2, 1, 2, 3, 2, 4, 2, 5}; // 2 번 수포자가 찍는 방식
    static int[] people3Pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 3 번 수포자가 찍는 방식
    static int[] peopleScore; // 수포자의 점수를 저장하는 배열
    static int maxScore; // 가장 문제를 많이 맞힌 사람의 점수
    static ArrayList<Integer> maxScorePeople; // 가장 많은 문제를 맞힌 사람을 저장하는 리스트

    public static void calculateAnswerNum(int[] answers) { // 가장 문제를 많이 맞힌 사람의 점수를 계산하는 메서드
        for (int a = 0, num = answers.length; a < num; a++) {
            if (answers[a] == people1Pattern[a % 5]) {
                peopleScore[0] += 1;
            }

            if (answers[a] == people2Pattern[a % 8]) {
                peopleScore[1] += 1;
            }

            if (answers[a] == people3Pattern[a % 10]) {
                peopleScore[2] += 1;
            }

            for (int p = 0; p < 3; p++) {
                maxScore = Math.max(maxScore, peopleScore[p]);
            }
        }
    }

    public static int[] findMaxAnswerPeople() { // 가장 많은 문제를 맞힌 사람을 구하는 메서드
        for (int m = 0; m < 3; m++) {
            if (maxScore == peopleScore[m]) {
                maxScorePeople.add(m + 1);
            }
        }

        return maxScorePeople.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution(int[] answers) {
        peopleScore = new int[3];
        calculateAnswerNum(answers);

        maxScorePeople = new ArrayList<>();
        return findMaxAnswerPeople();
    }
}