import java.util.*;

class Solution {

    public int solution(String dirs) {
        int currentX = 0;
        int currentY = 0;
        
        Set<String> visitedDirs = new LinkedHashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            int nextX = currentX;
            int nextY = currentY;
            char command = dirs.charAt(i);
            StringBuilder sb = new StringBuilder();
            
            if (command == 'U') {
                nextY += 1;
                sb.append(currentX).append(currentY).append(nextX).append(nextY);
            } else if (command == 'D') {
                nextY -= 1;
                sb.append(nextX).append(nextY).append(currentX).append(currentY);
            } else if (command == 'R') {
                nextX += 1;
                sb.append(currentX).append(currentY).append(nextX).append(nextY);
            } else {
                nextX -= 1;
                sb.append(nextX).append(nextY).append(currentX).append(currentY);
            }
            
            if (nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5) {
                continue;
            }
            
            visitedDirs.add(sb.toString());
            currentX = nextX;
            currentY = nextY;
        }
        
        return visitedDirs.size();
    }
}