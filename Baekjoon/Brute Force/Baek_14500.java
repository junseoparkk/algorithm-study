import java.io.*;
import java.util.*;

public class Baek_14500 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        // 초기화 및 입력
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.print(result);
    }

    private static void dfs(int x, int y, int sum, int count) {
        if (count == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && xx < N && yy >= 0 && yy < M) {
                if (!visited[xx][yy]) {
                    if (count == 2) {
                        visited[xx][yy] = true;
                        dfs(x, y, sum + map[xx][yy], count + 1);
                        visited[xx][yy] = false;
                    }
                    visited[xx][yy] = true;
                    dfs(xx, yy, sum + map[xx][yy], count + 1);
                    visited[xx][yy] = false;
                }
            }
        }
    }
}

