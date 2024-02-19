package Graph;

import java.io.*;
import java.util.*;

public class Baek_1389 {
    static final int INF = 1000000000;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            dist[u][v] = 1;
            dist[v][u] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[j][k]);
                }
            }
        }

        int[] kevinNumber = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                kevinNumber[i] += dist[i][j];
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            result = Math.min(result, kevinNumber[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (kevinNumber[i] == result) {
                System.out.print(i);
                break;
            }
        }
    }
}
