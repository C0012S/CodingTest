"""
4843. [파이썬 S/W 문제해결 기본] 2일차 - 특별한 정렬

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    보통의 정렬은 오름차순이나 내림차순으로 이루어지지만, 이번에는 특별한 정렬을 하려고 한다.
    N개의 정수가 주어지면 가장 큰 수, 가장 작은 수, 2번째 큰 수, 2번째 작은 수 식으로 큰 수와 작은 수를 번갈아 정렬하는 방법이다.
    예를 들어 1부터 10까지 10개의 숫자가 주어지면 다음과 같이 정렬한다.
        10 1 9 2 8 3 7 4 6 5

    주어진 숫자에 대해 특별한 정렬을 한 결과를 10개까지 출력하시오

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1<=T<=50
        다음 줄에 정수의 개수 N이 주어지고 다음 줄에 N개의 정수 ai가 주어진다. 10<=N<=100, 1<=ai<=100

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 특별히 정렬된 숫자를 10개까지 출력한다.


    입력
        3
        10
        1 2 3 4 5 6 7 8 9 10
        10
        67 39 16 49 60 28 8 85 89 11
        20
        3 69 21 46 43 60 62 97 64 30 17 88 18 98 71 75 59 36 9 26

    출력
        #1 10 1 9 2 8 3 7 4 6 5
        #2 89 8 85 11 67 16 60 28 49 39
        #3 98 3 97 9 88 17 75 18 71 21
"""


# 실행이 완료되었습니다. 실행 시간 : 0.12473s

T = int(input())

for t in range(1, T + 1):
    N = int(input())
    ai = list(map(int, input().split()))

    sort_ai = sorted(ai)
    special_sort_ai = [0] * N

    for n in range(N):
        if n % 2 != 0:
            special_sort_ai[n] = sort_ai[(n - 1) // 2]

        elif n % 2 == 0:
            special_sort_ai[n] = sort_ai[N - 1 - (n // 2)]

    result = [0] * 10
    for i in range(10):
        result[i] = str(special_sort_ai[i])

    print("#%d" % t, " ".join(result))
