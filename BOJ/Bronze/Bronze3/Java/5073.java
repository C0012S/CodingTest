/*
5073. Bronze 3 - 삼각형과 세 변

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    128 MB           48869	    22893     20843	         47.496%


    문제
        삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.
            · Equilateral :  세 변의 길이가 모두 같은 경우
            · Isosceles : 두 변의 길이만 같은 경우
            · Scalene : 세 변의 길이가 모두 다른 경우

        단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
        세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.


    입력
        각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.


    출력
        각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.


    예제 입력 1
        7 7 7
        6 5 4
        3 2 5
        6 2 6
        0 0 0
    예제 출력 1
        Equilateral
        Scalene
        Invalid
        Isosceles


    알고리즘 분류
        수학
        구현
        기하학
*/


// 메모리 : 14244KB
// 시간 : 100ms
// 코드 길이 : 2070B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] triangle; // 삼각형의 세 변의 길이를 저장하는 배열
    static StringBuilder sb;

    public static void distinguish() { // 세 변의 길이가 삼각형의 조건을 만족하는지 판별하는 메서드
        Arrays.sort(triangle);

        if (triangle[2] >= triangle[0] + triangle[1]) { // 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않은 경우
            sb.append("Invalid");
        }
        else if (triangle[0] == triangle[1] && triangle[1] == triangle[2]) { // 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길고, 세 변의 길이가 모두 같은 경우
            sb.append("Equilateral");
        }
        else if (triangle[0] == triangle[1] || triangle[1] == triangle[2] || triangle[0] == triangle[2]) { // 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길고, 두 변의 길이만 같은 경우
            sb.append("Isosceles");
        }
        else { // 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길고, 세 변의 길이가 모두 다른 경우
            sb.append("Scalene");
        }

        sb.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token;
        triangle = new int[3];
        sb = new StringBuilder();
        while (true) {
            token = new StringTokenizer(bf.readLine());
            triangle[0] = Integer.parseInt(token.nextToken());
            triangle[1] = Integer.parseInt(token.nextToken());
            triangle[2] = Integer.parseInt(token.nextToken());

            if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) {
                break;
            }

            distinguish();
        }

        System.out.println(sb);
    }
}
