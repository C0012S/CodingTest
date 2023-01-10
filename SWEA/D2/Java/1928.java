/*
1928. Base64 Decoder

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    다음과 같이 Encoding 을 한다.
        1. 우선 24비트 버퍼에 위쪽(MSB)부터 한 byte씩 3 byte의 문자를 집어넣는다.
        2. 버퍼의 위쪽부터 6비트씩 잘라 그 값을 읽고, 각각의 값을 아래 [표-1] 의 문자로 Encoding 한다.
            [표-1은 SW Expert Academy에서 참고]
            
    입력으로 Base64 Encoding 된 String 이 주어졌을 때, 해당 String 을 Decoding 하여, 원문을 출력하는 프로그램을 작성하시오.
    
    [제약사항]
        문자열의 길이는 항상 4의 배수로 주어진다.
        그리고 문자열의 길이는 100000을 넘지 않는다.
        
    [입력]
        입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
        다음 줄부터 각 테스트 케이스가 주어진다.
        테스트 케이스는 Encoding 된 상태로 주어지는 문자열이다.
        
    [출력]
        테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
        
        
    입력
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
        
    출력
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


// 실행 시간 : 0.17067s
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
//						Arrays.asList(binary).add(i, "0");  // Exception in thread "main" java.lang.UnsupportedOperationException 에러 발생
						binary_list.add(i, "0");
					}
				}
				
				for (int j = 0; j < binary_list.size(); j++) {
//					Arrays.asList(all_binary).add(binary[j]);  // Exception in thread "main" java.lang.UnsupportedOperationException 에러 발생
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
