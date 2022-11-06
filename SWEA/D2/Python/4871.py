"""
4871. [파이썬 S/W 문제해결 기본] 4일차 - 그래프 경로

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    V개 이내의 노드를 E개의 간선으로 연결한 방향성 그래프에 대한 정보가 주어질 때, 특정한 두 개의 노드에 경로가 존재하는지 확인하는 프로그램을 만드시오.
    두 개의 노드에 대해 경로가 있으면 1, 없으면 0을 출력한다.
    예를 들어 다음과 같은 그래프에서 1에서 6으로 가는 경로를 찾는 경우, 경로가 존재하므로 1을 출력한다.
        [그림은 SW Expert Academy에서 참고]

    노드번호는 1번부터 존재하며, V개의 노드 중에는 간선으로 연결되지 않은 경우도 있을 수 있다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1≤T≤50
        다음 줄부터 테스트 케이스의 첫 줄에 V와 E가 주어진다. 5≤V≤50, 4≤E≤1000
        테스트케이스의 둘째 줄부터 E개의 줄에 걸쳐, 출발 도착 노드로 간선 정보가 주어진다.
        E개의 줄 이후에는 경로의 존재를 확인할 출발 노드 S와 도착노드 G가 주어진다.

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 답을 출력한다.


    입력
        3
        6 5
        1 4
        1 3
        2 3
        2 5
        4 6
        1 6
        7 4
        1 6
        2 3
        2 6
        3 5
        2 5
        9 9
        2 6
        4 7
        5 7
        1 5
        2 9
        3 9
        4 8
        5 3
        7 8
        1 9

    출력
        #1 1
        #2 1
        #3 1
"""


# stack의 pop을 이용해서 다시 풀어 보기


# 실행 시간 : 0.13626s

T = int(input())

for t in range(1, T + 1):
    V, E = map(int, input().split())

    """
    N = [0] * E
    L = [0] * E
    
    for e in range(E):
        N[e], L[e] = map(int, input().split())

    S, G = map(int, input().split())

    # 세 번째(마지막) 테스트 케이스 결과가 다르다.  # 연결된 간선 중 하나만 확인할 수 있다.    
    while True:
        if S in N:
            print(L[N.index(S)])
            if L[N.index(S)]:
                S = L[N.index(S)]

                if S == G:
                    result = 1
                    break
            else:
                result = 0
                break
        else:
            result = 0
            break
            
    print("#%d" % t, result)
    """

#    graph = [[0] * (V + 1) for _ in range(V + 1)] # 밑의 코드와 다른 결과  # graph[0][0] = 1을 하면 graph[x][0] 모두 1이 된다.
    graph = [[] * (V + 1) for _ in range(V + 1)]

    for e in range(E):
        N, L = map(int, input().split())

        graph[N].append(L)

    S, G = map(int, input().split())

    visited = [False] * (V + 1)

    def DFS(s, g):
        visited[s] = True

        for i in graph[s]:
            if not visited[i]:
                DFS(i, g)

        return visited[g]

    if DFS(S, G):
        print("#%d" % t, 1)
    else:
        print("#%d" % t, 0)
