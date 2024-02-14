import java.io.*;
import java.util.*;

public class Baek_20040 {
    static int[] parent;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        // N : 숫자 갯수, M : 간선 개수
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            stk = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if (!union(a, b)) {
                result = i;
                break;
            }
        }

        System.out.print(result);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        }
        parent[b] = a;
        return true;
    }

    private static int find(int target) {
        if (target == parent[target]) {
            return target;
        } else {
            return parent[target] = find(parent[target]);
        }
    }
}
