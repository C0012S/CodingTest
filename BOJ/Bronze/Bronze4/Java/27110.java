/*
27110. Bronze 4 - 특식 배부

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    1024 MB          1978	    1662      1548	         85.289%


    문제
        설날을 맞아 부대원들을 위해 특식으로 치킨을 주문했다. 후라이드 치킨, 간장치킨, 양념치킨을 각각 N마리씩 주문했고, 1인당 치킨을 한 마리씩 배부하고자 한다.
        최대한 많은 부대원에게 본인이 선호하는 종류의 치킨을 배부해주기 위해 으뜸병사는 부대원들의 치킨 종류 선호도를 조사했고, 세 가지 치킨 중 후라이드 치킨, 간장치킨, 양념치킨을 가장 선호하는 인원의 수는 각각 A명, B명, C명이라는 것을 알아냈다. 이때, 모든 부대원은 각자 한 종류의 치킨만 골라 답했다.
        본인이 가장 선호하는 종류의 치킨을 받을 수 있는 인원수의 최댓값을 구하여라.


    입력
        첫 번째 줄에 주문한 각 종류의 치킨 마릿수 N이 주어진다. (1 ≤ N ≤ 1000)
        두 번째 줄에 후라이드 치킨을 가장 선호하는 병사의 수 A, 간장치킨을 가장 선호하는 병사의 수 B, 양념치킨을 가장 선호하는 병사의 수 C가 공백으로 구분되어 주어진다. (1 ≤ A, B, C ≤ 3000)


    출력
        본인이 가장 선호하는 종류의 치킨을 받을 수 있는 최대 인원수를 출력한다.


    예제 입력 1
        5
        1 7 6
    예제 출력 1
        11
    후라이드 치킨을 받고 싶어 하는 병사 1명과, 양념치킨과 간장치킨을 받고 싶어하는 병사 각각 5명씩 총 11명이 원하는 종류의 치킨을 받을 수 있다.

    예제 입력 2
        10
        9 8 7
    예제 출력 2
        24

    예제 입력 3
        5
        5 5 5
    예제 출력 3
        15

    예제 입력 4
        10
        100 200 300
    예제 출력 4
        30


    알고리즘 분류
        수학
        사칙연산
*/


// 메모리 : 14224KB
// 시간 : 124ms
// 코드 길이 : 1055B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 주문한 각 종류의 치킨 마릿수 N (1 ≤ N ≤ 1000)

        int maxNum = 0; // 본인이 가장 선호하는 종류의 치킨을 받을 수 있는 최대 인원수
        StringTokenizer token = new StringTokenizer(bf.readLine());
        for (int p = 0; p < 3; p++) { // 후라이드 치킨, 간장 치킨, 양념 치킨의 경우의 수 즉, 3 번 반복
            maxNum += Math.min(N, Integer.parseInt(token.nextToken())); // 해당 치킨을 가장 선호하는 병사 중 해당 치킨을 받을 수 있는 최대 인원수를 구한 후, 본인이 가장 선호하는 종류의 치킨을 받을 수 있는 최대 인원수에 추가
        }

        System.out.println(maxNum);
    }
}
