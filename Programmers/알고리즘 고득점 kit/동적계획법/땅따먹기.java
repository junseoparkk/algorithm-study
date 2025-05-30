import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        int answer = 0;
        int dp[][] = new int[land.length][land[0].length];
        
        // 초기값 세팅
        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
    
        // dp 계산
        for (int i = 1; i < land.length; i++) {
            land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3]);
            land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3]);
            land[i][2] += max(land[i-1][0], land[i-1][1], land[i-1][3]);
            land[i][3] += max(land[i-1][0], land[i-1][1], land[i-1][2]);
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }
        
        return answer;
    }
    
    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}