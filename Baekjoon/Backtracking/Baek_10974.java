import java.io.*;
import java.util.*;

public class Baek_10974 {
    static int N;
    static int[] numbers;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        numbers = new int[N];
        used = new boolean[N + 1];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                numbers[depth] = i;
                System.out.println("add: " + numbers[depth]);
                dfs(depth + 1);
                used[i] = false;
                System.out.println("delete: " + numbers[depth]);
            }
        }
    }
}

