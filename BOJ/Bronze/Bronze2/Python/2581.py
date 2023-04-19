"""
2581. Bronze 2 - 소수

    시간 제한	    메모리 제한        제출        정답	    맞힌 사람	    정답 비율
    1 초	        128 MB           121086	     47553       40011	         39.060%


    문제
        자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
            예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.


    입력
        입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
        M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.


    출력
        M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.
        단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.


    예제 입력 1
        60
        100
    예제 출력 1
        620
        61

    예제 입력 2
        64
        65
    예제 출력 2
        -1


    알고리즘 분류
        수학
        정수론
        소수 판정
"""


# 메모리 : 31256KB
# 시간 : 328ms
# 코드 길이 : 798B
# 정답

def checkPrimeNumber(num): # 소수인지 체크하는 함수
    if num == 1:
        return False

    for x in range(2, num):
        if num % x == 0: # 소수의 약수는 1과 자기 자신뿐이다.
            return False

    return True


M = int(input())
N = int(input())

sumPrimeNumber = 0 # 소수의 합
minPrimeNumber = 0 # 소수 중 최솟값
for n in range(M, N + 1):
    if checkPrimeNumber(n): # 소수인 경우
        if minPrimeNumber == 0: # 첫 번째 소수일 경우, 아직 minPrimeNumber가 0일 것이므로 minPrimeNumber의 값이 0일 때 소수의 최솟값을 지정해 준다.
            minPrimeNumber = n

        sumPrimeNumber += n

if minPrimeNumber == 0: # 소수가 없을 경우
    print(-1)
else:
    print(sumPrimeNumber)
    print(minPrimeNumber)
