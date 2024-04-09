import java.io.*;
import java.util.*;

public class Baek_18352 {
    static int N, M, K, X;
    static List<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        X = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            graph[u].add(v);
        }

        bfs(X);

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                result.add(i);
            }
        }
        Collections.sort(result);

        if (result.isEmpty()) {
            System.out.print(-1);
        } else {
            result.forEach(System.out::println);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (visited[next] == -1) {
                    q.offer(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }
}
