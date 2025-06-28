import java.util.*;

class Solution {
    static Map<String, Integer> index = new LinkedHashMap<>();
    
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        
        // 색인 번호 초기화
        for (int i = 1; i <= 26; i++) {
            index.put(String.valueOf((char) (64 + i)), i);
        }
        
        for (int i = 0; i < msg.length(); i++) {
            String word = "";
            
            // 사전에 등록된 가장 긴 문자열 찾기
            while (i < msg.length() && index.containsKey(word + msg.charAt(i))) {
                word += msg.charAt(i);
                i++;
            }
            
            answer.add(index.get(word));
            
            if (i < msg.length()) {
                index.put(word + msg.charAt(i), index.size() + 1);
                i -= 1;
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}