import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int hIndex = 0;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            int thesisCount = citations.length - i;
            
            if (citations[i] >= thesisCount) {
                hIndex = thesisCount;
                break;
            }
        }
        
        return hIndex;
    }
}