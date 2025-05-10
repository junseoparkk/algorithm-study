import java.util.*;

class Solution {
    static Set<Integer> primeNumbers;
    static boolean[] visited;
    
    public int solution(String numbers) {
        primeNumbers = new HashSet<>();
        visited = new boolean[7];
        
        int answer = 0;
        backtracking(numbers, "", 0);
        
        for (int number : primeNumbers) {
            if (isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }
    
    private void backtracking(String numbers, String tmp, int depth) {
        if (numbers.length() == depth) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                primeNumbers.add(Integer.parseInt(tmp + numbers.charAt(i)));
                backtracking(numbers, tmp + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}