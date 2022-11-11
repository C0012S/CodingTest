"""
4861. [파이썬 S/W 문제해결 기본] 3일차 - 회문

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    ABBA처럼 어느 방향에서 읽어도 같은 문자열을 회문이라 한다. NxN 크기의 글자판에서 길이가 M인 회문을 찾아 출력하는 프로그램을 만드시오.
    회문은 1개가 존재하는데, 가로 뿐만 아니라 세로로 찾아질 수도 있다.
    예를 들어 N=10, M=10 일 때, 다음과 같이 회문을 찾을 수 있다.
            G   O   F   F   A   K   W   F   S   M
            O   Y   E   C   R   S   L   D   L   Q
            U   J   A   J   Q   V   S   Y   Y   C
          [ J   A   E   Z   N   N   Z   E   A   J ]
            W   J   A   K   C   G   S   G   C   F
            Q   K   U   D   G   A   T   D   Q   L
            Q   K   G   P   F   P   Y   R   K   Q
            T   D   C   X   B   M   Q   T   I   O
            U   N   A   D   R   P   N   E   T   Z
            Z   A   T   W   D   E   K   D   Q   F

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1≤T≤50
        다음 줄부터 테스트케이스의 첫 줄에 N과 M이 주어진다. 10≤N≤100, 5≤M≤N
        다음 줄부터 N개의 글자를 가진 N개의 줄이 주어진다.

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 답을 출력한다.


    입력
        3
        10 10
        GOFFAKWFSM
        OYECRSLDLQ
        UJAJQVSYYC
        JAEZNNZEAJ
        WJAKCGSGCF
        QKUDGATDQL
        OKGPFPYRKQ
        TDCXBMQTIO
        UNADRPNETZ
        ZATWDEKDQF
        10 10
        WPMACSIBIK
        STWASDCOBQ
        AMOUENCSOG
        XTIIGBLRCZ
        WXVSWXYYVU
        CJVAHRZZEM
        NDIEBIIMTX
        UOOGPQCBIW
        OWWATKUEUY
        FTMERSSANL
        20 13
        ECFQBKSYBBOSZQSFBXKI
        VBOAIDLYEXYMNGLLIOPP
        AIZMTVJBZAWSJEIGAKWB
        CABLQKMRFNBINNZSOGNT
        NQLMHYUMBOCSZWIOBINM
        QJZQPSOMNQELBPLVXNRN
        RHMDWPBHDAMWROUFTPYH
        FNERUGIFZNLJSSATGFHF
        TUIAXPMHFKDLQLNYQBPW
        OPIRADJURRDLTDKZGOGA
        JHYXHBQTLMMHOOOHMMLT
        XXCNJGTXXKUCVOUYNXZR
        RMWTQQFHZUIGCJBASNOX
        CVODFKWMJSGMFTCSLLWO
        EJISQCXLNQHEIXXZSGKG
        KGVFJLNNBTVXJLFXPOZA
        YUNDJDSSOPRVSLLHGKGZ
        OZVTWRYWRFIAIPEYRFFG
        ERAPUWPSHHKSWCTBAPXR
        FIKQJTQDYLGMMWMEGRUZ

    출력
        #1 JAEZNNZEAJ
        #2 MWOIVVIOWM
        #3 TLMMHOOOHMMLT
"""


# 다시 풀어 봐야 한다.
# 세로로도 회문을 찾을 수 있다는 걸 고려해야 한다.
# Runtime error  Error Message: Memory error occured, (e.g. segmentation error, memory limit Exceed, stack overflow,... etc)


T = int(input())

for t in range(1, T + 1):
    N, M = map(int, input().split())

    square = [[0] * N for _ in range(N)]
    result = []

    for n in range(N):
        square[n] = list(input())

        cnt = 0
        for c in range(N):
            if cnt == 0:
                if square[n][c] == square[n][M + c - 1]: # 회문 아닌 문장을 넣었을 경우 오류 발생
                    cnt += 1
                    first_index = c
                else:
                    cnt = 0
            elif cnt > 0:
                if square[n][c] == square[n][M + first_index - cnt - 1]:
                    cnt += 1
                else:
                    cnt = 0
            elif c < N - M + 1:
                cnt = 0

            if cnt == M // 2:
                result = square[n][first_index:first_index + M]
                break

    print("#%d" % t, "".join(result))
