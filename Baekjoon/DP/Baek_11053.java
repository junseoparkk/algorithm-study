package DP;

import java.io.*;
import java.util.StringTokenizer;

public class Baek_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int x : dp) {
            max = Math.max(max, x);
        }
        System.out.print(max);
    }
}
