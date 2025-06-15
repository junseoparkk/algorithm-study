/**
1. J(A, B) : 교집합 크기 / 합집합 크기
2. 만약 A, B 모두 공집합인 경우 J(A, B) = 1
3. 다중 집합에서 a, b는 각각 중복 원소의 갯수
    - 교집합 : min(a, b)
    - 합집합 : max(a, b)
4. 문자열 사이 유사도 : 두 글자씩 끊어서 다중 집합을 만들 수 있음
    - 단, 영문자로 된 글자 쌍만 유효 -> 다른 글자가 존재하면 버림
    - 대문자와 소문자 구분 x
    - 문자열 다중 집합 크기 = 문자열 길이 - 1
*/

/**
필요한 로직
1. 문자열에 대한 다중집합 생성
    - 두 글자씩 잘라서 저장 [o]
    - 유효하지 않은 글자가 포함되면 저장 x [o]
2. 교집합과 합집합 구하기
3. 자카드 유사도 계산
*/

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 다중 집합
        List<String> str1MultiSet = getMultiSet(str1);
        List<String> str2MultiSet = getMultiSet(str2);
        
        // 다중 집합 원소별 갯수
        Map<String, Integer> str1Count = new LinkedHashMap<>();
        Map<String, Integer> str2Count = new LinkedHashMap<>();
        
        // 다중 집합 원소의 갯수 계산
        for (String str : str1MultiSet) {
            str1Count.put(str, str1Count.getOrDefault(str, 0) + 1);
        }
        for (String str : str2MultiSet) {
            str2Count.put(str, str2Count.getOrDefault(str, 0) + 1);
        }
        
        // 교집합 생성
        double intersectionSize = 0.0;
        for (Map.Entry<String, Integer> entry : str1Count.entrySet()) {
            String key = entry.getKey();
            if (str2Count.containsKey(key)) {
                int count = Math.min(entry.getValue(), str2Count.get(key));
                intersectionSize += count;
            }
        }
        
        // 합집합 생성
        double unionSize = (double) str1MultiSet.size() + str2MultiSet.size();
        for (Map.Entry<String, Integer> entry : str1Count.entrySet()) {
            String key = entry.getKey();
            if (str2Count.containsKey(key)) {
                int count = Math.min(entry.getValue(), str2Count.get(key));
                unionSize -= count;
            }
        }

        
        // 교집합 or 합집합 갯수가 0인 경우 예외 처리
        if (intersectionSize == 0 && unionSize == 0) {
            return 65536;
        } else if (intersectionSize == 0 || unionSize == 0) {
            return 0;
        }
        
        // 자카드 유사도 계산
        double jacquard = intersectionSize / unionSize;
        answer = (int) (jacquard * 65536.0);
        
        return answer;
    }
    
    private List<String> getMultiSet(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2).toLowerCase();
            if (isValidString(sub)) {
                list.add(sub);
            }
        }
        return list;
    }
    
    private boolean isValidString(String str) {
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        
        if (c1 < 'a' || c1 > 'z' || c2 < 'a' || c2 > 'z') {
            return false;
        }
        return true;
    }
}