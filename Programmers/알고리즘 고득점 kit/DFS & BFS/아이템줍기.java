import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        visited = new boolean[101][101];
        
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];
            draw(x1 * 2, y1 * 2, x2 * 2, y2 * 2);
        }
    
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    private static void draw(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                map[i][j] = 1;
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    map[i][j] = 2;
                }
            }
        }
    }
    
    private static int bfs(int cx, int cy, int ix, int iy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {cx, cy ,0});
        visited[cx][cy] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];
            
            // 아이템에 도착한 경우
            if (x == ix && y == iy) {
                return count / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < 101 && yy >= 0 && yy < 101) {
                    if (!visited[xx][yy] && map[xx][yy] == 2) {
                        q.offer(new int[] {xx, yy, count + 1});
                        visited[xx][yy] = true;
                    }
                }
            }
        }
        return 0;
    }
}