import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    // 인접 리스트: 리스트를 담는 배열로 선언
    static ArrayList<Integer>[] adj;
    static int node, line, start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 1. 인접 리스트 초기화
        adj = new ArrayList[node + 1];
        for (int i = 1; i <= node; i++) {
            adj[i] = new ArrayList<>();
        }

        // 2. 간선 정보 입력
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 연결
            adj[a].add(b);
            adj[b].add(a);
        }

        // 3. 번호가 낮은 노드부터 방문하기 위해 각 리스트 정렬 (중요!)
        for (int i = 1; i <= node; i++) {
            Collections.sort(adj[i]);
        }

        // DFS 실행
        check = new boolean[node + 1];
        dfs(start);
        sb.append("\n");

        // BFS 실행
        check = new boolean[node + 1];
        bfs(start);

        System.out.println(sb.toString());
    }

    public static void dfs(int cur) {
        check[cur] = true;
        sb.append(cur).append(" ");

        // 인접 리스트에서는 adj[cur]에 들어있는 노드들만 확인하면 됨
        for (int next : adj[cur]) {
            if (!check[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        check[startNode] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int next : adj[cur]) {
                if (!check[next]) {
                    check[next] = true;
                    q.add(next);
                }
            }
        }
    }
}