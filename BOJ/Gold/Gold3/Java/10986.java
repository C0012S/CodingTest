/*
10986. 나머지 합

	시간 제한		메모리 제한	제출		정답		맞힌 사람		정답 비율
	1 초			256 MB		25276	7328	5360		27.489%
	
	문제
		수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.		
		즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
	
		
	입력
		첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)	
		둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
	
		
	출력
		첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
	
		
	예제 입력 1 
		5 3
		1 2 3 1 2
	예제 출력 1 
		7
	
		
	알고리즘 분류
		수학
		누적 합
*/


// 메모리 : 120640KB
// 시간 : 508ms
// 코드 길이 : 1056B
// 정답

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		token = new StringTokenizer(bf.readLine(), " ");
		
		long sumArr[] = new long[N + 1]; // 합 배열
		long count[] = new long[M]; // 나머지(인덱스) 카운트 배열
		long rest = 0;
		for (int n = 0; n < N; n++) {
			sumArr[n + 1] = sumArr[n] + Integer.parseInt(token.nextToken());

			rest = sumArr[n + 1] % M;
			count[(int) rest]++;
		}
		
		long answer = 0;
		answer += count[0]; // sumArr[k] % M = 0인 경우
		for (int i = 0; i < M; i++) {
			answer += (count[i] * (count[i] - 1)) / 2; // 조합 : count[i]에서 2 가지를 뽑는 경우의 수
		}
		
		System.out.println(answer);
	}
}
