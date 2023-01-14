/*
1940. ����! RCī!

    �� �ð� : 10�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    RC (Radio Control) ī�� �̵��Ÿ��� ����Ϸ��� �Ѵ�.
    �Է����� �� �ʸ��� �Ʒ��� ���� command �� ������ �־�����.
        0 : ���� �ӵ� ����.
        1 : ����
        2 : ����
        
    �� command ��, ����(1) �Ǵ� ����(2) �� ��� ���ӵ��� ���� �߰��� �־�����.
    ���ӵ��� ������, m/s2 �̸�, ��� ���� ������ �־�����.
    �Է����� �־��� N ���� command �� ��� �������� ��, N �� ���� �̵��� �Ÿ��� ����ϴ� ���α׷��� �ۼ��϶�.
    RC ī�� �ʱ� �ӵ��� 0 m/s �̴�.
    
    [����]
	    �Ʒ� ���� �Է¿��� ������ 3 �� �ȴ�.
	        �Է�         �ð�     RC ī�� �ӵ� RC     ī�� �̵��Ÿ�
	        1 2          1 sec          2 m/s                    2 m
	        2 1          2 sec          1 m/s                    3 m
        
    [�������]
        1. N�� 2�̻� 30������ �����̴�. (2 �� N �� 30)
        2. ���ӵ��� ���� 1 m/s2 Ȥ�� 2 m/s2 �̴�.
        3. ���� �ӵ����� ������ �ӵ��� �� Ŭ ���, �ӵ��� 0 m/s �� �ȴ�.
        
    [�Է�]
        �Է��� ù �ٿ� �� �׽�Ʈ ���̽��� ���� T, ���� �ٺ��� �� �׽�Ʈ ���̽��� �־�����.
        �׽�Ʈ ���̽� ù �ٿ��� Command �� �� N�� �־�����, ��° �ٺ���, �� �ٸ��� ������ Command�� �־�����.
        
    [���]
        �׽�Ʈ ���̽� t�� ���� ����� ��#t���� ���, �� ĭ ���, ������ ����Ѵ�.
        (t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
        
        
    �Է�
        10
        2
        1 2
        2 1
        3
        1 1
        0
        1 1
        5
        1 2
        1 2
        2 1
        0
        0
        8
        0
        1 2
        1 1
        0
        1 2
        2 1
        1 1
        0
        10
        1 2
        1 1
        2 2
        1 2
        0
        0
        1 1
        1 1
        1 2
        0
        12
        1 2
        1 1
        1 2
        2 1
        0
        1 1
        1 1
        2 2
        2 2
        1 1
        0
        0
        15
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        20
        1 2
        2 1
        0
        1 2
        0
        1 1
        2 1
        1 2
        0
        2 1
        2 1
        0
        1 1
        0
        1 2
        1 2
        0
        1 2
        2 2
        2 2
        25
        2 1
        2 1
        0
        0
        0
        1 2
        0
        2 2
        1 2
        2 1
        1 1
        2 1
        0
        0
        0
        1 1
        1 2
        0
        0
        1 2
        2 2
        0
        2 2
        0
        1 1
        30
        2 1
        2 2
        2 2
        1 1
        1 2
        2 1
        0
        1 1
        0
        0
        1 2
        1 2
        2 1
        0
        0
        2 2
        2 1
        1 2
        0
        1 1
        2 2
        1 2
        2 2
        0
        1 2
        2 1
        2 2
        0
        1 1
        2 2
        
    ���
        #1 3
        #2 4
        #3 15
        #4 27
        #5 38
        #6 44
        #7 240
        #8 91
        #9 48
        #10 111
*/


// ���� �ð� : 0.13721s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int speed = 0;
			int distance = 0;
			
			for (int n = 0; n < N; n++) {
				int command_acceleration = sc.nextInt();
				
				if (command_acceleration == 0) {
					distance += speed;
				}
				else if (command_acceleration == 1) {
					int command_speed = sc.nextInt();
					
					speed += command_speed;
					distance += speed;
				}
				else if (command_acceleration == 2) {
					int command_speed = sc.nextInt();
					
					if (command_speed > speed) {
						speed = 0;
						distance += speed;
					}
					else {
						speed -= command_speed;
						distance += speed;
					}
				}
			}
			
			System.out.println("#" + t + " " + distance);
		}
	}
}
