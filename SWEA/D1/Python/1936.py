"""
1936. 1대1 가위바위보

    · 시간 : 1개 테스트케이스를 합쳐서 C++의 경우 1초 / Java의 경우 2초 / Python의 경우 4초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    A와 B가 가위바위보를 하였다.
    가위는 1, 바위는 2, 보는 3으로 표현되며 A와 B가 무엇을 냈는지 입력으로 주어진다.
    A와 B중에 누가 이겼는지 판별해보자.단, 비기는 경우는 없다.

    [입력]
        입력으로 A와 B가 무엇을 냈는지 빈 칸을 사이로 주어진다.

    [출력]
        A가 이기면 A, B가 이기면 B를 출력한다.


    입력
        3 2

    출력
        A
"""


a, b = map(int, input().split(' '))

if a == 1:
    if b == 2:
        print("B")
    elif b == 3:
        print("A")
elif a == 2:
    if b == 1:
        print("A")
    elif b == 3:
        print("B")
elif a == 3:
    if b == 1:
        print("B")
    elif b == 2:
        print("A")
