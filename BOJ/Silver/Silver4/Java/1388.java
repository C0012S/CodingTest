/*
1388. Silver 4 - 바닥 장식

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           5376	    3484      2904	         67.692%


    문제
        형택이는 건축가이다. 지금 막 형택이는 형택이의 남자 친구 기훈이의 집을 막 완성시켰다. 형택이는 기훈이 방의 바닥 장식을 디자인했고, 이제 몇 개의 나무 판자가 필요한지 궁금해졌다. 나무 판자는 크기 1의 너비를 가졌고, 양수의 길이를 가지고 있다. 기훈이 방은 직사각형 모양이고, 방 안에는 벽과 평행한 모양의 정사각형으로 나누어져 있다.
        이제 ‘-’와 ‘|’로 이루어진 바닥 장식 모양이 주어진다. 만약 두 개의 ‘-’가 인접해 있고, 같은 행에 있다면, 두 개는 같은 나무 판자이고, 두 개의 ‘|’가 인접해 있고, 같은 열에 있다면, 두 개는 같은 나무 판자이다.
        기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 방 바닥의 세로 크기N과 가로 크기 M이 주어진다. 둘째 줄부터 N개의 줄에 M개의 문자가 주어진다. 이것은 바닥 장식 모양이고, '-‘와 ’|‘로만 이루어져 있다. N과 M은 50 이하인 자연수이다.


    출력
        첫째 줄에 문제의 정답을 출력한다.


    예제 입력 1
        4 4
        ----
        ----
        ----
        ----
    예제 출력 1
        4

    예제 입력 2
        6 9
        -||--||--
        --||--||-
        |--||--||
        ||--||--|
        -||--||--
        --||--||-
    예제 출력 2
        31

    예제 입력 3
        7 8
        --------
        |------|
        ||----||
        |||--|||
        ||----||
        |------|
        --------
    예제 출력 3
        13

    예제 입력 4
        10 10
        ||-||-|||-
        ||--||||||
        -|-|||||||
        -|-||-||-|
        ||--|-||||
        ||||||-||-
        |-||||||||
        ||||||||||
        ||---|--||
        -||-||||||
    예제 출력 4
        41

    예제 입력 5
        6 6
        -||--|
        ||||||
        |||-|-
        -||||-
        ||||-|
        ||-||-
    예제 출력 5
        19


    알고리즘 분류
        구현
        그래프 이론
        그래프 탐색
        깊이 우선 탐색
*/


// 메모리 : 14200KB
// 시간 : 124ms
// 코드 길이 : 3895B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 방 바닥의 세로 크기 N
    static int M; // 방 바닥의 가로 크기 M
    static char woodArray[][]; // 바닥 장식 모양을 저장하는 배열
    static boolean isVisited[][]; // 해당 바닥 장식의 검사 여부
    static int woodNum = 0; // 방 바닥을 장식하는 데 필요한 나무 판자의 개수

    public static boolean check(int x, int y) { // 인덱스가 유효한지 검사하는 함수  // 유효한 인덱스일 경우 true, 유효하지 않은 인덱스일 경우 false 반환
        if (x >= 0 && x < N && y >= 0 && y < M) {
            return true;
        }

        return false;
    }

    public static void calculateWoodNum() { // 방 바닥을 장식하는 데 필요한 나무 판자의 개수를 구하는 함수
        // 검사할 바닥 장식의 모양이 '-'일 경우, 왼쪽과 오른쪽의 바닥 장식의 모양을 확인하면 된다. 그런데 왼쪽부터 검사하므로 오른쪽의 바닥 장식의 모양만 확인하면 된다.
        // 검사할 바닥 장식의 모양이 '|'일 경우, 위쪽과 아래쪽의 바닥 장식의 모양을 확인하면 된다. 그런데 위쪽부터 검사하므로 아래쪽의 바닥 장식의 모양만 확인하면 된다.
        // 같은 나무 판자일 경우, 바로 나무 판자의 개수를 세지 않고 해당 나무 판자의 끝에서 개수를 센다.
        isVisited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (isVisited[r][c]) { // 이미 검사한 바닥 장식일 경우
                    continue; // 다음 바닥 장식을 검사하도록 패스
                }

                if (woodArray[r][c] == '-') { // 해당 바닥 장식의 모양이 '-'일 경우
                    int ny = c + 1; // 해당 바닥 장식의 다음 바닥 장식의 열
                    while(check(r, ny) && woodArray[r][ny] == '-') { // 인덱스 범위에 벗어나지 않고, 다음 바닥 장식의 모양이 '-'일 경우
                        isVisited[r][ny] = true; // 다음 바닥 장식의 검사 여부 체크
                        ny += 1; // 계속해서 다음 바닥 장식의 모양을 검사하도록 그 다음 바닥 장식의 열 구하기
                    }

                    woodNum += 1; // 나무 판자의 개수 추가
                }

                if (woodArray[r][c] == '|') { // 해당 바닥 장식의 모양이 '|'일 경우
                    int nx = r + 1; // // 해당 바닥 장식의 다음 바닥 장식의 행
                    while(check(nx, c) && woodArray[nx][c] == '|') { // 인덱스 범위에 벗어나지 않고, 다음 바닥 장식의 모양이 '|'일 경우
                        isVisited[nx][c] = true; // 다음 바닥 장식의 검사 여부 체크
                        nx += 1; // 계속해서 다음 바닥 장식의 모양을 검사하도록 그 다음 바닥 장식의 행 구하기
                    }

                    woodNum += 1; // 나무 판자의 개수 추가
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        woodArray = new char[N][M];
        for (int n = 0; n < N; n++) {
            String wood = bf.readLine();
            for (int m = 0; m < M; m++) {
                woodArray[n][m] = wood.charAt(m);
            }
        }

        calculateWoodNum();
        System.out.println(woodNum);
    }
}
