"""
1959. 두 개의 숫자열

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    N 개의 숫자로 구성된 숫자열 Ai (i=1~N) 와 M 개의 숫자로 구성된 숫자열 Bj (j=1~M) 가 있다.
    아래는 N =3 인 Ai 와 M = 5 인 Bj 의 예이다.
        Ai = 1  5   3
        Bj = 3  6  -7  5  4

    Ai 나 Bj 를 자유롭게 움직여서 숫자들이 서로 마주보는 위치를 변경할 수 있다.
    단, 더 긴 쪽의 양끝을 벗어나서는 안 된다.
        Ai =    1   5  3
        Bj = 3  6  -7  5  4

    서로 마주보는 숫자들을 곱한 뒤 모두 더할 때 최댓값을 구하라.
    위 예제의 정답은 아래와 같이 30 이 된다.
        Ai =        1   5   3
                    ×   ×   ×
        Bj = 3  6  -7   5   4
                   -7   25  12  →  30

    [제약 사항]
        N 과 M은 3 이상 20 이하이다.

    [입력]
        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,
        두 번째 줄에는 Ai,
        세 번째 줄에는 Bj 가 주어진다.

    [출력]
        출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)


    입력
        10
        3 5
        1 5 3
        3 6 -7 5 4
        7 6
        6 0 5 5 -1 1 6
        -4 1 8 7 -9 3
        ...

    출력
        #1 30
        #2 63
        ...
"""


# 실행 시간 : 0.12851s
# Pass

def find_max(first, second):
    if N > M: # 첫 번째 숫자열의 길이가 두 번째 숫자열의 길이보다 긴 경우 고려
        first, second = second, first

    max_num_sum = 0

    for g in range(abs(M - N) + 1):
        num_sum = 0

        for f in range(len(first)):
            num_sum += first[f] * second[g + f]

        max_num_sum = max(max_num_sum, num_sum)

    return max_num_sum


T = int(input())

for t in range(1, T + 1):
    N, M = map(int, input().split())

    Ai = list(map(int, input().split()))
    Bj = list(map(int, input().split()))

    print("#%d" % t, find_max(Ai, Bj))
