/*
1938. ���� ������ ����
    �� �ð� : 1�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 1�� / Java�� ��� 2�� / Python�� ��� 4��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    �� ���� �ڿ����� �Է¹޾� ��Ģ������ �����ϴ� ���α׷��� �ۼ��϶�.
    
    [���� ����]
        1. �� ���� �ڿ��� a, b�� 1���� 9������ �ڿ����̴�. (1 �� a, b �� 9)
        2. ��Ģ���� + , - , * , / ������ ������ ����� ����Ѵ�.
        3. ������ ������ ������� �Ҽ��� ������ ���ڴ� ������.
        
    [�Է�]
        �Է����� �� ���� �ڿ��� a, b�� �� ĭ�� �ΰ� �־�����.
        
    [���]
        ��Ģ������ ����� �� �ٿ� ������� ����Ѵ�.
        
        
    �Է�
        8 3
        
    ���
        11
        5
        24
        2
*/


// ���� �ð� : 0.13030s
// Pass

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
	}
}
