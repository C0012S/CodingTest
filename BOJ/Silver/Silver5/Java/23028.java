/*
23028. Silver 5 - 5학년은 다니기 싫어요

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    1 초         512 MB           664        284        232            42.413%


    문제
        5학년은 다니기 싫은 아리는 4학년까지 졸업 학점을 채워 졸업할 수 있는지 궁금해졌다. 아리가 졸업하려면 총 130학점 이상 들어야 하고, 그중 66학점 이상은 전공학점이어야 한다. 아리는 현재 2021년 2학기까지 N학기를 마쳤고, 전공학점 A를 포함하여 총 B학점을 이수하였다. 고민하던 아리는 학교 홈페이지에서 다음과 같은 공지가 올라온 것을 확인했다.
            2022년 1학기부터 2026년 2학기까지 10개의 학기 동안 개설되는 과목의 수를 공지합니다.
                · 2022년 1학기 : 전공과목 X1개, 비전공 과목 Y1개
                · 2022년 2학기 : 전공과목 X2개, 비전공 과목 Y2개
                · 2023년 1학기 : 전공과목 X3개, 비전공 과목 Y3개
                                    ⋮
                · 2026년 2학기 : 전공과목 X10개, 비전공 과목 Y10개

            2022년 1학기부터는 한 학기에 전공 수업과 비전공 수업을 포함하여 최대 6과목을 수강할 수 있습니다.
            한 과목을 수강하게 되면 3학점을 얻게 되고, 그러므로 한 학기에 최대 18학점을 이수할 수 있습니다. 참고하시기 바랍니다.

        각 수업은 시간표가 서로 겹치지 않아서 아리는 원하는 수업을 모두 수강할 수 있다. 아리는 최대한 빨리 졸업을 하고 싶어서 휴학을 하지 않는다. 아리를 도와 아리가 전에 마쳤던 학기를 포함하여 총 8학기 안에 졸업할 수 있는지 확인하는 프로그램을 작성해보자.


    입력
        세 정수 N(1 ≤ N ≤ 7), A(1 ≤ A ≤ 150), B(A ≤ B ≤ 150)이 주어진다.
        다음 10개 줄에는 2022년 1학기부터 2026년 2학기까지 차례대로 학기에 개설되는 과목의 수가 주어지고, 한 줄에 한 학기의 전공과목 수 X(1 ≤ X ≤ 6), 비전공 과목 수 Y(1≤ Y ≤ 6)이 주어진다.


    출력
        총 8학기 안에 졸업 조건을 맞출 수 있다면 "Nice"를, 불가능하다면 "Nae ga wae"를 출력한다.


    예제 입력 1
        7 60 120
        4 3
        3 4
        1 6
        4 3
        3 4
        1 6
        4 3
        3 4
        1 6
        6 6
    예제 출력 1
        Nice
    2022년 1학기에는 전공 수업이 4과목, 비전공 수업이 3과목이 주어진다. 아리는 전공 2과목, 비전공 2과목을 듣게 되면 전공학점이 66학점, 총 학점이 132학점이 된다. 그래서 총 8학기 안에 졸업을 할 수 있다.

    예제 입력 2
        6 46 120
        3 3
        3 5
        6 2
        2 2
        3 1
        2 3
        1 5
        5 2
        2 3
        3 2
    예제 출력 2
        Nae ga wae
    아리는 남은 2학기 동안 전공과목을 최대한 수강해도 64학점으로 졸업 조건에 만족하지 못하여 총 8학기 안에 졸업할 수 없다.


    알고리즘 분류
        그리디 알고리즘
*/


// 메모리 : 14196KB
// 시간 : 132ms
// 코드 길이 : 3718B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 2021 년 2 학기까지 마친 학기
    static int A; // 2021 년 2 학기까지 이수한 전공 학점
    static int B; // 2021 년 2 학기까지 이수한 총 학점
    static int majorNum[]; // 2022 년 1 학기부터 2026 년 2 학기까지 개설되는 전공 과목 수 배열
    static int notMajorNum[]; // 2022 년 1 학기부터 2026 년 2 학기까지 개설되는 비전공 과목 수 배열
    static int allCredit; // 8 학기 동안 들을 총 학점
    static int majorCredit; // 8 학기 동안 들을 전공 학점

    public static void calculateCredit() { // 8 학기 동안 들을 수 있는 학점을 계산하여 졸업이 가능한지 검사하는 함수
        int restSemester = 8 - N; // 남은 학기
        boolean isPossible = false; // 8 학기 안에 졸업 조건을 맞출 수 있는지

        if (A >= 66 && B >= 130) { // 이미 현재 학기에서 졸업 조건(전공 학점 66 점 이상, 총 학점 130 점 이상)을 만족했다면
            System.out.println("Nice");
        }
        else {
            for (int r = 0; r < restSemester; r++) {
                int nowMajorCredit = majorNum[r] * 3; // 해당 학기에 들을 수 있는 최대 전공 학점
                int nowNotMajorCredit = 0; // 해당 학기에 들을 수 있는 최대 전공 학점을 듣고 들을 수 있는 비전공 학점
                if (notMajorNum[r] > (6 - majorNum[r])) { // 해당 학기에 들을 수 있는 최대 전공 학점을 듣고 비전공 과목을 다 듣는다고 가정했을 때, 한 학기에 들을 수 있는 최대 학점을 넘는다면
                    nowNotMajorCredit = (6 - majorNum[r]) * 3; // 최대 학점까지 들을 수 있는 비전공 과목 수만큼 듣는 비전공 학점
                }
                else {
                    nowNotMajorCredit = notMajorNum[r] * 3;
                }

                majorCredit += nowMajorCredit; // 현재 학기까지 듣는 전공 학점
                allCredit = allCredit + nowMajorCredit + nowNotMajorCredit; // 현재 학기까지 듣는 총 학점

                if (majorCredit >= 66 && allCredit >= 130) { // 졸업 조건을 만족한다면
                    isPossible = true;
                    break;
                }
            }

            if (isPossible) { // 졸업 조건을 만족한다면
                System.out.println("Nice");
            }
            else { // 졸업 조건을 만족하지 못한다면
                System.out.println("Nae ga wae");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());

        majorCredit = A;
        allCredit = B;

        majorNum = new int[10];
        notMajorNum = new int[10];
        for (int s = 0; s < 10; s++) { // 2022 년 1 학기부터 2026 년 2 학기까지
            token = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(token.nextToken()); // 해당 학기의 전공 과목 수
            int Y = Integer.parseInt(token.nextToken()); // 해당 학기의 비전공 과목 수

            majorNum[s] = X;
            notMajorNum[s] = Y;
        }

        calculateCredit(); // 8 학기 안에 졸업 조건을 맞출 수 있는지 검사
    }
}
