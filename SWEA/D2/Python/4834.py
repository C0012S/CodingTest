"""
4834. [파이썬 S/W 문제해결 기본] 1일차 - 숫자카드

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    0에서 9까지 숫자가 적힌 N장의 카드가 주어진다.
    가장 많은 카드에 적힌 숫자와 카드가 몇 장인지 출력하는 프로그램을 만드시오. 카드 장수가 같을 때는 적힌 숫자가 큰 쪽을 출력한다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  ( 1 ≤ T ≤ 50 )
        다음 줄부터 테스트케이스의 첫 줄에 카드 장수 N이 주어진다. ( 5 ≤ N ≤ 100 )
        다음 줄에 N개의 숫자 ai가 여백없이 주어진다. (0으로 시작할 수도 있다.)  ( 0 ≤ ai ≤ 9 )

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 가장 많은 카드의 숫자와 장 수를 차례로 출력한다.


    입력
        3
        5
        49679
        5
        08271
        10
        7797946543

    출력
        #1 9 2
        #2 8 1
        #3 7 3
"""


T = int(input())

for t in range(1, T + 1):
    N = int(input())
    aj = list(map(int, input()))

    card_count = [0] * 10

    for a in aj:
        card_count[a] += 1

    max_count = card_count[0]
    max_count_number = 0

    for c in range(1, len(card_count)):
        max_count = max(max_count, card_count[c])

        if max_count == card_count[c]:
            max_count_number = c

    print("#%d" % t, max_count_number, max_count)
