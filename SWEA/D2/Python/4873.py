"""
4873. [파이썬 S/W 문제해결 기본] 4일차 - 반복문자 지우기

    · 시간 : 10개 테스트케이스를 합쳐서 C/C++의 경우 1초 / Java의 경우 2초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    문자열 s에서 반복된 문자를 지우려고 한다. 지워진 부분은 다시 앞뒤를 연결하는데, 만약 연결에 의해 또 반복문자가 생기면 이부분을 다시 지운다.
    반복문자를 지운 후 남은 문자열의 길이를 출력 하시오. 남은 문자열이 없으면 0을 출력한다.
    다음은 CAAABBA에서 반복문자를 지우는 경우의 예이다.
        CAAABBA 연속 문자 AA를 지우고 C와 A를 잇는다.
        CABBA 연속 문자 BB를 지우고 A와 A를 잇는다.
        CAA 연속 문자 AA를 지운다.
        C 1글자가 남았으므로 1을 리턴한다.

    [입력]
        첫 줄에 테스트 케이스 개수 T가 주어진다.  1≤T≤ 50
        다음 줄부터 테스트 케이스의 별로 길이가 1000이내인 문자열이 주어진다.

    [출력]
        #과 1번부터인 테스트케이스 번호, 빈칸에 이어 답을 출력한다.


    입력
        3
        ABCCB
        NNNASBBSNV
        UKJWHGGHNFTCRRCTWLALX

    출력
        #1 1
        #2 4
        #3 11
"""


# 실행 시간 : 0.14999s

T = int(input())

for t in range(1, T + 1):
    letters = list(input())

    stack = []

    for l in range(len(letters)):
        if stack and stack[-1] == letters[l]: # stack에 원소가 있고, stack의 마지막 원소가 letters의 원소와 같을 때
            stack.pop() # stack의 마지막 원소 삭제

        elif not stack or stack[-1] != letters[l]: # stack에 원소가 있거나, stack의 마지막 원소가 letters의 원소가 같지 않을 때
            stack.append(letters[l]) # stack에 letters의 원소 추가

    print("#%d" % t, len(stack))
