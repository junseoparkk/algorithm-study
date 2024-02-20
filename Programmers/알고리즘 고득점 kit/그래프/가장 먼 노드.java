import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int[] visited;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        
        graph = new ArrayList[n + 1];
        visited = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            int[] row = edge[i];
            int u = row[0];
            int v = row[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        bfs(1);
        
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, visited[i]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (visited[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs(int node) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        visited[node] = 1;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (visited[next] == 0) {
                    q.offer(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }
}