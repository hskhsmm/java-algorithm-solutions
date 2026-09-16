import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int num : arr) {
            // 덱이 비어있거나 peekLast랑 현재 원소가 다를 때만 추가
            if (deque.isEmpty() || deque.peekLast() != num) {
                deque.addLast(num);
            }
        }

        // Deque -> int[] 변환
        int[] answer = new int[deque.size()];
        int index = 0;
        
        while (!deque.isEmpty()) {
            answer[index++] = deque.pollFirst(); // 앞에서부터 하나씩 꺼내기
        }

        return answer;
    }
}