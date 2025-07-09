import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        
        for (String r : record) {
            String[] split = r.split(" ");
            String command = split[0];
            StringBuilder sb = new StringBuilder();
            
            if (command.equals("Enter")) {
                if (!users.containsKey(split[1])) {
                    users.put(split[1], split[2]);
                } else {
                    users.replace(split[1], split[2]);
                }
                sb.append("E").append(split[1]);
                result.add(sb.toString());
            } else if (command.equals("Change")) {
                users.replace(split[1], split[2]);
            } else {
                sb.append("L").append(split[1]);
                result.add(sb.toString());
            }
        }
        
        String[] answer = new String[result.size()];
        
        int index = 0;
        for (String r : result) {
            char command = r.charAt(0);
            String uid = r.substring(1);
            String name = users.get(uid);
            
            if (command == 'E') {
                answer[index] = name + "님이 들어왔습니다.";
            } else {
                answer[index] = name + "님이 나갔습니다.";
            }
            index++;
        }
        
        return answer;
    }
}