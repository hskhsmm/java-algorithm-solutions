import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int[][] map;
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로가 M, 세로가 N
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토를 발견하면 큐에 미리 삽입
                if (map[i][j] == 1) {
                    q.offer(new Node(i, j));
                }
            }
        }

        // 시작점들이 이미 큐에 들어있음
        bfs();

        System.out.println(getResult());
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 0) {
                        // 이전 날짜 +1 저장
                        map[nr][nc] = map[cur.r][cur.c] + 1;
                        q.offer(new Node(nr, nc));
                    }
                }
            }
        }
    }

    public static int getResult() {
        int maxDays = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 하나라도 익지 않은 토마토가 남아있다면 -1
                if (map[i][j] == 0) {
                    return -1;
                }
                // 최댓값
                maxDays = Math.max(maxDays, map[i][j]);
            }
        }

        return maxDays - 1;
    }
}