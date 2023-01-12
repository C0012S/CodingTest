/*
1928. Base64 Decoder

    �� �ð� : 10�� �׽�Ʈ���̽��� ���ļ� C++�� ��� 30�� / Java�� ��� 30�� / Python�� ��� 30��
    �� �޸� : ��, ���� �޸� ���ļ� 256MB �̳�, ���� �޸� 1MB �̳�
    
    
    ������ ���� Encoding �� �Ѵ�.
        1. �켱 24��Ʈ ���ۿ� ����(MSB)���� �� byte�� 3 byte�� ���ڸ� ����ִ´�.
        2. ������ ���ʺ��� 6��Ʈ�� �߶� �� ���� �а�, ������ ���� �Ʒ� [ǥ-1] �� ���ڷ� Encoding �Ѵ�.
            [ǥ-1�� SW Expert Academy���� ����]
            
    �Է����� Base64 Encoding �� String �� �־����� ��, �ش� String �� Decoding �Ͽ�, ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
    
    [�������]
        ���ڿ��� ���̴� �׻� 4�� ����� �־�����.
        �׸��� ���ڿ��� ���̴� 100000�� ���� �ʴ´�.
        
    [�Է�]
        �Է��� ù �ٿ� �� �׽�Ʈ ���̽��� ���� T�� �´�.
        ���� �ٺ��� �� �׽�Ʈ ���̽��� �־�����.
        �׽�Ʈ ���̽��� Encoding �� ���·� �־����� ���ڿ��̴�.
        
    [���]
        �׽�Ʈ ���̽� t�� ���� ����� ��#t���� ���, �� ĭ ���, ������ ����Ѵ�.
        (t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
        
        
    �Է�
        10
        TGlmZSBpdHNlbGYgaXMgYSBxdW90YXRpb24u
        U3VzcGljaW9uIGZvbGxvd3MgY2xvc2Ugb24gbWlzdHJ1c3Qu
        VG8gZG91YnQgaXMgc2FmZXIgdGhhbiB0byBiZSBzZWN1cmUu
        T25seSB0aGUganVzdCBtYW4gZW5qb3lzIHBlYWNlIG9mIG1pbmQu
        QSBmdWxsIGJlbGx5IGlzIHRoZSBtb3RoZXIgb2YgYWxsIGV2aWwu
        QSBnaWZ0IGluIHNlYXNvbiBpcyBhIGRvdWJsZSBmYXZvciB0byB0aGUgbmVlZHku
        Qm9va3MgYXJlIHNoaXBzIHdoaWNoIHBhc3MgdGhyb3VnaCB0aGUgdmFzdCBzZWFzIG9mIHRpbWUu
        TGV0IHRoeSBzcGVlY2ggYmUgc2hvcnQsIGNvbXByZWhlbmRpbmcgbXVjaCBpbiBmZXcgd29yZHMu
        VGhlIHdvcmxkIGlzIGEgYmVhdXRpZnVsIGJvb2ssIGJ1dCBvZiBsaXR0bGUgdXNlIHRvIGhpbSB3aG8gY2Fubm90IHJlYWQgaXQu
        SGUgd2hvIHNwYXJlcyB0aGUgcm9kIGhhdGVzIGhpcyBzb24sIGJ1dCBoZSB3aG8gbG92ZXMgaGltIGlzIGNhcmVmdWwgdG8gZGlzY2lwbGluZSBoaW0u
        
    ���
        #1 Life itself is a quotation.
        #2 Suspicion follows close on mistrust.
        #3 To doubt is safer than to be secure.
        #4 Only the just man enjoys peace of mind.
        #5 A full belly is the mother of all evil.
        #6 A gift in season is a double favor to the needy.
        #7 Books are ships which pass through the vast seas of time.
        #8 Let thy speech be short, comprehending much in few words.
        #9 The world is a beautiful book, but of little use to him who cannot read it.
        #10 He who spares the rod hates his son, but he who loves him is careful to discipline him.
*/


// ���� �ð� : 0.13887s
// Pass

import java.util.Base64;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			String str = sc.nextLine();
			String result = new String(Base64.getDecoder().decode(str));
			
			System.out.println("#" + t + " " + result);
		}
	}
}
