/*
1936. 1��1 ����������
    �� �ð� : 1�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 1�� / Java�� ��� 2�� / Python�� ��� 4��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    A�� B�� ������������ �Ͽ���.
    ������ 1, ������ 2, ���� 3���� ǥ���Ǹ� A�� B�� ������ �´��� �Է����� �־�����.
    A�� B�߿� ���� �̰���� �Ǻ��غ���.��, ���� ���� ����.
    
    [�Է�]
        �Է����� A�� B�� ������ �´��� �� ĭ�� ���̷� �־�����.
        
    [���]
        A�� �̱�� A, B�� �̱�� B�� ����Ѵ�.
        
        
    �Է�
        3 2
        
    ���
        A
*/


// ���� �ð� : 0.12837s
// Pass

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if (A == 1) {
			if (B == 2) {
				System.out.print("B");
			}
			else if (B == 3) {
				System.out.print("A");
			}
		}
		else if (A == 2) {
			if (B == 1) {
				System.out.print("A");
			}
			else if (B == 3) {
				System.out.print("B");
			}
		}
		else if (A == 3) {
			if (B == 1) {
				System.out.print("B");
			}
			else if (B == 2) {
				System.out.print("A");
			}
		}
	}
}
