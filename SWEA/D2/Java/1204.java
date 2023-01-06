/*
1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기

    · 시간 : 10개 테스트케이스를 합쳐서 C의 경우 10초 / C++의 경우 10초 / Java의 경우 20초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.
    이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번 나타나는 값을 의미한다.
    다음과 같은 수 분포가 있으면,
    	10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3
    최빈수는 8이 된다.
    최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).
    
    [제약 사항]
        학생의 수는 1000명이며, 각 학생의 점수는 0점 이상 100점 이하의 값이다.
        
    [입력]
        첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
        각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄부터는 점수가 주어진다.
        
    [출력]
        #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.
        
        
    입력
        10
        1
        41 85 72 38 80 69 65 68 96 22 49 67 51 61 63 87 66 24 80 83 71 60 64 52 90 60 49 31 23 99 94 11 25 24 51 15 13 39 67 97 19 76 12 33 99 18 92 35 74 0 95 71 39 33 39 32 37 45 57 71 95 5 71 24 86 8 51 54 74 24 75 70 33 63 29 99 58 94 52 13 35 99 46 57 71 23 17 3 94 48 77 18 83 11 83 25 59 62 2 78 86 7 94 65 80 32 39 84 60 65 72 61 58 84 8 72 12 19 47 49 49 59 71 52 34 22 21 20 92 33 80 39 74 9 28 97 100 93 29 25 4 66 79 81 98 21 91 62 82 4 59 100 34 1 51 80 92 69 77 39 38 97 51 34 35 19 22 1 67 9 90 31 82 11 51 84 78 70 74 42 100 88 53 80 57 62 32 51 48 63 92 46 4 61 31 98 69 52 88 20 68 41 48 79 97 98 56 44 73 3 63 100 87 87 41 79 64 83 63 1 21 72 24 9 75 51 25 53 77 0 52 30 96 93 32 89 70 89 55 71 79 40 10 64 80 30 19 62 67 98 42 8 32 57 27 22 1 38 89 52 74 43 8 2 65 82 20 67 22 43 22 95 16 48 25 6 75 86 96 3 85 43 69 93 4 61 53 81 43 84 20 15 34 22 35 26 28 33 67 19 79 19 45 8 13 51 0 86 68 18 47 82 3 16 80 0 18 39 22 5 26 65 70 21 92 66 65 14 6 46 46 21 32 80 35 86 6 67 29 42 71 14 77 55 3 1 14 38 71 82 41 65 12 5 77 3 67 22 59 40 81 48 63 63 25 45 32 78 83 26 96 18 99 45 56 31 30 45 47 80 1 7 81 18 1 90 15 71 22 69 44 18 31 60 16 93 13 17 44 97 98 51 46 42 22 47 72 97 24 52 55 59 25 100 28 5 14 76 32 41 97 61 32 20 0 2 8 41 52 77 35 22 98 78 92 68 29 82 33 28 16 5 9 21 13 26 39 59 69 10 42 4 13 80 34 42 100 44 32 70 15 32 8 83 10 23 73 8 53 7 21 10 52 14 82 28 24 33 94 59 4 17 73 53 85 31 100 74 74 12 72 38 34 14 22 53 0 30 95 3 52 79 41 36 81 25 24 67 48 95 44 7 96 77 90 48 92 45 78 93 95 38 71 4 83 79 64 89 0 76 81 34 66 1 13 58 4 40 5 24 17 6 65 13 13 76 3 20 8 36 12 60 37 42 53 87 10 65 42 25 47 41 33 71 69 94 24 12 92 11 71 3 82 91 90 20 95 44 76 60 34 95 49 40 89 4 45 27 9 34 82 59 2 20 68 22 29 10 1 23 19 47 16 76 47 49 90 94 10 18 55 69 14 26 59 77 73 8 21 72 1 74 76 51 94 44 24 98 71 77 59 9 12 49 38 72 22 55 35 61 16 48 41 21 67 74 92 4 7 85 34 92 39 96 42 26 1 1 4 64 33 96 62 23 67 76 26 47 32 73 82 30 14 61 21 92 40 4 2 38 76 64 8 14 3 49 71 31 38 86 98 17 15 98 32 55 69 46 61 3 44 67 50 44 76 0 45 23 25 11 82 99 11 39 50 40 21 52 17 60 44 90 44 6 16 38 3 41 43 56 26 24 0 9 90 36 50 13 42 88 87 66 32 28 73 94 52 11 35 47 9 87 37 57 15 56 38 95 6 43 23 30 84 39 88 69 5 34 81 93 86 2 77 10 28 30 97 68 14 12 88 1 100 35 73 30 2 43 11 41 58 82 6 84 71 16 18 67 41 100 92 78 57 7 35 69 56 76 13 93 26 26 38 21 96 7 88 2 60 17 54 95 26 2 0 21 87 11 96 36 83 88 31 24 24 62 14 88 84 39 22 17 84 96 1 78 91 53 9 35 75 87 100 33 80 42 7 20 50 65 81 92 14 45 96 34 6 20 86 51 4 19 70 91 13 0 42 70 43 15 47 14 96 72 41 91 11 72 7 92 12 16 51 13 86 40 50 43 55 26 7 1 70 18 71 99 49 55 94 78 40 59 20 96 34 6 28 85 42 70 62 63 32 34 97 80 49 47 50 73 85 63 20 29 0 19 91 84 58 55 33 4 68 55 12 38 49 9 13 99 4 35 26 5 42 29 98 20 95 77 36 63 41 42 45 81 40 53 60 5 55 9 13 34 6 52 28 35 33 29 21 67 57 61 21 41 95 54 50 19 81 75 67 73 77 47 40 83 16 28
        2
        3 13 15 87 30 22 39 49 42 52 83 100 7 67 27 30 62 47 76 4 19 13 25 78 55 4 21 48 42 59 59 47 26 47 92 67 49 2 27 67 76 44 44 23 69 83 100 64 44 95 63 46 17 77 81 16 77 80 78 10 26 42 19 5 58 62 42 59 85 77 4 87 89 70 38 3 35 10 8 87 42 67 37 2 58 55 2 56 6 94 71 46 45 35 35 30 76 73 15 15 7 0 73 14 51 91 5 58 52 27 78 32 68 98 13 39 71 85 40 40 36 17 28 80 79 76 53 90 26 73 7 71 61 25 3 46 97 71 64 76 21 22 25 97 27 7 70 92 99 2 42 75 56 66 71 61 10 86 79 52 46 81 5 5 76 98 81 72 55 66 91 15 62 92 69 13 79 91 15 98 88 96 86 33 34 89 22 89 36 10 68 10 56 39 100 84 55 76 26 15 76 0 0 79 35 31 64 91 88 74 8 34 28 19 70 93 4 19 41 40 42 7 66 51 55 76 16 70 3 56 64 95 64 93 52 97 21 72 82 47 57 2 57 7 96 54 66 8 67 72 90 53 43 73 53 95 77 49 87 41 86 15 55 17 72 50 54 68 13 72 2 63 41 53 0 82 98 4 0 30 29 3 64 20 98 37 82 22 83 11 28 60 22 44 61 74 78 6 62 51 35 14 92 38 18 18 96 91 14 14 39 98 82 2 79 63 80 91 16 71 82 40 12 75 94 67 38 98 50 20 65 4 55 61 26 40 15 96 22 68 26 36 15 44 61 31 70 4 23 0 3 49 48 94 54 6 96 36 42 63 28 76 15 25 28 58 52 84 13 69 20 19 30 63 66 25 31 14 77 35 5 32 1 78 97 43 2 58 11 73 56 78 99 91 40 0 10 4 100 18 14 85 20 76 66 56 62 57 35 79 43 61 32 60 41 37 32 63 13 76 98 76 88 41 16 45 29 55 32 50 96 31 58 92 43 71 4 55 3 22 7 54 91 2 100 84 18 32 73 64 45 78 22 86 58 46 28 19 6 60 80 15 65 12 65 86 73 94 4 85 90 67 95 17 44 49 16 27 58 15 97 83 78 41 91 7 13 20 18 85 56 55 87 87 31 77 47 63 55 18 81 35 0 14 5 46 34 94 7 11 97 74 37 34 7 65 45 62 69 83 38 85 39 96 100 89 44 86 28 26 24 18 23 78 45 10 4 24 69 95 43 66 52 32 79 93 68 11 63 74 11 32 33 40 68 5 81 14 34 82 96 78 23 84 65 55 85 20 16 35 16 86 66 90 1 18 83 92 36 95 34 67 94 17 84 88 54 11 82 38 35 98 89 70 54 70 11 0 66 31 21 69 79 56 5 89 0 28 95 11 40 61 8 5 40 34 96 67 60 66 39 15 59 74 41 55 69 51 56 4 91 21 93 2 21 8 21 12 64 61 38 80 54 9 95 32 57 88 66 65 25 21 64 13 90 56 37 45 64 57 64 51 55 62 54 30 27 2 73 1 0 97 29 24 87 55 14 59 49 2 60 69 49 15 9 95 35 12 70 45 73 31 59 93 1 4 83 92 43 38 66 24 6 18 52 35 50 28 36 79 63 82 36 15 81 85 2 87 63 32 13 60 76 42 11 6 51 92 3 76 62 48 78 29 72 78 40 49 49 69 43 9 98 5 91 57 44 25 15 45 18 96 4 11 57 64 17 51 97 70 82 72 67 47 89 34 1 30 52 2 92 35 21 51 37 64 41 77 83 58 34 50 64 20 79 55 91 36 7 9 56 10 47 86 35 6 92 22 25 66 24 26 20 10 70 12 21 21 100 78 61 19 47 60 84 72 19 5 44 59 38 90 60 75 24 57 44 70 26 88 73 69 31 63 25 66 47 56 27 37 2 49 59 45 72 18 91 94 4 81 88 57 69 82 64 62 72 28 8 93 4 63 69 0 28 62 0 55 58 99 35 4 65 100 95 57 42 77 96 35 21 45 70 57 61 98 83 18 76 59 2 33 38 79 51 16 62 60 17 46 77 96 16 67 96 12 29 73 94 85 7 58 95 23 56 58 48 78 22 69 57 39 79 75 86 44 12 76 3 53 66 66 82 68 32 89 84 56 18 29 34 57 31 36 55 27 46 68 7 84 35 44 15 78 93 16 91 24 43 3 48 43 70 10 63 78 51 98 100 79 20 75 16 78 57 29 89 88 87 58 76 62 11 42 45 30 49 13 26 91 76 74 98 63 88 76 60 52 28 86
        3
        93 29 85 84 5 25 43 70 29 25 61 78 5 80 9 65 7 39 44 91 42 60 38 54 19 31 94 87 68 46 57 52 91 16 95 90 73 32 4 1 92 17 68 67 49 33 3 5 1 80 75 31 40 53 58 2 63 31 87 80 11 50 1 74 31 52 53 70 1 85 6 99 15 35 28 49 75 97 33 25 74 44 18 47 29 47 44 56 69 31 79 7 46 23 95 76 47 38 37 97 79 79 47 60 75 5 23 48 97 70 67 2 83 57 58 90 74 13 77 89 2 77 76 21 100 93 82 64 34 94 31 88 91 77 32 47 38 18 81 70 0 20 41 37 37 17 77 43 99 79 4 34 66 74 4 1 59 38 34 34 0 24 9 76 56 95 51 43 55 51 65 10 73 12 17 66 54 97 52 57 84 65 89 38 55 28 77 98 10 36 93 33 58 99 36 19 77 59 50 35 83 85 87 3 3 63 16 31 17 2 38 27 28 59 29 63 75 52 60 2 3 14 79 28 75 30 39 77 75 65 59 79 2 47 4 29 96 84 37 98 16 56 63 34 75 32 69 80 24 60 3 95 40 57 60 94 22 37 20 79 27 2 59 89 88 37 81 37 11 56 95 33 82 25 76 14 79 81 48 79 53 54 69 95 99 96 98 24 43 81 89 69 71 27 33 61 22 91 55 46 15 83 28 75 34 82 86 61 2 79 3 74 63 56 33 65 87 64 66 22 84 42 100 47 45 23 46 83 68 44 74 77 88 7 47 18 64 87 96 39 74 60 70 57 6 74 65 98 85 89 8 68 87 90 43 41 2 52 75 19 11 35 27 35 65 85 28 41 7 74 39 83 13 61 80 38 74 79 22 39 45 22 81 32 17 95 25 37 99 3 66 42 17 7 56 23 30 7 78 11 74 10 13 72 70 34 95 35 64 42 71 9 95 96 22 81 36 78 19 78 4 33 91 46 3 6 33 5 39 34 54 32 59 24 4 24 80 98 41 32 39 25 63 70 45 98 85 56 24 29 14 75 35 91 93 30 9 81 39 71 47 8 44 100 88 43 49 48 93 6 18 31 74 8 89 95 11 24 1 7 15 61 34 12 34 40 81 72 98 26 41 79 69 51 73 46 31 44 58 90 77 0 6 85 77 59 41 1 8 69 50 50 37 57 63 30 34 24 80 86 81 83 14 76 79 55 51 96 73 64 18 96 100 28 86 82 51 4 73 94 10 18 15 15 55 61 63 27 27 11 7 33 39 66 8 49 7 92 0 6 46 70 38 14 32 77 31 2 23 19 61 29 51 31 69 46 55 37 56 27 31 7 15 13 47 65 35 88 89 0 70 31 6 62 29 36 15 58 61 62 58 24 26 83 77 44 66 47 78 79 88 13 55 74 15 60 13 89 100 94 72 18 62 13 3 14 7 47 93 52 33 69 41 12 9 85 94 19 43 1 12 25 76 82 64 22 53 54 59 90 50 95 6 34 92 31 55 17 9 97 53 77 19 9 10 55 72 48 98 44 37 84 15 6 60 41 39 20 68 1 67 23 74 65 14 76 29 100 70 10 3 12 14 76 12 77 68 36 78 31 53 87 66 49 51 68 97 73 20 29 69 68 32 7 14 60 6 8 87 26 38 33 66 69 82 58 24 42 56 90 42 7 0 84 76 12 34 46 76 13 50 67 65 30 41 91 53 38 66 53 28 10 43 73 46 11 89 73 45 11 8 52 23 89 51 53 9 0 4 78 24 15 27 55 15 82 5 38 16 27 76 11 47 86 80 76 72 11 59 82 21 98 24 60 17 17 61 50 51 0 80 19 85 100 10 62 69 97 85 62 38 11 80 80 61 23 47 35 74 84 42 37 27 34 56 0 23 65 16 86 53 78 72 57 21 90 74 59 24 70 6 77 26 46 20 10 0 41 57 47 32 15 66 64 62 48 21 16 31 27 76 65 80 48 61 40 72 92 92 77 24 16 35 0 52 58 73 91 21 95 69 10 61 18 52 7 37 16 73 0 34 3 0 62 68 48 31 17 95 55 98 23 50 60 16 98 20 17 39 79 95 17 80 27 78 51 59 42 33 35 3 90 6 49 65 16 32 21 79 88 98 13 28 48 51 41 43 36 40 77 98 27 57 47 41 34 92 53 0 77 15 7 40 80 35 45 90 22 91 45 37 50 5 47 33 53 79 69 65 41 67 92 38 85 87 45 24 50 1 54 7 32 1 73 35 73 45 88 68 25 55 21 30 64 4 14 21 48 79 42
        4
        34 87 94 43 85 10 61 79 9 74 26 79 67 70 95 49 76 14 95 76 36 56 37 68 67 79 3 24 61 85 9 23 88 37 57 69 1 60 82 37 58 7 46 96 69 73 52 1 30 54 1 87 60 22 30 14 74 3 42 64 19 68 42 26 27 70 44 8 87 39 80 13 38 53 61 89 76 94 16 89 61 44 78 4 82 17 42 51 19 94 64 23 27 68 74 85 2 69 45 99 52 12 51 38 14 32 61 10 80 66 40 94 51 27 79 79 83 87 5 46 62 7 49 7 24 81 70 10 91 4 27 50 22 35 7 64 71 97 13 29 62 61 1 56 11 75 98 62 78 27 22 5 29 6 37 47 0 40 23 50 3 67 78 69 28 32 86 60 3 4 62 69 87 62 6 44 57 23 43 91 54 48 64 82 39 55 90 16 71 36 83 87 31 77 45 64 100 53 91 50 87 27 24 25 95 34 60 57 69 48 45 0 54 96 14 65 94 65 85 30 84 50 35 67 61 72 54 56 83 28 56 33 1 27 69 50 25 21 4 57 9 48 40 0 27 28 96 22 73 4 34 94 16 47 80 42 88 36 63 25 37 57 24 74 84 70 54 80 65 38 55 74 34 82 8 52 19 99 88 28 35 92 12 33 46 92 75 75 14 57 78 77 69 76 10 84 19 23 98 82 85 81 35 85 80 20 81 49 8 71 96 91 93 34 58 52 9 52 70 14 9 68 95 31 42 46 10 12 73 59 99 18 43 67 41 1 4 16 34 24 59 91 81 42 22 66 83 49 90 12 17 35 35 18 2 66 37 98 20 43 47 38 12 55 14 100 94 87 61 91 24 56 7 86 100 19 23 1 90 96 96 34 51 74 78 35 51 14 34 42 30 9 10 95 76 56 19 46 39 80 83 14 22 49 81 5 7 50 61 69 2 21 83 51 60 89 17 74 20 39 29 70 77 80 82 96 85 71 4 15 80 14 82 46 81 6 31 71 88 43 9 87 34 38 22 74 31 29 100 67 88 14 21 100 44 0 60 24 70 4 6 81 46 58 7 16 52 33 58 84 48 98 21 89 46 45 29 55 48 38 77 19 87 74 66 58 6 24 69 99 65 34 34 0 91 72 90 36 39 34 76 81 66 50 2 45 76 83 91 100 66 52 57 71 29 63 21 26 32 84 23 5 97 81 97 99 38 65 96 29 34 97 56 14 31 28 23 39 50 78 97 7 21 26 52 30 46 100 75 94 45 2 63 69 83 3 62 81 25 68 14 80 23 23 73 72 3 7 49 1 33 99 37 3 64 80 100 88 32 58 44 34 54 39 21 72 98 8 57 91 13 5 30 5 93 60 3 52 80 87 67 66 90 0 31 24 68 11 71 1 56 82 76 88 20 90 98 55 100 70 68 84 36 49 49 40 80 94 51 95 15 58 14 69 78 78 74 0 67 98 65 68 64 74 63 89 47 10 41 93 47 34 81 40 93 64 71 7 97 98 8 17 21 17 40 37 15 26 58 31 86 21 14 96 5 5 55 26 80 67 83 78 33 47 55 34 10 80 76 35 74 87 40 7 60 83 87 71 86 0 38 40 52 0 3 97 23 7 74 87 58 74 18 47 70 39 36 96 29 33 12 64 66 63 57 20 93 66 31 0 45 37 24 89 62 31 12 19 63 35 30 65 37 52 95 41 46 84 45 49 14 7 33 71 98 23 83 62 9 69 32 63 27 60 43 95 49 3 98 82 48 91 51 51 82 44 38 2 99 26 59 85 100 54 59 49 15 42 1 37 53 88 29 10 28 91 53 67 49 10 58 93 6 0 32 48 41 27 0 67 11 82 56 20 33 85 48 79 72 44 98 1 20 40 40 83 21 81 12 99 80 70 96 7 70 64 4 81 20 29 24 39 59 78 74 99 89 77 50 47 22 88 71 22 51 61 77 26 84 67 93 38 25 34 10 54 3 80 80 71 6 68 34 59 79 45 52 53 21 71 83 53 44 69 80 49 9 40 76 30 40 99 14 25 42 60 95 37 79 60 6 51 55 42 77 70 83 39 59 77 30 85 45 77 87 87 29 9 89 40 8 47 62 38 68 72 98 27 64 21 44 45 59 80 94 99 49 28 32 31 49 98 66 17 97 24 80 96 94 46 91 91 84 29 58 95 87 24 44 22 86 44 65 75 55 50 2 5 15 84 95 48 97 11 78 71 39 79 0 36 6 39 59 15 79 33 37 71 23 86 43 9 91 4 40 17 31 84 3 94
        5
        78 88 25 32 72 55 87 85 38 42 71 89 48 48 80 83 18 48 2 16 29 52 28 88 8 90 63 84 81 10 87 74 29 96 71 96 65 30 38 77 36 60 62 65 11 0 78 42 8 38 46 93 29 47 14 6 29 20 26 26 40 58 98 35 88 6 27 63 21 65 60 69 92 82 95 89 93 52 46 36 79 11 80 77 92 16 73 50 11 61 17 85 78 76 67 71 52 83 94 18 91 81 80 7 19 16 64 97 16 93 36 99 53 67 77 71 88 31 100 37 7 52 13 37 49 25 34 99 56 29 3 14 79 99 50 29 6 6 28 72 95 81 37 98 77 20 75 80 73 31 62 80 35 21 51 7 79 65 24 40 14 58 37 63 7 90 7 78 61 11 50 93 42 46 95 95 91 75 11 78 23 50 97 83 6 87 48 92 98 62 17 52 36 37 25 0 0 37 44 17 99 34 9 81 1 9 36 89 100 52 4 52 10 90 63 86 71 41 66 95 79 79 75 71 52 69 42 10 85 5 34 6 43 84 53 16 62 17 46 67 19 63 78 93 84 78 92 6 100 8 29 98 38 33 17 39 74 74 100 58 12 41 8 95 72 71 70 20 69 72 46 54 71 79 99 71 17 64 72 26 58 29 40 78 65 37 44 65 6 16 69 65 71 12 22 66 27 98 88 57 85 25 3 68 73 1 73 74 36 82 27 47 35 47 3 41 68 71 26 60 23 8 99 11 15 59 16 98 100 35 34 47 72 99 36 60 21 9 63 31 74 46 54 8 1 83 75 52 21 39 47 87 45 34 57 5 20 1 27 60 50 49 31 53 96 38 5 32 50 23 68 1 27 81 47 53 18 86 84 44 50 86 59 15 18 55 87 99 47 39 90 58 31 91 90 80 49 12 11 8 17 14 36 11 49 51 97 4 29 52 36 95 34 6 52 93 68 92 81 24 83 100 23 75 74 88 84 4 2 17 66 16 73 53 61 92 38 0 49 21 56 11 59 79 70 7 76 17 12 25 79 32 7 32 2 57 93 11 18 61 65 43 52 65 3 16 83 38 65 85 76 9 1 66 83 58 56 94 89 62 95 24 68 15 70 11 10 60 36 68 36 52 79 32 21 53 7 82 79 22 59 100 64 12 5 8 86 66 48 4 34 53 95 19 82 49 22 96 33 56 35 91 96 52 72 69 51 74 90 74 29 14 51 6 79 51 45 89 36 4 4 8 68 36 27 44 48 67 74 65 51 98 99 50 90 82 46 1 88 99 20 77 5 10 72 5 45 9 19 49 52 92 12 8 83 35 76 63 82 74 49 69 57 61 73 16 59 97 32 77 47 2 65 21 82 9 71 65 24 80 65 48 98 1 90 63 62 8 74 29 4 18 19 51 57 83 41 20 78 2 20 37 57 41 67 85 26 80 9 78 24 17 56 31 72 21 83 71 93 8 33 13 71 88 11 67 82 34 68 83 83 27 0 76 29 6 51 3 38 15 53 75 0 56 45 7 91 9 85 66 52 66 91 49 55 15 85 53 91 11 39 41 57 45 22 57 44 82 79 17 80 100 9 99 55 77 66 29 91 84 44 95 11 72 77 25 36 60 25 71 52 13 36 20 5 71 37 67 38 41 36 56 46 56 19 29 27 42 90 53 14 84 86 28 41 41 0 38 84 39 96 63 5 20 18 7 50 63 69 74 29 53 0 66 39 52 63 72 70 4 66 81 7 100 61 76 53 82 96 14 28 84 57 54 75 16 83 35 59 5 41 14 64 19 30 37 92 24 40 56 4 54 25 33 50 100 67 14 68 36 90 54 19 37 43 21 81 51 94 84 82 85 82 63 85 67 65 53 0 38 94 37 21 27 48 18 70 55 30 46 22 95 44 3 74 71 21 39 83 36 22 46 68 72 88 6 32 96 79 69 94 2 95 49 38 86 13 92 98 52 37 67 34 72 36 43 92 45 85 63 11 52 5 9 61 21 90 23 2 58 28 71 93 52 48 98 41 6 74 24 89 2 2 28 34 42 100 82 82 59 86 57 97 92 17 16 19 33 59 63 3 70 91 65 78 23 41 66 29 22 38 78 24 75 72 20 21 4 40 5 15 11 80 71 63 7 13 47 13 3 0 42 41 24 53 88 10 94 51 79 27 26 49 74 98 39 20 99 80 48 85 29 67 17 66 32 91 21 83 7 83 44 32 73 4 64 67 48 52 71 71 13 85 2 91 34 29 7 66 16 46 57 67 90 44 17 72 94 45 67
        6
        100 38 61 38 88 19 37 56 9 92 14 1 50 41 66 60 78 17 65 32 1 22 86 2 76 93 49 39 85 35 88 40 69 38 59 69 47 44 82 69 5 77 56 35 41 4 3 54 10 9 50 82 51 76 89 84 61 94 27 7 22 59 21 14 81 100 61 45 16 30 6 8 61 9 70 33 11 68 12 78 66 75 24 52 77 31 0 59 84 51 44 36 44 49 61 1 2 71 16 92 35 33 61 61 62 86 96 86 88 34 7 71 59 91 74 95 78 41 52 8 43 10 73 65 42 14 46 0 40 61 91 45 15 87 40 16 19 74 36 82 97 18 42 98 29 41 32 78 65 80 39 63 86 94 60 46 24 89 32 7 34 69 42 45 25 94 90 30 92 76 12 26 69 73 82 26 7 41 37 22 66 47 74 31 70 53 30 48 11 87 97 52 50 98 19 12 93 6 55 77 63 53 8 94 17 18 63 60 49 78 91 81 8 67 93 25 48 57 24 38 85 92 32 12 33 50 62 14 47 23 7 55 39 27 55 71 76 13 47 25 59 88 27 61 23 34 57 85 51 10 50 25 12 24 13 32 80 92 13 0 34 46 88 38 33 51 73 61 18 29 8 11 10 95 56 85 57 35 44 93 47 31 88 5 48 74 26 74 7 20 64 20 43 90 61 67 69 39 20 22 66 28 90 86 56 39 79 42 68 25 40 14 86 85 96 0 78 55 73 67 59 7 84 96 93 95 51 100 64 22 12 86 83 31 75 51 96 8 60 29 64 29 29 18 50 39 36 3 16 74 90 89 71 11 16 3 32 80 19 89 71 5 58 94 18 53 88 57 44 36 39 7 9 19 82 98 52 66 5 10 79 83 29 51 14 41 23 94 97 92 40 93 10 13 56 61 56 30 94 81 19 59 16 67 83 13 19 92 34 83 62 83 26 94 100 73 29 17 19 84 9 57 44 79 10 70 52 46 48 15 26 56 8 73 85 88 65 79 6 34 37 67 99 45 49 78 47 81 5 55 19 95 67 28 56 75 51 49 42 90 6 7 75 41 89 20 71 85 8 65 62 36 66 42 52 100 81 84 30 65 55 25 86 60 96 23 59 90 19 69 66 34 46 8 70 45 8 47 62 80 43 17 31 2 63 79 12 42 14 45 80 93 27 91 17 83 20 44 4 79 83 63 57 51 82 68 95 95 7 46 35 2 94 93 71 86 65 7 13 3 58 4 92 38 97 28 16 94 87 30 13 79 77 1 39 20 13 4 17 84 60 10 5 59 18 99 36 60 30 2 67 4 9 56 47 85 84 8 19 56 22 31 32 17 86 24 40 16 61 48 62 23 25 96 88 7 92 85 7 50 55 1 60 50 6 93 83 76 82 1 23 28 45 78 33 13 15 5 21 61 86 38 34 22 37 47 47 22 44 22 81 71 60 85 0 1 61 58 3 48 71 95 59 12 1 85 44 66 56 79 7 66 37 54 52 33 13 68 96 5 53 51 74 18 13 83 57 90 60 64 100 6 60 8 50 83 69 32 20 80 44 81 54 14 78 83 5 90 8 64 79 2 36 51 90 92 96 82 75 48 46 34 70 12 92 24 36 83 66 39 42 38 85 96 67 2 32 68 19 18 56 34 49 85 76 81 30 58 94 18 76 79 21 100 86 12 46 67 22 56 31 36 59 59 64 64 42 96 24 88 65 81 81 47 46 39 50 99 79 1 60 29 43 12 91 33 43 40 85 23 87 74 45 92 76 10 59 63 79 17 50 92 95 86 35 48 60 8 68 70 34 59 41 55 23 67 15 59 51 67 3 26 28 66 75 99 39 95 86 98 70 7 39 66 86 23 93 1 71 64 13 28 30 43 52 39 53 99 30 26 100 0 68 69 65 18 4 75 4 51 68 51 52 14 3 9 31 74 78 15 63 20 70 19 91 88 55 72 72 66 56 50 81 53 46 75 92 100 74 63 100 54 96 76 56 63 1 12 46 55 37 58 10 75 80 83 46 7 37 2 57 87 89 17 82 58 21 44 51 24 73 87 64 25 11 5 2 30 95 81 17 89 11 44 24 70 45 84 71 20 66 71 86 57 68 62 42 100 24 6 46 76 13 51 31 80 62 43 72 66 70 54 88 62 52 35 31 89 68 97 64 82 59 76 73 80 2 33 20 39 7 11 58 66 1 17 25 57 65 38 25 78 4 88 94 68 74 53 80 58 80 93 9 81 100 63 36 66 51 1 66 89 64 52 71 94 68 95 61 97
        7
        72 33 81 87 35 71 31 80 44 63 35 74 86 55 44 0 96 94 85 2 41 22 15 94 20 69 62 53 77 64 69 23 29 40 94 83 68 78 5 18 38 80 41 35 35 58 90 2 18 7 74 86 88 73 59 37 73 62 11 72 78 71 48 93 49 5 22 15 55 48 6 39 96 91 0 36 8 92 67 8 48 70 9 14 94 56 29 6 65 77 21 15 7 2 23 23 81 35 60 59 65 47 93 35 97 57 97 1 55 68 47 8 47 83 85 72 35 12 10 98 8 65 22 95 18 10 18 1 68 82 3 34 66 65 92 91 56 60 72 84 30 93 92 39 24 95 43 85 75 95 74 26 21 21 70 5 22 88 10 4 31 13 40 88 42 86 100 23 67 23 60 6 1 30 53 75 60 24 61 18 18 36 85 29 33 59 63 41 87 93 20 0 64 76 6 35 23 5 27 48 6 78 86 94 84 36 100 36 81 24 91 72 31 52 10 37 65 21 7 67 29 53 3 7 46 43 86 82 68 89 68 67 87 97 64 38 61 35 11 25 26 66 46 39 37 82 12 71 19 71 43 50 46 91 78 24 56 67 96 86 21 50 81 64 54 73 28 62 64 20 51 35 84 51 5 57 76 90 52 89 34 15 70 40 14 96 39 81 36 14 13 80 46 60 84 26 83 30 33 16 95 35 36 94 65 98 78 81 30 65 60 96 15 54 8 43 93 83 53 61 23 57 54 35 16 27 35 66 81 9 81 7 58 66 69 79 76 29 91 31 100 79 4 66 75 11 55 67 30 48 87 23 79 53 76 26 100 83 2 41 95 98 90 28 2 62 19 46 44 57 96 2 42 68 13 87 93 93 83 4 45 12 58 77 99 24 31 52 89 28 69 48 93 72 100 41 50 72 71 1 35 96 0 88 73 66 80 73 84 62 12 1 62 65 85 67 16 92 89 71 20 3 55 73 37 82 57 80 35 38 89 72 51 32 96 95 9 62 82 73 0 28 56 10 1 33 54 30 3 26 25 41 6 71 25 83 71 10 52 36 83 60 95 91 62 19 40 60 29 81 96 83 20 16 28 18 61 23 34 25 40 100 3 60 90 17 39 49 61 13 69 59 32 40 35 82 86 48 62 30 79 28 96 93 67 44 95 59 80 100 65 30 70 42 40 71 95 1 11 21 66 67 38 35 96 28 85 37 66 33 3 99 95 25 52 58 80 29 95 81 13 20 42 75 48 78 37 86 96 73 42 87 25 33 37 86 15 77 29 66 36 4 89 86 86 27 20 7 86 94 44 58 77 66 97 21 64 30 62 32 22 36 84 79 60 49 36 13 63 98 37 42 1 96 54 37 61 15 24 24 9 4 23 65 28 45 65 27 61 84 42 6 21 50 61 69 25 14 53 33 69 36 19 34 58 27 17 90 32 51 0 10 40 48 72 4 55 32 18 26 88 69 97 7 26 25 92 18 14 28 94 79 51 10 98 70 80 97 87 14 83 67 11 33 5 41 80 79 90 96 41 17 34 63 91 2 56 11 84 13 32 53 70 80 100 73 77 32 38 17 87 76 99 17 31 20 24 62 24 18 68 62 89 91 37 59 83 31 62 83 93 0 0 81 87 96 63 1 3 77 13 93 20 76 66 40 32 24 27 45 33 9 96 5 85 43 2 40 78 33 68 38 64 48 40 67 36 54 5 29 93 71 33 43 37 61 88 7 13 31 7 62 24 41 79 0 79 36 13 36 72 30 10 59 94 74 79 23 18 73 22 55 15 42 9 75 36 3 67 50 84 34 13 55 62 98 86 15 32 95 6 50 21 91 74 92 78 33 66 9 64 64 95 17 37 40 31 61 63 34 22 35 98 61 98 1 61 50 84 56 92 7 84 59 60 51 41 10 95 69 32 74 10 86 91 50 69 21 70 0 10 55 31 56 45 61 24 92 67 86 13 71 56 71 38 59 27 20 27 39 34 8 2 40 85 52 7 12 59 6 31 84 50 68 17 40 29 90 65 8 45 73 58 72 53 72 34 49 97 19 34 45 58 23 66 19 64 18 75 86 12 80 15 60 69 0 74 74 68 97 100 95 38 83 63 13 92 19 84 73 58 72 34 100 8 79 9 13 12 84 51 79 73 46 77 69 47 40 97 37 60 49 59 37 36 42 87 14 23 72 77 20 23 70 1 77 28 20 51 54 1 16 51 81 40 74 90 66 42 42 85 20 17 25 42 70 76 6 45 33 98 82 31 44 20 92 16 99 55 41
        8
        94 3 36 44 23 50 83 39 24 41 85 78 63 7 77 20 52 1 44 44 0 25 16 32 56 40 1 42 24 99 25 56 61 74 25 63 14 80 53 25 15 98 71 17 90 98 47 97 47 72 15 80 30 71 67 4 38 20 76 14 78 95 3 43 14 92 68 41 89 92 2 63 5 44 56 60 96 24 46 34 49 68 14 97 84 72 92 54 36 77 2 70 73 83 36 1 9 31 13 46 39 15 78 48 91 23 59 17 67 33 77 51 31 48 12 18 41 59 15 87 11 71 30 57 31 72 66 81 67 10 99 17 75 79 81 84 32 3 3 14 97 10 54 14 65 7 14 100 55 98 75 45 7 55 1 22 68 65 80 7 58 10 10 7 92 75 86 6 83 78 2 78 43 20 4 83 65 98 89 33 93 8 34 6 77 85 2 100 22 33 17 59 22 55 83 82 1 78 89 91 35 20 77 19 2 97 53 36 62 75 91 15 68 9 71 52 79 31 70 4 82 29 0 90 91 75 96 21 32 33 1 57 48 74 19 3 52 98 64 18 77 39 70 55 8 40 84 87 97 87 87 55 89 17 9 62 18 43 67 19 11 21 17 51 71 62 48 1 16 64 87 51 55 97 9 87 42 9 47 53 95 29 71 84 48 56 62 56 55 97 14 85 70 92 42 22 94 46 50 63 19 58 96 77 36 55 65 47 59 7 0 94 28 68 57 49 65 72 76 5 28 72 6 95 53 75 94 55 27 88 81 40 3 70 20 4 95 70 16 88 61 5 9 36 78 61 44 9 71 74 6 21 91 97 1 86 22 70 74 58 21 52 55 13 24 70 19 74 74 9 0 29 10 43 54 96 48 39 6 96 31 36 69 18 88 58 49 50 83 13 53 56 60 64 91 6 37 54 29 63 7 79 35 5 56 41 39 24 4 7 96 51 39 17 56 93 46 46 45 8 100 67 71 42 8 82 30 82 47 97 90 71 13 42 41 66 34 46 83 68 11 47 67 32 34 13 77 18 71 54 93 38 50 4 80 100 56 93 86 48 85 88 78 72 44 21 100 16 69 83 85 63 97 25 67 54 12 16 52 30 5 65 82 86 75 48 58 18 42 4 94 26 68 51 27 96 74 72 56 31 98 3 0 24 97 60 32 59 86 29 40 43 72 21 40 57 54 78 52 53 72 41 50 66 46 52 53 86 74 24 32 60 17 29 70 74 42 82 50 46 25 64 59 97 29 25 98 70 44 68 93 65 1 43 29 15 12 96 86 54 36 40 24 92 27 59 45 98 45 69 64 71 2 0 48 43 61 70 91 58 0 1 53 50 96 69 78 8 16 7 21 18 48 41 79 45 42 33 0 45 8 1 99 17 92 16 19 6 88 92 30 80 38 47 58 83 72 65 9 66 13 55 85 75 18 52 44 64 33 0 29 87 47 97 24 69 95 54 53 57 21 3 91 84 30 51 31 0 26 99 55 91 84 46 12 10 94 100 6 82 18 95 2 100 82 97 5 37 47 38 55 57 42 4 23 13 9 85 69 5 33 6 20 88 42 67 22 5 0 4 52 13 43 71 48 83 1 79 19 90 10 49 87 3 24 88 97 100 9 91 45 50 7 19 30 47 86 29 92 78 60 98 62 77 87 22 21 83 30 81 68 9 94 30 51 30 20 58 57 0 77 2 50 77 86 81 33 99 45 70 19 32 1 60 4 71 68 57 2 40 87 40 12 93 75 68 3 7 20 71 54 91 20 54 42 66 39 11 34 4 22 51 33 15 63 18 55 85 23 17 41 73 98 88 93 4 22 99 28 9 83 38 74 40 4 42 62 76 36 20 76 23 79 13 29 61 2 59 34 33 34 59 99 93 44 69 65 13 32 15 78 89 69 19 19 65 85 6 49 25 66 78 16 42 76 69 16 40 64 59 44 57 24 88 65 1 38 64 63 12 47 2 29 35 56 63 11 7 99 81 40 58 43 40 80 6 34 9 28 17 21 8 43 42 7 8 39 39 20 79 70 54 66 72 19 29 65 93 81 8 30 23 14 51 87 85 6 31 47 66 13 48 78 48 40 3 96 78 62 93 52 0 86 59 47 47 19 45 45 6 58 54 79 17 90 89 71 74 27 31 38 78 2 9 83 61 21 52 18 4 73 27 1 72 15 7 65 43 60 35 80 89 52 43 33 71 97 76 32 91 67 6 16 13 92 42 10 37 33 31 92 51 36 1 49 42 43 93 37 47 97 12 34 89 34 0 8 17 92 24
        9
        76 34 37 56 81 31 39 64 15 22 69 94 74 34 1 55 21 3 84 33 98 10 97 0 51 25 22 98 66 82 100 23 28 6 57 95 43 49 38 74 33 56 1 95 30 53 71 84 17 68 100 37 96 39 69 86 26 23 56 43 96 92 60 100 68 56 47 49 18 76 82 30 92 34 65 17 48 41 75 56 80 34 2 54 24 92 18 76 8 53 47 36 62 65 37 71 94 92 97 75 94 32 3 16 97 57 81 1 7 48 12 39 80 93 95 29 93 8 35 39 51 89 45 13 58 48 21 2 46 9 20 71 100 80 49 50 82 14 64 56 3 57 52 42 9 62 69 41 11 55 78 56 32 92 74 1 36 8 58 85 40 12 58 18 83 1 90 97 71 12 92 5 45 23 87 48 69 95 78 51 51 33 17 22 67 100 90 9 5 42 34 67 32 15 52 45 92 50 97 15 70 47 59 74 28 37 68 34 10 46 54 18 51 60 50 2 95 36 13 46 21 67 90 10 99 27 93 60 91 15 92 43 63 30 82 13 81 1 42 41 50 75 91 92 42 44 43 8 2 32 25 48 11 39 36 93 70 100 60 75 88 12 99 10 15 51 50 89 73 12 96 58 58 42 56 1 24 48 90 43 90 62 43 68 47 83 67 59 38 3 85 70 64 24 9 95 86 27 60 23 35 24 59 41 11 12 37 79 0 75 93 91 61 59 98 98 72 93 88 2 37 41 85 85 44 16 42 41 57 10 13 67 68 83 72 77 9 98 45 25 76 64 83 38 33 6 88 18 31 11 16 64 35 88 28 84 82 32 97 11 47 69 88 12 61 46 43 49 76 66 3 2 27 10 5 54 27 88 85 64 74 25 11 52 79 52 87 91 63 87 15 92 11 45 64 82 19 24 9 60 85 35 18 94 76 92 28 84 77 46 81 40 4 85 30 92 99 58 9 29 2 76 39 46 74 71 16 8 20 23 19 31 32 70 52 45 14 76 92 80 6 59 31 55 58 36 69 19 59 22 62 5 59 74 61 56 5 95 22 42 72 46 47 39 96 91 47 100 83 47 58 28 79 19 35 42 42 67 80 31 63 63 77 28 50 71 46 14 59 41 49 44 11 63 36 33 90 69 65 85 20 54 4 53 23 23 73 48 97 44 98 4 34 11 15 88 66 47 97 17 11 21 58 35 19 26 99 72 64 32 86 43 52 100 80 69 33 57 84 21 17 48 12 50 81 80 17 64 40 55 61 99 31 9 54 5 95 54 74 20 93 99 50 61 36 39 54 69 98 23 99 83 0 94 99 29 14 51 57 62 9 25 79 26 11 67 93 58 49 61 58 34 88 4 92 63 44 9 71 9 57 100 96 76 4 24 99 82 0 100 68 59 39 44 94 72 83 72 19 10 82 74 25 50 52 17 91 64 63 88 83 55 42 51 43 47 44 61 11 95 55 56 34 89 81 64 27 21 66 93 84 96 67 42 82 38 0 21 75 60 83 16 84 33 55 20 59 58 91 40 30 93 17 0 71 98 5 77 73 74 98 57 70 59 79 97 29 32 54 47 5 63 94 7 66 49 76 63 51 82 78 90 95 34 21 16 100 92 37 70 38 54 58 83 65 60 4 8 8 18 58 28 51 85 1 67 50 1 32 15 75 65 39 5 79 72 22 87 76 1 19 55 66 77 69 16 49 13 37 58 31 12 80 1 23 6 84 12 35 81 23 96 46 63 78 55 73 92 13 45 58 74 82 25 46 51 60 69 93 66 25 51 65 86 82 50 72 81 95 100 23 11 83 2 45 94 90 53 92 30 68 25 54 54 84 29 3 19 68 80 26 16 21 31 59 12 4 61 48 18 14 52 10 99 35 92 27 43 39 58 6 2 97 65 63 60 71 23 34 18 54 22 2 36 47 67 75 61 70 65 54 87 39 18 36 10 33 79 25 54 95 35 83 58 46 60 72 78 20 60 49 19 1 43 90 42 27 95 59 77 93 68 23 92 55 86 35 77 6 13 76 41 36 18 88 9 28 100 18 53 53 89 38 85 1 19 94 90 45 89 10 56 12 53 94 16 17 6 98 38 23 16 6 32 7 53 57 78 52 29 99 0 47 84 48 13 97 92 64 78 30 35 13 29 47 16 52 95 42 62 28 9 30 89 35 68 35 79 65 91 16 86 77 92 97 28 53 54 83 100 0 91 38 14 64 62 52 4 19 50 31 67 26 100 11 58 43 91 79 4 29 9 90 21 87 13 85 3 96 77
        10
        91 77 93 100 72 18 26 56 20 6 19 32 75 52 34 67 88 27 86 85 97 17 19 46 17 79 43 65 36 11 44 56 16 69 23 13 90 21 94 77 67 31 26 47 50 82 33 48 4 75 82 74 6 76 3 33 99 61 64 17 93 26 35 47 66 72 89 47 12 32 24 38 57 18 89 73 47 49 16 58 42 11 26 1 29 76 65 54 98 71 14 54 85 44 78 97 97 25 53 68 74 76 93 34 67 81 31 43 62 12 48 74 19 64 34 76 99 35 37 83 71 4 94 17 39 99 33 42 17 73 53 29 7 98 98 63 23 7 43 64 59 24 62 98 19 50 82 37 7 88 85 72 56 17 50 19 46 51 61 1 72 74 47 84 9 41 20 90 19 19 87 97 6 39 70 76 35 44 79 53 96 58 79 68 14 65 92 28 95 72 19 99 72 21 98 56 32 58 85 54 52 55 45 75 16 15 2 36 25 27 53 89 28 83 37 64 58 9 48 85 78 26 48 79 79 68 26 70 72 85 68 33 33 39 8 88 16 68 43 56 83 67 38 11 61 52 56 34 64 100 66 85 71 48 2 92 79 56 22 34 12 23 34 55 21 17 23 97 5 49 13 46 41 50 17 89 21 52 47 87 3 3 26 97 26 52 60 55 93 57 47 57 68 71 96 21 87 8 4 32 73 80 6 11 55 51 48 83 36 64 60 36 29 33 0 0 81 21 70 2 67 63 97 62 82 93 26 88 6 18 83 12 77 63 27 79 17 3 65 33 39 81 31 19 14 91 66 36 61 77 50 93 38 38 1 42 85 66 53 30 80 15 35 53 23 80 50 92 12 91 20 30 73 90 4 20 87 53 90 69 50 52 87 62 27 95 8 60 80 18 54 43 88 71 20 12 87 83 74 5 93 96 30 98 100 46 69 61 92 85 87 64 61 72 95 7 33 31 45 67 72 46 97 73 89 87 53 21 91 5 70 35 4 5 43 98 24 74 95 53 3 98 63 1 36 33 41 50 91 67 83 12 82 57 99 41 38 97 86 22 72 3 31 20 15 54 14 36 68 91 21 90 43 63 27 46 50 98 79 61 59 19 100 87 17 53 21 81 70 11 30 17 67 60 54 4 47 91 30 91 98 26 1 67 57 55 25 49 20 67 85 42 47 44 6 96 73 62 65 85 83 12 19 33 88 83 85 53 26 99 84 9 6 93 13 5 25 95 63 44 21 68 93 37 88 65 78 73 28 33 85 11 42 58 62 0 33 72 57 81 78 20 58 54 79 80 60 73 13 5 64 68 2 50 62 77 82 43 5 7 83 88 20 83 65 82 28 72 72 26 99 96 16 2 40 86 67 50 59 30 61 15 18 83 43 44 20 86 92 9 58 92 35 27 81 98 19 17 21 5 78 99 52 84 25 35 7 38 29 43 53 17 49 96 16 51 8 96 80 69 45 29 24 56 98 89 27 36 96 77 52 28 38 50 72 22 82 27 18 71 37 27 98 21 93 80 26 63 51 41 51 78 98 71 98 18 88 68 66 38 21 0 4 36 84 81 51 39 28 65 0 43 49 48 16 10 31 48 66 10 96 87 71 59 51 62 18 38 93 8 55 68 5 19 40 28 64 2 26 40 14 3 63 29 55 80 18 100 86 37 12 11 70 19 13 33 77 33 30 61 30 9 35 81 47 67 84 29 40 65 72 66 1 49 4 75 88 62 78 41 81 65 78 97 44 95 56 19 49 62 0 74 6 67 62 67 74 67 34 20 21 42 91 6 99 94 40 82 53 73 72 21 97 88 7 43 78 49 98 22 58 72 56 7 13 29 2 23 88 15 54 98 72 33 38 45 96 5 66 21 44 14 72 77 64 70 10 9 13 44 66 45 24 90 27 5 16 53 19 11 32 99 39 72 31 18 42 87 51 84 65 24 26 60 62 66 91 20 39 70 0 79 44 8 67 58 67 96 24 37 61 100 85 49 89 23 83 2 11 84 71 88 84 90 24 17 82 95 70 9 84 55 70 65 54 40 69 10 43 51 62 31 30 90 3 16 96 32 67 60 67 39 86 80 2 32 62 64 11 76 69 94 81 52 29 36 29 4 64 24 61 71 12 97 70 65 72 37 40 7 40 43 58 77 19 12 5 80 69 2 43 74 97 63 13 32 72 80 18 57 10 40 73 10 18 45 20 69 64 11 9 71 61 45 43 71 20 54 10 60 0 27 95 29 96 54 15 69 34 25 52 31 45 54 18 85 66 31 65 10
        
    출력
        #1 71
        #2 76
        #3 79
        #4 80
        #5 52
        #6 66
        #7 35
        #8 97
        #9 92
        #10 72
*/


// 실행 시간 : 0.18556s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int Test_num = sc.nextInt();
			int[] score = new int[1000]; // 학생들의 성적 리스트
			int[] count = new int[101]; // 성적 개수 리스트  // 101의 크기를 가지고 초기값이 0인 배열
			
			for (int s = 0; s < score.length; s++) {
				score[s] = sc.nextInt(); // 학생들의 성적 입력
				
				count[score[s]] += 1;
			}
			
			int max_score_count = count[0];
			int max_score = 0;
			for (int c = 1; c < count.length; c++) {
				if (count[c] >= max_score_count) {
					max_score_count = count[c];
					max_score = c;
				}
			}
			
			System.out.println("#" + Test_num + " " + max_score);
		}
	}
}
