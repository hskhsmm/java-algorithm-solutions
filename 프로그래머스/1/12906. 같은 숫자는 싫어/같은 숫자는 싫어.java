import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        // Intger -> Integer 로 수정
        List<Integer> list = new ArrayList<>();
        
        for (int num : arr) {
            if (list.isEmpty() || list.get(list.size() - 1) != num) {
                list.add(num);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}