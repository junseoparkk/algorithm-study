package Graph;
import java.io.*;
import java.util.*;

public class Baek_2206 {
    static class Point {
        int x, y, cnt;
        boolean crashed;

        public Point(int x, int y, int cnt, boolean crashed) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.crashed = crashed;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;   // 0: 안부숨, 1: 부숨
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.print(bfs(0, 0));
    }

    private static int bfs(int cx, int cy) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(cx, cy, 1, false));
        while (!q.isEmpty()) {
            Point now = q.poll();
            int nx = now.x;
            int ny = now.y;
            int ncnt = now.cnt;
            boolean isCrashed = now.crashed;

            if (nx == N - 1 && ny == M - 1) {
                return ncnt;
            }

            for (int i = 0; i < 4; i++) {
                int xx = nx + dx[i];
                int yy = ny + dy[i];
                if (xx >= 0 && xx < N && yy >= 0 && yy < M) {
                    if (map[xx][yy] == 0) {
                        if (!isCrashed && !visited[xx][yy][0]) {
                            q.offer(new Point(xx, yy, ncnt + 1, false));
                            visited[xx][yy][0] = true;
                        } else if (isCrashed && !visited[xx][yy][1]) {
                            q.offer(new Point(xx, yy, ncnt + 1, true));
                            visited[xx][yy][1] = true;
                        }
                    } else {
                        if (!isCrashed) {
                            q.offer(new Point(xx, yy, ncnt + 1, true));
                            visited[xx][yy][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

