"""
5099. [파이썬 S/W 문제해결 기본] 6일차 - 피자 굽기

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    N개의 피자를 동시에 구울 수 있는 화덕이 있다. 피자는 치즈가 모두 녹으면 화덕에서 꺼내며, 치즈의 양은 피자마다 다르다.
    1번부터 M번까지 M개의 피자를 순서대로 화덕에 넣을 때, 치즈의 양에 따라 녹는 시간이 다르기 때문에 꺼내지는 순서는 바뀔 수 있다.
    주어진 조건에 따라 피자를 구울 때, 화덕에 가장 마지막까지 남아있는 피자 번호를 알아내는 프로그램을 작성하시오.

        [그림은 SW Expert Academy에서 참고]
            - 피자는 1번위치에서 넣거나 뺄 수 있다.
            - 화덕 내부의 피자받침은 천천히 회전해서 1번에서 잠시 꺼내 치즈를 확인하고 다시 같은 자리에 넣을 수 있다.
            - M개의 피자에 처음 뿌려진 치즈의 양이 주어지고, 화덕을 한 바퀴 돌 때 녹지않은 치즈의 양은 반으로 줄어든다. 이전 치즈의 양을 C라고 하면 다시 꺼냈을 때 C//2로 줄어든다.
            - 치즈가 모두 녹아 0이 되면 화덕에서 꺼내고, 바로 그 자리에 남은 피자를 순서대로 넣는다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1<=T<=50
        다음 줄부터 테스트 케이스의 첫 줄에 화덕의 크기 N과 피자 개수 M이 주어지고, 다음 줄에 M개의 피자에 뿌려진 치즈의 양을 나타내는 Ci가 주어진다.
        3<=N<=20, N<=M<=100, 1<=Ci<=20

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 번호를 출력한다.


    입력
        3
        3 5
        7 2 6 5 3
        5 10
        5 9 3 9 9 2 5 8 7 1
        5 10
        20 4 5 7 3 15 2 1 2 2

    출력
        #1 4
        #2 8
        #3 6
"""


# 다시 풀어 보고 복습하기


# 실행 시간 : 0.19344s
# Pass

from collections import deque


def last_pizza(cheeze):
    oven = deque()

    for n in range(N):
        oven.append(cheeze[0])
        cheeze.pop(0)

    while len(oven) > 1:
        if len(oven) < N and cheeze:
            oven.append(cheeze[0])
            cheeze.pop(0)

        num, pizza_cheeze = oven.popleft()

        if pizza_cheeze // 2 == 0:
            continue
        else:
            oven.append((num, pizza_cheeze // 2))

    return oven[0][0]
#    return oven.popleft()[0]


T = int(input())

for t in range(1, T + 1):
    N, M = map(int, input().split())
    Ci = list(enumerate(list(map(int, input().split())), 1))

    print("#%d" % t, last_pizza(Ci))
