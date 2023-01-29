/*
1946. 간단한 압축 풀기

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    원본 문서는 너비가 10인 여러 줄의 문자열로 이루어져 있다.
    문자열은 마지막 줄을 제외하고 빈 공간 없이 알파벳으로 채워져 있고 마지막 줄은 왼쪽부터 채워져 있다.
    이 문서를 압축한 문서는 알파벳과 그 알파벳의 연속된 개수로 이루어진 쌍들이 나열되어 있다. (예 : A 5  →  AAAAA)
    압축된 문서를 입력 받아 원본 문서를 만드는 프로그램을 작성하시오.
    
    [예제]
        압축된 문서의 내용
            A 10
            B 7
            C 5

        압축을 풀었을 때 원본 문서의 내용
            AAAAAAAAAA
            BBBBBBBCCC
            CC

    [제약사항]
        1. 압축된 문서의 알파벳과 숫자 쌍의 개수 N은1이상 10이하의 정수이다. (1 ≤ N ≤ 10)
        2. 주어지는 알파벳 Ci는 A~Z의 대문자이다. (i는 줄의 번호로 1~N까지의 수)
        3. 알파벳의 연속된 개수로 주어지는 수 Ki는 1이상 20이하의 정수이다. (1 ≤ Ki ≤ 20, i는 줄의 번호로 1~N까지의 수)
        4. 원본 문서의 너비는 10으로 고정이다.
        
    [입력]
        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        각 테스트 케이스에는 N이 주어지고 다음 줄부터 N+1줄까지 Ci와 Ki가 빈 칸을 사이에 두고 주어진다.
        
    [출력]
        각 줄은 '#t'로 시작하고, 다음 줄부터 원본 문서를 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
        
        
    입력
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
        
    출력
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


// 실행 시간 : 0.14344s
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
			
//			System.out.print("# " + t);  // 실행 시간 : 0.13963s  // 오답 : 10개의 테스트케이스 중 8개가 맞았습니다.  // '#' 뒤에 공백이 없어야 한다.
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
