import java.io.*;
import java.util.*;

public class Baek_4195 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> friends;
    static int[] parent;
    static int[] level;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            solve();
        }
        System.out.print(result.toString());
    }

    private static void solve() throws IOException {
        int F = Integer.parseInt(bf.readLine());
        int index = 0;

        friends = new LinkedHashMap<>();
        parent = new int[F * 2];
        level = new int[F * 2];

        for (int i = 0; i < F * 2; i++) {
            parent[i] = i;
            level[i] = 1;
        }

        for (int i = 0; i < F; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            String name1 = stk.nextToken();
            String name2 = stk.nextToken();

            if (!friends.containsKey(name1)) {
                friends.put(name1, index++);
            }
            if (!friends.containsKey(name2)) {
                friends.put(name2, index++);
            }
            result.append(union(friends.get(name1), friends.get(name2))).append('\n');
        }
    }

    private static int union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            level[a] += level[b];
        }
        return level[a];
    }

    private static int find(int target) {
        if (target == parent[target]) {
            return target;
        } else {
            return parent[target] = find(parent[target]);
        }
    }
}

