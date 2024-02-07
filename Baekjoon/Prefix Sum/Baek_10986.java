import java.io.*;
import java.util.*;

public class Baek_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        long[] S = new long[N + 1];
        long[] C = new long[M];
        long result = 0;

        stk = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stk.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int remainder = (int)(S[i] % M);
            if (remainder == 0) {
                result++;
            }
            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                result += (C[i] * (C[i] - 1) / 2);
            }
        }

        System.out.print(result);
    }
}
