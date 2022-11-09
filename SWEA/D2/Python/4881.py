"""
4881. [파이썬 S/W 문제해결 기본] 5일차 - 배열 최소 합

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    NxN 배열에 숫자가 들어있다. 한 줄에서 하나씩 N개의 숫자를 골라 합이 최소가 되도록 하려고 한다. 단, 세로로 같은 줄에서 두 개 이상의 숫자를 고를 수 없다.
    조건에 맞게 숫자를 골랐을 때의 최소 합을 출력하는 프로그램을 만드시오.
    예를 들어 다음과 같이 배열이 주어진다.
        2   (1)  2
        (5)  8   5
        7    2  (2)

    이경우 1, 5, 2를 고르면 합이 8로 최소가 된다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1≤T≤50
        다음 줄부터 테스트 케이스의 첫 줄에 숫자 N이 주어지고, 이후 N개씩 N줄에 걸쳐 10보다 작은 자연수가 주어진다. 3≤N≤10

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 합계를 출력한다.


    입력
        3
        3
        2 1 2
        5 8 5
        7 2 2
        3
        9 4 7
        8 6 5
        5 3 7
        5
        5 2 1 1 9
        3 3 8 3 1
        9 2 8 8 6
        1 5 7 8 3
        5 5 4 6 8

    출력
        #1 8
        #2 14
        #3 9
"""


# 실행 시간 : 0.13103s

# 연속으로 세로로 같은 줄에서 숫자를 못 고르는 게 아니라, 세로로 같은 줄에서 두 개 이상의 숫자를 고를 수 없다.

def subset_sum(index, now_sum):
    """
    # 연속으로 세로로 같은 줄에서 숫자를 못 고르는 문제로 잘못 이해해서 작성 중이던 코드
    result = 0

    stack = []

    # min_sum <= now_sum
    min_sum = min(min_sum, now_sum)

    while stack:
        x = stack.pop()

        for nn in range(N ** N):
            if not visited[nn] and x % N == nn % N:
                stack.append(square[nn])
                visited[nn] = True
            else:
                continue
    """

    global min_sum # 전역 변수 사용

    if index == N:
        if now_sum < min_sum:
            min_sum = now_sum
        return min_sum

    if min_sum <= now_sum:
        return min_sum

    for r in range(N):
        if not visited[r]:
            visited[r] = True
            subset_sum(index + 1, now_sum + square[index][r])
            visited[r] = False

    return min_sum


T = int(input())

for t in range(1, T + 1):
    N = int(input())

    square = [[0] * N for _ in range(N)]
    for n in range(N):
        square[n] = list(map(int, input().split()))

    visited = [False] * N
    min_sum = 100 # 최솟값을 구하기 위해 임의의 큰 수로 설정

    print("#%d" % t, subset_sum(0, 0))
