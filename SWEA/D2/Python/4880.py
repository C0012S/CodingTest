"""
4880. [파이썬 S/W 문제해결 기본] 5일차 - 토너먼트 카드게임

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    사다리 게임이 지겨워진 알고리즘 반 학생들이 새로운 게임을 만들었다. 가위바위보가 그려진 카드를 이용해 토너먼트로 한 명을 뽑는 것이다. 게임 룰은 다음과 같다.
    1번부터 N번까지 N명의 학생이 N장의 카드를 나눠 갖는다. 전체를 두 개의 그룹으로 나누고, 그룹의 승자끼리 카드를 비교해서 이긴 사람이 최종 승자가 된다.
    그룹의 승자는 그룹 내부를 다시 두 그룹으로 나눠 뽑는데, i번부터 j번까지 속한 그룹은 파이썬 연산으로 다음처럼 두개로 나눈다.
        (i + j) // 2 | (i + j) // 2 + 1
        [그림은 SW Expert Academy에서 참고]

    두 그룹이 각각 1명이 되면 양 쪽의 카드를 비교해 승자를 가리고, 다시 더 큰 그룹의 승자를 뽑는 방식이다.
    다음은 4명이 카드를 비교하는 경우로, 숫자 1은 가위, 2는 바위, 3은 보를 나타낸다. 만약 같은 카드인 경우 편의상 번호가 작은 쪽을 승자로 하고, 처음 선택한 카드는 바꾸지 않는다.
        [자세한 그림은 SW Expert Academy에서 참고]

    N명이 학생들이 카드를 골랐을 때 1등을 찾는 프로그램을 만드시오.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1≤T≤50
        다음 줄부터 테스트 케이스의 별로 인원수 N과 다음 줄에 N명이 고른 카드가 번호순으로 주어진다. 4≤N≤100
        카드의 숫자는 각각 1은 가위, 2는 바위, 3은 보를 나타낸다.

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 1등의 번호를 출력한다.


    입력
        3
        4
        1 3 2 1
        6
        2 1 1 2 3 3
        7
        1 3 3 3 1 1 3

    출력
        #1 3
        #2 5
        #3 1
"""


# 다시 풀어 봐야 한다.

def rock_scissors_paper_winner(p1, p2):
    if card[p1] == 1:
        if card[p2] == 1:
            if p1 < p2:
                winner = p1
            else:
                winner = p2
        elif card[p2] == 2:
            winner = p2
        elif card[p2] == 3:
            winner = p1
    elif card[p1] == 2:
        if card[p2] == 1:
            winner = p1
        elif card[p2] == 2:
            if p1 < p2:
                winner = p1
            else:
                winner = p2
        elif card[p2] == 3:
            winner = p2
    elif card[p1] == 3:
        if card[p2] == 1:
            winner = p2
        elif card[p2] == 2:
            winner = p1
        elif card[p2] == 3:
            if p1 < p2:
                winner = p1
            else:
                winner = p2

    return winner # 가위바위보 승리자


def group_winner(card_group):
    stack = []

    for cg in range(len(card_group)):
        stack.append(card_group[cg])

    while len(stack) > 1:
        a = stack.pop()
        b = stack.pop()

        """
        # 가위바위보 함수로 따로 작성 → rock_scissors_paper_winner(p1, p2)
        if card[a] == 1:
            if card[b] == 1:
                if a < b:
                    stack.append(a)
                else:
                    stack.append(b)
            elif card[b] == 2:
                stack.append(b)
            elif card[b] == 3:
                stack.append(a)
        elif card[a] == 2:
            if card[b] == 1:
                stack.append(a)
            elif card[b] == 2:
                if a < b:
                    stack.append(a)
                else:
                    stack.append(b)
            elif card[b] == 3:
                stack.append(b)
        elif card[a] == 3:
            if card[b] == 1:
                stack.append(b)
            elif card[b] == 2:
                stack.append(a)
            elif card[b] == 3:
                if a < b:
                    stack.append(a)
                else:
                    stack.append(b)
        """
        stack.append(rock_scissors_paper_winner(a, b))

    return stack[0] # 해당 그룹의 가위바위보 승리자


T = int(input()) # 1 <= T <= 50

for t in range(1, T + 1):
    N = int(input()) # 인원 수  # 4 <= N <= 100
    card = list(map(int, input().split())) # N 명이 고른 카드

#    card_left = card[0:(0 + N) // 2] # 이렇게 하면 카드를 가진 학생의 번호를 알 수 없다.
#    card_right = card[(0 + N) // 2 + 1:] # 이렇게 하면 카드를 가진 학생의 번호를 알 수 없다.
    card_left = []
    card_right = []

    """
    # 실행 시간 : 0.13005s
    # 오답 : 10개의 테스트케이스 중 4개가 맞았습니다.
    for cl in range(0, (0 + N) // 2):
        card_left.append(cl)
    for cr in range((0 + N) // 2, N):
        card_right.append(cr)
    """
    # 실행 시간 : 0.14349s
    # 오답 : 10개의 테스트케이스 중 4개가 맞았습니다.
    for cl in range(0, (1 + N) // 2):
        card_left.append(cl)
    for cr in range((1 + N) // 2, N):
        card_right.append(cr)

    left_group_winner = group_winner(card_left)
    right_group_winner = group_winner(card_right)

    print("#%d" % t, rock_scissors_paper_winner(left_group_winner, right_group_winner) + 1) # 번호는 1 번부터 시작하나 리스트의 인덱스는 0 부터이므로 1 을 더해 준다.
