/*
Lv. 4 #131116 - 식품분류별 가장 비싼 식품의 정보 조회하기

    문제 설명
        다음은 식품의 정보를 담은 FOOD_PRODUCT 테이블입니다. FOOD_PRODUCT 테이블은 다음과 같으며 PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE는 식품 ID, 식품 이름, 식품코드, 식품분류, 식품 가격을 의미합니다.
            Column name	    Type	        Nullable
            PRODUCT_ID	    VARCHAR(10)	    FALSE
            PRODUCT_NAME	VARCHAR(50)	    FALSE
            PRODUCT_CD	    VARCHAR(10)	    TRUE
            CATEGORY	    VARCHAR(10)	    TRUE
            PRICE	        NUMBER	        TRUE


    문제
        FOOD_PRODUCT 테이블에서 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회하는 SQL문을 작성해주세요. 이때 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력시켜 주시고 결과는 식품 가격을 기준으로 내림차순 정렬해주세요.


    예시
        FOOD_PRODUCT 테이블이 다음과 같을 때
            PRODUCT_ID	PRODUCT_NAME	PRODUCT_CD	    CATEGORY	PRICE
            P0018	    맛있는고추기름	    CD_OL00008	    식용유	    6100
            P0019	    맛있는카놀라유	    CD_OL00009	    식용유	    5100
            P0020	    맛있는산초유	    CD_OL00010	    식용유	    6500
            P0021	    맛있는케첩	    CD_SC00001	    소스	        4500
            P0022	    맛있는마요네즈	    CD_SC00002	    소스	        4700
            P0039	    맛있는황도	    CD_CN00008	    캔	        4100
            P0040	    맛있는명이나물	    CD_CN00009	    캔	        3500
            P0041	    맛있는보리차	    CD_TE00010	    차	        3400
            P0042	    맛있는메밀차	    CD_TE00001	    차	        3500
            P0099	    맛있는맛동산	    CD_CK00002	    과자	        1800

        SQL을 실행하면 다음과 같이 출력되어야 합니다.
            CATEGORY	MAX_PRICE	PRODUCT_NAME
            식용유	    6500	    맛있는산초유
            과자	        1800	    맛있는맛동산
*/


-- 정답

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM (SELECT RANK() OVER (PARTITION BY CATEGORY ORDER BY PRICE DESC) AS RANK,
              CATEGORY, PRICE, PRODUCT_NAME
      FROM FOOD_PRODUCT
      WHERE CATEGORY IN ('과자', '국', '김치', '식용유'))
WHERE RANK = 1
ORDER BY MAX_PRICE DESC;