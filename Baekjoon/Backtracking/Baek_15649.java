package Backtracking;

import java.io.*;
import java.util.*;

public class Baek_15649 {
    static int N, M;
    static int[] number;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        number = new int[M];
        visited = new boolean[9];

        backtracking(0);
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (int x : number) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                number[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}

