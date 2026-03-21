import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new ArrayDeque<>(); //우선순위,원래 인덱스 용도
        for(int i = 0; i<priorities.length; i++) {
            pq.offer(priorities[i]);
            //원소, 원래 인덱스
            q.offer(new int[]{priorities[i], i});
        }
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            
            //제일 큰지 확인
            if(current[0] == pq.peek()) {
                answer++;
                pq.poll();
                
                //인덱스 확인
                if(current[1] == location) {
                    return answer;
                } 
            }
            else {
                q.add(current);
            }
        } 
        return answer;
    }
}

