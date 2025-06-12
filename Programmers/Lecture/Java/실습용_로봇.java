/*
PCCP 모의고사 2회. #121687 - [PCCP 모의고사 2] 1번, 실습용 로봇

    문제 설명
        컴퓨터공학과에서는 실습용 로봇을 이용해서 로봇 프로그래밍을 학습합니다. 실습용 로봇은 입력된 명령에 따라 x좌표와 y좌표로 표현되는 2차원 좌표 평면 위를 이동합니다. 하나의 명령은 하나의 문자로 주어지며 각 명령어에 따라 로봇이 수행하는 일은 다음과 같이 네 종류입니다.
            · 'R': 로봇이 오른쪽으로 90도 회전합니다.
            · 'L': 로봇이 왼쪽으로 90도 회전합니다.
            · 'G': 로봇이 한 칸 전진합니다.
            · 'B': 로봇이 한 칸 후진합니다.

        명령어는 각각의 명령들이
        모인 하나의 문자열로 주어지며, 차례대로 수행됩니다.

        로봇은 처음에 (0, 0) 위치에 +y 축을 향하여 놓여 있습니다.

        다음 그림은 번호 순서대로 명령어 "GRGLGRG"의 과정을 보여줍니다.
            [그림은 문제에서 참고]
            [그림은 문제에서 참고]
            [그림은 문제에서 참고]
            [그림은 문제에서 참고]
            [그림은 문제에서 참고]
            [그림은 문제에서 참고]
            [그림은 문제에서 참고]
            [그림은 문제에서 참고]

        로봇에 입력된 명령어를 순서대로 담고 있는 문자열 command가 주어집니다. 로봇이 주어진 명령어들을 순서대로 모두 수행한 뒤 도착한 최종 위치의 좌푯값 x, y를 순서대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.


    제한사항
        · 1 ≤ commad의 길이 ≤ 1,000,000
        · command는 'R', 'L', 'G', 'B'으로 구성된 문자열입니다.
        · command에 들어있는 문자 하나하나가 각 명령을 나타내며, 문자열에 먼저 등장하는 명령을 먼저 수행해야 합니다.


    입출력 예
        command	    result
        "GRGLGRG"	[2, 2]
        "GRGRGRB"	[2, 0]


    입출력 예 설명
        입출력 예 #1
            · 문제 예시와 같습니다.

        입출력 예 #2
            · 로봇이 이동한 좌표는 (0, 0) → (0, 1) → (1, 1) → (1, 0) → (2, 0) 입니다.
*/


/*
    정확성  테스트
        테스트 1 〉통과 (21.30ms, 80.2MB)
        테스트 2 〉통과 (21.01ms, 82.8MB)
        테스트 3 〉통과 (11.38ms, 97.7MB)
        테스트 4 〉통과 (13.57ms, 82.7MB)
        테스트 5 〉통과 (19.36ms, 90.5MB)
        테스트 6 〉통과 (12.37ms, 78.9MB)
        테스트 7 〉통과 (21.00ms, 96.8MB)
        테스트 8 〉통과 (18.98ms, 83.4MB)
        테스트 9 〉통과 (17.22ms, 96.3MB)
        테스트 10 〉통과 (19.83ms, 94.2MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

class Solution {
    int direction; // 로봇이 바라보고 있는 방향
    int[] dx = {0, 1, 0, -1}; // 상, 우, 하, 좌
    int[] dy = {1, 0, -1, 0}; // 상, 우, 하, 좌
    int[] coordinate; // 로봇이 위치한 좌표

    public void operate(char operation) { // 명령어에 따라 로봇을 수행시키는 메서드
        if (operation == 'R') { // 명령어가 'R'일 경우
            direction = (direction + 1) % 4; // 로봇을 오른쪽으로 90 도 회전
        }
        else if (operation == 'L') { // 명령어가 'L'일 경우
            // 로봇을 왼쪽으로 90 도 회전
            direction -= 1;
            if (direction < 0) {
                direction += 4;
            }
        }
        else if (operation == 'G') { // 명령어가 'G'일 경우
            // 로봇이 바라보고 있는 방향으로 한 칸 전진
            coordinate[0] += dx[direction];
            coordinate[1] += dy[direction];
        }
        else { // 명령어가 'B'일 경우
            // 로봇이 바라보고 있는 방향으로부터 한 칸 후진
            int reverseDirection = (direction + 2) % 4; // 로봇이 바라보고 있는 방향의 반대 방향
            coordinate[0] += dx[reverseDirection];
            coordinate[1] += dy[reverseDirection];
        }
    }

    public int[] solution(String command) {
        coordinate = new int[2];

        for (int c = 0, len = command.length(); c < len; c++) {
            operate(command.charAt(c));
        }

        return coordinate;
    }
}