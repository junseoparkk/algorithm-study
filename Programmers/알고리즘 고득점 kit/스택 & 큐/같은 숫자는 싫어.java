import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (stk.peek() == arr[i]) {
                continue;
            } else {
                answer.add(stk.pop());
                stk.push(arr[i]);
            }
        }
        
        answer.add(stk.pop());
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}