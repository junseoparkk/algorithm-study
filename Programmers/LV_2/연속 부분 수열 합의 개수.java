import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> numbers = new LinkedHashSet<>();
        
        int length = 1;
        while (length <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < i + length; j++) {
                    sum += elements[j % elements.length];
                }
                numbers.add(sum);
            }
            length++;
        }
        
        return numbers.size();
    }
}