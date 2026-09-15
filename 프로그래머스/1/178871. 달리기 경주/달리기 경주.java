import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수 이름 -> 현재 등수(index) 저장
        Map<String, Integer> rankMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }
        
        for (String calling : callings) {
            // 1. 불린 선수의 현재 등수 조회
            int currentRank = rankMap.get(calling);
            int prevRank = currentRank - 1;
            
            // 2. 바로 앞 선수 이름 조회
            String prevPlayer = players[prevRank];
            
            // 3. players 배열 내 위치 Swap
            players[prevRank] = calling;
            players[currentRank] = prevPlayer;
            
            // 4. rankMap 내 등수 정보 갱신
            rankMap.put(calling, prevRank);
            rankMap.put(prevPlayer, currentRank);
        }
        
        return players;
    }
}