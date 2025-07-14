class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split("");
        int index = 0;
        
        for (String str : split) {
            index = str.contains(" ") ? 0 : index + 1;
            sb.append(index % 2 == 0 ? str.toLowerCase() : str.toUpperCase());
        }
        return sb.toString();
    }
}