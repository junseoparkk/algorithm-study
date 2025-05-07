import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        
        for (int priority : priorities) {
            queue.offer(priority);
        }
        
        while(!queue.isEmpty()) {  
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]) {
                    queue.poll();
                    count++;
                    
                    if (location == i) {
                        return count;
                    }
                }
            }
        }
        return count;
    }
}