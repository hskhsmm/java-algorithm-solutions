class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 0번 인덱스는 사용x
        int[] students = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            students[i] = 1;
        }

        // 도난당한 학생들 -1
        for (int l : lost) {
            students[l]--;
        }

        // 여벌이 있는 학생들 +1
        for (int r : reserve) {
            students[r]++;
        }

        // 체육복 없는 학생들 확인
        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {
                // 그리디 선택
                if (i - 1 >= 1 && students[i - 1] == 2) {
                    students[i - 1]--;
                    students[i]++;
                } 
                // 없다면 뒷번호 확인
                else if (i + 1 <= n && students[i + 1] == 2) {
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }

        // 1벌 이상 학생 수
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}