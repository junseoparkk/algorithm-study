import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
       
        int front = 0;
        int back = people.length - 1;
        
        while (front <= back) {
            if (people[front] + people[back] <= limit) {
                answer++;
                front++;
                back--;
            } else {
                back--;
                answer++;
            }
        }
        
        return answer;
    }
}