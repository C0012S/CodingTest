/*
2047. �Ź� ������

    �� �ð� : 1�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    �Ź��� �������� �����ϱ� ����, �־����� ���ڿ��� ���ĺ� �ҹ��ڸ� ��� �빮�ڷ� �ٲٴ� ���α׷��� ���� ���̴�.
    �Է����� �־��� ���忡 ��� �ҹ��� ���ĺ��� ã�� �빮�ڷ� ��ȯ�� ����, �� ����� ����ϴ� ���α׷��� �ۼ��϶�.
    
    [���� Ǯ��]
        The_headline_is_the_text_indicating_the_nature_of_the_article_below_it.
        ���� ���� ���ڿ��� �Է����� �־����� ��, ����� ������ ����.
        THE_HEADLINE_IS_THE_TEXT_INDICATING_THE_NATURE_OF_THE_ARTICLE_BELOW_IT.

    [���� ����]
        ���ڿ��� �ִ� ���̴� 80 bytes �̴�.
    
    [�Է�]
        �Է����� 80 bytes ������ ���̸� ���� ���ڿ��� �־�����.
    
    [���]
        ���ڿ��� �ҹ��ڸ� ��� �빮�ڷ� ������ ����� ����Ѵ�.
        
        
    �Է�
        The_headline_is_the_text_indicating_the_nature_of_the_article_below_it.

    ���
        THE_HEADLINE_IS_THE_TEXT_INDICATING_THE_NATURE_OF_THE_ARTICLE_BELOW_IT.
*/


// ���� �ð� : 0.13282s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		System.out.println(str.toUpperCase());
	}
}
