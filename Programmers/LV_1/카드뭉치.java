import java.util.*;

class Solution {
    static Queue<String> q1 = new ArrayDeque<>();
    static Queue<String> q2 = new ArrayDeque<>();
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        setCards(cards1, cards2);
        
        for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            
            if (!q1.isEmpty() && q1.peek().equals(word)) {
                q1.poll();
            } else if (!q2.isEmpty() && q2.peek().equals(word)) {
                q2.poll();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
    
    private static void setCards(String[] cards1, String[] cards2) {
        for (int i = 0; i < cards1.length; i++) {
            q1.offer(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            q2.offer(cards2[i]);
        }
    }
}