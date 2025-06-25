// 11:08 ~ 11:25

// X(바다)
// 1~9 자연수(무인도) => 모두 합한 값 = 무인도에서 머무를 수 있는 날짜
// 각 섬에서 최대 며칠씩 머무를 수 있는지? (오름차순)
// 만약 지낼 수 있는 무인도가 없다면 -1 반환

import java.util.*;

class Solution {
    static int w, h;
    
    static char map[][];
    static boolean[][] visited;
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1 ,0};
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        w = maps.length;
        h = maps[0].length();
        boolean impossible = true;
        
        map = new char[w][h];
        visited = new boolean[w][h];
        
        // maps -> map
        for (int i = 0; i < w; i++) {
            String str = maps[i];
            for (int j = 0; j < h; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] != 'X') {
                    impossible = false;
                }
            }
        }
        
        // 지낼 수 있는 무인도가 없는 경우
        if (impossible) {
            return new int[] {-1};
        }
        
        // bfs
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }
        
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int bfs(int x, int y) {
        int date = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[] {x, y});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            
            if (map[nx][ny] != 'X') {
                date += map[nx][ny] - '0';
            }
            
            for (int i = 0; i < 4; i++) {
                int xx = nx + dx[i];
                int yy = ny + dy[i];
                
                if (xx < 0 || xx >= w || yy < 0 || yy >= h) {
                    continue;
                }
                if (visited[xx][yy] || map[xx][yy] == 'X') {
                    continue;
                }
                
                q.add(new int[] {xx, yy});
                visited[xx][yy] = true;
            }
        }
        return date;
    }
}