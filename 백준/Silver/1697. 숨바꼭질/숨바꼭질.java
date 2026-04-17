import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] check = new boolean[100001]; // 방문 체크 배열
    static int[] dx = {-1, 1, 2}; // 이동 연산

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    public static int bfs(int N, int K) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N, 0));
        check[N] = true;

        while(!q.isEmpty()) {
            Point current = q.poll();

            if(current.x == K) {
                return current.time;
            }

            for(int i=0; i<3; i++) {
                int next;
                if(i==2) {
                    next = current.x*2; //순간이동
                } else {
                    next = current.x+dx[i]; //-1이나 1
                }
                if(next >= 0 && next < 100001 && !check[next]) {
                    check[next] = true;
                    q.add(new Point(next, current.time+1));
                }
            }

        }
        return -1;

    }

    static class Point {
        int x;
        int time;

        public Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
