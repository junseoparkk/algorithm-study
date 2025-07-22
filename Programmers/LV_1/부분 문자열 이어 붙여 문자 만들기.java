class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_strings.length; i++) {
            String str = my_strings[i];
            int[] part = parts[i];
            
            sb.append(str.substring(part[0], part[1] + 1));
        }
        
        return sb.toString();
    }
}