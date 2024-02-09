package Graph;

import java.io.*;
import java.util.*;

public class Baek_13023 {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean arrived = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(graph[i]);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (arrived) {
                break;
            }
        }

        System.out.print(arrived ? 1 : 0);
    }

    private static void dfs(int node, int depth) {
        if (depth == 5 || arrived) {
            arrived = true;
            return;
        }

        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[node] = false;
    }
}

