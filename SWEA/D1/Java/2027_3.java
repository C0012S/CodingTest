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


// ���� �ð� : 0.09903s
// Pass

class Solution
{
	public static void main(String args[]) throws Exception
	{
		StringBuilder builder = new StringBuilder("+++++");
		
		for (int i = 0; i< 5; i++) {
			builder.setCharAt(i, '#');
			
			System.out.println(builder);
			
			builder.setCharAt(i, '+');
		}
	}
}
