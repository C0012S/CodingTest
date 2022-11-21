"""
5102. [파이썬 S/W 문제해결 기본] 6일차 - 노드의 거리

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    V개의 노드 개수와 방향성이 없는 E개의 간선 정보가 주어진다.
    주어진 출발 노드에서 최소 몇 개의 간선을 지나면 도착 노드에 갈 수 있는지 알아내는 프로그램을 만드시오.
    예를 들어 다음과 같은 그래프에서 1에서 6으로 가는 경우, 두 개의 간선을 지나면 되므로 2를 출력한다.
        [그림은 SW Expert Academy에서 참고]

    노드 번호는 1번부터 존재하며, 노드 중에는 간선으로 연결되지 않은 경우도 있을 수 있다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1<=T<=50
        다음 줄부터 테스트 케이스의 첫 줄에 V와 E가 주어진다. 5<=V=50, 4<=E<=1000
        테스트케이스의 둘째 줄부터 E개의 줄에 걸쳐, 간선의 양쪽 노드 번호가 주어진다.
        E개의 줄 이후에는 출발 노드 S와 도착 노드 G가 주어진다.

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 답을 출력한다.
        두 노드 S와 G가 서로 연결되어 있지 않다면, 0을 출력한다.


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
        1 5
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
        #1 2
        #2 4
        #3 3
"""


# 다시 풀어 봐야 한다.


# 실행 시간 : 0.15791s
# 오답 : 10개의 테스트케이스 중 9개가 맞았습니다.

from collections import deque


def arrive_node(start_graph):
    visited = [False] * (V + 1)
    distance = [1000] * (V + 1)

    graph_queue = deque()
    graph_queue.append(S)
    distance[S] = 0

    while graph_queue:
        now_node = graph_queue.popleft()

        if visited[now_node] == False:
            for ll in range(len(start_graph[now_node])):
                graph_queue.append(start_graph[now_node][ll])

            visited[now_node] = True

            if start_graph[now_node]:
                for nn in range(len(start_graph[now_node])):
                    distance[start_graph[now_node][nn]] = min(distance[now_node] + 1, distance[start_graph[now_node][nn]])

        else:
            continue

    return distance[G]


T = int(input())

for t in range(1, T + 1):
    V, E = map(int, input().split())

    graph = [[] * (V + 1) for _ in range(V + 1)]
    for e in range(E):
        node, line = map(int, input().split())
        graph[node].append(line)
        graph[line].append(node)

    S, G = map(int, input().split())

    print("#%d" % t, arrive_node(graph))
