import java.io.*;
import java.util.*;

public class Baek_15651 {
    static int N, M;
    static int[] number;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        number = new int[M];
        visited = new boolean[9];

        backtracking(0);
        System.out.print(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (int x : number) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            number[depth] = i;
            backtracking(depth + 1);
        }
    }
}
