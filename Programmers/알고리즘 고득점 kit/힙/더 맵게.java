import java.util.*;

class Solution {
    
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        for (int score : scoville) {
            pq.add(score);
        }
        
        while (true) {
            // 모든 음식의 스코빌 지수가 K 이상인 경우
            if (check(K)) {
                return count;
            }
            
            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
            if (pq.size() == 1 && pq.peek() < K) {
                return -1;
            }
            
            int mixed = pq.poll() + (pq.poll() * 2);
            pq.add(mixed);
            count++;
        }
    }
    
    private boolean check(int k) {
        for (int score : pq) {
            if (score < k) {
                return false;
            }
        }
        return true;
    }
}