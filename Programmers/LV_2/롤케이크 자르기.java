/**
dp[n] = n번째에서 자를 때 토핑 갯수
topping = [1, 2, 1, 3, 1, 4, 1, 2]
dp1 = [1, 2, 2, 3, 3, 4, 4, 4] => 정순 (형)
dp2 = [4, 4, 4, 4, 3, 3, 2, 1] => 역순 (동생)
*/

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] old = new int[topping.length];
        int[] young = new int[topping.length];
        Set<Integer> set = new HashSet<>();
        
        // 정순
        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            old[i] = set.size();
        }
        
        set.clear();
        
        // 역순
        for (int i = topping.length - 1; i >= 0; i--) {
            set.add(topping[i]);
            young[i] = set.size();
        }
        
        for (int i = 0; i < topping.length - 1; i++) {
            if (old[i] == young[i + 1]) {
                answer++;
            }
        }
        
        return answer;
    }
}