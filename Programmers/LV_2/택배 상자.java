// 택배 상자 : 1번 ~ n번 까지 오름차순 순서대로 놓여있음
// 1번 상자부터 내릴 수 있음. (맨 앞부터)
// 만약 현재 트럭에 실어야 하는 순서가 아닌 경우 => 보조 컨테이너 벨트에 보관 (LIFO)

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> main = new ArrayDeque<>();
        Stack<Integer> sub = new Stack<>();
        
        // 메인 컨베이어 벨트 (1 ~ N번 상자 적재)
        for (int i = 1; i <= order.length; i++) {
            main.add(i);
        }
        
        for (int target : order) {
            if (!sub.isEmpty() && sub.peek() == target) {
                sub.pop();
                answer++;
            } else {
                boolean possible = false;
                
                while (!main.isEmpty()) {
                    if (main.peek() == target) {
                        main.poll();
                        answer++;
                        possible = true;
                        break;
                    } else {
                        sub.push(main.poll());
                    }
                }
                
                if (!possible) {
                    break;
                }
            }
        }
        
        return answer;
    }
}