package Graph;

import java.io.*;
import java.util.*;

public class Baek_1068 {
    static int root;
    static int deleteNode;
    static List<Integer>[] tree;
    static boolean[] visited;
    static int leafNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 노드 개수
        int N = Integer.parseInt(bf.readLine());

        tree = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 부모 노드
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(stk.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree[i].add(parent);
                tree[parent].add(i);
            }
        }

        // 삭제 노드
        deleteNode = Integer.parseInt(bf.readLine());
        if (deleteNode == root) {
            System.out.print(0);
        } else {
            dfs(root);
            System.out.print(leafNode);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        int leaf = 0;
        for (int next : tree[node]) {
            if (!visited[next] && next != deleteNode) {
                leaf++;
                dfs(next);
            }
        }
        if (leaf == 0) {
            leafNode++;
        }
    }
}

