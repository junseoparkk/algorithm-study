package DP;

import java.io.*;
import java.util.*;

public class Baek_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] coins = new int[n];
        long[] dp = new long[k + 1];  // k원을 만들 수 있는 경우의 수

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.print(dp[k]);
    }
}

