/*
Lv. 1 #276013 - Python 개발자 찾기

    문제 설명
        DEVELOPER_INFOS 테이블은 개발자들의 프로그래밍 스킬 정보를 담은 테이블입니다. DEVELOPER_INFOS 테이블 구조는 다음과 같으며, ID, FIRST_NAME, LAST_NAME, EMAIL, SKILL_1, SKILL_2, SKILL_3는 각각 ID, 이름, 성, 이메일, 첫 번째 스킬, 두 번째 스킬, 세 번째 스킬을 의미합니다.
            NAME	        TYPE	        UNIQUE	NULLABLE
            ID	            VARCHAR(N)	    Y	    N
            FIRST_NAME	    VARCHAR(N)	    N	    Y
            LAST_NAME	    VARCHAR(N)	    N	    Y
            EMAIL	        VARCHAR(N)	    Y	    N
            SKILL_1	        VARCHAR(N)	    N	    Y
            SKILL_2	        VARCHAR(N)	    N	    Y
            SKILL_3	        VARCHAR(N)	    N	    Y


    문제
        DEVELOPER_INFOS 테이블에서 Python 스킬을 가진 개발자의 정보를 조회하려 합니다. Python 스킬을 가진 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문을 작성해 주세요.
        결과는 ID를 기준으로 오름차순 정렬해 주세요.


    예시
        예를 들어 DEVELOPER_INFOS 테이블이 다음과 같다면
            ID	    FIRST_NAME	LAST_NAME	EMAIL	                    SKILL_1	    SKILL_2	        SKILL_3
            D165	Jerami	    Edwards	    jerami_edwards@grepp.co	    Java	    JavaScript	    Python
            D161	Carsen	    Garza	    carsen_garza@grepp.co	    React
            D164	Kelly	    Grant	    kelly_grant@grepp.co	    C#
            D163	Luka	    Cory	    luka_cory@grepp.co	        Node.js
            D162	Cade	    Cunningham	cade_cunningham@grepp.co	Vue	        C++	            Python

        다음과 같이 Python 스킬을 가진 개발자의 정보가 결과에 나와야 합니다.
            ID	    EMAIL	                    FIRST_NAME	    LAST_NAME
            D162	cade_cunningham@grepp.co	Cade	        Cunningham
            D165	jerami_edwards@grepp.co	    Jerami	        Edwards
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

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE 'PYTHON' IN (SKILL_1, SKILL_2, SKILL_3)
ORDER BY ID;