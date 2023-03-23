/*
10986. ������ ��

	�ð� ����		�޸� ����	����		����		���� ���		���� ����
	1 ��			256 MB		25276	7328	5360		27.489%
	
	����
		�� N�� A1, A2, ..., AN�� �־�����. �̶�, ���ӵ� �κ� ������ ���� M���� ������ �������� ������ ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.		
		��, Ai + ... + Aj (i �� j) �� ���� M���� ������ �������� (i, j) ���� ������ ���ؾ� �Ѵ�.
	
		
	�Է�
		ù° �ٿ� N�� M�� �־�����. (1 �� N �� 106, 2 �� M �� 103)	
		��° �ٿ� N���� �� A1, A2, ..., AN�� �־�����. (0 �� Ai �� 109)
	
		
	���
		ù° �ٿ� ���ӵ� �κ� ������ ���� M���� ������ �������� ������ ������ ����Ѵ�.
	
		
	���� �Է� 1 
		5 3
		1 2 3 1 2
	���� ��� 1 
		7
	
		
	�˰��� �з�
		����
		���� ��
*/


// �޸� : 120640KB
// �ð� : 508ms
// �ڵ� ���� : 1056B
// ����

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
		
		long sumArr[] = new long[N + 1]; // �� �迭
		long count[] = new long[M]; // ������(�ε���) ī��Ʈ �迭
		long rest = 0;
		for (int n = 0; n < N; n++) {
			sumArr[n + 1] = sumArr[n] + Integer.parseInt(token.nextToken());

			rest = sumArr[n + 1] % M;
			count[(int) rest]++;
		}
		
		long answer = 0;
		answer += count[0]; // sumArr[k] % M = 0�� ���
		for (int i = 0; i < M; i++) {
			answer += (count[i] * (count[i] - 1)) / 2; // ���� : count[i]���� 2 ������ �̴� ����� ��
		}
		
		System.out.println(answer);
	}
}
