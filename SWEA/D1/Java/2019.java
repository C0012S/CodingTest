/*
2019. �������
    �� �ð� : 1�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    1���� �־��� Ƚ������ 2�� ���� ��(��)�� ����Ͻÿ�.
    �־��� ���ڴ� 30�� ���� �ʴ´�.
    
    
    �Է�
        8
        
    ���
        1 2 4 8 16 32 64 128 256
*/


// ���� �ð� : 0.12902s
// Pass

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 0; i <= num; i++) {
			System.out.print((int) Math.pow(2, i) + " ");
		}
	}
}
