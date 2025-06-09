// 1. 괄호 문자열의 길이 - 1 만큼 회전 가능
// 2. 괄호 문자열 중 올바른 괄호 문자열 개수

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            String str = rotate(i, s);
            if (isValid(str)) {
                answer++;
            }
        }
        return answer;
    }
    
    public String rotate(int count, String s) {
        Queue<String> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            q.add(String.valueOf(s.charAt(i)));
        }
        for (int i = 0; i < count; i++) {
            String tmp = q.poll();
            q.add(tmp);
        }
        while (!q.isEmpty()) {
            sb.append(q.poll());
        }
        return sb.toString();
    }
    
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (stk.isEmpty()) {
                stk.push(s.charAt(i));
                continue;
            }
            
            if (stk.peek() == '{' && now == '}') {
                stk.pop();
            } else if (stk.peek() == '[' && now == ']') {
                stk.pop();
            } else if (stk.peek() == '(' && now == ')') {
                stk.pop();
            } else {
                stk.push(now);
            }
        }
        return stk.isEmpty();
    }
}