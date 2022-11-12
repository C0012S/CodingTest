"""
5105. [파이썬 S/W 문제해결 기본] 6일차 - 미로의 거리

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    NxN 크기의 미로에서 출발지 목적지가 주어진다.
    이때 최소 몇 개의 칸을 지나면 출발지에서 도착지에 다다를 수 있는지 알아내는 프로그램을 작성하시오.
    경로가 있는 경우 출발에서 도착까지 가는데 지나야 하는 최소한의 칸 수를, 경로가 없는 경우 0을 출력한다.
    다음은 5x5 미로의 예이다. 1은 벽, 0은 통로를 나타내며 미로 밖으로 벗어나서는 안된다.
        13101
        10101
        10101
        10101
        10021

    마지막 줄의 2에서 출발해서 0인 통로를 따라 이동하면 맨 윗줄의 3에 5개의 칸을 지나 도착할 수 있다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1<=T<=50
        다음 줄부터 테스트 케이스의 별로 미로의 크기 N과 N개의 줄에 걸쳐 미로의 통로와 벽에 대한 정보가 주어진다. 5<=N<=100
        0은 통로, 1은 벽, 2는 출발, 3은 도착이다.

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 답을 출력한다.


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
        #1 5
        #2 5
        #3 0
"""


# 실행 시간 : 0.27819s
# Pass

import queue


def escape(escape_maze):
    que = queue.Queue()
    distance = [[0] * N for _ in range(N)]
    result = 0

    que.put([start_row, start_column])
    while que:
        x, y = que.get()

        for d in range(len(dx)):
            mx = x + dx[d]
            my = y + dy[d]

            if mx < 0 or mx > len(escape_maze) - 1 or my < 0 or my > len(escape_maze) - 1:
                continue

            if escape_maze[mx][my] == 0:
                escape_maze[mx][my] = 1
                que.put([mx, my])
                distance[mx][my] = distance[x][y] + 1
            elif escape_maze[mx][my] == 1:
                continue
            elif escape_maze[mx][my] == 3:
                result = distance[x][y]
                return result

        if que.empty():
            return result


T = int(input())

for t in range(1, T + 1):
    N = int(input())

    maze = [[0] * N for _ in range(N)]

    for n in range(N):
        maze[n] = list(map(int, input()))

        if 2 in maze[n]:
            start_row = n
            start_column = maze[n].index(2)

    dx = [-1, 1, 0, 0] # 상하좌우
    dy = [0, 0, -1, 1] # 상하좌우

    print("#%d" % t, escape(maze))
