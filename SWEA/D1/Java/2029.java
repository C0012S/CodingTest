/*
2029. 몫과 나머지 출력하기

    · 시간 : 3개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    2개의 수 a, b를 입력 받아, a를 b로 나눈 몫과 나머지를 출력하는 프로그램을 작성하라.
    
    [제약 사항]
        각 수는 1이상 10000이하의 정수이다.
        
    [입력]
        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        각 테스트 케이스의 첫 번째 줄에는 2개의 수가 주어진다.
        
    [출력]
        출력의 각 줄은 '#t'로 시작하고 공백을 한 칸 둔 다음, 몫을 출력하고 공백을 한 칸 둔 다음 나머지를 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
        
        
    입력
        3
        9 2
        15 6
        369 15
        
    출력
        #1 4 1
        #2 2 3
        #3 24 9
*/


// 실행 시간 : 0.13050s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("#" + t + " " + a / b + " " + a % b);
		}
	}
}
