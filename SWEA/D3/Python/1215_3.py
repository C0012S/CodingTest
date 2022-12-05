"""
1215. [S/W 문제해결 기본] 3일차 - 회문1

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 10초 / Java의 경우 20초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    "기러기", "토마토", "스위스"와 같이 똑바로 읽어도 거꾸로 읽어도 똑같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
    8x8 평면 글자판에서 제시된 길이를 가진 회문의 개수를 구하라.
        [그림은 SW Expert Academy에서 참고]

    위와 같은 글자판이 주어졌을 때, 길이가 5인 회문은 붉은색 테두리로 표시된 4개이므로 4를 반환하면 된다.

    [제약 사항]
        각 칸의 들어가는 글자는 'A', 'B', 'C' 중 하나이다.
        ABA도 회문이며, ABBA도 회문이다. A 또한 길이 1짜리 회문이다.
        가로 또는 세로로 이어진 회문의 개수만 센다.
        아래 그림에서 노란색 경로를 따라가면 길이 7짜리 회문이 되지만 직선이 아니기 때문에 인정되지 않는다.

    [입력]
        총 10개의 테스트 케이스가 주어진다.
        각 테스트 케이스의 첫 번째 줄에는 찾아야 하는 회문의 길이가 주어지며, 다음 줄에 8x8 크기의 글자판이 주어진다.

    [출력]
        #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 찾은 회문의 개수를 출력한다.


    입력
        4
        CBBCBAAB
        CCCBABCB
        CAAAACAB
        BACCCCAC
        AABCBBAC
        ACAACABC
        BCCBAABC
        ABBBCCAA
        4
        BCBBCACA
        BCAAACAC
        ABACBCCB
        AACBCBCA
        ACACBAAA
        ACCACCCB
        AACAAABA
        CACCABCB
        ...

    출력
        #1 12
        #2 10
        ...
"""


# 실행 시간 : 0.14531s
# Pass

# 가로 회문 찾기
def find_width_circular_letter(num, array):
    width_result = 0

    for r in range(8):
        for c in range(8 - num + 1):
            if array[r][c:c + num] == array[r][c:c + num][::-1]:  # array[r][c + num::]는 array[r][c + num]부터 끝까지  # list[::-1]은 리스트를 역순으로 뒤집는다.
                width_result += 1

    return width_result


# 세로 회문 찾기
def find_height_circular_letter(num, array):
    height_result = 0

    for hc in range(8):
        for hr in range(8 - num + 1):
            char = ""

            for hrn in range(hr, hr + num):
                char += array[hrn][hc]

            if char == char[::-1]:
                height_result += 1

    return height_result


for t in range(1, 11):
    N = int(input())
    square = [[0] * 8 for _ in range(8)]

    for s in range(8):
        square[s] = list(input())

    print("#%d" % t, find_width_circular_letter(N, square) + find_height_circular_letter(N, square))
