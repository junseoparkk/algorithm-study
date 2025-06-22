import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if (n > s) {
            return new int[] {-1};
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
        }
        int remain = s % n;
        
        for (int i = n - 1; i >= n - remain; i--) {
            answer[i] += 1;
        }
        
        return answer;
    }
}