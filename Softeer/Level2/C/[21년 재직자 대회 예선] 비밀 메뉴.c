/*
[21년 재직자 대회 예선] 비밀 메뉴

    언어별 시간/메모리
        언어	        시간  	메모리
        C	        1초	    1024MB
        C++	        1초	    1024MB
        Java	    1초	    1024MB
        Python	    1초	    1024MB
        Javascript	1초	    1024MB


    문제
        회사 식당에는 전설처럼 전해 내려오는 비밀 메뉴에 대한 소문이 있다. 소문의 내용은 대강 이러하다.
        식권 자판기의 버튼을 특정 순서대로 누르고 결제를 하면, 평소와는 다른 색깔의 식권이 나온다.

        이 식권을 배식대에 제출하면, 어떤 비밀 메뉴를 받을 수 있다는 것이다. 물론 이를 실제로 본 사람은 아무도 없어서, 어떤 메뉴가 나오는지는 커녕 눌러야 하는 버튼의 순서조차 알려져 있지 않다.

        주방장인 당신은 이 소문의 실체를 알고 있다. 이는 분명한 사실이다!
        정해진 버튼 조작법을 사용하면 비밀 메뉴의 식권을 얻을 수 있다. 그러나 얼마 전 식권 자판기가 고장으로 교체되면서, 새 자판기에서는 비밀 메뉴 조작법이 작동하지 않게 되었다.

        당신은 프로그래밍 실력을 살려, 사용자의 버튼 조작 중 비밀 메뉴 조작법이 포함되어 있는지를 판단하는 회로를 추가하려 한다.

        자판기에는 총 K개의 버튼이 있다. 각 버튼마다 1부터 K까지 번호가 붙어 있어서, 조작 과정은 1 이상 K 이하의 정수 여러 개로 나타낼 수 있다.
        비밀 메뉴 조작법은 M개의 버튼 조작으로 이루어져 있으며, 이 순서대로 버튼을 누르면 반드시 비밀 메뉴 식권이 발매된다. 이때, 이 조작법 앞뒤로 다른 버튼 조작이 있어도 비밀 메뉴로 인정된다.

        사용자가 누른 N개의 버튼 조작이 주어질 때, 사용자가 비밀 메뉴 식권을 받을 수 있는지를 확인하는 프로그램을 작성하여라.


    제약조건
        1 ≤ K ≤ 9
        1 ≤ M ≤ 100
        1 ≤ N ≤ 100
        각 버튼의 번호는 1 이상 K 이하이다.


    입력형식
        첫째 줄에 M, N, K가 공백을 사이에 두고 주어진다.
        둘째 줄에 비밀 메뉴 조작법을 나타내는 M개의 정수가 공백을 사이에 두고 주어진다. 각 정수는 1 이상 K 이하이다.
        셋째 줄에 사용자의 버튼 조작을 나타내는 N개의 정수가 공백을 사이에 두고 주어진다. 각 정수는 1 이상 K 이하이다.


    출력형식
        사용자가 비밀 메뉴 식권을 받을 수 있다면 secret을, 그렇지 않다면 normal을 첫째 줄에 출력한다.


    입력예제1
        3 10 5
        1 4 5
        3 3 1 2 4 1 4 5 1 4


    출력예제1
        secret

        비밀 메뉴 조작에 해당하는 부분을 표시하면 다음과 같다:
            3 3 1 2 4 [1 4 5] 1 4


    입력예제2
        4 10 3
        2 1 3 2
        1 3 2 1 3 2 1 3 2 1


    출력예제2
        secret

        비밀 메뉴 조작이 두 번 나타났다:
            1 3 [2 1 3 2] 1 3 2 1
            1 3 2 1 3 [2 1 3 2] 1

        비밀 메뉴 조작이 두 번 이상 나타나고 심지어 위의 예시와 같이 서로 겹치게 나타나더라도 정상적인 비밀 메뉴 조작으로 인정된다.


    입력예제3
        4 10 9
        2 7 1 8
        3 1 4 1 5 9 2 6 5 3


    출력예제3
        normal

        비밀 메뉴 조작 2 7 1 8이 나타나지 않았으므로 정상적인 식권이 발매된다.


    입력예제4
        4 3 5
        1 2 3 4
        3 2 1


    출력예제4
        normal

        사용자의 버튼 조작이 비밀 메뉴 조작법보다 짧은 경우가 있을 수 있다.
        이 경우 정상적인 식권이 발매된다. 즉, N＜M인 경우도 가능하다.
*/


// 실행 시간 : 5ms
// 메모리 : 0.99Mb
// 정답

#include <stdio.h>
#include <stdbool.h>

int main() {
    int M = 0;
    int N = 0;
    int K = 0;
    scanf("%d %d %d", &M, &N, &K);
  
    int secret_recipe[M];
    int user_recipe[N];
    for (int m = 0; m < M; m++) {
        scanf("%d ", &secret_recipe[m]);
    }
    for (int n = 0; n < N; n++) {
        scanf("%d ", &user_recipe[n]);
    }
  
    bool flag = false;
    for (int u = 0; u < N; u++) {
        if (M > N) {
            flag = false;
            break;
        }
    
        if (user_recipe[u] == secret_recipe[0]) {
            if (N - u - 1 >= M - 1) {
                for (int s = 0; s < M; s++) {
                    if (user_recipe[u + s] == secret_recipe[s]) {
                        flag = true;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
        }
    
        if (flag) {
            break;
        }
    }
  
    if (flag) {
        printf("secret");
    }
    else {
        printf("normal");
    }

    return 0;
}
