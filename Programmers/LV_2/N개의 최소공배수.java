class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int gcd = gcd(arr[i], lcm);
            lcm = arr[i] * lcm / gcd;
        }
        return lcm;
    }
    
    private int gcd(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        
        while (x % y != 0) {
            int remain = x % y;
            x = y;
            y = remain;
        }
        
        return y;
    }
}