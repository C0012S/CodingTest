"""
4831. [파이썬 S/W 문제해결 기본] 1일차 - 전기버스

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    A도시는 전기버스를 운행하려고 한다. 전기버스는 한번 충전으로 이동할 수 있는 정류장 수가 정해져 있어서, 중간에 충전기가 설치된 정류장을 만들기로 했다.
    버스는 0번에서 출발해 종점인 N번 정류장까지 이동하고, 한번 충전으로 최대한 이동할 수 있는 정류장 수 K가 정해져 있다.
    충전기가 설치된 M개의 정류장 번호가 주어질 때, 최소한 몇 번의 충전을 해야 종점에 도착할 수 있는지 출력하는 프로그램을 만드시오.
    만약 충전기 설치가 잘못되어 종점에 도착할 수 없는 경우는 0을 출력한다. 출발지에는 항상 충전기가 설치되어 있지만 충전횟수에는 포함하지 않는다.

    [예시]
        정류장     0   1   2   3   4   5   6   7   8   9   10
        충전기         ○      ○      ○       ○      ○
        충전 횟수               1      2        3

    다음은 K = 3, N = 10, M = 5, 충전기가 설치된 정류장이 1, 3, 5, 7, 9인 경우의 예이다.

    [입력]
        첫 줄에 노선 수 T가 주어진다.(1 ≤ T ≤ 50 )
        각 노선별로 K, N, M이 주어지고, 다음줄에 M개의 정류장 번호가 주어진다. ( 1 ≤ K, N, M ≤ 100 )

    [출력]
        #과 노선번호, 빈칸에 이어 최소 충전횟수 또는 0을 출력한다.


    입력
        3
        3 10 5
        1 3 5 7 9
        3 10 5
        1 3 7 8 9
        5 20 5
        4 7 9 14 17

    출력
        #1 3
        #2 0
        #3 4
"""


# 다른 방법으로도 풀어 보기

T = int(input())

for t in range(1, T + 1):
    K, N, M = map(int, input().split())
    station_charger = list(map(int, input().split()))

    station = [0] * (N + 1)

    """
    for n in range(N):
        print(n)
        for s in station_charger:
            if n == s:
                station[n] += 1
    """

    for s in station_charger:
        station[s] += 1

    cnt = 0
    start = 0
    end = K

    while end < N:
        zero = 0

        for mv in range(start + 1, end + 1):
            if station[mv] == 1:
                start = mv
            else:
                zero += 1

        if zero == K:
            cnt = 0
            break

        cnt += 1
        end = start + K

        if end >= N:
            break

    print("#%d" % t, cnt)
