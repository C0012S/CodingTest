/*
25640. Bronze 4 - MBTI

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    512 MB           2703	    2268      2153	         85.032%


    문제
        진호는 요즘 유행하는 심리 검사인 MBTI에 관심이 많다. MBTI는 아래와 같이 네 가지 척도로 사람들의 성격을 구분해서, 총 16가지의 유형중에서 자신의 유형을 찾을 수 있는 심리 검사이다.
            · 내향(I) / 외향(E)
            · 직관(N) / 감각(S)
            · 감정(F) / 사고(T)
            · 인식(P) / 판단(J)

        모든 유형의 목록은 다음과 같다.
            · INFP, ENFP, ISFP, ESFP, INTP, ENTP, ISTP, ESTP, INFJ, ENFJ, ISFJ, ESFJ, INTJ, ENTJ, ISTJ, ESTJ

        진호는 N명의 친구들에게 MBTI 유형을 물어 봤다. 이 중에서 진호와 MBTI 유형이 같은 사람의 수는 얼마일까?


    입력
        첫째 줄에 진호의 MBTI 유형이 주어진다.
        둘째 줄에 진호의 친구의 수 N(1 ≤ N ≤ 100)이 주어진다.
        셋째 줄부터 N개의 줄에 친구들의 MBTI 유형이 주어진다.


    출력
        진호와 MBTI 유형이 같은 사람의 수를 출력한다.


    예제 입력 1
        ESTJ
        5
        ISTP
        ESTJ
        INTP
        ESTJ
        ENTJ
    예제 출력 1
        2

    예제 입력 2
        INTP
        6
        INTP
        INTP
        ESFP
        ISFP
        INFP
        INTP
    예제 출력 2
        3


    알고리즘 분류
        구현
        문자열
*/


// 메모리 : 14260KB
// 시간 : 120ms
// 코드 길이 : 629B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String MBTI = bf.readLine(); // 진호의 MBTI 유형
        int N = Integer.parseInt(bf.readLine()); // 진호의 친구의 수 (1 ≤ N ≤ 100)

        int sameMBTI = 0;
        for (int n = 0; n < N; n++) {
            if (MBTI.equals(bf.readLine())) {
                sameMBTI += 1;
            }
        }

        System.out.println(sameMBTI);
    }
}
