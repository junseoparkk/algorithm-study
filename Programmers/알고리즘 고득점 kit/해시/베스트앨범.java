// 장르 별로 가장 많이 재생된 노래 2개 => 베스트 앨범
// 노래 수록 기준
// 1. 속한 노래가 가장 많이 재생된 장르 먼저
// 2. 장르 내에서 가장 많이 재생된 노래 먼저
// 3. 장르 내에서 재생 횟수가 같다면 고유 번호가 낮은 노래 먼저 (오름차순 정렬?)

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        Map<String, Map<Integer, Integer>> music = new HashMap<>();

        for(int i = 0; i < plays.length; i++) {
            if(!count.containsKey(genres[i])) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                count.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                count.put(genres[i], count.get(genres[i]) + plays[i]);
            }
        }

        List<String> keySet = new ArrayList(count.keySet());
        Collections.sort(keySet, (s1, s2) -> count.get(s2) - (count.get(s1)));

        for(String key : keySet) {
            Map<Integer, Integer> map = music.get(key);
            List<Integer> indexes = new ArrayList(map.keySet());

            Collections.sort(indexes, (s1, s2) -> map.get(s2) - (map.get(s1)));

            answer.add(indexes.get(0));
            if(indexes.size() > 1)
                answer.add(indexes.get(1));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}