/*
1945. 간단한 소인수분해

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    숫자 N은 아래와 같다.
        N = 2^a x 3^b x 5^c x 7^d x 11^e
        
    N이 주어질 때 a, b, c, d, e 를 출력하라.
    
    [제약 사항]
        N은 2 이상 10,000,000 이하이다.
        
    [입력]
        가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        각 테스트 케이스의 첫 번째 줄에 N 이 주어진다.
        
    [출력]
        출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
        
        
    입력
        10
        6791400
        1646400
        1425600
        8575
        185625
        6480
        1185408
        6561
        25
        330750
        
    출력
        #1 3 2 2 3 1
        #2 6 1 2 3 0
        #3 6 4 2 0 1
        #4 0 0 2 3 0
        #5 0 3 4 0 1
        #6 4 4 1 0 0
        #7 7 3 0 3 0
        #8 0 8 0 0 0
        #9 0 0 2 0 0
        #10 1 3 3 2 0
*/


// 실행 시간 : 0.13500s
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
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			
			while (N != 1) {
				if (N % 2 == 0) {
					a += 1;
					N /= 2;
				}
				else if (N % 3 == 0) {
					b += 1;
					N /= 3;
				}
				else if (N % 5 == 0) {
					c += 1;
					N /= 5;
				}
				else if (N % 7 == 0) {
					d += 1;
					N /= 7;
				}
				else if (N % 11 == 0) {
					e += 1;
					N /= 11;
				}
			}
			
			System.out.println("#" + t + " " + a + " " + b + " " + c + " " + d + " " + e);
		}
	}
}
