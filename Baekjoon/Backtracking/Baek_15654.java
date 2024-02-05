import java.io.*;
import java.util.*;

public class Baek_15654 {
    static int N, M;
    static int[] number;
    static int[] newNumber;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        number = new int[N];
        newNumber = new int[N];
        visited = new boolean[N];

        stk = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(number);

        backtracking(0);
        System.out.print(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(newNumber[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                newNumber[depth] = number[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
