/*
Lv. 3 #59044 - 오랜 기간 보호한 동물(1)

    문제 설명
        ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.
            NAME	            TYPE	        NULLABLE
            ANIMAL_ID	        VARCHAR(N)	    FALSE
            ANIMAL_TYPE	        VARCHAR(N)	    FALSE
            DATETIME	        DATETIME	    FALSE
            INTAKE_CONDITION	VARCHAR(N)	    FALSE
            NAME	            VARCHAR(N)	    TRUE
            SEX_UPON_INTAKE	    VARCHAR(N)	    FALSE

        ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. ANIMAL_OUTS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다. ANIMAL_OUTS 테이블의 ANIMAL_ID는 ANIMAL_INS의 ANIMAL_ID의 외래 키입니다.
            NAME	            TYPE	        NULLABLE
            ANIMAL_ID	        VARCHAR(N)	    FALSE
            ANIMAL_TYPE	        VARCHAR(N)	    FALSE
            DATETIME	        DATETIME	    FALSE
            NAME	            VARCHAR(N)	    TRUE
            SEX_UPON_OUTCOME	VARCHAR(N)	    FALSE

        아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일 순으로 조회해야 합니다.


    예시
        예를 들어, ANIMAL_INS 테이블과 ANIMAL_OUTS 테이블이 다음과 같다면
            ANIMAL_INS
                ANIMAL_ID	ANIMAL_TYPE	    DATETIME	            INTAKE_CONDITION	NAME	SEX_UPON_INTAKE
                A354597	    Cat	            2014-05-02 12:16:00	    Normal	            Ariel	Spayed Female
                A373687	    Dog	            2014-03-20 12:31:00	    Normal	            Rosie	Spayed Female
                A412697	    Dog	            2016-01-03 16:25:00	    Normal	            Jackie	Neutered Male
                A413789	    Dog	            2016-04-19 13:28:00	    Normal	            Benji	Spayed Female
                A414198	    Dog	            2015-01-29 15:01:00	    Normal	            Shelly	Spayed Female
                A368930	    Dog	            2014-06-08 13:20:00	    Normal	            	    Spayed Female

            ANIMAL_OUTS
                ANIMAL_ID	ANIMAL_TYPE	    DATETIME	            NAME	SEX_UPON_OUTCOME
                A354597	    Cat	            2014-05-02 12:16:00	    Ariel	Spayed Female
                A373687	    Dog	            2014-03-20 12:31:00	    Rosie	Spayed Female
                A368930	    Dog	            2014-06-13 15:52:00	    	    Spayed Female

        SQL문을 실행하면 다음과 같이 나와야 합니다.
            NAME	DATETIME
            Shelly	2015-01-29 15:01:00
            Jackie	2016-01-03 16:25:00
            Benji	2016-04-19 13:28:00

        ※ 입양을 가지 못한 동물이 3마리 이상인 경우만 입력으로 주어집니다.


    본 문제는 Kaggle의 "Austin Animal Center Shelter Intakes and Outcomes"에서 제공하는 데이터를 사용하였으며 ODbL의 적용을 받습니다.
*/


-- 정답

SELECT AI.NAME, AI.DATETIME
FROM ANIMAL_INS AI LEFT JOIN ANIMAL_OUTS AO
                             ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AO.DATETIME IS NULL
ORDER BY AI.DATETIME
FETCH FIRST 3 ROWS ONLY;