class Solution {
    public int solution(int[][] signals) {
        // 한 사이클
        long maxCycle = 1;
        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2]; 
            //최소공배수 적용
            maxCycle = lcm(maxCycle, cycle);
        }

        // 1초부터 최소공배수 시간까지 1초씩 증가
        for (int time = 1; time <= maxCycle; time++) {
            boolean allYellow = true;

            for (int[] signal : signals) {
                int g = signal[0];
                int y = signal[1];
                int r = signal[2];
                int total = g + y + r;

                // 현재 시간이 이 신호등의 주기에서 몇 번째 초인지 계산
                int remain = time % total;
                if (remain == 0) {
                    remain = total; // 나머지가 0이면 주기의 마지막 초(빨간불 끝)를 의미
                }

                // 노란불 구간(초록불 끝난 직후 ~ 노란불 끝날 때까지)인지 확인
                if (!(remain > g && remain <= g + y)) {
                    allYellow = false;
                    break; // 한 번이라도 노란불이 아니면 탈락
                }
            }

            // 모든 신호등이 노란불인 순간을 찾았다면 즉시 그 시간을 반환
            if (allYellow) {
                return time;
            }
        }

        // 최소공배수 주기 동안 단 한 번도 겹치지 않았다면 영원히 겹치지 않으므로 -1
        return -1;
    }

    // 최대공약수 
    private long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소공배수
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}