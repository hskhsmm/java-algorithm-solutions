import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. 참가자 등록 (+1)
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 2. 완주자 차감 (-1)
        for (String c : completion) {
            map.put(c, map.get(c) - 1); 
        }
        
        // 3. entrySet으로 탐색
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //차감 안된 값
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        
        return ""; // 기본 리턴
    }
}