/*
2056. 연월일 달력

    · 시간 : 5개 테스트케이스를 합쳐서 C++의 경우 30초 / Java의 경우 30초 / Python의 경우 30초
    · 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
    
    
    연월일 순으로 구성된 8자리의 날짜가 입력으로 주어진다.
        22220228 → 2222/02/28
            [그림1]
            
    해당 날짜의 유효성을 판단한 후, 날짜가 유효하다면
    [그림1] 과 같이 ”YYYY/MM/DD”형식으로 출력하고,
    날짜가 유효하지 않을 경우, -1 을 출력하는 프로그램을 작성하라.
    
    연월일로 구성된 입력에서 월은 1~12 사이 값을 가져야 하며
    일은 [표1] 과 같이, 1일 ~ 각각의 달에 해당하는 날짜까지의 값을 가질 수 있다.
        1 월  1 일 ~ 31일      2 월  1 일 ~ 28 일
        3 월  1 일 ~ 31일      4 월  1 일 ~ 30 일
        5 월  1 일 ~ 31일      6 월  1 일 ~ 30 일
        7 월  1 일 ~ 31일      8 월  1 일 ~ 31 일
        9 월  1 일 ~ 30일      10 월  1 일 ~ 31 일
        11 월  1 일 ~ 30일     12 월  1 일 ~ 31 일
            [표1]
            
    ※ 2월의 경우, 28일인 경우만 고려한다. (윤년은 고려하지 않는다.)
    
    [입력]
        입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
        다음 줄부터 각 테스트 케이스가 주어진다.
        
    [출력]
        테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
        (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)


    입력
        5
        22220228
        20150002
        01010101
        20140230
        11111111
        
    출력
        #1 2222/02/28
        #2 -1
        #3 0101/01/01
        #4 -1
        #5 1111/11/11
*/


// 실행 시간 : 0.14420s
// Pass

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc <= T; tc++) {
			String date = sc.nextLine();
			
			String year = date.charAt(0) + "" + date.charAt(1) + "" +  date.charAt(2) + "" + date.charAt(3);
			String month = date.charAt(4) + "" + date.charAt(5);
//			String day = date.charAt(6) + "" + date.charAt(7);
			int day = 0;
			if (date.charAt(6) == 0) {
				day = date.charAt(7) - '0';
			}
			else {
				day = (date.charAt(6) - '0') * 10 + (date.charAt(7) - '0'); // 아스키코드 값이 48인 '0'을 빼서 정수형(int형)으로 변환한다.
			}
			
			if (month.equals("01") || month.equals("03") || month.equals("05") || month.equals("07") || month.equals("08") || month.equals("10") || month.equals("12")) {
				if (day >= 1 && day <= 31) {
					System.out.println("#" + tc + " " + year + "/" + month + "/" + date.charAt(6) + "" + date.charAt(7));
				}
				else {
					System.out.println("#" + tc + " " + -1);
				}
			}
			else if (month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) {
				if (day >= 1 && day <= 30) {
					System.out.println("#" + tc + " " + year + "/" + month + "/" + date.charAt(6) + "" + date.charAt(7));
				}
				else {
					System.out.println("#" + tc + " " + -1);
				}
			}
			else if (month.equals("02")) {
				if (day >= 1 && day <= 28) {
					System.out.println("#" + tc + " " + year + "/" + month + "/" + date.charAt(6) + "" + date.charAt(7));
				}
				else {
					System.out.println("#" + tc + " " + -1);
				}
			}
			else {
				System.out.println("#" + tc + " " + -1);
			}
		}
	}
}
