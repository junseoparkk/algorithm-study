import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        int[] answer = new int[2];
        
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer stk = new StringTokenizer(operations[i]);
            String command = stk.nextToken();
            int number = Integer.parseInt(stk.nextToken());
            
            if (command.equals("D") && minq.size() < 1) {
                continue;
            }
            
            if (command.equals("I")) {
                maxq.add(number);
                minq.add(number);
                continue;
            }
            
            if (number == -1) {
                int min = minq.poll();
                maxq.remove(min);
                continue;
            }
            
            int max = maxq.poll();
            minq.remove(max);
        }
        
        if (minq.size() > 0) {
            answer[0] = maxq.poll();
            answer[1] = minq.poll();
        }
        
        return answer;
    }
}