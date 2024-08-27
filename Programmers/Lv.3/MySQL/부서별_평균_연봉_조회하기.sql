/*
Lv. 3 #284529 - 부서별 평균 연봉 조회하기

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


    문제
        HR_DEPARTMENT와 HR_EMPLOYEES 테이블을 이용해 부서별 평균 연봉을 조회하려 합니다. 부서별로 부서 ID, 영문 부서명, 평균 연봉을 조회하는 SQL문을 작성해주세요.
        평균연봉은 소수점 첫째 자리에서 반올림하고 컬럼명은 AVG_SAL로 해주세요.
        결과는 부서별 평균 연봉을 기준으로 내림차순 정렬해주세요.


    예시
        HR_DEPARTMENT 테이블이 다음과 같고
            DEPT_ID	    DEPT_NAME_KR	DEPT_NAME_EN	LOCATION
            D0005	    재무팀	        Finance	        그렙타워 5층
            D0006	    구매팀	        Purchasing	    그렙타워 5층
            D0007	    마케팅팀	        Marketing	    그렙타워 6층

        HR_EMPLOYEES 테이블이 다음과 같을 때
            EMP_NO	    EMP_NAME	DEPT_ID	    POSITION	EMAIL	                    COMP_TEL	        HIRE_DATE	    SAL
            2019003	    한동희	    D0005	    팀장	        donghee_han@grep.com	    031-8000-1122	    2019-03-01	    57000000
            2020032	    한명지	    D0005	    팀원	        mungji_han@grep.com	        031-8000-1123	    2020-03-01	    52000000
            2022003	    김보라	    D0005	    팀원	        bora_kim@grep.com	        031-8000-1126	    2022-03-01	    47000000
            2018005	    이재정	    D0006	    팀장	        jaejung_lee@grep.com	    031-8000-1127	    2018-03-01	    60000000
            2019032	    윤성희	    D0006	    팀원	        sunghee_yoon@grep.com	    031-8000-1128	    2019-03-01	    57000000
            2020009	    송영섭	    D0006	    팀원	        yungseop_song@grep.com	    031-8000-1130	    2020-03-01	    51000000
            2021006	    이성주	    D0006	    팀원	        sungju_lee@grep.com	        031-8000-1131	    2021-03-01	    49000000
            2018004	    이주리	    D0007	    팀장	        joori_lee@grep.com	        031-8000-1132	    2018-03-01	    61000000
            2020012	    김사랑	    D0007	    팀원	        sarang_kim@grep.com	        031-8000-1133	    2020-03-01	    54000000
            2021018	    김히라	    D0007	    팀원	        heera_kim@grep.com	        031-8000-1136	    2021-03-01	    49000000

        SQL을 실행하면 다음과 같이 출력되어야 합니다.
            DEPT_ID	    DEPT_NAME_EN	AVG_SAL
            D0007	    Marketing	    54666667
            D0006	    Purchasing	    54250000
            D0005	    Finance	        52000000
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

SELECT HD.DEPT_ID, HD.DEPT_NAME_EN, ROUND(AVG(HE.SAL), 0) AVG_SAL
FROM HR_DEPARTMENT HD JOIN HR_EMPLOYEES HE
                           ON HD.DEPT_ID = HE.DEPT_ID
GROUP BY HD.DEPT_ID
ORDER BY AVG_SAL DESC;