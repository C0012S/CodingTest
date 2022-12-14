/*
2025. N줄덧셈
    · 시간 : 1개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    1부터 주어진 숫자만큼 모두 더한 값을 출력하시오.
    단, 주어질 숫자는 10000을 넘지 않는다.
    
    [예제]
        주어진 숫자가 10 일 경우 출력해야 할 정답은,
        1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
        
        
    입력
        10
        
    출력
        55
*/


// 실행 시간 : 0.13197s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		
		System.out.print(sum);
	}
}
