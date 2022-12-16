/*
2056. ������ �޷�

    �� �ð� : 5�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    ������ ������ ������ 8�ڸ��� ��¥�� �Է����� �־�����.
        22220228 �� 2222/02/28
            [�׸�1]
            
    �ش� ��¥�� ��ȿ���� �Ǵ��� ��, ��¥�� ��ȿ�ϴٸ�
    [�׸�1] �� ���� ��YYYY/MM/DD���������� ����ϰ�,
    ��¥�� ��ȿ���� ���� ���, -1 �� ����ϴ� ���α׷��� �ۼ��϶�.
    
    �����Ϸ� ������ �Է¿��� ���� 1~12 ���� ���� ������ �ϸ�
    ���� [ǥ1] �� ����, 1�� ~ ������ �޿� �ش��ϴ� ��¥������ ���� ���� �� �ִ�.
        1 ��  1 �� ~ 31��      2 ��  1 �� ~ 28 ��
        3 ��  1 �� ~ 31��      4 ��  1 �� ~ 30 ��
        5 ��  1 �� ~ 31��      6 ��  1 �� ~ 30 ��
        7 ��  1 �� ~ 31��      8 ��  1 �� ~ 31 ��
        9 ��  1 �� ~ 30��      10 ��  1 �� ~ 31 ��
        11 ��  1 �� ~ 30��     12 ��  1 �� ~ 31 ��
            [ǥ1]
            
    �� 2���� ���, 28���� ��츸 ����Ѵ�. (������ ������� �ʴ´�.)
    
    [�Է�]
        �Է��� ù �ٿ� �� �׽�Ʈ ���̽��� ���� T�� �´�.
        ���� �ٺ��� �� �׽�Ʈ ���̽��� �־�����.
        
    [���]
        �׽�Ʈ ���̽� t�� ���� ����� ��#t���� ���, �� ĭ ���, ������ ����Ѵ�.
        (t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)


    �Է�
        5
        22220228
        20150002
        01010101
        20140230
        11111111
        
    ���
        #1 2222/02/28
        #2 -1
        #3 0101/01/01
        #4 -1
        #5 1111/11/11
*/


// ���� �ð� : 0.14420s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc <= T; tc++) {
			String date = sc.nextLine();
			
			String year = date.charAt(0) + "" + date.charAt(1) + "" +  date.charAt(2) + "" + date.charAt(3);
			String month = date.charAt(4) + "" + date.charAt(5);
//			String day = date.charAt(6) + "" + date.charAt(7);
			int day = 0;
			if (date.charAt(6) == 0) {
				day = date.charAt(7) - '0';
			}
			else {
				day = (date.charAt(6) - '0') * 10 + (date.charAt(7) - '0'); // �ƽ�Ű�ڵ� ���� 48�� '0'�� ���� ������(int��)���� ��ȯ�Ѵ�.
			}
			
			if (month.equals("01") || month.equals("03") || month.equals("05") || month.equals("07") || month.equals("08") || month.equals("10") || month.equals("12")) {
				if (day >= 1 && day <= 31) {
					System.out.println("#" + tc + " " + year + "/" + month + "/" + date.charAt(6) + "" + date.charAt(7));
				}
				else {
					System.out.println("#" + tc + " " + -1);
				}
			}
			else if (month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) {
				if (day >= 1 && day <= 30) {
					System.out.println("#" + tc + " " + year + "/" + month + "/" + date.charAt(6) + "" + date.charAt(7));
				}
				else {
					System.out.println("#" + tc + " " + -1);
				}
			}
			else if (month.equals("02")) {
				if (day >= 1 && day <= 28) {
					System.out.println("#" + tc + " " + year + "/" + month + "/" + date.charAt(6) + "" + date.charAt(7));
				}
				else {
					System.out.println("#" + tc + " " + -1);
				}
			}
			else {
				System.out.println("#" + tc + " " + -1);
			}
		}
	}
}
