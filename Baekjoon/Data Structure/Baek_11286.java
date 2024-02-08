import java.io.*;
import java.util.*;

public class Baek_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder result = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> {
            long abs1 = Math.abs(o1);
            long abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                return o1 > o2 ? 1 : -1;
            }
            return (int) (abs1 - abs2);
        });

        for (int i = 0; i < N; i++) {
            long num = Integer.parseInt(bf.readLine());
            if (num != 0) {
                pq.offer(num);
            } else {
                if (pq.isEmpty()) {
                    result.append(0).append('\n');
                } else {
                    result.append(pq.poll()).append('\n');
                }
            }
        }
        System.out.print(result.toString());
    }
}
