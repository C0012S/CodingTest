"""
2501. Bronze 3 - 이진수

    시간 제한	    메모리 제한        제출        정답	    맞힌 사람	    정답 비율
    1 초	        128 MB           13826	     7512        6529	        55.448%


    문제
        양의 정수 n이 주어졌을 때, 이를 이진수로 나타냈을 때 1의 위치를 모두 찾는 프로그램을 작성하시오. 최하위 비트(least significant bit, lsb)의 위치는 0이다


    입력
        첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, n이 주어진다. (1 ≤ T ≤ 10, 1 ≤ n ≤ 106)


    출력
        각 테스트 케이스에 대해서, 1의 위치를 공백으로 구분해서 줄 하나에 출력한다. 위치가 낮은 것부터 출력한다.


    예제 입력 1
        1
        13
    예제 출력 1
        0 2 3
"""


# 메모리 : 31256KB
# 시간 : 40ms
# 코드 길이 : 241B
# 정답

T = int(input())

for t in range(T):
    n = int(input())

#    binary = bin(n)[2::] # 이진수 변환 후 '0b' 제외
    binary = bin(n)[2::][::-1] # 이진수 변환 후 '0b' 제외 & 역순으로 변경

    for i in range(len(binary)):
        if binary[i] == "1":
            print(i, end = " ")
