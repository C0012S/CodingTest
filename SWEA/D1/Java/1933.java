/*
1933. 간단한 N의 약수
    · 시간 : 1개 테스트케이스를 합쳐서 C++의 경우 1초 / Java의 경우 2초 / Python의 경우 4초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    입력으로 1개의 정수 N 이 주어진다.
    정수 N 의 약수를 오름차순으로 출력하는 프로그램을 작성하라.
    
    [제약사항]
        N은 1이상 1,000이하의 정수이다. (1 ≤ N ≤ 1,000)
        
    [입력]
        입력으로 정수 N 이 주어진다.
        
    [출력]
        정수 N 의 모든 약수를 오름차순으로 출력한다.
        
        
    입력
        10
    출력
        1 2 5 10
*/


// 실행 시간 : 0.12837s
// Pass

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
