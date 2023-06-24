"""
Lv. 2 - 미로 탈출

    문제 설명
        1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다. 따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.
        미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요. 만약, 탈출할 수 없다면 -1을 return 해주세요.


    제한사항
        · 5 ≤ maps의 길이 ≤ 100
            · 5 ≤ maps[i]의 길이 ≤ 100
            · maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
                · S : 시작 지점
                · E : 출구
                · L : 레버
                · O : 통로
                · X : 벽
            · 시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
            · 출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.


    입출력 예
        maps	                                    result
        ["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]	16
        ["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]	-1


    입출력 예 설명
        입출력 예 #1
            주어진 문자열은 다음과 같은 미로이며
                START   ○   ○   ○   LEVER
                ×       ×    ×   ×     ○
                ○      ○   ○   ○     ○
                ○      ×    ×    ×     ×
                ○      ○   ○   ○    EXIT

            다음과 같이 이동하면 가장 빠른 시간에 탈출할 수 있습니다.
                0   1   2   3   4
                ×   ×   ×   ×   5
                10  9   8   7   6
                11  ×   ×   ×   ×
                12  13  14  15  16

            4번 이동하여 레버를 당기고 출구까지 이동하면 총 16초의 시간이 걸립니다. 따라서 16을 반환합니다.

        입출력 예 #2
            주어진 문자열은 다음과 같은 미로입니다.
                LEVER   ○   ○   ×   START
                ○      ○   ○   ○     ×
                ○      ○   ○   ○     ○
                ○      ○   ○   ○     ○
                EXIT    ○   ○   ○     ○

            시작 지점에서 이동할 수 있는 공간이 없어서 탈출할 수 없습니다. 따라서 -1을 반환합니다.
"""


"""
    정확성  테스트
        테스트 1 〉	통과 (0.07ms, 10.4MB)
        테스트 2 〉	통과 (0.18ms, 10.3MB)
        테스트 3 〉	통과 (0.24ms, 10.3MB)
        테스트 4 〉	통과 (0.20ms, 10.3MB)
        테스트 5 〉	통과 (0.28ms, 10.4MB)
        테스트 6 〉	통과 (0.15ms, 10.1MB)
        테스트 7 〉	통과 (2.98ms, 10.3MB)
        테스트 8 〉	통과 (4.93ms, 10.4MB)
        테스트 9 〉	통과 (0.05ms, 10.3MB)
        테스트 10 〉	통과 (0.04ms, 10.2MB)
        테스트 11 〉	통과 (1.20ms, 10.4MB)
        테스트 12 〉	통과 (6.92ms, 10.3MB)
        테스트 13 〉	통과 (8.70ms, 10.3MB)
        테스트 14 〉	통과 (6.58ms, 10.2MB)
        테스트 15 〉	통과 (0.76ms, 10.5MB)
        테스트 16 〉	통과 (14.80ms, 10.3MB)
        테스트 17 〉	통과 (20.08ms, 10.5MB)
        테스트 18 〉	통과 (0.47ms, 10.3MB)
        테스트 19 〉	통과 (0.30ms, 10.1MB)
        테스트 20 〉	통과 (12.82ms, 10.3MB)
        테스트 21 〉	통과 (3.00ms, 10.3MB)
        테스트 22 〉	통과 (0.29ms, 10.3MB)
        테스트 23 〉	통과 (0.07ms, 10.3MB)
    
    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
"""
# 정답
# pop()이 아닌 popleft()를 사용해야 한다.

def findIndex(map): # 시작 지점, 출구, 레버가 있는 곳을 찾는 함수
    startIndex = [] # 시작 지점의 행의 인덱스와 시작 지점의 열의 인덱스를 저장할 리스트
    exitIndex = [] # 출구의 행의 인덱스와 출구의 열의 인덱스를 저장할 리스트
    leverIndex = [] # 레버가 있는 곳의 행의 인덱스와 레버가 있는 곳의 열의 인덱스를 저장할 리스트
    for i in range(len(map)):
        for j in range(len(map[i])):
            if map[i][j:j + 1] == "S":
                startIndex.append(i) # 시작 지점의 행의 인덱스
                startIndex.append(j) # 시작 지점의 열의 인덱스
            elif map[i][j:j + 1] == "E":
                exitIndex.append(i) # 출구의 행의 인덱스
                exitIndex.append(j) # 출구의 열의 인덱스
            elif map[i][j:j + 1] == "L":
                leverIndex.append(i) # 레버가 있는 곳의 행의 인덱스
                leverIndex.append(j) # 레버가 있는 곳의 열의 인덱스

    index = [startIndex, exitIndex, leverIndex]
    return index


def check(map, x, y): # 미로의 범위 안에 있는지 체크하는 함수
    if x < 0 or x >= len(map) or y < 0 or y >= len(map[0]):
        return False
    return True


def escape(map, startIndex, endIndex): # 출발 좌표부터 목표 좌표까지 가는 데 필요한 최소 시간을 계산하는 함수
    dx = [-1, 1, 0, 0] # 상, 하, 좌, 우
    dy = [0, 0, -1, 1] # 상, 하, 좌, 우

    isVisited = [[False] * len(map[0]) for _ in range(len(map))] # 방문 여부 기록

    queue = deque()
    queue.append([startIndex[0], startIndex[1], 0])
    isVisited[startIndex[0]][startIndex[1]] = True # 출발 좌표 방문 체크

    while queue:
        now = queue.popleft() # 현재 위치와 현재 위치까지 이동하는 데 걸린 시간
        x = now[0]
        y = now[1]
        count = now[2]

        if x == endIndex[0] and y == endIndex[1]: # 현재 위치가 목표 위치일 경우
            return count # 목표 위치에 도달하는 데 필요한 시간 return

        for d in range(4):
            nx = x + dx[d] # 다음에 이동할 위치의 x 좌표
            ny = y + dy[d] # 다음에 이동할 위치의 y 좌표

            if check(map, nx, ny) and not isVisited[nx][ny] and map[nx][ny] != "X": # 미로의 범위 안에 있고, 다음에 이동할 위치를 방문한 적이 없고, 다음에 이동할 위치가 벽이 아닐 경우
                isVisited[nx][ny] = True # 해당 위치 방문 체크
                queue.append([nx, ny, count + 1])

    return -1 # 목표 좌표에 도달하지 못했을 때, -1 return


from collections import deque


def solution(maps):
    indexs = findIndex(maps) # 시작 지점, 출구, 레버가 있는 곳의 좌표를 담고 있는 리스트
    findLeverTime = escape(maps, indexs[0], indexs[2]) # 시작 지점부터 레버가 있는 곳까지 가는 데 필요한 최소 시간
    findExitTime = escape(maps, indexs[2], indexs[1]) # 레버가 있는 곳부터 출구까지 가는 데 필요한 최소 시간

    if findLeverTime == -1 or findExitTime == -1: # 시작 지점부터 레버가 있는 곳까지 도달하지 못했거나 레버가 있는 곳부터 출구까지 도달하지 못했을 경우
        return -1
    else:
        return findLeverTime + findExitTime
