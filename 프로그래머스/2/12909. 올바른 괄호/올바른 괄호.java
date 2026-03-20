import java.util.ArrayDeque; 

class Solution {
    boolean solution(String s) {
        // 1. String -> Character
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c); // 2. 문자 c를 그대로 push
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        // 3. 스택이 비었는지 여부 리턴
        return stack.isEmpty();
    }
}