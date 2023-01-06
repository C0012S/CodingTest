"""
장애물 인식 프로그램

    언어별 시간/메모리
        언어	시간	메모리
        C	1초	128MB
        C++	1초	128MB
        Java	2초	128MB
        Python	2초	128MB
        Javascript	2초	128MB


    문제
        자율주행팀 SW 엔지니어인 당신에게 장애물과 도로를 인식할 수 있는 프로그램을 만들라는 업무가 주어졌다.
            [그림은 Softeer에서 참고]
                [그림 1] 지도 예시

        우선 [그림 1]과 같이 정사각형 모양의 지도가 있다. 1은 장애물이 있는 곳을, 0은 도로가 있는 곳을 나타낸다.

        당신은 이 지도를 가지고 연결된 장애물들의 모임인 블록을 정의하고, 불록에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 장애물이 좌우, 혹은 아래위로 붙어 있는 경우를 말한다. 대각선 상에 장애물이 있는 경우는 연결된 것이 아니다.
            [그림은 Softeer에서 참고]
                [그림 2] 블록 별 번호 부여

        [그림 2]는 [그림 1]을 블록 별로 번호를 붙인 것이다.

        지도를 입력하여 장애물 블록수를 출력하고, 각 블록에 속하는 장애물의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.


    제약조건
        N은 정사각형임으로 가로와 세로의 크기는 같으며 5 ≤ N ≤ 25


    입력형식
        입력 값의 첫 번째 줄에는 지도의 크기 N이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.


    출력형식
        첫 번째 줄에는 총 블록 수를 출력 하시오.
        그리고 각 블록 내 장애물의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.


    입력예제1
        7
        1110111
        0110101
        0110101
        0000100
        0110000
        0111110
        0110000


    출력예제1
        3
        7
        8
        9
"""


# 실행 시간 : 110ms
# 메모리 : 37.52Mb

def find_barrier(array):
    stack = []
    visited = [[False] * N for _ in range(N)]
    block_count = 0
    block_nums = [0] * (N * N)

    # 수학적 그래프 (x, y)로 설정
    dx = [0, 0, 1, -1] # 하상우좌
    dy = [1, -1, 0, 0] # 하상우좌

    for r in range(N):
        for c in range(N):
            if array[c][r] == 1 and not visited[c][r]:
                stack.append([c, r])
                block_count += 1

            while stack:
                location = stack.pop(-1)
#                print("위치", location)
                x = location[0]
                y = location[1]
                if not visited[x][y]:
                    block_nums[block_count - 1] += 1
                visited[x][y] = True
#                print(block_count)

                for d in range(len(dx)):
                    nx = x + dx[d]
                    ny = y + dy[d]

                    if 0 <= nx <= N - 1 and 0 <= ny <= N - 1 and not visited[nx][ny]:
                        if array[nx][ny] == 1:
#                            print("추가", nx, ny)
                            stack.append([nx, ny])

    block_nums = block_nums[0:block_count]
    print(block_count)
    block_nums.sort()
    for bn in range(block_count):
        print(block_nums[bn])


N = int(input())

square = [[0] * N for _ in range(N)]

for n in range(N):
    square[n] = list(map(int, input()))

find_barrier(square)
