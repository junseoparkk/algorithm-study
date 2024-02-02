package Graph;

import java.io.*;
import java.util.*;

public class Baek_21736 {
    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int result = 0;
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        if (result == 0) {
            System.out.print("TT");
        } else {
            System.out.print(result);
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < N && yy >= 0 && yy < M) {
                    if (campus[xx][yy] != 'X' && !visited[xx][yy]) {
                        q.offer(new int[] {xx, yy});
                        visited[xx][yy] = true;
                        if (campus[xx][yy] == 'P') {
                            result++;
                        }
                    }
                }
            }
        }
    }
}
