"""
1978. Bronze 2 - 소수 찾기

    시간 제한	    메모리 제한        제출        정답	    맞힌 사람	    정답 비율
    2 초	        128 MB           164014	     76703        61290	         46.624%


    문제
        주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.


    입력
        첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.


    출력
        주어진 수들 중 소수의 개수를 출력한다.


    예제 입력 1
        4
        1 3 5 7
    예제 출력 1
        3


    알고리즘 분류
        수학
        정수론
        소수 판정
"""


# 메모리 : 31256KB
# 시간 : 40ms
# 코드 길이 : 291B
# 정답

N = int(input())
numArr = list(map(int, input().split()))

answer = 0
for n in range(N):
    factor = 0

    for i in range(2, numArr[n]):
        if numArr[n] % i == 0:
            factor += 1
            break

    if (factor == 0) and (numArr[n] != 1):
        answer += 1

print(answer)
