/*
1639. Silver 1 - 행운의 티켓

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           777	    382       329	         54.201%


    문제
        프로야구단 다숌 자이언츠에서는 야구장에 오는 손님에게 티켓을 나누어준다. 그리고 나서 그 티켓 중에 다음과 같은 규칙을 가진 티켓을 행운의 티켓이라고 하며, 그 티켓을 가진 사람들에게 상품을 나누어준다.
        행운의 티켓은 정확하게 2N자리로 이루어진 티켓이다. 왼쪽 N자리의 합과 오른쪽 N자리의 합이 일치하면 그 티켓은 행운의 티켓이라고 한다.
        숌은 티켓 번호를 조작하려고 한다. 어떤 문자열이 주어지면, 그 문자열의 연속된 부분 문자열중 행운의 티켓 규칙을 만족하는 최대 부분 문자열의 길이를 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 문자열 S가 주어진다. 문자열 S는 1보다 크거나 같고, 9보다 작거나 같은 수로만 이루어져 있고, 길이는 50보다 작거나 같은 자연수이다.


    출력
        첫째 줄에 주어진 입력의 연속된 부분 문자열 중 행운의 티켓 규칙을 만족하는 부분 문자열의 최대 길이를 출력하시오. 찾을 수 없다면 0을 출력한다.


    예제 입력 1
        74233285
    예제 출력 1
        4

    예제 입력 2
        123231
    예제 출력 2
        6

    예제 입력 3
        986561517416921217551395112859219257312
    예제 출력 3
        36

    예제 입력 4
        1
    예제 출력 4
        0

    예제 입력 5
        112
    예제 출력 5
        2


    알고리즘 분류
        구현
        브루트포스 알고리즘
*/


// 메모리 : 14160KB
// 시간 : 124ms
// 코드 길이 : 3105B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S; // 1보다 크거나 같고 9보다 작거나 같은 수로만 이루어져 있고, 길이는 50보다 작거나 같은 자연수인 문자열 S
    static int maxSize; // 행운의 티켓 규칙을 만족하는 부분 문자열의 최대 길이

    public static void findTicketMaxSize(int stringSize, int windowSize) {
        while (windowSize > 0) {
            for (int s = 0; s <= stringSize - windowSize; s++) {
                int halfSize = windowSize / 2; // 검사할 행운의 티켓의 길이의 반
                String first = S.substring(s, s + halfSize); // 검사할 행운의 티켓의 앞 부분의 문자열
                String second = S.substring(s + halfSize, s + windowSize); // 검사할 행운의 티켓의 뒷 부분의 문자열
                int firstSum = 0; // 검사할 행운의 티켓의 앞 부분의 문자열을 구성하고 있는 수들의 합
                int secondSum = 0; // 검사할 행운의 티켓의 뒷 부분의 문자열을 구성하고 있는 수들의 합

                for (int i = 0; i < halfSize; i++) { // 검사할 행운의 티켓의 문자열을 구성하고 있는 수들의 합 구하기
                    firstSum += first.charAt(i) - '0';
                    secondSum += second.charAt(i) - '0';
                }

                if (firstSum == secondSum) { // 검사할 행운의 티켓의 앞 부분의 문자열을 구성하고 있는 수들의 합과 뒷 부분의 문자열을 구성하고 있는 수들의 합이 같을 경우
                    maxSize = windowSize; // 해당 행운의 티켓의 길이가 행운의 티켓 규칙을 만족하는 부분 문자열의 최대 길이
                    return; // 검사할 행운의 티켓의 길이를 가장 큰 길이부터 설정하여 검사했으므로 행운의 티켓 규칙을 만족하는 첫 번째 행운의 티켓의 길이가 최대 길이다.
                }
            }

            windowSize -= 2; // 행운의 티켓의 길이는 2의 배수이므로 검사할 행운의 티켓의 길이를 2씩 줄여가며 설정한다.
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        S = bf.readLine();

        int stringSize = S.length(); // 문자열 S의 길이
        int windowSize; // 검사할 행운의 티켓의 길이
        if (stringSize % 2 == 0) { // 문자열 S의 길이가 짝수일 경우
            windowSize = stringSize; // 문자열 S의 길이만큼의 길이를 가진 행운의 티켓의 길이를 검사할 길이로 설정
        }
        else { // 문자열 S의 길이가 홀수일 경우
            windowSize = stringSize - 1; // 문자열 S의 길이보다 1 작은 짝수의 길이를 가진 행운의 티켓의 길이를 검사할 길이로 설정
        }

        findTicketMaxSize(stringSize, windowSize);
        System.out.println(maxSize);
    }
}
