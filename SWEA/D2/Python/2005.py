"""
2005. 파스칼의 삼각형

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    크기가 N인 파스칼의 삼각형을 만들어야 한다.
    파스칼의 삼각형이란 아래와 같은 규칙을 따른다.
        1. 첫 번째 줄은 항상 숫자 1이다.
        2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성된다.

    N이 4일 경우,
              1
            1   1
          1   2   1
        1   3   3   1

    N을 입력 받아 크기 N인 파스칼의 삼각형을 출력하는 프로그램을 작성하시오.

    [제약 사항]
        파스칼의 삼각형의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)

    [입력]
        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        각 테스트 케이스에는 N이 주어진다.

    [출력]
        각 줄은 '#t'로 시작하고, 다음 줄부터 파스칼의 삼각형을 출력한다.
        삼각형 각 줄의 처음 숫자가 나오기 전까지의 빈 칸은 생략하고 숫자들 사이에는 한 칸의 빈칸을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)


    입력
        10
        1
        2
        3
        4
        5
        6
        7
        8
        9
        10

    출력
        #1
        1
        #2
        1
        1 1
        #3
        1
        1 1
        1 2 1
        #4
        1
        1 1
        1 2 1
        1 3 3 1
        #5
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        #6
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        1 5 10 10 5 1
        #7
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        1 5 10 10 5 1
        1 6 15 20 15 6 1
        #8
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        1 5 10 10 5 1
        1 6 15 20 15 6 1
        1 7 21 35 35 21 7 1
        #9
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        1 5 10 10 5 1
        1 6 15 20 15 6 1
        1 7 21 35 35 21 7 1
        1 8 28 56 70 56 28 8 1
        #10
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
        1 5 10 10 5 1
        1 6 15 20 15 6 1
        1 7 21 35 35 21 7 1
        1 8 28 56 70 56 28 8 1
        1 9 36 84 126 126 84 36 9 1
"""


# 실행 시간 : 0.14185s
# Pass

T = int(input())

for t in range(1, T + 1):
    N = int(input())
    pascal = [[0] * N for _ in range(N)]

    for r in range(N):
        for c in range(N):
            if c == 0 or c == r:
                pascal[r][c] = 1
            elif r != 0:
                pascal[r][c] = pascal[r - 1][c - 1] + pascal[r - 1][c]

    print("#%d" % t)
    for nr in range(N):
        for nc in range(N):
            if pascal[nr][nc] != 0:
                if nc != nr:
                    print(pascal[nr][nc], end = ' ')
                else:
                    print(pascal[nr][nc])