import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static class Node {
        int r,c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] map;
    static int[][] check;
    static int N,M;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new int[N][M];

        map = new int[N][M];
        check = new int[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(check[N-1][M-1]);
    }

    public static void bfs(int r, int c) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(r,c));
        //시작점 처리 및 거리 1 설정
        check[r][c] = 1;
        
        while(!q.isEmpty()) {
            //현재 위치를 큐에서 꺼냄
            Node cur = q.poll();
            for(int i = 0; i < dr.length; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    //이동 가능하면서 아직 방문 x인거
                    if(map[nr][nc] == 1 && check[nr][nc] == 0) {
                        //현재 칸 + 1이 다음 칸
                        check[nr][nc] = check[cur.r][cur.c] + 1;
                        
                        q.offer(new Node(nr,nc));
                    }
                }
            }
        }
    }
}
