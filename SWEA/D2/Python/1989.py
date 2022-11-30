"""
1989. 초심자의 회문 검사

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    "level" 과 같이 거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
    단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력하는 프로그램을 작성하라.

    [제약 사항]
        각 단어의 길이는 3 이상 10 이하이다.

    [입력]
        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        각 테스트 케이스의 첫 번째 줄에 하나의 단어가 주어진다.

    [출력]
        출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)


    입력
        10
        level
        samsung
        eye
        exo
        ioi
        blackpink
        hannah
        B1A4
        linetown
        nursesrun

    출력
        #1 1
        #2 0
        #3 1
        #4 0
        #5 1
        #6 0
        #7 1
        #8 0
        #9 0
        #10 1
"""


# 실행 시간 : 0.14323s
# Pass

T = int(input())

for t in range(1, T + 1):
    word = list(input())

    for w in range(len(word) // 2):
        # 단어의 글자 수가 짝수인 경우와 홀수인 경우, 구현 코드가 같기 때문에 구현하지 않아도 된다.
        if word[w] == word[len(word) - w - 1]:
            result = 1
        else:
            result = 0
            break

    print("#%d" % t, result)
