"""
1545. 거꾸로 출력해 보아요

    · 시간 : 1개 테스트케이스를 합쳐서 C++의 경우 1초 / Java의 경우 2초 / Python의 경우 4초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    주어진 숫자부터 0까지 순서대로 찍어보세요
    아래는 입력된 숫자가 N일 때 거꾸로 출력하는 예시입니다
        n  n - 1  n - 2  0


    입력
        8

    출력
        8 7 6 5 4 3 2 1 0
"""


n = int(input())

for i in range(0, n + 1):
    print(n - i, end = ' ')
