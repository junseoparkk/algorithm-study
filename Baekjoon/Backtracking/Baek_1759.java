package Backtracking;

import java.io.*;
import java.util.*;

public class Baek_1759 {
    static int L, C;
    static char[] word;
    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        word = new char[C];
        result = new char[L];
        stk = new StringTokenizer(bf.readLine());

        for (int i = 0; i < C; i++) {
            word[i] = stk.nextToken().charAt(0);
        }

        Arrays.sort(word);

        dfs(0, 0);
    }

    private static void dfs(int index, int depth) {
        if (depth == L) {
            if (isValidPassword()) {
                System.out.println(result);
            }
            return;
        }

        for (int i = index; i < C; i++) {
            result[depth] = word[i];
            dfs(i + 1, depth + 1);
        }
    }

    private static boolean isValidPassword() {
        int consonant = 0;
        int vowel = 0;
        for (char ch : result) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }
        return vowel >= 1 && consonant >= 2;
    }
}
