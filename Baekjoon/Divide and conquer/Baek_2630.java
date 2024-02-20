import java.io.*;
import java.util.*;

public class Baek_2630 {
    static int white = 0;
    static int blue = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(white);
        System.out.print(blue);
    }

    private static void partition(int row, int col, int size) {
        //  더 이상 분할할 수 없을 경우
        if (checkColor(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;

        // 재귀 호출
        partition(row, col, newSize);   // 2사분면
        partition(row, col + newSize, newSize); // 1사분면
        partition(row + newSize, col, newSize); // 3사분면
        partition(row + newSize, col + newSize, newSize);   // 4사분면
    }

    private static boolean checkColor(int row, int col, int size) {
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
