/*
1933. ������ N�� ���
    �� �ð� : 1�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 1�� / Java�� ��� 2�� / Python�� ��� 4��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    �Է����� 1���� ���� N �� �־�����.
    ���� N �� ����� ������������ ����ϴ� ���α׷��� �ۼ��϶�.
    
    [�������]
        N�� 1�̻� 1,000������ �����̴�. (1 �� N �� 1,000)
        
    [�Է�]
        �Է����� ���� N �� �־�����.
        
    [���]
        ���� N �� ��� ����� ������������ ����Ѵ�.
        
        
    �Է�
        10
    ���
        1 2 5 10
*/


// ���� �ð� : 0.12837s
// Pass

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
