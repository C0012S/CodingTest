/*
Lv. 1 #133502 - 햄버거 만들기

    문제 설명
        햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
        예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
        상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.


    제한사항
        · 1 ≤ ingredient의 길이 ≤ 1,000,000
        · ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.


    입출력 예
        ingredient	                    result
        [2, 1, 1, 2, 3, 1, 2, 3, 1]	    2
        [1, 3, 2, 1, 2, 1, 3, 1, 2]	    0


    입출력 예 설명
        입출력 예 #1
            · 문제 예시와 같습니다.

        입출력 예 #2
            · 상수가 포장할 수 있는 햄버거가 없습니다.
*/


/*
    정확성  테스트
        테스트 1 〉	통과 (0.17ms, 76.3MB)
        테스트 2 〉	통과 (0.19ms, 71.2MB)
        테스트 3 〉	통과 (41.56ms, 93MB)
        테스트 4 〉	통과 (56.51ms, 104MB)
        테스트 5 〉	통과 (74.05ms, 130MB)
        테스트 6 〉	통과 (75.40ms, 109MB)
        테스트 7 〉	통과 (62.94ms, 99.3MB)
        테스트 8 〉	통과 (54.48ms, 99.2MB)
        테스트 9 〉	통과 (74.49ms, 112MB)
        테스트 10 〉	통과 (3.93ms, 75.7MB)
        테스트 11 〉	통과 (45.32ms, 91.1MB)
        테스트 12 〉	통과 (76.04ms, 133MB)
        테스트 13 〉	통과 (0.11ms, 72.7MB)
        테스트 14 〉	통과 (0.11ms, 73.7MB)
        테스트 15 〉	통과 (0.12ms, 74.8MB)
        테스트 16 〉	통과 (0.11ms, 73.9MB)
        테스트 17 〉	통과 (0.15ms, 73.2MB)
        테스트 18 〉	통과 (0.16ms, 76.1MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

import java.util.*;

class Solution {
    static Stack<Integer> stack;
    static int hamburgerNum;

    public static void packHamburger(int[] ingredient) {
        hamburgerNum = 0;

        int breadNum = 0;
        for (int i = 0, num = ingredient.length; i < num; i++) {
            if (ingredient[i] == 1) { // 해당 재료가 빵일 경우
                if (breadNum >= 1 && stack.size() >= 3) {
                    int thirdIngredient = stack.pop();
                    int secondIngredient = stack.pop();
                    int firstIngredient = stack.pop();

                    if (thirdIngredient == 3 && secondIngredient == 2 && firstIngredient ==1) {
                        breadNum -= 1;
                        hamburgerNum += 1;

                        continue;
                    }
                    else {
                        stack.add(firstIngredient);
                        stack.add(secondIngredient);
                        stack.add(thirdIngredient);
                    }
                }

                // 포장할 수 있는 햄버거 형태가 아닐 경우
                stack.push(ingredient[i]);
                breadNum += 1;
            }
            else {
                stack.push(ingredient[i]);
            }
        }
    }

    public int solution(int[] ingredient) {
        stack = new Stack<>();

        packHamburger(ingredient);

        return hamburgerNum;
    }
}
