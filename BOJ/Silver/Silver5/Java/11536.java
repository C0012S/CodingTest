/*
11536. Silver 5 - 줄 세우기

    시간 제한	    메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    1 초	    256 MB           2135	    1448      1277	         70.631%


    문제
        악독한 코치 주혁은 선수들을 이름 순으로 세우는 것을 좋아한다. 더 악독한 것은 어떤 순서로 서야할지도 알려주지 않았다! 선수들의 이름이 주어질 때 어떤 순서로 이루어져있는지 확인해보자.


    입력
        첫째 줄에 N개의 이름이 주어진다. (2 ≤ N ≤ 20)
        다음 N개의 줄에는 각 선수들의 이름이 주어진다. 이름은 2 이상 12 이하의 대문자로만 이루어져있다. 선수의 이름은 중복되지 않는다.


    출력
        이름이 증가하는 순으로 나타나면 INCREASING, 감소하는 순이면 DECREASING을 한 줄에 출력한다. 만약 위의 두 경우가 아니라면 NEITHER를 출력한다.


    예제 입력 1
        5
        JOE
        BOB
        ANDY
        AL
        ADAM
    예제 출력 1
        DECREASING

    예제 입력 2
        11
        HOPE
        ALI
        BECKY
        JULIE
        MEGHAN
        LAUREN
        MORGAN
        CARLI
        MEGAN
        ALEX
        TOBIN
    예제 출력 2
        NEITHER

    예제 입력 3
        4
        GEORGE
        JOHN
        PAUL
        RINGO
    예제 출력 3
        INCREASING


    알고리즘 분류
        구현
        문자열
        정렬
*/


// 메모리 : 14180KB
// 시간 : 124ms
// 코드 길이 : 1636B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 이름의 개수 N

        ArrayList<String> nameList = new ArrayList<>(); // 주어진 이름을 저장하는 리스트
        ArrayList<String> sortedNameList = new ArrayList<>(); // 이름 리스트를 오름차순으로 정렬한 리스트
        ArrayList<String> sortedReverseNameList = new ArrayList<>(); // 이름 리스트를 내림차순으로 정렬한 리스트
        for (int n = 0; n < N; n++) {
            String name = bf.readLine();

            nameList.add(name);
            sortedNameList.add(name);
            sortedReverseNameList.add(name);
        }

        Collections.sort(sortedNameList); // 오름차순 정렬
        sortedReverseNameList.sort(Comparator.reverseOrder()); // 내림차순 정렬

        if (nameList.equals(sortedNameList)) { // 이름이 증가하는 순으로 나타났을 경우
            System.out.println("INCREASING");
        }
        else if (nameList.equals(sortedReverseNameList)) { // 이름이 감소하는 순으로 나타났을 경우
            System.out.println("DECREASING");
        }
        else { // 이름이 증가하는 순으로 또는 감소하는 순으로 나타나지 않았을 경우
            System.out.println("NEITHER");
        }
    }
}
