import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int a, b;
    static int[][] graph;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1]; // 1촌부터
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1; // 친척이니까 양방향
        }

        dfs(a, b, 0); //처음엔 0
        System.out.println(result);
    }

    static void dfs(int person, int target, int count) {
        if (person == target) { //만나면
            result = count;
            return;
        }

        visited[person] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[person][i] == 1 && !visited[i]) {
                dfs(i, target, count + 1);
                if (result != -1) { // 이미 결과가 구해졌다면 더 이상 탐색하지 않음
                    return;
                }
            }
        }
    }
}
