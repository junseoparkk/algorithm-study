import java.util.*;

class Solution {
    static class File implements Comparable<File> {
        String head;
        String number;
        String tail;
        
        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        @Override
        public int compareTo(File file) {
            if (this.head.equalsIgnoreCase(file.head)) {
                if (Integer.parseInt(this.number) != Integer.parseInt(file.number)) {
                    return Integer.parseInt(this.number) - Integer.parseInt(file.number);
                }
            }
            return this.head.toLowerCase().compareTo(file.head.toLowerCase());
        }
    }
    
    public String[] solution(String[] files) {
        List<File> sortedFiles = new LinkedList<>();
        List<String> answer = new LinkedList<>();
        
        // 문자열 파싱 후 File 객체로 변환
        for (String file : files) {
            String head = "";
            String number = "";
            String tail = "";
            
            int numberIdx = 0;
            for (int i = 0; i < file.length(); i++) {
                int ch = file.charAt(i) - '0';
                if (ch >= 0 && ch <= 9) {
                    head = file.substring(0, i);
                    numberIdx = i;
                    break;
                }
            }
            
            int tailIdx = 0;
            for (int i = numberIdx; i < file.length(); i++) {
                int ch = file.charAt(i) - '0';
                if (ch >= 0 && ch <= 9) {
                    number += file.charAt(i);
                } else {
                    tailIdx = i;
                    break;
                }
            }
            
            if (tailIdx == 0) {
                tail = "";
            } else {
                tail = file.substring(tailIdx);
            }

            sortedFiles.add(new File(head, number, tail));
        }
        
        // 정렬
        Collections.sort(sortedFiles);
        
        for(File file : sortedFiles) {
            answer.add(file.head + file.number + file.tail);
        }
        
        return answer.stream().toArray(String[]::new);
    }
}