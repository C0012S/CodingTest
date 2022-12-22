/*
2068. �ִ�� ���ϱ�

    �� �ð� : 3�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    10���� ���� �Է� �޾�, �� �߿��� ���� ū ���� ����ϴ� ���α׷��� �ۼ��϶�.
    
    [���� ����]
        �� ���� 0 �̻� 10000 ������ �����̴�.
        
    [�Է�]
        ���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.
        �� �׽�Ʈ ���̽��� ù ��° �ٿ��� 10���� ���� �־�����.
        
    [���]
        ����� �� ���� '#t'�� �����ϰ�, ������ �� ĭ �� ���� ������ ����Ѵ�.
        (t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
        
        
    �Է�
        3
        3 17 1 39 8 41 2 32 99 2
        22 8 5 123 7 2 63 7 3 46
        6 63 2 3 58 76 21 33 8 1
        
    ���
        #1 99
        #2 123
        #3 76
*/


// ���� �ð� : 0.12712s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			int[] nums = new int[10];
			
			for (int i = 0; i < 10; i++) {
				nums[i] = sc.nextInt();
			}
			
			int result = nums[0];
			for (int j = 1; j < nums.length; j++) {
				result = Math.max(result, nums[j]);
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
