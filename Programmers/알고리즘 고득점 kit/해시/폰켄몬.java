import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer>pocketmon=new TreeSet<>();
        
        for(int i=0;i<nums.length;i++)
            pocketmon.add(nums[i]);
        
        if(pocketmon.size() < (nums.length/2)) {
            answer=pocketmon.size();
        } 
        else {
            answer=nums.length/2;
        }
        
        return answer;
    }
}