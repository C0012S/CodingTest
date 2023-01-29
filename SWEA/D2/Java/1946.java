/*
1946. ������ ���� Ǯ��

    �� �ð� : 10�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    ���� ������ �ʺ� 10�� ���� ���� ���ڿ��� �̷���� �ִ�.
    ���ڿ��� ������ ���� �����ϰ� �� ���� ���� ���ĺ����� ä���� �ְ� ������ ���� ���ʺ��� ä���� �ִ�.
    �� ������ ������ ������ ���ĺ��� �� ���ĺ��� ���ӵ� ������ �̷���� �ֵ��� �����Ǿ� �ִ�. (�� : A 5  ��  AAAAA)
    ����� ������ �Է� �޾� ���� ������ ����� ���α׷��� �ۼ��Ͻÿ�.
    
    [����]
        ����� ������ ����
            A 10
            B 7
            C 5

        ������ Ǯ���� �� ���� ������ ����
            AAAAAAAAAA
            BBBBBBBCCC
            CC

    [�������]
        1. ����� ������ ���ĺ��� ���� ���� ���� N��1�̻� 10������ �����̴�. (1 �� N �� 10)
        2. �־����� ���ĺ� Ci�� A~Z�� �빮���̴�. (i�� ���� ��ȣ�� 1~N������ ��)
        3. ���ĺ��� ���ӵ� ������ �־����� �� Ki�� 1�̻� 20������ �����̴�. (1 �� Ki �� 20, i�� ���� ��ȣ�� 1~N������ ��)
        4. ���� ������ �ʺ�� 10���� �����̴�.
        
    [�Է�]
        ���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.
        �� �׽�Ʈ ���̽����� N�� �־����� ���� �ٺ��� N+1�ٱ��� Ci�� Ki�� �� ĭ�� ���̿� �ΰ� �־�����.
        
    [���]
        �� ���� '#t'�� �����ϰ�, ���� �ٺ��� ���� ������ ����Ѵ�.
        (t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
        
        
    �Է�
    	10
		3
		A 10
		B 7
		C 5
		4
		B 20
		C 19
		E 18
		R 17
		5
		Y 10
		J 3
		G 5
		Z 7
		A 11
		6
		Q 16
		P 5
		O 1
		I 2
		B 3
		V 4
		7
		C 6
		Z 20
		M 10
		J 10
		G 10
		H 8
		T 2
		8
		R 1
		Y 3
		U 9
		L 15
		Z 14
		N 11
		X 8
		W 7
		10
		S 4
		D 12
		H 3
		A 16
		O 9
		X 5
		V 1
		C 5
		H 10
		W 14
		1
		U 14
		2
		I 6
		K 2
		10
		S 4
		D 12
		H 13
		A 16
		O 19
		X 15
		V 11
		C 15
		H 11
		W 13
        
    ���
		#1
		AAAAAAAAAA
		BBBBBBBCCC
		CC
		#2
		BBBBBBBBBB
		BBBBBBBBBB
		CCCCCCCCCC
		CCCCCCCCCE
		EEEEEEEEEE
		EEEEEEERRR
		RRRRRRRRRR
		RRRR
		#3
		YYYYYYYYYY
		JJJGGGGGZZ
		ZZZZZAAAAA
		AAAAAA
		#4
		QQQQQQQQQQ
		QQQQQQPPPP
		POIIBBBVVV
		V
		#5
		CCCCCCZZZZ
		ZZZZZZZZZZ
		ZZZZZZMMMM
		MMMMMMJJJJ
		JJJJJJGGGG
		GGGGGGHHHH
		HHHHTT
		#6
		RYYYUUUUUU
		UUULLLLLLL
		LLLLLLLLZZ
		ZZZZZZZZZZ
		ZZNNNNNNNN
		NNNXXXXXXX
		XWWWWWWW
		#7
		SSSSDDDDDD
		DDDDDDHHHA
		AAAAAAAAAA
		AAAAAOOOOO
		OOOOXXXXXV
		CCCCCHHHHH
		HHHHHWWWWW
		WWWWWWWWW
		#8
		UUUUUUUUUU
		UUUU
		#9
		IIIIIIKK
		#10
		SSSSDDDDDD
		DDDDDDHHHH
		HHHHHHHHHA
		AAAAAAAAAA
		AAAAAOOOOO
		OOOOOOOOOO
		OOOOXXXXXX
		XXXXXXXXXV
		VVVVVVVVVV
		CCCCCCCCCC
		CCCCCHHHHH
		HHHHHHWWWW
		WWWWWWWWW
*/


// ���� �ð� : 0.14344s
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
			String[] contents = new String[N * 20];
			String[] Ci = new String[N];
			int[] Ki = new int[N];
			int before_index_sum = 0;
			
			for (int n = 0; n < N; n++) {
				Ci[n] = sc.next();
				Ki[n] = sc.nextInt();
				
				for (int k = 0; k < Ki[n]; k++) {
					contents[before_index_sum + k] = Ci[n];
				}
				
				before_index_sum += Ki[n];
			}
			
//			System.out.print("# " + t);  // ���� �ð� : 0.13963s  // ���� : 10���� �׽�Ʈ���̽� �� 8���� �¾ҽ��ϴ�.  // '#' �ڿ� ������ ����� �Ѵ�.
			System.out.print("#" + t);
			for (int c = 0; c < contents.length; c++) {
				if (contents[c] == null) {
					System.out.println();
					
					break;
				}
				
				if (c % 10 != 0) {
					System.out.print(contents[c]);
				}
				else {
					System.out.println();
					System.out.print(contents[c]);
				}
			}
		}
	}
}
