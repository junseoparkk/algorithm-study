/** 
- 절대값이 10^c (c >= 0) 형태의 정수
- 1의 자리수 < 5 => 빼기
- 1의 자리수 = 5
    - 10의 자리수 >= 5 => 10의 자리수 
    - 10의 자리수 < 5 => 더하기
- 1의 자리수 > 5 => 더하기
*/

import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
            int one = storey % 10;
            int ten = (storey / 10) % 10;
            
            if (one < 5) {
                answer += one;
            } else if (one == 5) {
                answer += one;
                storey += ten >= 5 ? 10 : 0;
            } else {
                answer += 10 - one;
                storey += 10;
            }
            storey /= 10;
        }
        return answer;
    }
} {
    
}
