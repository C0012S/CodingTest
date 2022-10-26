"""
2056. 연월일 달력

    · 시간 : 5개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내


    연월일 순으로 구성된 8자리의 날짜가 입력으로 주어진다.
        22220228 → 2222/02/28
            [그림1]

    해당 날짜의 유효성을 판단한 후, 날짜가 유효하다면
    [그림1] 과 같이 ”YYYY/MM/DD”형식으로 출력하고,
    날짜가 유효하지 않을 경우, -1 을 출력하는 프로그램을 작성하라.

    연월일로 구성된 입력에서 월은 1~12 사이 값을 가져야 하며
    일은 [표1] 과 같이, 1일 ~ 각각의 달에 해당하는 날짜까지의 값을 가질 수 있다.
        1 월  1 일 ~ 31일      2 월  1 일 ~ 28 일
        3 월  1 일 ~ 31일      4 월  1 일 ~ 30 일
        5 월  1 일 ~ 31일      6 월  1 일 ~ 30 일
        7 월  1 일 ~ 31일      8 월  1 일 ~ 31 일
        9 월  1 일 ~ 30일      10 월  1 일 ~ 31 일
        11 월  1 일 ~ 30일     12 월  1 일 ~ 31 일
            [표1]

    ※ 2월의 경우, 28일인 경우만 고려한다. (윤년은 고려하지 않는다.)

    [입력]
        입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
        다음 줄부터 각 테스트 케이스가 주어진다.

    [출력]
        테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)


    입력
        5
        22220228
        20150002
        01010101
        20140230
        11111111

    출력
        #1 2222/02/28
        #2 -1
        #3 0101/01/01
        #4 -1
        #5 1111/11/11
"""


T = int(input())

for t in range(T):
    date = list(map(int, input()))

    year = date[0:4]
    month = date[4:6]
    day = date[6:]

    isPrint = False

    calendar_month = 10 * month[0] + month[1]
    calendar_day = 10 * day[0] + day[1]

    if (calendar_month == 1) or (calendar_month == 3) or (calendar_month == 5) \
            or (calendar_month == 7) or (calendar_month == 8) or (calendar_month == 10) or (calendar_month == 12):
        if 1 <= calendar_day <= 31:
            isPrint = True
        else:
            isPrint = False
    elif (calendar_month == 4) or (calendar_month == 6) \
            or (calendar_month == 9) or (calendar_month == 11):
        if 1 <= calendar_day <= 30:
            isPrint = True
        else:
            isPrint = False
    elif calendar_month == 2:
        if 1 <= calendar_day <= 28:
            isPrint = True
        else:
            isPrint = False
    else:
        isPrint = False

    if isPrint:
        print("#%d" % (t + 1), end = ' ')
        print("{}{}{}{}".format(year[0], year[1], year[2], year[3]), end = '')
        print("/{}{}".format(month[0], month[1]), end = '')
        print("/{}{}".format(day[0], day[1]))
    else:
        print("#%d" % (t + 1), -1)
