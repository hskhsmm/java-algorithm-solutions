import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int maxLen = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        int typeCnt = set.size();
        
        if(typeCnt > maxLen) {
            return maxLen;
        } else {
            return typeCnt;
        }
        
    }
}
