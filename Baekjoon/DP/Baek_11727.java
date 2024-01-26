package DP;

import java.io.*;
import java.util.*;

public class Baek_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] dp = new int[N + 1];
        int mod = 10007;

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % mod;
        }
        System.out.print(dp[N]);
    }
}
