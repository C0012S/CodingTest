/*
2058. 자릿수 더하기

    · 시간 : 1개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    하나의 자연수를 입력 받아 각 자릿수의 합을 계산하는 프로그램을 작성하라.

    [제약 사항]
        자연수 N은 1부터 9999까지의 자연수이다. (1 ≤ N ≤ 9999)
        
    [입력]
        입력으로 자연수 N이 주어진다.
        
    [출력]
        각 자릿수의 합을 출력한다.
        
        
    입력
        6789
        
    출력
        30
*/


// 실행 시간 : 0.12878s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		
		for (int i = 3; i >= 0; i--) {
			result += N / Math.pow(10, i);
			N = (int) (N % Math.pow(10, i));
		}
		
		System.out.println(result);
	}
}
