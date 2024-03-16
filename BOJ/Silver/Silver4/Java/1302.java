/*
1302. Silver 4 - 베스트셀러

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초	    128 MB           25024	    13427     11144	         53.766%


    문제
        김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다. 김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.
        오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.


    입력
        첫째 줄에 오늘 하루 동안 팔린 책의 개수 N이 주어진다. 이 값은 1,000보다 작거나 같은 자연수이다. 둘째부터 N개의 줄에 책의 제목이 입력으로 들어온다. 책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.


    출력
        첫째 줄에 가장 많이 팔린 책의 제목을 출력한다. 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.


    예제 입력 1
        5
        top
        top
        top
        top
        kimtop
    예제 출력 1
        top

    예제 입력 2
        9
        table
        chair
        table
        table
        lamp
        door
        lamp
        table
        chair
    예제 출력 2
        table

    예제 입력 3
        6
        a
        a
        a
        b
        b
        b
    예제 출력 3
        a

    예제 입력 4
        8
        icecream
        peanuts
        peanuts
        chocolate
        candy
        chocolate
        icecream
        apple
    예제 출력 4
        chocolate

    예제 입력 5
        1
        soul
    예제 출력 5
        soul


    알고리즘 분류
        자료 구조
        문자열
        정렬
        해시를 사용한 집합과 맵
*/


// 메모리 : 14340KB
// 시간 : 120ms
// 코드 길이 : 1295B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 오늘 하루 동안 팔린 책의 개수

        Map<String, Integer> bookMap = new HashMap(); // 책의 제목을 key, 해당 책의 개수를 value로 저장하는 HashMap
        for (int n = 0; n < N; n++) {
            String bookTitle = bf.readLine(); // 책의 제목
            bookMap.put(bookTitle, bookMap.getOrDefault(bookTitle, 0) + 1);
        }

        int maxBookNum = 0; // 가장 많이 팔린 책의 개수
        String maxBook = ""; // 가장 많이 팔린 책의 제목
        for (String book : bookMap.keySet()) {
            int bookNum = bookMap.get(book);

            if (maxBookNum < bookNum) {
                maxBookNum = bookNum;
                maxBook = book;
            }
            else if (maxBookNum == bookNum) {
                if (maxBook.compareTo(book) > 0) {
                    maxBook = book;
                }
            }
        }

        System.out.println(maxBook);
    }
}
