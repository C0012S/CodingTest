/*
1545. �Ųٷ� ����� ���ƿ�

    �� �ð� : 1�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 1�� / Java�� ��� 2�� / Python�� ��� 4��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    �־��� ���ں��� 0���� ������� ������
    �Ʒ��� �Էµ� ���ڰ� N�� �� �Ųٷ� ����ϴ� �����Դϴ�
        n  n - 1  n - 2  0
        
        
    �Է�
        8

    ���
        8 7 6 5 4 3 2 1 0
*/


// ���� �ð� : 0.12757s
// Pass

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 0; i <= num; i++) {
			System.out.print(num - i + " ");
		}
	}
}
