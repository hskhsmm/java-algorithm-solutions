import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static int[] visited; // 0이면 미방문 양수면 방문
    static int count = 1; // 카운트 초기 1번부터

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new int[N + 1];
        bfs(R);

        // 노드 방문 순서 출력. \n 해야함
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = count++; // 시작 정점 방문 순서 기록

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (visited[next] == 0) { 
                    visited[next] = count++; // 방문 안하면 카운트증가
                    q.offer(next);
                }
            }
        }
    }
}