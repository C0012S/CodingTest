/*
1940. 가랏! RC카!

    · 시간 : 10개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    RC (Radio Control) 카의 이동거리를 계산하려고 한다.
    입력으로 매 초마다 아래와 같은 command 가 정수로 주어진다.
        0 : 현재 속도 유지.
        1 : 가속
        2 : 감속
        
    위 command 중, 가속(1) 또는 감속(2) 의 경우 가속도의 값이 추가로 주어진다.
    가속도의 단위는, m/s2 이며, 모두 양의 정수로 주어진다.
    입력으로 주어진 N 개의 command 를 모두 수행했을 때, N 초 동안 이동한 거리를 계산하는 프로그램을 작성하라.
    RC 카의 초기 속도는 0 m/s 이다.
    
    [예제]
	    아래 예제 입력에서 정답은 3 이 된다.
	        입력         시간     RC 카의 속도 RC     카의 이동거리
	        1 2          1 sec          2 m/s                    2 m
	        2 1          2 sec          1 m/s                    3 m
        
    [제약사항]
        1. N은 2이상 30이하의 정수이다. (2 ≤ N ≤ 30)
        2. 가속도의 값은 1 m/s2 혹은 2 m/s2 이다.
        3. 현재 속도보다 감속할 속도가 더 클 경우, 속도는 0 m/s 가 된다.
        
    [입력]
        입력은 첫 줄에 총 테스트 케이스의 개수 T, 다음 줄부터 각 테스트 케이스가 주어진다.
        테스트 케이스 첫 줄에는 Command 의 수 N이 주어지고, 둘째 줄부터, 매 줄마다 각각의 Command가 주어진다.
        
    [출력]
        테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
        
        
    입력
        10
        2
        1 2
        2 1
        3
        1 1
        0
        1 1
        5
        1 2
        1 2
        2 1
        0
        0
        8
        0
        1 2
        1 1
        0
        1 2
        2 1
        1 1
        0
        10
        1 2
        1 1
        2 2
        1 2
        0
        0
        1 1
        1 1
        1 2
        0
        12
        1 2
        1 1
        1 2
        2 1
        0
        1 1
        1 1
        2 2
        2 2
        1 1
        0
        0
        15
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        1 2
        20
        1 2
        2 1
        0
        1 2
        0
        1 1
        2 1
        1 2
        0
        2 1
        2 1
        0
        1 1
        0
        1 2
        1 2
        0
        1 2
        2 2
        2 2
        25
        2 1
        2 1
        0
        0
        0
        1 2
        0
        2 2
        1 2
        2 1
        1 1
        2 1
        0
        0
        0
        1 1
        1 2
        0
        0
        1 2
        2 2
        0
        2 2
        0
        1 1
        30
        2 1
        2 2
        2 2
        1 1
        1 2
        2 1
        0
        1 1
        0
        0
        1 2
        1 2
        2 1
        0
        0
        2 2
        2 1
        1 2
        0
        1 1
        2 2
        1 2
        2 2
        0
        1 2
        2 1
        2 2
        0
        1 1
        2 2
        
    출력
        #1 3
        #2 4
        #3 15
        #4 27
        #5 38
        #6 44
        #7 240
        #8 91
        #9 48
        #10 111
*/


// 실행 시간 : 0.13721s
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
			int speed = 0;
			int distance = 0;
			
			for (int n = 0; n < N; n++) {
				int command_acceleration = sc.nextInt();
				
				if (command_acceleration == 0) {
					distance += speed;
				}
				else if (command_acceleration == 1) {
					int command_speed = sc.nextInt();
					
					speed += command_speed;
					distance += speed;
				}
				else if (command_acceleration == 2) {
					int command_speed = sc.nextInt();
					
					if (command_speed > speed) {
						speed = 0;
						distance += speed;
					}
					else {
						speed -= command_speed;
						distance += speed;
					}
				}
			}
			
			System.out.println("#" + t + " " + distance);
		}
	}
}
