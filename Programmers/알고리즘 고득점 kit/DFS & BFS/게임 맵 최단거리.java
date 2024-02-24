import java.util.*;

class Solution {
    static int N, M;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        visited = new boolean[N][M];
        
        bfs(0, 0, maps);
        
        return maps[N - 1][M - 1] != 1 ? maps[N - 1][M - 1] : -1;
    }
    
    private static void bfs(int fx, int fy, int[][] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {fx, fy});
        visited[fx][fy] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < N && yy >= 0 && yy < M) {
                    if (!visited[xx][yy] && maps[xx][yy] != 0) {
                        q.add(new int[] {xx, yy});
                        visited[xx][yy] = true;
                        maps[xx][yy] = maps[x][y] + 1;
                    }
                }
            }
        }
    }
}