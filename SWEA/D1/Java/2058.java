/*
2058. �ڸ��� ���ϱ�

    �� �ð� : 1�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    �ϳ��� �ڿ����� �Է� �޾� �� �ڸ����� ���� ����ϴ� ���α׷��� �ۼ��϶�.

    [���� ����]
        �ڿ��� N�� 1���� 9999������ �ڿ����̴�. (1 �� N �� 9999)
        
    [�Է�]
        �Է����� �ڿ��� N�� �־�����.
        
    [���]
        �� �ڸ����� ���� ����Ѵ�.
        
        
    �Է�
        6789
        
    ���
        30
*/


// ���� �ð� : 0.12878s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		
		for (int i = 3; i >= 0; i--) {
			result += N / Math.pow(10, i);
			N = (int) (N % Math.pow(10, i));
		}
		
		System.out.println(result);
	}
}
