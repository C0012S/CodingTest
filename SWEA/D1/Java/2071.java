/*
2071. 평균값 구하기

    · 시간 : 3개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하라.
    (소수점 첫째 자리에서 반올림한 정수를 출력한다.)
    
    [제약 사항]
        각 수는 0 이상 10000 이하의 정수이다.
        
    [입력]
        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.
        
    [출력]
        출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
        
        
    입력
        3
        3 17 1 39 8 41 2 32 99 2
        22 8 5 123 7 2 63 7 3 46
        6 63 2 3 58 76 21 33 8 1
        
    출력
        #1 24
        #2 29
        #3 27
*/


// 실행 시간 : 0.13379s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[] nums = new int[10];
			double sum = 0;
			
			for (int i = 0; i < nums.length; i++) {
				nums[i] = sc.nextInt();
				sum += nums[i];
			}
			
			System.out.println("#" + t + " " + Math.round(sum / nums.length));
		}
	}
}
