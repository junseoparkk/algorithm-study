import java.util.*;

class Solution {
    static Map<String, Integer> products = new LinkedHashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i < want.length; i++) {
            products.put(want[i], number[i]);
        }
        
        // day 1 부터 회원가입 가능한지 판단, 가능하면 answer + 1
        for (int i = 0; i < discount.length; i++) {
            if (checkSignupCondition(i, discount)) {
                answer++;
            }
        }
        return answer;
    }
    
    private boolean checkSignupCondition(int day, String[] discount) {
        Map<String, Integer> copyMap = new LinkedHashMap<>(products);
        
        for (int i = day; i < day + 10; i++) {
            if (i == discount.length) {
                break;
            }
            if (copyMap.containsKey(discount[i]) && (copyMap.get(discount[i]) > 0)) {
                copyMap.put(discount[i], copyMap.get(discount[i]) - 1);
            } 
        }
        
        for (Map.Entry<String, Integer> entry : copyMap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }        
        return true;
    }
}