import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int price : prices) {
            q.add(price);
        }
       
        int index = 0;
        while (!q.isEmpty()) {
            int nowPrice = q.poll();
            int nextPriceIndex = prices.length - q.size();
            
            for (int i = nextPriceIndex; i < prices.length; i++) {
                answer[index]++;
                if (nowPrice > prices[i]) {
                    break;
                }
            }
            index++;
        }
        return answer;
    }
}