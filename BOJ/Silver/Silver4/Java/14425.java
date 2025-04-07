/*
14425. Silver 4 - 문자열 집합

    시간 제한	            메모리 제한        제출        정답	      맞힌 사람	    정답 비율
    2 초 (하단 참고)	    1536 MB          65874	    35977     27553	         54.193%


    문제
        총 N개의 문자열로 이루어진 집합 S가 주어진다.
        입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.


    입력
        첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.
        다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
        다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
        입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.


    출력
        첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.


    예제 입력 1
        5 11
        baekjoononlinejudge
        startlink
        codeplus
        sundaycoding
        codingsh
        baekjoon
        codeplus
        codeminus
        startlink
        starlink
        sundaycoding
        codingsh
        codinghs
        sondaycoding
        startrink
        icerink
    예제 출력 1
        4


    알고리즘 분류
        자료 구조
        문자열
        해시를 사용한 집합과 맵
        트리를 사용한 집합과 맵


    시간 제한
        Java 8: 6 초
        Java 8 (OpenJDK): 6 초
        Java 11: 6 초
        Kotlin (JVM): 6 초
*/


// 메모리 : 872764KB
// 시간 : 2292ms
// 코드 길이 : 2993B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 집합 S를 구성하는 문자열의 개수
    static int M; // 입력으로 주어지는 문자열의 개수

    static class Trie { // 트라이 자료구조 클래스
        Trie[] child; // 현재 노드의 자식 노드들
        boolean flag; // 현재 노드가 단어의 끝을 나타내는지의 여부

        public Trie() {
            child = new Trie[26];
            flag = false;
        }

        public void insert(String word) { // 트라이 자료구조에 단어를 삽입하는 메서드
            Trie node = this; // 루트 노드

            for (int i = 0, len = word.length(); i < len; i++) {
                char ch = word.charAt(i); // 단어의 인덱스 i에 해당하는 문자

                if (node.child[ch - 'a'] == null) { // 자식 노드가 없을 경우
                    node.child[ch - 'a'] = new Trie(); // 새로운 노드를 생성해서 삽입
                }

                node = node.child[ch - 'a']; // 해당 문자에 대응하는 노드로 변환
            }

            node.flag = true; // 마지막 문자의 노드가 단어의 끝이라고 표시
        }

        public boolean contains(String word) { // 트라이 자료구조에 해당 단어가 존재하는지 확인하는 메서드
            Trie node = this; // 루트 노드

            for (int c = 0, len = word.length(); c < len; c++) {
                char ch = word.charAt(c); // 단어의 인덱스 c에 해당하는 문자
                Trie foundNode = node.child[ch - 'a']; // 해당 문자에 대응하는 노드(현재 노드의 자식 노드)

                if (foundNode == null) { // 해당 문자에 대응하는 노드가 없을 경우
                    return false;
                }

                node = foundNode; // 다음 문자에 대응하는 노드를 탐색하기 위해 현재 노드를 해당 문자에 대응하는 노드로 설정
            }

            return node.flag; // 마지막 문자의 노드가 단어의 끝을 나타내면 true, 마지막 문자의 노드가 단어의 끝을 나타내지 않을 경우 false
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        Trie trie = new Trie();
        for (int n = 0; n < N; n++) {
            trie.insert(bf.readLine());
        }

        int wordNum = 0; // 집합 S에 포함되어 있는 문자열의 개수
        for (int m = 0; m < M; m++) {
            if (trie.contains(bf.readLine())) {
                wordNum += 1;
            }
        }

        System.out.println(wordNum);
    }
}
