/*
2070. ū ��, ���� ��, ���� ��

    �� �ð� : 3�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    2���� ���� �Է� �޾� ũ�⸦ ���Ͽ� ��ȣ �Ǵ� �ε�ȣ�� ����ϴ� ���α׷��� �ۼ��϶�.
    
    [���� ����]
        �� ���� 0 �̻� 10000 ������ �����̴�.
        
    [�Է�]
        ���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.
        �� �׽�Ʈ ���̽��� ù ��° �ٿ��� 2���� ���� �־�����.
        
    [���]
        ����� �� ���� '#t'�� �����ϰ�, ������ �� ĭ �� ���� ������ ����Ѵ�.
        (t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
        
        
    �Է�
        3
        3 8
        7 7
        369 123
        
    ���
        #1 <
        #2 =
        #3 >
*/


// ���� �ð� : 0.13771s
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
			
			if (a > b) {
				System.out.println("#" + t + " >");
			}
			else if (a < b) {
				System.out.println("#" + t + " <");
			}
			else {
				System.out.println("#" + t + " =");
			}
		}
	}
}
