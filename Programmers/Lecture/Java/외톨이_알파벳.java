/*
PCCP 모의고사 1회. #121683 - [PCCP 모의고사 1] 1번, 외톨이 알파벳

    문제 설명
        알파벳 소문자로만 이루어진 어떤 문자열에서, 2회 이상 나타난 알파벳이 2개 이상의 부분으로 나뉘어 있으면 외톨이 알파벳이라고 정의합니다.

        문자열 "edeaaabbccd"를 예시로 들어보면,
            · a는 2회 이상 나타나지만, 하나의 덩어리로 뭉쳐있으므로 외톨이 알파벳이 아닙니다.
                · "ede(aaa)bbccd"
            · b, c도 a와 같은 이유로 외톨이 알파벳이 아닙니다.
            · d는 2회 나타나면서, 2개의 부분으로 나뉘어 있으므로 외톨이 알파벳입니다.
                · "e(d)eaaabbcc(d)"
            · e도 d와 같은 이유로 외톨이 알파벳입니다.

        문자열 "eeddee"를 예시로 들어보면,
            · e는 4회 나타나면서, 2개의 부분으로 나뉘어 있으므로 외톨이 알파벳입니다.
                · "(ee)dd(ee)"
            · d는 2회 나타나지만, 하나의 덩어리로 뭉쳐있으므로 외톨이 알파벳이 아닙니다.
                · "ee(dd)ee"

        문자열 input_string이 주어졌을 때, 외톨이 알파벳들을 알파벳순으로 이어 붙인 문자열을 return 하도록 solution 함수를 완성해주세요. 만약, 외톨이 알파벳이 없다면 문자열 "N"을 return 합니다.


    제한사항
        · 1 ≤ input_string의 길이 ≤ 2,600
        · input_string은 알파벳 소문자로만 구성되어 있습니다..


    입출력 예
        input_string	result
        "edeaaabbccd"	"de"
        "eeddee"	    "e"
        "string"	    "N"
        "zbzbz"	        "bz"


    입출력 예 설명
        입출력 예 #1
            · 문제 예시와 같습니다.
            · 외톨이 알파벳인 e, d를 알파벳순으로 이어 붙여 문자열을 만들면 "de"가 됩니다.

        입출력 예 #2
            · 문제 예시와 같습니다.

        입출력 예 #3
            · 모든 문자들이 한 번씩만 등장하므로 외톨이 알파벳이 없습니다.

        입출력 예 #4
            · 외톨이 알파벳인 z, b를 알파벳순으로 이어 붙여 문자열을 만들면 "bz"가 됩니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.06ms, 95.7MB)
        테스트 2 〉	통과 (0.04ms, 86.6MB)
        테스트 3 〉	통과 (0.04ms, 89.7MB)
        테스트 4 〉	통과 (1.77ms, 77.2MB)
        테스트 5 〉	통과 (0.83ms, 82.8MB)
        테스트 6 〉	통과 (1.74ms, 90.4MB)
        테스트 7 〉	통과 (0.84ms, 73MB)
        테스트 8 〉	통과 (0.79ms, 88.3MB)
        테스트 9 〉	통과 (0.76ms, 89.5MB)
        테스트 10 〉	통과 (0.85ms, 70.8MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    int[] count; // 각 알파벳의 등장 횟수를 저장하는 배열
    boolean[] isSelected; // 각 알파벳의 외톨이 알파벳 여부를 저장하는 배열
    StringBuilder sb;

    public String get() { // 외톨이 알파벳들을 문제의 답 조건에 맞게 조작하는 메서드
        for (int o = 0; o < 26; o++) {
            if (isSelected[o]) { // 외톨이 알파벳일 경우
                sb.append((char) (o + 'a'));
            }
        }

        if (sb.length() == 0) { // 외톨이 알파벳이 없을 경우
            return "N";
        }

        return sb.toString();
    }

    public String find(String input_string) { // 외톨이 알파벳을 찾는 메서드
        for (int s = 0, len = input_string.length(); s < len; s++) {
            char nowChar = input_string.charAt(s); // 현재 검사하는 알파벳
            int nowIndex = nowChar - 'a'; // 현재 검사하는 알파벳의 알파벳 내 인덱스

            count[nowIndex] += 1; // 알파벳의 등장 횟수 추가

            if ((count[nowIndex] >= 2)) { // 해당 알파벳이 2 회 이상 나타났을 경우
                // (알파벳의 등장 횟수 - 1)만큼 현재 알파벳과 이전 알파벳 비교
                for (int c = 1; c < count[nowIndex]; c++) {
                    char prevChar = input_string.charAt(s - c); // 이전 알파벳

                    if ((nowChar != prevChar) && !isSelected[nowIndex]) { // 현재 알파벳과 이전 알파벳이 다르고, 외톨이 알파벳으로 선정되지 않은 알파벳일 경우
                        isSelected[nowIndex] = true; // 외톨이 알파벳으로 선정
                    }
                }
            }
        }

        return get();
    }

    public String solution(String input_string) {
        count = new int[26];
        isSelected = new boolean[26];
        sb = new StringBuilder();

        return find(input_string);
    }
}
