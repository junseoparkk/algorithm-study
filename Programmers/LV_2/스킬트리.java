import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            String replaced = skill_trees[i].replaceAll("[^" + skill + "]", "");
            String ordered = skill.substring(0, replaced.length());
            
            if (replaced.equals(ordered)) {
                answer++;
            }
        }
        return answer;
    }
}