// 가능한 비율
// 1) a = b 
// 2) a x 3 = b x 2
// 3) a x 4 = b x 2
// 4) a x 4 = b x 3

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        
        Arrays.sort(weights);
        
        for (int weight : weights) {
            double case1 = (double) weight;
            double case2 = (double) (weight * 2) / 3;
            double case3 = (double) weight / 2;
            double case4 = (double) (weight * 3) / 4;
            
            if (map.containsKey(case1)) {
                answer += map.get(case1);
            }
            if (map.containsKey(case2)) {
                answer += map.get(case2);
            }
            if (map.containsKey(case3)) {
                answer += map.get(case3);
            }
            if (map.containsKey(case4)) {
                answer += map.get(case4);
            }
            map.put(case1, map.getOrDefault(case1, 0) + 1);
        }
        
        
        return answer;
    }
}