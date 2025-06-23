// 출구까지 최소 시간 = 1) 출발 지점 ~ 레버까지 최소 시간 + 2) 레버 ~ 출구까지 최소 시간
// 같은 곳을 여러 번 지날 수 있다? => 최소 시간이 되려면 지나면 안됨

import java.util.*;

class Solution {
    
    static char[][] maze;
    static boolean[][] visited;
    
    static int mazeW;
    static int mazeH;
    
    static int dx[] = {1, 0, -1 ,0};
    static int dy[] = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        // 미로 너비 및 높이 초기화
        mazeW = maps.length;
        mazeH = maps[0].length();
        
        // 미로 및 방문 배열 초기화
        maze = new char[mazeW][mazeH];
        visited = new boolean[mazeW][mazeH];
        
        // 시작 지점 및 레버 위치 초기화
        int[] start = new int[2];
        int[] lever = new int[2];
        
        // 미로 초기화
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                maze[i][j] = maps[i].charAt(j);

                if (maze[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maze[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
        
        // 레버까지 최소시간 구하기
        int toLeverTime = bfs(start, 'L');
        if (toLeverTime == -1) {
            return -1;
        }
        
        // 방문 배열 초기화
        visited = new boolean[mazeW][mazeH];
        
        // 출구까지 최소 시간 구하기
        int toExitTime = bfs(lever, 'E');
        if (toExitTime == -1) {
            return -1;
        }
        
        return toLeverTime + toExitTime;
    }
    
    private static int bfs(int[] location, char target) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {location[0], location[1], 0});
        visited[location[0]][location[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int cnt = now[2];
            
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                // 범위를 벗어난 경우
                if (nextX < 0 || nextX >= mazeW || nextY < 0 || nextY >= mazeH) {
                    continue;
                }
                
                // 벽인 경우
                if (maze[nextX][nextY] == 'X' || visited[nextX][nextY]) {
                    continue;
                }
                
                // 목적지인 경우
                if (maze[nextX][nextY] == target) {
                    return cnt + 1;
                }
                
                queue.add(new int[] {nextX, nextY, cnt + 1});
                visited[nextX][nextY] = true;
            }
        }
        return -1;
    }
}