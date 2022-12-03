"""
2007. 패턴 마디의 길이

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    패턴에서 반복되는 부분을 마디라고 부른다. 문자열을 입력 받아 마디의 길이를 출력하는 프로그램을 작성하라.

    [제약 사항]
        각 문자열의 길이는 30이다. 마디의 최대 길이는 10이다.

    [입력]
        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        각 테스트 케이스의 첫 번째 줄에는 길이가 30인 문자열이 주어진다.

    [출력]
        출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)


    입력
        10
        KOREAKOREAKOREAKOREAKOREAKOREA
        SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA
        GALAXYGALAXYGALAXYGALAXYGALAXY
        EXOEXOEXOEXOEXOEXOEXOEXOEXOEXO
        B1A4B1A4B1A4B1A4B1A4B1A4B1A4B1
        APINKAPINKAPINKAPINKAPINKAPINK
        BLACKPINKBLACKPINKBLACKPINKBLA
        TWICETWICETWICETWICETWICETWICE
        REDVELVETREDVELVETREDVELVETRED
        ABCABCABCABCABCABCABCABCABCABC

    출력
        #1 5
        #2 7
        #3 6
        #4 3
        #5 4
        #6 5
        #7 9
        #8 5
        #9 9
        #10 3
"""


# 실행 시간 : 0.12691s
# Pass

T = int(input())

for t in range(1, T + 1):
    pattern = list(input())

    for p in range(1, len(pattern)):
        result = 0

        if pattern[p] == pattern[0]:
            for l in range(p):
                if pattern[p + l] == pattern[0 + l]:
                    result += 1
                else:
                    break

            if result > 1:
                break

    print("#%d" % t, result)
