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


// ���� �ð� : 0.09924s
// Pass

class Solution
{
	public static void main(String args[]) throws Exception
	{
		String[] str = {"+", "+", "+", "+", "+"};
		
		for (int i = 0; i < 5; i++) {
			str[i] = "#";
			
			for (int j = 0; j < 5; j++) {
				System.out.print(str[j]);
			}
			System.out.println();
			
			str[i] = "+";
		}
	}
}
