import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 효율적인 출력 처리를 위해 StringBuilder를 사용
    static StringBuilder sb = new StringBuilder();

    // 각 노드의 방문 여부를 저장하는 배열
    static boolean[] check;

    // 그래프를 인접 행렬로 표현하는 2차원 배열
    static int[][] arr;

    // 노드의 수, 간선의 수, 시작 노드를 저장하는 변수들
    static int node, line, start;

    // BFS에서 사용할 큐 (큐에 노드를 추가하여 순차적으로 방문)
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        // BufferedReader를 사용하여 입력을 빠르게 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 노드의 수, 간선의 수, 시작 노드를 입력 받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());  // 노드의 수
        line = Integer.parseInt(st.nextToken());  // 간선의 수
        start = Integer.parseInt(st.nextToken()); // 시작 노드

        // 인접 행렬을 노드 수 + 1 크기로 초기화 (0번 노드는 사용하지 않음)
        arr = new int[node + 1][node + 1];

        // 방문 여부 배열을 노드 수 + 1 크기로 초기화 (0번 노드는 사용하지 않음)
        check = new boolean[node + 1];

        // 간선 정보를 입력받아서 인접 행렬에 저장
        for (int i = 0; i < line; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            // 두 개의 노드 a, b가 간선으로 연결되어 있다는 정보를 입력받음
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());

            // 간선이 양방향이므로 a -> b, b -> a 둘 다 1로 표시
            arr[a][b] = arr[b][a] = 1;
        }

        // DFS 탐색을 시작
        dfs(start);
        sb.append("\n");  // DFS가 끝나면 줄바꿈을 추가

        // BFS를 시작하기 전에 방문 여부 배열을 초기화
        check = new boolean[node + 1];

        // BFS 탐색을 시작
        bfs(start);

        // 최종적으로 StringBuilder에 저장된 결과를 출력
        System.out.println(sb.toString());
    }

    // DFS 함수 정의
    public static void dfs(int start) {
        // 현재 노드를 방문했다고 표시
        check[start] = true;
        // 현재 노드를 출력 (StringBuilder에 추가)
        sb.append(start + " ");

        // 현재 노드와 연결된 모든 노드를 재귀적으로 방문
        for (int i = 1; i <= node; i++) {
            // 연결된 노드이면서 아직 방문하지 않은 노드라면 DFS를 재귀적으로 호출
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    // BFS 함수 정의
    public static void bfs(int start) {
        // 시작 노드를 큐에 추가하고 방문 표시
        q.add(start);
        check[start] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 큐에서 노드를 꺼내서 방문
            start = q.poll();
            sb.append(start + " "); // 현재 노드를 출력 (StringBuilder에 추가)

            // 현재 노드와 연결된 모든 노드를 큐에 추가하여 차례대로 방문
            for (int i = 1; i <= node; i++) {
                // 연결된 노드이고 아직 방문하지 않은 노드라면 큐에 넣고 방문 표시
                if (arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}