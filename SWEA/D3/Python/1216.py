"""
1216. [S/W 문제해결 기본] 3일차 - 회문2

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 10초 / Java의 경우 20초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    "기러기" 또는 "level" 과 같이 거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
    주어진 100x100 평면 글자판에서 가로, 세로를 모두 보아 가장 긴 회문의 길이를 구하는 문제이다.
        [그림은 SW Expert Academy에서 참고]

    위와 같은 글자 판이 주어졌을 때, 길이가 가장 긴 회문은 붉은색 테두리로 표시된 7칸짜리 회문이다.
    예시의 경우 설명을 위해 글자판의 크기가 100 x 100이 아닌 8 x 8으로 주어졌음에 주의한다.

    [제약사항]
        각 칸의 들어가는 글자는 c언어 char type으로 주어지며 'A', 'B', 'C' 중 하나이다.
        글자 판은 무조건 정사각형으로 주어진다.
        ABA도 회문이며, ABBA도 회문이다. A또한 길이 1짜리 회문이다.
        가로, 세로 각각에 대해서 직선으로만 판단한다. 즉, 아래 예에서 노란색 경로를 따라가면 길이 7짜리 회문이 되지만 직선이 아니기 때문에 인정되지 않는다.
            [그림은 SW Expert Academy에서 참고]

    [입력]
        각 테스트 케이스의 첫 번째 줄에는 테스트 케이스의 번호가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.
        총 10개의 테스트케이스가 주어진다.

    [출력]
        #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 찾은 회문의 길이를 출력한다.


    입력
        1
        CCBBCBAABCCCBABCBCAAAACABBACCCCACAABCBBACACAACABCBCCB...
        ACBAAAACCACCCBAACAAABACACCABCBCBABBBACBABCAACCBCCACBC...
        CCCACCBCBACBACBCABAABABCCAAAACCCCCBBAABBCCBCCCABBACAC...
        CABACBCBBCBABACABBBBBBABBCABCBCBCAABCBCCCBABACCCCABBA...
        BCCBCCACCBCBCABBBCCABAACACCBCCCBCCACCBBCBCCCBBCCBACBC...
        BBBBCBBAACABACCBCBCCABBBBCCAABCBBCACCBBCAAAABABABBABB...
        ABBAACCCACBBABBABCCCABABCACABABACCCBACACABCBCCCBABCCC...
        ABBBBAABCAACCBACBBAACACABCABACBAABCAABBCCCCCCACBCCCCA...
        ACCACABABBACBBAACCBBACBBCCACCACCABCCBABABBBACBACBAABC...
        BABACACCABCAACBAABCCACCACBCCAABBCBAABABAACAAAAAACCCBC...
        ...
        2
        CBBABBACCAACCCAABABAACCABCBBCCABABBBBBCCACBCCCCBBBAAC...
        BBBCBACAAABAACACBCAABBAAABCABBBCAAACBAABCAAAAACBABBAB...
        CAAAABCAABAACCBBABCCCACABABACBCCBCCBABABBCCCBCBACAAAC...
        BBBACBBBBBAACBBCBABBCBAABACCCBBBBCCCBBBCABCABCAABCBCA...
        ABBBBAABCBACCACBBCBBAABABCBCCAAABBCAAABBAABBCACABAABA...
        ABCBACAAACCCAAABCACABBAABBCAACCBABCCACBABBBABAABAACBB...
        ACACABCBAAACCACABABBCABCBABAAABCBCCABABCCAACACBCBABCA...
        ACCBACACCAAAABABACABABBBBABBAABABBBBACBACABABACACACAA...
        AAACCCCCBCAACCCCCAAAACBCACBBABBBBBABABBCCCCBBAACCBBCB...
        CCABCCBBCAAAACACBBBBAAAACABACABCCCBACBABBACCAABAAACAB...

    출력
        #1 18
        #2 17
        ...
"""


# 실행 시간 : 3.45331s
# Pass

def find_width_max_length(array):
    width_max_length = 0

    for wr in range(100):
        for wc in range(100):
            for wl in range(100 - wc):
                if array[wr][wc:wc + wl + 1] == array[wr][wc:wc + wl + 1][::-1]:
                    width_max_length = max(width_max_length, len(array[wr][wc:wc + wl + 1]))
                else:
                    continue

    return width_max_length


def find_height_max_length(array):
    height_max_length = 0

    for hc in range(100):
        for hr in range(100):
            char = ""

            for hl in range(100 - hr):
                char += array[hr + hl][hc]

                if char == char[:: - 1]:
                    height_max_length = max(height_max_length, len(char))

                """                
                char = ""
                
                for al in range(hl + 1):
                    char += array[hr + al][hc]
                    
                if char == char[::-1]:
                    height_max_length = max(height_max_length, len(char))
                """

    return height_max_length


for t in range(1, 11):
    T = int(input())
    square = [[0] * 100 for _ in range(100)]

    for s in range(100):
        square[s] = list(input())

    print("#%d" % t, max(find_width_max_length(square), find_height_max_length(square)))
