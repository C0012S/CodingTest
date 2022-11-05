"""
4866. [파이썬 S/W 문제해결 기본] 4일차 - 괄호검사

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    주어진 입력에서 괄호 {}, ()가 제대로 짝을 이뤘는지 검사하는 프로그램을 만드시오.
    예를 들어 {( )}는 제대로 된 짝이지만, {( })는 제대로 된 짝이 아니다. 입력은 한 줄의 파이썬 코드일수도 있고, 괄호만 주어질 수도 있다.
    정상적으로 짝을 이룬 경우 1, 그렇지 않으면 0을 출력한다.
    print(‘{‘) 같은 경우는 입력으로 주어지지 않으므로 고려하지 않아도 된다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1≤T≤50
        다음 줄부터 테스트 케이스 별로 온전한 형태이거나 괄호만 남긴 한 줄의 코드가 주어진다.

    [출력]
        각 줄마다 "#T" (T는 테스트 케이스 번호)를 출력한 뒤, 답을 출력한다.


    입력
        3
        print('{} {}'.format(1, 2))
        N, M = map(int, input().split())
        print('#{} {}'.format(tc, find())

    출력
        #1 1
        #2 1
        #3 0
"""


# 실행 시간 : 0.14882s

T = int(input())

for t in range(1, T + 1):
    letters = list(input())

    letter_array = list()
    num = 0

    for l in letters:
        if l == '\'':
            num += 1

        if num % 2 != 0:
            continue

        if l == '(' or l == '{':
            letter_array.append(l)
        elif l == ')' or l == '}':
            if len(letter_array) == 0:
                letter_array.append(l)
                break
            elif (l == ')' and letter_array[-1] != '(') or (l == '}' and letter_array[-1] != '{'):
                letter_array.append(l)
                break
            else:
                letter_array.pop()

    if len(letter_array) == 0:
        print("#%d" % t, 1)
    else:
        print("#%d" % t, 0)
