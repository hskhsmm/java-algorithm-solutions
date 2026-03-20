import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 배포 일수 계산해서 큐에 담기
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i]; // 남은 작업량
            int day = remaining / speeds[i];     // 소요 일수 계산
            
            // 올림 처리
            if (remaining % speeds[i] != 0) {
                day++;
            }
            q.offer(day); 
        }

        // 2. 배포 묶음 계산
        ArrayList<Integer> list = new ArrayList<>();
        
        // 배포 기준
        int x = q.poll(); 
        int count = 1; //본인 포함

        while (!q.isEmpty()) {
            if (x >= q.peek()) {
                // 기준보다 일찍 or 똑같이 끝나면
                count++;
                q.poll(); // 같이 제거
            } else {
                list.add(count); // 쌓인 개수를 리스트에 추가
                count = 1;     // 개수 초기화
                x = q.poll();  
            }
        }
        
        // 마지막으로 처리 중이던 묶음도 리스트에 추가
        list.add(count);

        // 3. int[] 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}