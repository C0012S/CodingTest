"""
4864. [파이썬 S/W 문제해결 기본] 3일차 - 문자열 비교

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    두 개의 문자열 str1과 str2가 주어진다. 문자열 str2 안에 str1과 일치하는 부분이 있는지 찾는 프로그램을 만드시오.
    예를 들어 두 개의 문자열이 다음과 같이 주어질 때, 첫 문자열이 두번째에 존재하면 1, 존재하지 않으면 0을 출력한다.
        ABC
        ZZZZZABCZZZZZ
            두번째 문자열에 첫번째 문자열과 일치하는 부분이 있으므로 1을 출력.

        ABC
        ZZZZAZBCZZZZZ
            문자열이 일치하지 않으므로 0을 출력.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  (1≤T≤50)
        다음 줄부터 테스트 케이스 별로 길이가 N인 문자열 str1과 길이가 M인 str2가 각각 다른 줄에 주어집니다. (5≤N≤100, 10≤M≤1000, N≤M)

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 답을 출력한다.


    입력
        3
        XYPV
        EOGGXYPVSY
        STJJ
        HOFSTJPVPP
        ZYJZXZTIBSDG
        TTXGZYJZXZTIBSDGWQLW

    출력
        #1 1
        #2 0
        #3 1
"""


# 실행 시간 : 0.13128s

def BruteForce(s1, s2):
    i = 0 # s1의 인덱스  # s1 : 찾을 문자열
    j = 0 # s2의 인덱스  # s2 : 전체 문자열

    while i < N and j < M:
        if s1[i] != s2[j]:
            j = j - i
            i = -1
        j = j + 1
        i = i + 1

    if i == N:
        return 1 # 두 번째 문자열에 첫 번째 문자열과 일치하는 부분 있음
    else:
        return 0 # 두 번째 문자열에 첫 번째 문자열과 일치하는 부분 없음


T = int(input())

for t in range(1, T + 1):
    str1 = input() # 찾을 문자열
    str2 = input() # 전체 문자열

    N = len(str1)
    M = len(str2)

    print("#%d" % t, BruteForce(str1, str2))
