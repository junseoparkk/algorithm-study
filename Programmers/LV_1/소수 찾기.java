class Solution {
    
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 0; i <= n; i++) {
            if (isPrime[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}