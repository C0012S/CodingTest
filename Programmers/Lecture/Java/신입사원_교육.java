/*
PCCP 모의고사 2회. #121688 - [PCCP 모의고사 2] 2번, 신입사원 교육

    문제 설명
        산업스파이 민수는 A회사에 위장 취업했습니다. 이를 모르는 민수의 상사는 신입사원 교육 중 일부를 민수에게 맡겼습니다. 민수가 맡은 임무는 신입사원 중 2명을 선발하고 선발된 2명이 같이 공부하게 하는 것입니다. 모든 신입사원들의 능력치는 정수로 표현되어 있는데, 2명의 신입사원이 같이 공부하면 서로의 능력을 흡수하여 두 신입사원의 능력치는 공부 전 두 사람의 능력치의 합이 됩니다. 즉, 능력치가 3과 7인 두 사원이 같이 공부하면 두 사원의 능력치가 모두 10이 됩니다. 선발한 2인의 교육이 끝나면 민수는 다시 2인을 선발하여 교육을 진행할 수도 있습니다. 이때 한번 민수에게 선발된 사원이 다시 선발될 수도 있습니다. 민수가 교육한 신입사원들을 제외한 다른 신입사원들의 능력치는 변하지 않습니다.
        민수는 산업스파이이기 때문에 교육 후 모든 신입사원들의 능력치의 합을 최소화하고 싶습니다. 예를 들어, 신입사원들의 능력치가 순서대로 10, 3, 7, 2이며, 민수가 2번 교육을 해야 한다면, 첫 번째 교육은 두 번째 사원과 네 번째 사원을 선발하면 두 사원의 능력치가 5가 되어 신입사원들의 능력치가 10, 5, 7, 5가 됩니다. 두 번째 교육도 두 번째 사원과 네 번째 사원을 선발하면 신입사원들의 능력치는 순서대로 10, 10, 7, 10이 됩니다. 이 경우가 교육 후 모든 신입사원들의 능력치의 합이 37로 최소가 되는 경우입니다.
        신입사원들의 능력치를 나타내는 정수 배열 ability와 민수가 교육을 진행해야 하는 횟수를 나타내는 정수 number가 주어졌을 때, 교육 후 모든 신입사원들의 능력치의 합의 최솟값을 return 하는 solution 함수를 완성하세요.


    제한사항
        · 2 ≤ ability의 길이 ≤ 1,000,000
        · 1 ≤ ability의 원소 ≤ 100
        · 1 ≤ number ≤ 10,000
        · return 값이 10억 이하가 되도록 ability와 number가 주어집니다.


    입출력 예
        ability	            number	    result
        [10, 3, 7, 2]	    2	        37
        [1, 2, 3, 4]	    3	        26


    입출력 예 설명
        입출력 예 #1
            · 문제 예시와 같습니다.

        입출력 예 #2
            · 첫 번째 사원과 두 번째 사원을 선발하여 공부를 시킨 후, 세 번째 사원과 네 번째 사원을 선발하여 공부를 시킵니다. 그 후 첫 번째 사원과 두 번째 사원을 한번 더 선발해 공부를 시키면, 신입사원들의 능력치는 순서대로 6, 6, 7, 7이 되고, 이때가 능력치의 합이 최소인 26이 됩니다.
*/


/*
    정확성  테스트
        테스트 1 〉통과 (22.06ms, 89.5MB)
        테스트 2 〉통과 (47.81ms, 141MB)
        테스트 3 〉통과 (55.91ms, 140MB)
        테스트 4 〉통과 (28.92ms, 99.8MB)
        테스트 5 〉통과 (53.19ms, 141MB)
        테스트 6 〉통과 (18.48ms, 99.7MB)
        테스트 7 〉통과 (22.59ms, 88.6MB)
        테스트 8 〉통과 (52.44ms, 137MB)
        테스트 9 〉통과 (56.98ms, 132MB)
        테스트 10 〉통과 (44.17ms, 94.5MB)
        테스트 11 〉통과 (53.70ms, 139MB)
        테스트 12 〉통과 (54.83ms, 134MB)

    채점 결과
        정확성: 100.0
        합계: 100.0 / 100.0
*/


// 정답

import java.util.*;

class Solution {
    PriorityQueue<Integer> abilityQueue; // 각 신입 사원의 능력치를 저장하는 우선 순위 큐
    int abilitySum; // 모든 신입 사원들의 능력치의 합

    public void init(int[] ability) { // 교육 전 우선 순위 큐에 각 신입 사원의 능력치를 저장하고, 모든 신입 사원들의 능력치의 합을 구하는 메서드
        abilityQueue = new PriorityQueue<>();

        for (int a = 0, len = ability.length; a < len; a++) {
            abilityQueue.offer(ability[a]);
            abilitySum += ability[a];
        }
    }

    public void educate(int[] ability) { // 민수가 신입 사원들을 교육하는 메서드
        int firstAbility = abilityQueue.poll(); // 현재 능력치가 가장 낮은 신입 사원
        int secondAbility = abilityQueue.poll(); // 현재 능력치가 두 번째로 낮은 신입 사원
        int educatedAbility = firstAbility + secondAbility; // 두 신입 사원의 교육 후 능력치

        // 교육 후, 신입 사원들의 능력치 정보 및 모든 신입 사원들의 능력치의 합 갱신
        abilityQueue.offer(educatedAbility);
        abilityQueue.offer(educatedAbility);
        abilitySum += educatedAbility;
    }

    public int solution(int[] ability, int number) {
        init(ability);

        for (int e = 0; e < number; e++) {
            educate(ability);
        }

        return abilitySum;
    }
}