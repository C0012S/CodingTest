"""
10818. Bronze 3 - 최소, 최대

    시간 제한	    메모리 제한        제출        정답	    맞힌 사람	    정답 비율
    1 초	        256 MB           289877	     127763      96540	        43.267%


    문제
        N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.


    출력
        첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.


    예제 입력 1
        5
        20 10 35 30 7
    예제 출력 1
        7 35
"""


N = int(input())
numArr = list(map(int, input().split()))

minNum = numArr[0]
maxNum = numArr[0]

for i in range(1, len(numArr)):
    minNum = min(minNum, numArr[i])
    maxNum = max(maxNum, numArr[i])

print(minNum, maxNum)
