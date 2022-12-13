/*
2019. 더블더블
    · 시간 : 1개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    1부터 주어진 횟수까지 2를 곱한 값(들)을 출력하시오.
    주어질 숫자는 30을 넘지 않는다.
    
    
    입력
        8
        
    출력
        1 2 4 8 16 32 64 128 256
*/


// 실행 시간 : 0.12902s
// Pass

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 0; i <= num; i++) {
			System.out.print((int) Math.pow(2, i) + " ");
		}
	}
}
