"""
4869. [파이썬 S/W 문제해결 기본] 4일차 - 종이붙이기

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    어린이 알고리즘 교실의 선생님은 경우의 수 놀이를 위해, 그림처럼 가로x세로 길이가 10x20, 20x20인 직사각형 종이를 잔뜩 준비했다.
        [그림은 SW Expert Academy에서 참고]

    그리고 교실 바닥에 20xN 크기의 직사각형을 테이프로 표시하고, 이 안에 준비한 종이를 빈틈없이 붙이는 방법을 찾아보려고 한다. N이 30인 경우 다음 그림처럼 종이를 붙일 수 있다.
        [그림은 SW Expert Academy에서 참고]

    10의 배수인 N이 주어졌을 때, 종이를 붙이는 모든 경우를 찾으려면 테이프로 만든 표시한 영역을 몇 개나 만들어야 되는지 계산하는 프로그램을 만드시오. 직사각형 종이가 모자라는 경우는 없다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1≤T≤50
        다음 줄부터 테스트 케이스 별로 N이 주어진다. 10≤N≤300, N은 10의 배수

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 답을 출력한다.


    입력
        3
        30
        50
        70

    출력
        #1 5
        #2 21
        #3 85
"""


# 점화식 : attach_paper(n - 1) + 2 * attach_paper(n - 2) (n > 2일 경우, n = N // 10)
# attach_paper(1) = 1, attach_paper(2) = 3, attach_paper(3) = 5(= 3 + 2 * 1), attach_paper(4) = 11(= 5 + 2 * 3), attach_paper(5) = 21(= 11 + 2 * 5)

# 실행 시간 : 0.12932s

T = int(input()) # 1 <= T <=50

for t in range(1, T + 1):
    N = int(input()) # 10 <= N <= 300 # N은 10의 배수

    attached_paper = [0] * (N // 10)
    attached_paper[0] = 1
    attached_paper[1] = 3

    for n in range(2, N // 10):
        attached_paper[n] = attached_paper[n - 1] + 2 * attached_paper[n - 2]

    print("#%d" % t, attached_paper[(N // 10) - 1])
