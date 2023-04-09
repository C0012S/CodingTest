"""
2609. Bronze 1 - 최대공약수와 최소공배수

    시간 제한	    메모리 제한        제출        정답	    맞힌 사람	    정답 비율
    1 초	        128 MB           90427	     52217        42369	         58.091%


    문제
        두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.


    출력
        첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.


    예제 입력 1
        24 18
    예제 출력 1
        6
        72


    알고리즘 분류
        수학
        정수론
        유클리드 호제법
"""


# 메모리 : 31256KB
# 시간 : 44ms
# 코드 길이 : 1082B
# 정답

def primeFactorization(num, factor): # 소인수 분해
    n = 2
    while num != 1:
        if num % n == 0:
            factor[n] += 1
            num //= n
        else:
            n += 1


def calculateCommon(): # 최대 공약수와 최소 공배수 계산
    greatestCommonDivisor = 1 # 최대 공약수
    leastCommonMultiple = 1 # 최소 공배수

    for i in range(10001):
        if aFactor[i] != 0 and bFactor[i] != 0:
            greatestCommonDivisor *= pow(i, aFactor[i] if aFactor[i] < bFactor[i] else bFactor[i])

        leastCommonMultiple *= pow(i, aFactor[i] if aFactor[i] > bFactor[i] else bFactor[i])

    print(greatestCommonDivisor)
    print(leastCommonMultiple)


a, b = map(int, input().split())

aFactor = [0] * 10001 # 첫 번째 수의 인수 개수 저장 리스트
bFactor = [0] * 10001 # 두 번째 수의 인수 개수 저장 리스트
primeFactorization(a, aFactor) # 첫 번째 수 소인수 분해
primeFactorization(b, bFactor) # 두 번째 수 소인수 분해

calculateCommon() # 두 수의 최대 공약수와 최소 공배수 계산
