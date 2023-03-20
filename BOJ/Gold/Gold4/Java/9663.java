/*
9663. N-Queen

	시간 제한		메모리 제한	제출		정답		맞힌 사람		정답 비율
	10 초		128 MB		87778	42188	27387		46.744%
	
	문제
		N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
		
		N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
	
		
	입력
		첫째 줄에 N이 주어진다. (1 ≤ N < 15)
	
		
	출력
		첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
	
		
	예제 입력 1 
		8
	예제 출력 1 
		92
	
		
	알고리즘 분류
		브루트포스 알고리즘
		백트래킹
*/


// 메모리 : 15128KB
// 시간 : 3664ms
// 코드 길이 : 1156B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	
	static boolean isSelected[];
	static int selectQueen[];
	
	static int count;
	
	public static boolean check(int index) { // 대각선 체크 함수		
		for (int n = 0; n < index; n++) {
			if (Math.abs(index - n) == Math.abs(selectQueen[index] - selectQueen[n])) { // 대각선 조건 체크
				return false;
			}
		}
		
		return true;
	}
	
	public static void permutation(int r) { // 순열 구하는 함수 이용
		if (r == N) {
			count++;
			return;
		}
		
		for (int j = 0; j < N; j++) {
			if (isSelected[j]) {
				continue;
			}
			
			isSelected[j] = true;
			selectQueen[r] = j; // j : 선택한 행(열의 값)
			if (check(r)) {
				permutation(r + 1);
			}
			isSelected[j] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
				
		isSelected = new boolean[N];
		selectQueen = new int[N];
		
		permutation(0);
		System.out.println(count);
	}
}
