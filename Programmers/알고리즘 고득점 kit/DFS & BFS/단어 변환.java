import java.util.*;

class Solution {
    static int step = 0;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return step;
    }
    
    private static void dfs(String begin, String target, String[] words, int depth) {
        if (begin.equals(target)) {
            step = depth;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            String nextWord = words[i];
            int sameCount = 0;
            for (int j = 0; j < nextWord.length(); j++){
                if (begin.charAt(j) == nextWord.charAt(j)) {
                    sameCount++;
                }
            }
            
            if (sameCount ==  nextWord.length() - 1) {
                visited[i] = true;
                dfs(nextWord, target, words, depth + 1);
                visited[i] = false;
            }
        }
    }
}