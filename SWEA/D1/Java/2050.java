/*
2050. ���ĺ��� ���ڷ� ��ȯ

    �� �ð� : 1�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    ���ĺ����� �̷���� ���ڿ��� �Է� �޾� �� ���ĺ��� 1���� 26������ ���ڷ� ��ȯ�Ͽ� ����϶�.
    
    [���� ����]
        ���ڿ��� �ִ� ���̴� 200�̴�.

    [�Է�]
        ���ĺ����� �̷���� ���ڿ��� �־�����.
    
    [���]
        �� ���ĺ��� ���ڷ� ��ȯ�� ������� �� ĭ�� �ΰ� ����Ѵ�.
        
        
    �Է�
        ABCDEFGHIJKLMNOPQRSTUVWXYZ
        
    ���
        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
*/


// ���� �ð� : 0.12628s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		for (int i = 0; i < str.length(); i++) {
			int num = (int) str.charAt(i);
			System.out.print(num - 64 + " ");
		}
	}
}
