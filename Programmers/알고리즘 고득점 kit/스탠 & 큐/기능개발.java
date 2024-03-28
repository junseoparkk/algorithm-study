import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer>q=new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++)
            q.add((int)(Math.ceil((100-progresses[i]) / (double)speeds[i])));
        
        List<Integer>answer = new ArrayList<>();
        while(!q.isEmpty()){
            int day = q.poll();
            int cnt = 1;
            
            while(!q.isEmpty() && day >= q.peek()){
                q.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        int size = answer.size();
        return answer.stream().mapToInt(i->i).toArray();
    }
}