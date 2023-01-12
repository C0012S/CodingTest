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


// ���� �ð� : 0.17067s
// Pass

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			String[] str_array = new String[100000];
			String str = sc.nextLine();
			
			str_array = str.split("");
			
			String[] decode = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
								"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
								"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "/"};
			
//			String[] all_binary = null;
			List<String> all_binary = new ArrayList<>();
			for (int s = 0; s < str_array.length; s++) {
				int num = Arrays.asList(decode).indexOf(str_array[s]);
				String[] binary = new String[6];
				binary = (Integer.toBinaryString(num)).split("");

				List<String> binary_list = new ArrayList<>(Arrays.asList(binary));
				if (binary.length < 6) {
					for (int i = 0; i < 6 - binary.length; i++) {
//						Arrays.asList(binary).add(i, "0");  // Exception in thread "main" java.lang.UnsupportedOperationException ���� �߻�
						binary_list.add(i, "0");
					}
				}
				
				for (int j = 0; j < binary_list.size(); j++) {
//					Arrays.asList(all_binary).add(binary[j]);  // Exception in thread "main" java.lang.UnsupportedOperationException ���� �߻�
					all_binary.add(binary_list.get(j));
				}
			}
			
			String result = "";
			for (int a = 0; a < all_binary.size() / 8; a++) {
				String[] bit_slicing_array = new String[8];
				int decimal_number;
				
				for (int k = (a * 8); k < ((a + 1) * 8); k++) {
					bit_slicing_array[k % 8] = all_binary.get(k);
				}
				
				decimal_number = Integer.parseInt(String.join("", bit_slicing_array), 2);
				
				result += (char) decimal_number;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
