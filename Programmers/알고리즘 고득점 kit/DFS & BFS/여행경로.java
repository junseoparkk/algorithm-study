import java.util.*;

class Solution {
    static List<String> paths = new ArrayList<>();
    static boolean[] usedTicket;
    
    public String[] solution(String[][] tickets) {
        usedTicket = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(paths);
        return paths.get(0).split(" ");
    }
    
    private static void dfs(int depth, String now, String path, String[][] tickets) {
        if (depth == tickets.length) {
            paths.add(path);
            return;
        }
        
        for (int i = 0; i < usedTicket.length; i++) {
            String depart = tickets[i][0];
            String arrive = tickets[i][1];
            
            if (!usedTicket[i] && now.equals(depart)) {
                usedTicket[i] = true;
                dfs(depth + 1, arrive, path + " " + arrive, tickets);
                usedTicket[i] = false;
            }
        }
    }
}