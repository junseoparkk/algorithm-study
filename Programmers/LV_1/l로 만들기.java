import java.util.*;

class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < myString.length(); i++) {
            char ch = myString.charAt(i);
            if (ch < 'l') {
                sb.append('l');
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}