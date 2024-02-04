/*
1181. Silver 5 - 단어 정렬

    시간 제한     메모리 제한        제출        정답        맞힌 사람       정답 비율
    2 초         256 MB           173932     72860      54609           40.349%


    문제
        알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
            1. 길이가 짧은 것부터
            2. 길이가 같으면 사전 순으로

        단, 중복된 단어는 하나만 남기고 제거해야 한다.


    입력
        첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.


    출력
        조건에 따라 정렬하여 단어들을 출력한다.


    예제 입력 1
        13
        but
        i
        wont
        hesitate
        no
        more
        no
        more
        it
        cannot
        wait
        im
        yours
    예제 출력 1
        i
        im
        it
        no
        but
        more
        wait
        wont
        yours
        cannot
        hesitate


    알고리즘 분류
        문자열
        정렬
*/


// 메모리 : 26148KB
// 시간 : 352ms
// 코드 길이 : 1772B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int N; // 단어의 개수 N (1 ≤ N ≤ 20000)
    static ArrayList<String> wordList; // 단어를 저장하는 리스트

    public static void sortWords() { // 단어 리스트를 정렬하는 메서드
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) { // 단어의 길이가 같을 경우
                    return o1.compareTo(o2); // 사전 순으로 정렬
                }
                else {
                    return o1.length() - o2.length(); // 단어의 길이가 짧은 순으로 정렬
                }
            }
        });
    }

    public static void printSortedWords() { // 단어 리스트를 출력하는 메서드
        StringBuilder sb = new StringBuilder();

        sb.append(wordList.get(0));
        sb.append("\n");
        for (int p = 1; p < N; p++) {
            if (!wordList.get(p).equals(wordList.get(p - 1))) { // 중복되지 않은 단어만 출력
                sb.append(wordList.get(p));
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        wordList = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            wordList.add(bf.readLine());
        }

        sortWords();

        printSortedWords();
    }
}
