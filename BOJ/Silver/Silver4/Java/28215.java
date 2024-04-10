/*
28215. Silver 4 - 대피소

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    3 초	    1024 MB          1146	    508       397	         52.306%


    문제
        2차원 평면의 KOI 마을에 N개의 집이 있다. 각 i번째 집의 위치는 (X_i, Y_i)이다.

        i번째 집과 j번째 집 사이의 거리는 | X_i - X_j | + | Y_i - Y_j |이다. 즉, 두 집 사이의 거리는 X의 차이와 Y의 차이의 합이다. 예를 들어, (1, 6)에 위치한 집과 (2, 4)에 위치한 집은 (2 - 1) + (6 - 4)인 3만큼 떨어져 있다.
            [그림은 문제에서 참고]

        KOI 마을은 재난 발생 시 주민들이 안전하게 대피할 수 있도록 K개의 집에 대피소를 설치할 계획이다. 모 든 주민의 안전을 고려하여, 집에서 가장 가까운 대피소로 이동할 때 가장 긴 거리가 최소가 되도록 대피소를 설치할 K개의 집을 선택하고, 그때 대피소와 가장 멀리 떨어진 집과의 거리를 구하려고 한다.

        아래는 5개의 집이 각각 (1, 5), (3, 0), (3, 3), (6, 12), (8, 9)에 위치한 마을의 예이다.
            [그림은 문제에서 참고]

        이 마을에 2개의 대피소를 설치하려고 한다. 만약 (3, 0)과 (1, 5)에 위치한 집에 대피소를 설치한다면 설치하지 않은 나머지 세 집에서 가까운 대피소까지의 거리가 각각 3, 11, 12이고, 이 중 가장 먼 거리는 12이다.
            [그림은 문제에서 참고]

        하지만 (3, 3)와 (6, 12)에 위치한 집에 대피소를 설치하면 가장 가까운 대피소와 가장 멀리 떨어져 있는 집은 (8, 9)에 위치한 집으로, (6, 12)와 5만큼 떨어져 있다. 대피소를 어떻게 설치해도 최대 거리가 5보다 작아지는 경우가 없으므로 5가 구하고자 하는 거리가 된다.
            [그림은 문제에서 참고]

        KOI 마을의 집들의 위치와 설치할 대피소의 개수가 주어질 때, 대피소를 설치하는 모든 방법 중 가장 가까운 대피소와 집 사이의 거리 중 가장 큰 값이 가장 작을 때의 거리를 구해라.


    입력
        첫 번째 줄에 N과 K가 공백을 사이에 두고 주어진다.
        다음 N개의 줄에는 집의 위치가 주어지는데, 이 중 i (1 ≤ i ≤ N)번째 줄에는 X_i와 Y_i가 공백을 사이에 두고 주어진다.


    출력
        첫 번째 줄에 답을 출력한다.


    제한
        · 주어지는 모든 수는 정수이다.
        · 1 ≤ K ≤ 3
        · K ≤ N ≤ 50
        · 0 ≤ X_i ≤ 100000
        · 0 ≤ Y_i ≤ 100000
        · 같은 위치에 집이 여럿 존재하지 않는다. 즉, (X_1, Y_1), (X_2, Y_2), ···, (X_N, Y_N)는 서로 다르다.


    서브태스크
        번호	    배점	    제한
        1	    5       N = K + 1
        2	    7       K = 1, 모든 i (1 ≤ i ≤ N)에 대해 X_i = i이고 Y_i = 0이다.
        3	    10      K = 1
        4	    18      K = 2
        5	    35      K = 3, 1 ≤ i ≤ N - 1에 대해 X_i < X_{i+1}이며, 모든 i (1 ≤ i ≤ N)에 대해 Y_i = 0이다. 즉, X는 오름차순으로 정렬되어 있다.
        6	    25      K = 3


    예제 입력 1
        5 2
        1 5
        3 0
        3 3
        6 12
        8 9
    예제 출력 1
        5

    예제 입력 2
        4 2
        0 0
        0 5
        5 0
        5 5
    예제 출력 2
        5

    예제 입력 3
        4 1
        1 0
        2 0
        3 0
        4 0
    예제 출력 3
        2

    예제 입력 4
        2 1
        20 23
        5 14
    예제 출력 4
        24


    알고리즘 분류
        수학
        구현
        브루트포스 알고리즘
        시뮬레이션


    채점 및 기타 정보
        예제는 채점하지 않는다.
*/


// 메모리 : 25528KB
// 시간 : 356ms
// 코드 길이 : 3934B
// 100 점

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; // 집의 개수 (K ≤ N ≤ 50)
    static int K; // 대피소의 개수 (1 ≤ K ≤ 3)
    static int coordinate[][]; // 집의 좌표를 저장하는 배열
    static boolean isSelected[]; // 해당 인덱스의 집의 대피소 설치 여부를 저장하는 배열
    static ArrayList<Integer> selectedCoordinateIndex; // 대피소가 설치된 집의 인덱스를 저장하는 리스트
    static int minDistance; // 대피소를 설치하는 모든 방법 중 가장 가까운 대피소와 집 사이의 거리 중 가장 큰 값이 가장 작을 때의 거리

    public static int calculateDistance(int x1, int y1, int x2, int y2) { // 두 집 사이의 거리를 구하는 메서드
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static int calculateAllDistance() { // 대피소를 설치한 집과 대피소를 설치하지 않은 집 사이의 거리를 구하는 메서드
        int maxShelterDistance = 0; // 가장 가까운 대피소와 집 사이의 거리 중 가장 큰 값
        for (int c = 0; c < N; c++) {
            if (isSelected[c]) { // 대피소를 설치한 집일 경우
                continue; // 대피소를 설치한 집들과 거리를 구하는 과정을 넘긴다.
            }

            // 대피소를 설치하지 않은 집일 경우, 대피소를 설치한 집들과 거리를 구하여 그중 가장 가까운 대피소와 집 사이의 거리를 구한다.
            int minShelterDistance = Integer.MAX_VALUE; // 가장 가까운 대피소와 집 사이의 거리
            for (Integer index : selectedCoordinateIndex) {
                minShelterDistance = Math.min(minShelterDistance, calculateDistance(coordinate[c][0], coordinate[c][1], coordinate[index][0], coordinate[index][1]));
            }

            // 가장 가까운 대피소와 집 사이의 거리들 중 최댓값을 구한다.
            maxShelterDistance = Math.max(maxShelterDistance, minShelterDistance);
        }

        return maxShelterDistance;
    }

    public static void findMinPath(int selectedNum) { // 대피소를 설치하는 모든 방법 중 가장 가까운 대피소와 집 사이의 거리 중 가장 큰 값이 가장 작을 때의 거리를 구하는 메서드
        if (selectedNum >= K) { // 대피소를 K 개만큼 설치했을 경우
            minDistance = Math.min(minDistance, calculateAllDistance()); // 가장 가까운 대피소와 집 사이의 거리 중 가장 큰 값들 중의 최솟값 구하기

            return;
        }

        for (int n = 0; n < N; n++) {
            if (!isSelected[n]) {
                isSelected[n] = true;
                selectedCoordinateIndex.add(n);
                findMinPath(selectedNum + 1);
                isSelected[n] = false;
                selectedCoordinateIndex.remove(selectedNum);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        coordinate = new int[N][2];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(token.nextToken()); // x 좌표
            int Y = Integer.parseInt(token.nextToken()); // y 좌표

            coordinate[i][0] = X;
            coordinate[i][1] = Y;
        }

        isSelected = new boolean[N];
        selectedCoordinateIndex = new ArrayList<>();
        minDistance = Integer.MAX_VALUE;
        findMinPath(0);

        System.out.println(minDistance);
    }
}
