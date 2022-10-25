"""
2027. 대각선 출력하기

    · 시간 : 1개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    주어진 텍스트를 그대로 출력하세요.


    입력

    출력
        #++++
        +#+++
        ++#++
        +++#+
        ++++#
"""


j = 1

for i in range(1, 6):
    array = ["+"] * 5

    if i == j:
        array[i - 1] = "#"
        print("".join(array))

    j += 1
