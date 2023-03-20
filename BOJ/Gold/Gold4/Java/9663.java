/*
9663. N-Queen

	�ð� ����		�޸� ����	����		����		���� ���		���� ����
	10 ��		128 MB		87778	42188	27387		46.744%
	
	����
		N-Queen ������ ũ�Ⱑ N �� N�� ü���� ���� �� N���� ���� ������ �� ���� ���� �����̴�.
		
		N�� �־����� ��, ���� ���� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
		
	�Է�
		ù° �ٿ� N�� �־�����. (1 �� N < 15)
	
		
	���
		ù° �ٿ� �� N���� ���� ������ �� ���� ���� ����� ���� ����Ѵ�.
	
		
	���� �Է� 1 
		8
	���� ��� 1 
		92
	
		
	�˰��� �з�
		���Ʈ���� �˰���
		��Ʈ��ŷ
*/


// �޸� : 15128KB
// �ð� : 3664ms
// �ڵ� ���� : 1156B
// ����

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	
	static boolean isSelected[];
	static int selectQueen[];
	
	static int count;
	
	public static boolean check(int index) { // �밢�� üũ �Լ�		
		for (int n = 0; n < index; n++) {
			if (Math.abs(index - n) == Math.abs(selectQueen[index] - selectQueen[n])) { // �밢�� ���� üũ
				return false;
			}
		}
		
		return true;
	}
	
	public static void permutation(int r) { // ���� ���ϴ� �Լ� �̿�
		if (r == N) {
			count++;
			return;
		}
		
		for (int j = 0; j < N; j++) {
			if (isSelected[j]) {
				continue;
			}
			
			isSelected[j] = true;
			selectQueen[r] = j; // j : ������ ��(���� ��)
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
