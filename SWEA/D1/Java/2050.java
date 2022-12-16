/*
2050. 알파벳을 숫자로 변환

    · 시간 : 1개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    알파벳으로 이루어진 문자열을 입력 받아 각 알파벳을 1부터 26까지의 숫자로 변환하여 출력하라.
    
    [제약 사항]
        문자열의 최대 길이는 200이다.

    [입력]
        알파벳으로 이루어진 문자열이 주어진다.
    
    [출력]
        각 알파벳을 숫자로 변환한 결과값을 빈 칸을 두고 출력한다.
        
        
    입력
        ABCDEFGHIJKLMNOPQRSTUVWXYZ
        
    출력
        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
*/


// 실행 시간 : 0.12628s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		for (int i = 0; i < str.length(); i++) {
			int num = (int) str.charAt(i);
			System.out.print(num - 64 + " ");
		}
	}
}
