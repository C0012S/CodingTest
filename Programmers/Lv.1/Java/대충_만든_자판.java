/*
Lv. 1 #160586 - 대충 만든 자판

    문제 설명
        휴대폰의 자판은 컴퓨터 키보드 자판과는 다르게 하나의 키에 여러 개의 문자가 할당될 수 있습니다. 키 하나에 여러 문자가 할당된 경우, 동일한 키를 연속해서 빠르게 누르면 할당된 순서대로 문자가 바뀝니다.
        예를 들어, 1번 키에 "A", "B", "C" 순서대로 문자가 할당되어 있다면 1번 키를 한 번 누르면 "A", 두 번 누르면 "B", 세 번 누르면 "C"가 되는 식입니다.
        같은 규칙을 적용해 아무렇게나 만든 휴대폰 자판이 있습니다. 이 휴대폰 자판은 키의 개수가 1개부터 최대 100개까지 있을 수 있으며, 특정 키를 눌렀을 때 입력되는 문자들도 무작위로 배열되어 있습니다. 또, 같은 문자가 자판 전체에 여러 번 할당된 경우도 있고, 키 하나에 같은 문자가 여러 번 할당된 경우도 있습니다. 심지어 아예 할당되지 않은 경우도 있습니다. 따라서 몇몇 문자열은 작성할 수 없을 수도 있습니다.
        이 휴대폰 자판을 이용해 특정 문자열을 작성할 때, 키를 최소 몇 번 눌러야 그 문자열을 작성할 수 있는지 알아보고자 합니다.
        1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때, 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.
        단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.


    제한사항
        · 1 ≤ keymap의 길이 ≤ 100
            · 1 ≤ keymap의 원소의 길이 ≤ 100
            · keymap[i]는 i + 1번 키를 눌렀을 때 순서대로 바뀌는 문자를 의미합니다.
                · 예를 들어 keymap[0] = "ABACD" 인 경우 1번 키를 한 번 누르면 A, 두 번 누르면 B, 세 번 누르면 A 가 됩니다.
            · keymap의 원소의 길이는 서로 다를 수 있습니다.
            · keymap의 원소는 알파벳 대문자로만 이루어져 있습니다.
        · 1 ≤ targets의 길이 ≤ 100
            · 1 ≤ targets의 원소의 길이 ≤ 100
            · targets의 원소는 알파벳 대문자로만 이루어져 있습니다.


    입출력 예
        keymap	                targets	            result
        ["ABACD", "BCEFD"]	    ["ABCD","AABB"]	    [9, 4]
        ["AA"]	                ["B"]	            [-1]
        ["AGZ", "BSSS"]	        ["ASA","BGZ"]	    [4, 6]


    입출력 예 설명
        입출력 예 #1
            · "ABCD"의 경우,
            · 1번 키 한 번 → A
            · 2번 키 한 번 → B
            · 2번 키 두 번 → C
            · 1번 키 다섯 번 → D
            · 따라서 총합인 9를 첫 번째 인덱스에 저장합니다.
            · "AABB"의 경우,
            · 1번 키 한 번 → A
            · 1번 키 한 번 → A
            · 2번 키 한 번 → B
            · 2번 키 한 번 → B
            · 따라서 총합인 4를 두 번째 인덱스에 저장합니다.
            · 결과적으로 [9,4]를 return 합니다.

        입출력 예 #2
            · "B"의 경우, 'B'가 어디에도 존재하지 않기 때문에 -1을 첫 번째 인덱스에 저장합니다.
            · 결과적으로 [-1]을 return 합니다.

        입출력 예 #3
            · "ASA"의 경우,
            · 1번 키 한 번 → A
            · 2번 키 두 번 → S
            · 1번 키 한 번 → A
            · 따라서 총합인 4를 첫 번째 인덱스에 저장합니다.
            · "BGZ"의 경우,
            · 2번 키 한 번 → B
            · 1번 키 두 번 → G
            · 1번 키 세 번 → Z
            · 따라서 총합인 6을 두 번째 인덱스에 저장합니다.
            · 결과적으로 [4, 6]을 return 합니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.09ms, 71.6MB)
        테스트 2 〉	통과 (0.09ms, 74.7MB)
        테스트 3 〉	통과 (0.06ms, 86.2MB)
        테스트 4 〉	통과 (0.10ms, 71.8MB)
        테스트 5 〉	통과 (0.08ms, 73.9MB)
        테스트 6 〉	통과 (0.11ms, 74.5MB)
        테스트 7 〉	통과 (0.07ms, 74.8MB)
        테스트 8 〉	통과 (0.08ms, 74.5MB)
        테스트 9 〉	통과 (0.10ms, 72.9MB)
        테스트 10 〉	통과 (0.13ms, 80.2MB)
        테스트 11 〉	통과 (0.04ms, 78.7MB)
        테스트 12 〉	통과 (0.04ms, 77.3MB)
        테스트 13 〉	통과 (0.02ms, 74.5MB)
        테스트 14 〉	통과 (0.50ms, 80.1MB)
        테스트 15 〉	통과 (0.50ms, 78.3MB)
        테스트 16 〉	통과 (0.42ms, 77.4MB)
        테스트 17 〉	통과 (0.49ms, 70.6MB)
        테스트 18 〉	통과 (0.45ms, 77.8MB)
        테스트 19 〉	통과 (0.35ms, 74.4MB)
        테스트 20 〉	통과 (0.32ms, 71MB)
        테스트 21 〉	통과 (0.54ms, 77.4MB)
        테스트 22 〉	통과 (0.39ms, 76.8MB)
        테스트 23 〉	통과 (0.40ms, 77.8MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    static int[] pushNumber; // 최소 키를 몇 번 눌러야 해당 인덱스의 알파벳을 작성할 수 있는지 저장하는 배열
    static int[] answerCount; // 문자열 배열 targets의 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 저장한 배열

    public static void calculateAlphabetPushNumber(String[] keymap) { // keymap 문자열 배열에 담긴 각 알파벳을 최소 키를 몇 번 눌러야 작성할 수 있는지 구하는 메서드
        pushNumber = new int[26];
        for (int k = 0, keyNum = keymap.length; k < keyNum; k++) {
            for (int s = 0, stringLen = keymap[k].length(); s < stringLen; s++) {
                int alphabetIndex = keymap[k].charAt(s) - 'A';

                if (pushNumber[alphabetIndex] != 0) {
                    pushNumber[alphabetIndex] = Math.min(pushNumber[alphabetIndex], s + 1);
                }
                else {
                    pushNumber[alphabetIndex] = s + 1;
                }
            }
        }
    }

    public static void count(String[] targets) { // 문자열 배열 targets의 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 구하는 메서드
        int targetNum = targets.length;
        answerCount = new int[targetNum];
        for (int t = 0; t < targetNum; t++) {
            for (int a = 0, len = targets[t].length(); a < len; a++) {
                int nowAlphabetIndex = targets[t].charAt(a) - 'A';

                if (pushNumber[nowAlphabetIndex] == 0) {
                    answerCount[t] = -1;
                    break;
                }

                answerCount[t] += pushNumber[nowAlphabetIndex];
            }
        }
    }

    public int[] solution(String[] keymap, String[] targets) {
        calculateAlphabetPushNumber(keymap);

        count(targets);

        return answerCount;
    }
}
