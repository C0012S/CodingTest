/*
Lv. 4 #284528 - 연간 평가점수에 해당하는 평가 등급 및 성과금 조회하기

    문제 설명
        HR_DEPARTMENT 테이블은 회사의 부서 정보를 담은 테이블입니다. HR_DEPARTMENT 테이블의 구조는 다음과 같으며 DEPT_ID, DEPT_NAME_KR, DEPT_NAME_EN, LOCATION은 각각 부서 ID, 국문 부서명, 영문 부서명, 부서 위치를 의미합니다.
            Column name	    Type	    Nullable
            DEPT_ID	        VARCHAR	    FALSE
            DEPT_NAME_KR	VARCHAR	    FALSE
            DEPT_NAME_EN	VARCHAR	    FALSE
            LOCATION	    VARCHAR	    FLASE

        HR_EMPLOYEES 테이블은 회사의 사원 정보를 담은 테이블입니다. HR_EMPLOYEES 테이블의 구조는 다음과 같으며 EMP_NO, EMP_NAME, DEPT_ID, POSITION, EMAIL, COMP_TEL, HIRE_DATE, SAL은 각각 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉을 의미합니다.
            Column name	    Type	    Nullable
            EMP_NO	        VARCHAR	    FALSE
            EMP_NAME	    VARCHAR	    FALSE
            DEPT_ID	        VARCHAR	    FALSE
            POSITION	    VARCHAR	    FALSE
            EMAIL	        VARCHAR	    FALSE
            COMP_TEL	    VARCHAR	    FALSE
            HIRE_DATE	    DATE	    FALSE
            SAL	            NUMBER	    FALSE

        HR_GRADE 테이블은 2022년 사원의 평가 정보를 담은 테이블입니다. HR_GRADE의 구조는 다음과 같으며 EMP_NO, YEAR, HALF_YEAR, SCORE는 각각 사번, 연도, 반기, 평가 점수를 의미합니다.
            Column name	    Type	    Nullable
            EMP_NO	        VARCHAR	    FALSE
            YEAR	        NUMBER	    FALSE
            HALF_YEAR	    NUMBER	    FALSE
            SCORE	        NUMBER	    FALSE


    문제
        HR_DEPARTMENT, HR_EMPLOYEES, HR_GRADE 테이블을 이용해 사원별 성과금 정보를 조회하려합니다. 평가 점수별 등급과 등급에 따른 성과금 정보가 아래와 같을 때, 사번, 성명, 평가 등급, 성과금을 조회하는 SQL문을 작성해주세요.
        평가등급의 컬럼명은 GRADE로, 성과금의 컬럼명은 BONUS로 해주세요.
        결과는 사번 기준으로 오름차순 정렬해주세요.
            기준 점수	    평가 등급	    성과금(연봉 기준)
            96 이상	    S	        20%
            90 이상	    A	        15%
            80 이상	    B	        10%
            이외	        C	        0%


    예시
        HR_DEPARTMENT 테이블이 다음과 같고
            DEPT_ID	    DEPT_NAME_KR	DEPT_NAME_EN	    LOCATION
            D0001	    법무팀	        Law Dep	            그렙타워 4층
            D0002	    인사팀	        Human resources	    그렙타워 4층
            D0003	    총무팀	        General Affairs	    그렙타워 4층

        HR_EMPLOYEES 테이블이 다음과 같고
            EMP_NO	    EMP_NAME	DEPT_ID	    POSITION	EMAIL	                COMP_TEL	    HIRE_DATE	    SAL
            2017002	    정호식	    D0001	    팀장	        hosick_jung@grep.com	031-8000-1101	2017-03-01	    65000000
            2018001	    김민석	    D0001	    팀원	        minseock_kim@grep.com	031-8000-1102	2018-03-01	    60000000
            2019001	    김솜이	    D0002	    팀장	        somi_kim@grep.com	    031-8000-1106	2019-03-01	    60000000
            2020002	    김연주	    D0002	    팀원	        yeonjoo_kim@grep.com	031-8000-1107	2020-03-01	    53000000
            2020005	    양성태	    D0003	    팀원	        sungtae_yang@grep.com	031-8000-1112	2020-03-01	    53000000

        HR_GRADE 테이블이 다음과 같을 때
            EMP_NO	    YEAR	HALF_YEAR	SCORE
            2017002	    2022	1	        92
            2018001	    2022	1	        89
            2019001	    2022	1	        94
            2020002	    2022	1	        90
            2020005	    2022	1	        92
            2017002	    2022	2	        84
            2018001	    2022	2	        89
            2019001	    2022	2	        81
            2020002	    2022	2	        91
            2020005	    2022	2	        81

        다음과 같이 사원별 성과금 정보를 출력해야 합니다.
            EMP_NO	    EMP_NAME	GRADE	BONUS
            2017002	    정호식	    B	    6500000
            2018001	    김민석	    B	    6000000
            2019001	    김솜이	    B	    6000000
            2020002	    김연주	    A	    7950000
            2020005	    양성태	    B	    5300000
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

SELECT HRG.EMP_NO, HRE.EMP_NAME, HRG.GRADE,
       (CASE
            WHEN GRADE = 'S' THEN 0.2
            WHEN GRADE = 'A' THEN 0.15
            WHEN GRADE = 'B' THEN 0.10
            WHEN GRADE = 'C' THEN 0
        END) * SAL AS BONUS
FROM (SELECT EMP_NO,
             CASE
                 WHEN AVG(SCORE) >= 96 THEN 'S'
                 WHEN AVG(SCORE) >= 90 THEN 'A'
                 WHEN AVG(SCORE) >= 80 THEN 'B'
                 ELSE 'C'
             END AS GRADE
      FROM HR_GRADE
      GROUP BY EMP_NO) HRG
     JOIN HR_EMPLOYEES HRE
     ON HRG.EMP_NO = HRE.EMP_NO
ORDER BY EMP_NO;