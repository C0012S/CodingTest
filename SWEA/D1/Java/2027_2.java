/*
2027. �밢�� ����ϱ�

    �� �ð� : 1�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�

    
    �־��� �ؽ�Ʈ�� �״�� ����ϼ���.
    
    
    �Է�
    
    ���
        #++++
        +#+++
        ++#++
        +++#+
        ++++#
*/


// ���� �ð� : 0.10053s
// Pass

class Solution
{
	public static void main(String args[]) throws Exception
	{
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 5; j++) {
				if (j == i) {
					System.out.print("#");
				}
				else {
					System.out.print("+");
				}
			}
			
			System.out.println();
		}
	}
}
