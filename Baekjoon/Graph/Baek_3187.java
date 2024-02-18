package Graph;

import java.io.*;
import java.util.*;

public class Baek_3187 {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int sheep = 0;   // k
    static int wolf = 0;    // v

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = bf.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        System.out.print(sheep + " " + wolf);
    }

    private static void bfs(int cx, int cy) {
        int sheepCount = 0;
        int wolfCount = 0;
        Queue<int[]> q = new ArrayDeque<>();
        visited[cx][cy] = true;
        q.offer(new int[] {cx, cy});

        if (map[cx][cy] == 'k') {
            sheepCount++;
        } else if (map[cx][cy] == 'v'){
            wolfCount++;
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < R && yy >= 0 && yy < C) {
                    if (!visited[xx][yy] && map[xx][yy] != '#') {
                        char ch = map[xx][yy];
                        if (ch == 'k') {
                            sheepCount++;
                        } else if (ch == 'v'){
                            wolfCount++;
                        }
                        q.offer(new int[] {xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
        }
        if (sheepCount <= wolfCount) {
            wolf += wolfCount;
        } else {
            sheep += sheepCount;
        }
    }
}

