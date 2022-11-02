"""
1954. 달팽이 숫자

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
    다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.

    [예제]
        N이 3일 경우,
            1 2 3
            8 9 4
            7 6 5

        N이 4일 경우,
            1   2  3 4
            12 13 14 5
            11 16 15 6
            10  9  8 7

    [제약사항]
        달팽이의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)

    [입력]
        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        각 테스트 케이스에는 N이 주어진다.

    [출력]
        각 줄은 '#t'로 시작하고, 다음 줄부터 빈칸을 사이에 두고 달팽이 숫자를 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)


    입력
        2
        3
        4

    출력
        #1
        1 2 3
        8 9 4
        7 6 5
        #2
        1 2 3 4
        12 13 14 5
        11 16 15 6
        10 9 8 7
"""


# 델타 탐색 알고리즘으로 풀어 보기


# 실행 시간 : 0.12649s

T = int(input())

for t in range(1, T + 1):
    N = int(input())

    snail = [[0] * N for _ in range(N)]

    num = 1
    start = 0
    end = 0

    for n in range(1, 2 * N):
        if n % 4 == 1: # 오른쪽 방향 가로
            for i in range(0 + start, N - end):
                snail[(n - 1) // 4][i] = num
                num += 1

        if n % 4 == 2: # 아래 방향 세로
            for j in range(1 + start, N - end):
                snail[j][(2 - n) // 4 + (N - 1)] = num
                num += 1

        if n % 4 == 3: # 왼쪽 방향 가로
            for k in range(2 + start, N - end + 1):
                snail[(2 - n) // 4 + N][N - k] = num
                num += 1

        if n % 4 == 0: # 위쪽 방향 세로
            for m in range(2 + start, N - end):
                snail[N - m][(n - 4) // 4] = num
                num += 1

            start += 1
            end += 1

    print("#%d" % t)
    for p in range(len(snail)):
        for r in range(len(snail[p])):
            if r != len(snail[p]) - 1:
                print(snail[p][r], end = " ")
            else:
                print(snail[p][r])
