/*
1343. Silver 5 - 폴리오미노

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    2 초         128 MB           12303      6560       5550           53.191%


    문제
        민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB
        이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.
        폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.


    출력
        첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.


    예제 입력 1
        XXXXXX
    예제 출력 1
        AAAABB

    예제 입력 2
        XX.XX
    예제 출력 2
        BB.BB

    예제 입력 3
        XXXX....XXX.....XX
    예제 출력 3
        -1

    예제 입력 4
        X
    예제 출력 4
        -1

    예제 입력 5
        XX.XXXXXXXXXX..XXXXXXXX...XXXXXX
    예제 출력 5
        BB.AAAAAAAABB..AAAAAAAA...AAAABB


    알고리즘 분류
        구현
        그리디 알고리즘
*/


// 메모리 : 14280KB
// 시간 : 136ms
// 코드 길이 : 3472B
// 예를 들어, 입력되는 보드판이 'XX.XX...'이라면 'BB.BB...'이 나와야 한다.
// Try1과 Try2에서는 해당 예제의 경우가 반영되지 않았고, 해당 코드에서는 이를 반영했다.
// 그런데 Try1과 마찬가지로 보드판의 입력오르 'X'와 '.'만 올 수 있게 체크하는 과정이 없다. 입력으로 'X'와 '.'만 주어져서 그런 것 같다.
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void coverBoard(String boardString) { // 폴리오미노로 보드판을 모두 덮을 수 있을 경우 폴리오미노로 모두 덮은 보드판을 출력하고, 덮을 수 없는 경우 -1을 출력하는 함수
        String board[] = boardString.split("\\."); // 보드판을 '.'으로 구분하여 나온 값을 저장하는 배열
        int boardStringLength = boardString.length(); // 보드판의 크기
        int checkLength = board.length; // 보드판을 '.'으로 구분하여 나온 값을 저장한 배열의 크기
        int indexNum = 0; // 마지막이 '.'으로 끝날 경우, 마지막으로 연속된 '.'의 값이 시작되는 순서

        String answer = ""; // 출력할 답
        if (checkLength != 0) { // 보드판을 '.'으로 구분하여 나온 값을 저장한 배열의 크기가 0이 아닐 경우 (ex : 보드판이 모두 '.'으로 구성되어 있을 경우)
            for (int b = 0; b < checkLength; b++) {
                int nowBoardLength = board[b].length(); // 현재 검사할 보드판 부분의 길이

                if (nowBoardLength % 2 == 0) { // 현재 검사할 보드판 부분의 길이가 짝수일 경우
                    while (nowBoardLength != 0) { // 현재 검사할 보드판 부분의 검사할 길이가 0이 아닐 때까지 반복
                        if (nowBoardLength >= 4) { // 현재 검사할 보드판 부분의 검사할 길이가 4 이상일 경우  // 사전순으로 가장 앞서는 답을 출력하므로 'AAAA'로 덮을 수 있는지를 우선적으로 검사한다.
                            answer += "AAAA";
                            nowBoardLength -= 4; // 현재 검사할 보드판 부분의 검사할 길이를 검사한 만큼 길이 감소
                            indexNum += 4;
                        }
                        else if (nowBoardLength == 2) {
                            answer += "BB"; // 현재 검사할 보드판 부분의 검사할 길이가 2일 경우
                            nowBoardLength -= 2; // 현재 검사할 보드판 부분의 검사할 길이를 검사한 만큼 길이 감소
                            indexNum += 2;
                        }
                    }
                }
                else {
                    answer = "-1";
                    break;
                }

                if (b != checkLength - 1) { // 마지막으로 검사할 보드판 부분이 아닐 경우
                    answer += "."; // 검사한 보드판 부분의 마지막에 '.' 추가
                    indexNum += 1;
                }
                else if (boardString.charAt(boardStringLength - 1) == '.') { // 보드판의 마지막에 오는 게 '.'일 경우
                    answer += ".".repeat(boardStringLength - indexNum); // 마지막에 '.'이 오는 수만큼 '.' 추가
                }
            }
        }
        else {
            answer = ".".repeat(boardStringLength); // 보드판의 크기만큼 '.' 대입
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String boardString = bf.readLine(); // 보드판 (보드판의 크기는 최대 50)

        coverBoard(boardString);
    }
}
