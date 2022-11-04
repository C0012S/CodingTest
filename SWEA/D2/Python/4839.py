"""
4839. [파이썬 S/W 문제해결 기본] 2일차 - 이진탐색

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    코딩반 학생들에게 이진 탐색을 설명하던 선생님은 이진탐색을 연습할 수 있는 게임을 시켜 보기로 했다.
    짝을 이룬 A, B 두 사람에게 교과서에서 각자 찾을 쪽 번호를 알려주면, 이진 탐색만으로 지정된 페이지를 먼저 펼치는 사람이 이기는 게임이다.
    예를 들어 책이 총 400쪽이면, 검색 구간의 왼쪽 l=1, 오른쪽 r=400이 되고, 중간 페이지 c= int((l+r)/2)로 계산한다.
    찾는 쪽 번호가 c와 같아지면 탐색을 끝낸다.
    A는 300, B는 50 쪽을 찾아야 하는 경우, 다음처럼 중간 페이지를 기준으로 왼쪽 또는 오른 쪽 영역의 중간 페이지를 다시 찾아가면 된다.
                                A                              B
        첫 번째 탐색    l = 1, r = 400, c = 200        l = 1, r = 400, c = 200
        두 번째 탐색    l = 200, r = 400, c = 300      l = 1, r = 200, c = 100
        세 번째 탐색                                   l = 1, r = 100, c = 50

    책의 전체 쪽수와 두 사람이 찾을 쪽 번호가 주어졌을 때, 이진 탐색 게임에서 이긴 사람이 누구인지 알아내 출력하시오. 비긴 경우는 0을 출력한다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1<=T<=50
        테스트 케이스 별로 책의 전체 쪽 수 P, A, B가 찾을 쪽 번호 Pa, Pb가 차례로 주어진다. 1<= P, Pa, Pb <=1000

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, A, B, 0 중 하나를 출력한다.


    입력
        3
        400 300 350
        1000 299 578
        1000 222 888

    출력
        #1 A
        #2 0
        #3 A
"""


T = int(input())

for t in range(1, T + 1):
    P, Pa, Pb = map(int, input().split())

    start_a = 1
    start_b = 1
    end_a = P
    end_b = P
    count_a = 0
    count_b = 0

    for p in range(P):
        middle_a = (start_a + end_a) // 2

        if Pa < middle_a:
            end_a = middle_a
        elif Pa > middle_a:
            start_a = middle_a
        elif Pa == middle_a:
            count_a += 1
            break

        count_a += 1

    for q in range(P):
        middle_b = (start_b + end_b) // 2

        if Pb < middle_b:
            end_b = middle_b
        elif Pb > middle_b:
            start_b = middle_b
        elif Pb == middle_b:
            count_b += 1
            break

        count_b += 1

    if count_a < count_b:
        print("#%d" % t, "A")
    elif count_a > count_b:
        print("#%d" % t, "B")
    elif count_a == count_b:
        print("#%d" % t, "0")
