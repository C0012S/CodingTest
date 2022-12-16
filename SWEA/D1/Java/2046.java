/*
2046. 스탬프 찍기

    · 시간 : 1개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    주어진 숫자만큼 # 을 출력해보세요.
    주어질 숫자는 100,000 이하다.
    
    
    입력
        3
        
    출력
        ###
*/


// 실행 시간 : 0.12797s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for (int n = 0; n < num; n++) {
			System.out.print("#");
		}
	}
}
