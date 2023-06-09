"""
6679. Bronze 2 - 싱기한 네자리 숫자

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           4289	     3022     2527	         73.035%


    문제
        싱기한 네자리 숫자란, [1000,9999]인 10진수 숫자중에서,  다음의 조건을 만족하는 숫자를 말한다.
            · 숫자를 10진수, 12진수, 16진수로 나타낸 다음, 각각의 숫자에 대해, 각 숫자의 자리수를 더했을 때, 세 값이 모두 같아야 한다.
        여러분은 싱기한 네자리 숫자를 모두 출력해야 한다.


    입력
        입력은 주어지지 않는다.


    출력
        싱기한 네자리 숫자를 오름차순으로 한줄에 하나씩 출력한다.


    예제 입력 1
    예제 출력 1
        2992
        2993
        2994
        2995
        2996
        2997
        2998
        2999


    힌트
        싱기한 네자리 숫자의 첫 번째 수는 2992이다.


    알고리즘 분류
        수학
        구현
        브루트포스 알고리즘
        사칙연산
"""


# 메모리 : 31256KB
# 시간 : 48ms
# 코드 길이 : 326B
# 정답

def calculate(num, system):
    sum = 0

    while num > 0:
        sum += num % system
        num = num // system

    return sum


for n in range(1000, 10000):
    decimal = calculate(n, 10)
    duodecimal = calculate(n, 12)
    hexadecimal = calculate(n, 16)

    if decimal == duodecimal == hexadecimal:
        print(n)
