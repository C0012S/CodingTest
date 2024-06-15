/*
Lv. 2 #284530 - 연도 별 평균 미세먼지 농도 조회하기

    문제 설명
        AIR_POLLUTION 테이블은 전국의 월별 미세먼지 정보를 담은 테이블입니다. AIR_POLLUTION 테이블의 구조는 다음과 같으며 LOCATION1, LOCATION2, YM, PM_VAL1, PM_VAL2은 각각 지역구분1, 지역구분2, 측정일, 미세먼지 오염도, 초미세먼지 오염도를 의미합니다.
            Column name	    Type	    Nullable
            LOCATION1	    VARCHAR	    FALSE
            LOCATION2	    VARCHAR	    FALSE
            YM	            DATE	    FALSE
            PM_VAL1	        NUMBER	    FLASE
            PM_VAL2	        NUMBER	    FLASE


    문제
        AIR_POLLUTION 테이블에서 수원 지역의 연도 별 평균 미세먼지 오염도와 평균 초미세먼지 오염도를 조회하는 SQL문을 작성해주세요. 이때, 평균 미세먼지 오염도와 평균 초미세먼지 오염도의 컬럼명은 각각 PM10, PM2.5로 해 주시고, 값은 소수 셋째 자리에서 반올림해주세요.
        결과는 연도를 기준으로 오름차순 정렬해주세요.


    예시
        AIR_POLLUTION 테이블이 다음과 같을 때
            LOCATION1	LOCATION2	YM	            PM_VAL1	    PM_VAL2
            경기도	    수원	        2018-01-01	    48	        27
            경기도	    수원	        2018-02-01	    51	        30
            경기도	    수원	        2018-03-01	    52	        21
            경기도	    수원	        2018-04-01	    52	        20
            경기도	    수원	        2018-05-01	    45	        19
            경기도	    수원	        2018-06-01	    39	        17
            경기도	    수원	        2018-07-01	    27	        15
            경기도	    수원	        2018-08-01	    26	        16
            경기도	    수원	        2018-09-01	    21	        12
            경기도	    수원	        2018-10-01	    31	        18
            경기도	    수원	        2018-11-01	    56	        21
            경기도	    수원	        2018-12-01	    44	        27
            서울시	    노원	        2018-11-01	    25	        45
            경기도	    용인	        2018-02-01	    14	        21

        SQL을 실행하면 다음과 같이 출력되어야 합니다.
            YEAR	PM10	PM2.5
            2018	41	    20.25


    ※ 공지 - 2023년 3월 4일 문제 오탈자가 수정되었습니다.
*/


/*
    채점을 시작합니다.
        테스트 1 〉	통과
        테스트 2 〉	통과
        테스트 3 〉	통과
        테스트 4 〉	통과
        테스트 5 〉	통과
        테스트 6 〉	통과

    채점 결과
        합계: 100.0 / 100.0
*/


-- 정답

SELECT YEAR(YM) AS 'YEAR', ROUND(AVG(PM_VAL1), 2) AS 'PM10', ROUND(AVG(PM_VAL2), 2) AS 'PM2.5'
FROM AIR_POLLUTION
WHERE LOCATION2 = '수원'
GROUP BY YEAR
ORDER BY YEAR;