/*
2029. ��� ������ ����ϱ�

    �� �ð� : 3�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    2���� �� a, b�� �Է� �޾�, a�� b�� ���� ��� �������� ����ϴ� ���α׷��� �ۼ��϶�.
    
    [���� ����]
        �� ���� 1�̻� 10000������ �����̴�.
        
    [�Է�]
        ���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.
        �� �׽�Ʈ ���̽��� ù ��° �ٿ��� 2���� ���� �־�����.
        
    [���]
        ����� �� ���� '#t'�� �����ϰ� ������ �� ĭ �� ����, ���� ����ϰ� ������ �� ĭ �� ���� �������� ����Ѵ�.
        (t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
        
        
    �Է�
        3
        9 2
        15 6
        369 15
        
    ���
        #1 4 1
        #2 2 3
        #3 24 9
*/


// ���� �ð� : 0.13050s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("#" + t + " " + a / b + " " + a % b);
		}
	}
}