// 집: (1,1), 학교: (n,m)

import java.util.*;

class Solution {
    
    static int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n + 1][m + 1];
        
        // 물이 잠긴 지역 -1로 설정
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        // 초기값 설정
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }
                
                if (dp[i - 1][j] > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }
                if (dp[i][j - 1] > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }
        
        return dp[n][m];
    }
}