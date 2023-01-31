/*
1948. 날짜 계산기

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
 
    
    월 일로 이루어진 날짜를 2개 입력 받아, 두 번째 날짜가 첫 번째 날짜의 며칠째인지 출력하는 프로그램을 작성하라.
    
    [제약 사항]
	    월은 1 이상 12 이하의 정수이다. 각 달의 마지막 날짜는 다음과 같다.
	        1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31
	        
	    두 번째 날짜가 첫 번째 날짜보다 항상 크게 주어진다.
    
    [입력]
        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        각 테스트 케이스의 첫 번째 줄에는 4개의 수가 주어진다.
        첫 번째 수가 월을 나타내고 두 번째 수가 일을 나타낸다. 그 다음 같은 형식으로 두 번째 날짜가 주어진다.
        
    [출력]
        출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다. (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
        
        
    입력
        10
		3 1 3 31
		5 5 8 15
		7 17 12 24
		3 22 5 10
		2 13 6 12
		4 30 11 9
		7 10 9 28
		6 30 9 20
		4 19 12 12
		1 1 12 31
		5 23 9 12
		2 12 9 4
        
    출력
        #1 31
		#2 103
		#3 161
		#4 50
		#5 120
		#6 194
		#7 81
		#8 83
		#9 238
		#10 365
*/


// 실행 시간 : 0.12933s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int[] date = new int[4];
			for (int d = 0; d < date.length; d++) {
				date[d] = sc.nextInt();
			}
//			date[0] = sc.nextInt();
//			date[1] = sc.nextInt();
//			date[2] = sc.nextInt();
//			date[3] = sc.nextInt();			
			int result = 0;
			
			int[] month_day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			
			if (date[0] == date[2]) {
				result = date[3] - date[1] + 1;
			}
			else {
				result = month_day[date[0]] - date[1] + 1;
				for (int m = date[0] + 1; m < date[2]; m++) {
					result += month_day[m];
				}
				result += date[3];
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
