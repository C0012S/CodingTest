"""
1983. 조교의 성적 매기기

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    학기가 끝나고, 학생들의 점수로 학점을 계산중이다.
    학점은 상대평가로 주어지는데, 총 10개의 평점이 있다.
        A+  A0  A-  B+  B0  B-  C+  C0  C-  D0

    학점은 학생들이 응시한 중간/기말고사 점수 결과 및 과제 점수가 반영한다.
    각각 아래 비율로 반영된다.
        총점 = 중간고사 (35%) + 기말고사 (45%) + 과제 (20%)

    10 개의 평점을 총점이 높은 순서대로 부여하는데,
    각각의 평점은 같은 비율로 부여할 수 있다.
    예를 들어, N 명의 학생이 있을 경우 N/10 명의 학생들에게 동일한 평점을 부여할 수 있다.
    입력으로 각각의 학생들의 중간, 기말, 과제 점수가 주어지고,
    학점을 알고싶은 K 번째 학생의 번호가 주어졌을 때,
    K 번째 학생의 학점을 출력하는 프로그램을 작성하라.

    [제약사항]
        1. N은 항상 10의 배수이며, 10이상 100이하의 정수이다. (10 ≤ N ≤ 100)
        2. K는 1 이상 N 이하의 정수이다. (1 ≤ K ≤ N)
        3. K 번째 학생의 총점과 다른 학생의 총점이 동일한 경우는 입력으로 주어지지 않는다.

    [입력]
        입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
        다음 줄부터 각 테스트 케이스가 주어진다.
        테스트 케이스의 첫 번째 줄은 학생수 N 과, 학점을 알고싶은 학생의 번호 K 가 주어진다.
        테스트 케이스 두 번째 줄 부터 각각의 학생이 받은 시험 및 과제 점수가 주어진다.

    [출력]
        테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)


    입력
        10
        10 2
        87 59 88
        99 94 78
        94 86 86
        99 100 99
        69 76 70
        76 89 96
        98 95 96
        74 69 60
        98 84 67
        85 84 91
        ...

    출력
        #1 A-
        ...
"""


# 실행 시간 : 0.15671s
# Pass

def print_score(all_student_score, student_num):
    equal_score_num = N // 10

    total_score = [0] * N
    for ts in range(N):
        total_score[ts] = all_student_score[ts][0] * 0.35 + all_student_score[ts][1] * 0.45 + all_student_score[ts][2] * 0.20

    sorted_total_score = sorted(total_score, reverse = True) # 내림차순으로 정렬

    grade_list = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]

    return grade_list[sorted_total_score.index(total_score[student_num - 1]) // equal_score_num]


T = int(input())

for t in range(1, T + 1):
    N, K = map(int, input().split()) # 1 ≤ K ≤ N이므로 K 번째 학생의 성적은 score[K - 1]

    score = [[0] * 3 for _ in range(N)]
    for n in range(N):
        score[n] = list(map(int, input().split()))

    print("#%d" % t, print_score(score, K))
