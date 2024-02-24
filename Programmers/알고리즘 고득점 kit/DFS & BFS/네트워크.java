import java.util.*;

class Solution {
    static List<Integer>[] network;
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        network = new ArrayList[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            network[i] = new ArrayList<>();
        }
        
        // 그래프 설정
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (computers[i][j] == 1) {
                    if (i == j) continue;
                    network[i].add(j);
                    network[j].add(i);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int computer) {
        visited[computer] = true;
        for (int next : network[computer]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}