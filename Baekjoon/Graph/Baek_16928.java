package Graph;
import java.io.*;
import java.util.*;

/**
 * 1. 1번 칸에서 시작, 100번 칸에 도착
 * 2. 주사위는 1~6 사이의 숫자.
 * 3. 플레이어가 i번 칸, 주사위가 n 이라면 i+n 칸으로 이동
 */
public class Baek_16928 {
    static int N, M;
    static int[] board;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        board = new int[101];
        visited = new int[101];

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            board[x] = y;
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            board[x] = y;
        }

        System.out.print(bfs(1));
    }

    private static int bfs(int startPoint) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startPoint);
        visited[startPoint] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 1; i < 7; i++) {
                int next = current + i;
                if (next > 100) {
                    continue;
                }
                if (visited[board[next]] == 0) {
                    q.add(board[next]);
                    visited[board[next]] = visited[current] + 1;
                }
                if (board[next] == 100) {
                    return visited[100];
                }
            }
        }
        return -1;
    }
}
