import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // [의상 종류 : 개수]
        HashMap<String, Integer> map = new HashMap<>();
        
        // 2차원 배열 돌면서 종류별 개수를 세자
        for (String[] cloth : clothes) {
            String type = cloth[1]; // 의상 종류 (Key)
            // 이미 존재하는 종류면 +1, 없으면 0 + 1
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // (각 종류별 개수 + 1)을 모두 곱하자.
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        
        // 맨 몸은 안되니까 -1
        return answer - 1;
    }
}