import java.io.*;
import java.util.*;

public class Baek_1966 {
    static class Document {
        int index;
        int value;

        public Document(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            solve();
        }
        System.out.print(result.toString());
    }

    private static void solve() throws IOException {
        LinkedList<Document> q = new LinkedList<>();
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int importance = Integer.parseInt(stk.nextToken());
            q.offer(new Document(i, importance));
        }

        int count = 0;

        while (!q.isEmpty()) {
            Document front = q.poll();
            boolean isMax = true;

            for (int i = 0; i < q.size(); i++) {
                if (front.value < q.get(i).value) {
                    q.offer(front);
                    for (int j = 0; j < i; j++) {
                        q.offer(q.poll());
                    }
                    isMax = false;
                    break;
                }
            }

            if (!isMax) {
                continue;
            }
            count++;
            if (front.index == M) {
                break;
            }
        }
        result.append(count + "\n");
    }
}