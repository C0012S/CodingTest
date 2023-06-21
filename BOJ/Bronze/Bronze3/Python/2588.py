"""
2588. Bronze 3 - 곱셈

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           313409	    148351    124720	     47.560%


    문제
        (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
                  4 7 2  ······ (1)
                × 3 8 5  ······ (2)
            ------------
                2 3 6 0  ······ (3)
              3 7 7 6    ······ (4)
            1 4 1 6      ······ (5)
            ------------
            1 8 1 7 2 0  ······ (6)

        (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.


    출력
        첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.


    예제 입력 1
        472
        385
    예제 출력 1
        2360
        3776
        1416
        181720


    알고리즘 분류
        수학
        사칙연산
"""


# 메모리 : 31256KB
# 시간 : 40ms
# 코드 길이 : 218B
# 정답

A = int(input())
B = input()

for b in range(len(B), 0, -1): # len(B) : 3
    print(A * int(B[b - 1:b])) # B의 일의 자리 수부터 십의 자리 수, 백의 자리 수 순서로 A와 곱한다.

print(A * int(B))
