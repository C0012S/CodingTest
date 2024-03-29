"""
1051. Silver 3 - 숫자 정사각형

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           18512	    7856      6681	         43.299%


    문제
        N×M크기의 직사각형이 있다. 각 칸에는 한 자리 숫자가 적혀 있다. 이 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성하시오. 이때, 정사각형은 행 또는 열에 평행해야 한다.


    입력
        첫째 줄에 N과 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 수가 주어진다.


    출력
        첫째 줄에 정답 정사각형의 크기를 출력한다.


    예제 입력 1
        3 5
        42101
        22100
        22101
    예제 출력 1
        9

    예제 입력 2
        2 2
        12
        34
    예제 출력 2
        1

    예제 입력 3
        2 4
        1255
        3455
    예제 출력 3
        4

    예제 입력 4
        1 10
        1234567890
    예제 출력 4
        1

    예제 입력 5
        11 10
        9785409507
        2055103694
        0861396761
        3073207669
        1233049493
        2300248968
        9769239548
        7984130001
        1670020095
        8894239889
        4053971072
    예제 출력 5
        49


    알고리즘 분류
        구현
        브루트포스 알고리즘
"""


# 메모리 : 31256KB
# 시간 : 44ms
# 코드 길이 : 898B
# 정답

def findSquare(row, col):
    maxLength = min(row, col) # 행의 길이와 열의 길이 중 최솟값이 정사각형의 최대 변의 길이

    for s in range(maxLength, 0, -1):
        for c in range(col - s + 1):
            for r in range(row - s + 1):
                if rectangle[r][c] == rectangle[r][c + s - 1] == rectangle[r + s - 1][c] == rectangle[r + s - 1][c + s - 1]: # 정사각형의 꼭짓점에 쓰여 있는 수가 모두 같은지
                    side = s # 조건을 만족하는 정사각형의 최대 변의 길이
                    return side


N, M = map(int, input().split()) # 행의 길이 N, 열의 길이 M

rectangle = [[0] * M for _ in range(N)] # N * M 크기의 직사각형
for n in range(N):
    rectangle[n] = list(map(int, input()))

print(pow(findSquare(N, M), 2)) # 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형의 크기
