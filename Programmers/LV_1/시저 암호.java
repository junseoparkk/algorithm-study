import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                sb.append(' ');
                continue;
            }
            
            if ('a' <= ch && ch <= 'z') {
                if (ch + n > 'z') {
                    sb.append((char) (ch - 26 + n));
                } else {
                    sb.append((char) (ch + n));
                } 
            }
            
            if ('A' <= ch && ch <= 'Z') {
                if (ch + n > 'Z') {
                    sb.append((char) (ch - 26 + n));
                } else {
                    sb.append((char) (ch + n));
                } 
            }
        }
        return sb.toString();
    }
}