import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int totalCount = brown + yellow;
        
        for (int i = totalCount; i > 0; i--) {
            if (totalCount % i == 0) {
                int row = i;
                int col = totalCount / i;
                if (checkCondition(row, brown, yellow)) {
                    return new int[] {row, col};
                }
            }
        }
        return new int[] {};
    }
    
    private boolean checkCondition(int row, int brown, int yellow) {
        int yellowCol = (brown - row * 2) / 2;
        int yellowRow = row - 2;
        return yellowRow * yellowCol == yellow;
    }
}