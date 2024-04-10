import java.io.*;
import java.util.StringTokenizer;

public class Baek_9184 {
    static int[][][] dp = new int[101][101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = bf.readLine();
            if (str.equals("-1 -1 -1")) {
                break;
            }
            StringTokenizer stk = new StringTokenizer(str);
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, wabc(a, b, c));
        }
    }

    public static int wabc(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return wabc(20, 20, 20);
        }
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            return dp[a][b][c] = wabc(a, b, c - 1) + wabc(a, b - 1, c - 1) - wabc(a, b - 1, c);
        }
        return dp[a][b][c] = wabc(a - 1, b, c) + wabc(a - 1, b - 1, c) + wabc(a - 1, b, c - 1) - wabc(a - 1, b - 1, c - 1);
    }
}