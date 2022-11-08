"""
4875. [파이썬 S/W 문제해결 기본] 5일차 - 미로

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    NxN 크기의 미로에서 출발지에서 목적지에 도착하는 경로가 존재하는지 확인하는 프로그램을 작성하시오. 도착할 수 있으면 1, 아니면 0을 출력한다.
    주어진 미로 밖으로는 나갈 수 없다.
    다음은 5x5 미로의 예이다.
        13101
        10101
        10101
        10101
        10021

    마지막 줄의 2에서 출발해서 0인 통로를 따라 이동하면 맨 윗줄의 3에 도착할 수 있는지 확인하면 된다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1<=T<=50
        다음 줄부터 테스트 케이스의 별로 미로의 크기 N과 N개의 줄에 걸쳐 미로의 통로와 벽에 대한 정보가 주어진다. 0은 통로, 1은 벽, 2는 출발, 3은 도착이다. 5<=N<=100

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 계산결과를 정수로 출력하거나 또는 ‘error’를 출력한다.


    입력
        3
        5
        13101
        10101
        10101
        10101
        10021
        5
        10031
        10111
        10101
        10101
        12001
        5
        00013
        01110
        21000
        01111
        00000

    출력
        #1 1
        #2 1
        #3 0
"""


# 실행 시간 : 0.12777s  # 0.12 ~ 0.14 정도 걸리는 것 같음

T = int(input())

for t in range(1, T + 1):
    N = int(input())

    maze = [[0] * N for _ in range(N)] # N x N 크기의 미로

    for n in range(N):
        maze[n] = list(map(int, input())) # 미로 입력

        if 2 in maze[n]: # 시작 위치 찾기
            start_row = n # 시작 위치 행
            start_column = maze[n].index(2) # 시작 위치 열

#    dx = [0, 0, -1, 1] # 수학의 x, y 좌표와 행과 열의 x, y는 다르기 때문에 이는 상하좌우가 아니라 좌우상하를 의미함
#    dy = [-1, 1, 0, 0] # 수학의 x, y 좌표와 행과 열의 x, y는 다르기 때문에 이는 상하좌우가 아니라 좌우상하를 의미함
    dx = [-1, 1, 0, 0] # 상하좌우
    dy = [0, 0, -1, 1] # 상하좌우

    stack = []
    result = 0

    stack.append([start_row, start_column])

    while stack:
        x, y = stack.pop()
        maze[x][y] = 1

        for d in range(len(dx)):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx <= N - 1 and 0 <= ny <= N - 1:
                if maze[nx][ny] == 0:
                    stack.append([nx, ny])
                elif maze[nx][ny] == 1:
                    continue
                elif maze[nx][ny] == 3:
                    result = 1
                    break
            else:
                continue

    print("#%d" % t, result)
