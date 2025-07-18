import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> words = new ArrayList<>();
        
        for (String str : strings) {
            words.add(str);
        }
        
        Collections.sort(words, new Comparator<String>() {
            
            @Override 
            public int compare(String s1, String s2) {
                char c1 = s1.charAt(n);
                char c2 = s2.charAt(n);
            
                if (c1 == c2) {
                    return s1.compareTo(s2);
                }
                return c1 - c2;
            }
        });
        
        return words.stream().toArray(String[] ::new);
    }
}