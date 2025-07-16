import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int weight = getDivisorCount(i);
            if (weight > limit) {
                answer += power;
            } else {
                answer += weight;
            }
        }
        return answer;
    }
    
    private int getDivisorCount(int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divisors.add(i);
                if (i != number / i) {
                    divisors.add(i);
                }
            }
        }
        return divisors.size();
    }
}