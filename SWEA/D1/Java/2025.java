/*
2025. N�ٵ���
    �� �ð� : 1�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    1���� �־��� ���ڸ�ŭ ��� ���� ���� ����Ͻÿ�.
    ��, �־��� ���ڴ� 10000�� ���� �ʴ´�.
    
    [����]
        �־��� ���ڰ� 10 �� ��� ����ؾ� �� ������,
        1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
        
        
    �Է�
        10
        
    ���
        55
*/


// ���� �ð� : 0.13197s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		
		System.out.print(sum);
	}
}
