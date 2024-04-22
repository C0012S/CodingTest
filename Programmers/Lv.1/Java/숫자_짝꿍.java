/*
Lv. 1 #131128 - 숫자 짝꿍

    문제 설명
        두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
        예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
        두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.


    제한사항
        · 3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
        · X, Y는 0으로 시작하지 않습니다.
        · X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.


    입출력 예
        X	        Y	        result
        "100"	    "2345"	    "-1"
        "100"	    "203045"	"0"
        "100"	    "123450"	"10"
        "12321"	    "42531"	    "321"
        "5525"	    "1255"	    "552"


    입출력 예 설명
        입출력 예 #1
            · X, Y의 짝꿍은 존재하지 않습니다. 따라서 "-1"을 return합니다.

        입출력 예 #2
            · X, Y의 공통된 숫자는 0으로만 구성되어 있기 때문에, 두 수의 짝꿍은 정수 0입니다. 따라서 "0"을 return합니다.

        입출력 예 #3
            · X, Y의 짝꿍은 10이므로, "10"을 return합니다.

        입출력 예 #4
            · X, Y의 짝꿍은 321입니다. 따라서 "321"을 return합니다.

        입출력 예 #5
            · 지문에 설명된 예시와 같습니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.37ms, 75.5MB)
        테스트 2 〉	통과 (0.29ms, 73.9MB)
        테스트 3 〉	통과 (0.47ms, 70.1MB)
        테스트 4 〉	통과 (0.34ms, 72MB)
        테스트 5 〉	통과 (0.35ms, 71.7MB)
        테스트 6 〉	통과 (1.24ms, 70.9MB)
        테스트 7 〉	통과 (0.49ms, 75.1MB)
        테스트 8 〉	통과 (2.05ms, 70MB)
        테스트 9 〉	통과 (1.28ms, 72.2MB)
        테스트 10 〉	통과 (1.65ms, 72.7MB)
        테스트 11 〉	통과 (641.55ms, 276MB)
        테스트 12 〉	통과 (679.32ms, 252MB)
        테스트 13 〉	통과 (684.89ms, 259MB)
        테스트 14 〉	통과 (636.15ms, 248MB)
        테스트 15 〉	통과 (777.13ms, 255MB)
        테스트 16 〉	통과 (0.34ms, 81.9MB)
        테스트 17 〉	통과 (0.26ms, 73.4MB)
        테스트 18 〉	통과 (0.31ms, 72.8MB)
        테스트 19 〉	통과 (0.23ms, 71.5MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] appearedNum = new int[10]; // 해당 인덱스가 문자열 X에서 몇 개로 구성되어 있는지 저장하는 배열

        for (int x = 0, xLen = X.length(); x < xLen; x++) {
            appearedNum[X.charAt(x) - '0'] += 1;
        }

        ArrayList<Integer> duplicatedNum = new ArrayList<>(); // 문자열 X와 문자열 Y에서 공통으로 나타나는 정수를 저장하는 리스트
        for (int y = 0, yLen = Y.length(); y < yLen; y++) {
            int num = Y.charAt(y) - '0';
            if (appearedNum[num] > 0) {
                duplicatedNum.add(num);
                appearedNum[num] -= 1;
            }
        }

        Collections.sort(duplicatedNum); // 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        for (int i = duplicatedNum.size() - 1; i >= 0; i--) {
            sb.append(duplicatedNum.get(i));
        }

        String answer = sb.toString();
        if (answer.equals("")) { // X와 Y의 공통된 숫자가 존재하지 않을 경우
            return "-1";
        }
        else if (answer.replace("0", "").equals("")) { // X와 Y의 공통된 숫자가 0으로만 구성되어 있을 경우
            return "0";
        }

        return answer;
    }
}