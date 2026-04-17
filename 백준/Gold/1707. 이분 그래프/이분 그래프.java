import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Integer>> graph;
    private static int[] colors;
    private static final int RED = 1; // 색은 1과 -1로 구분

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); 


        for (int testCase = 0; testCase < K; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            colors = new int[V + 1]; // 색을 -1로 초기화할 배열

            for (int vertex = 0; vertex <= V; vertex++) {
                graph.add(new ArrayList<>());
            }


            for (int edge = 0; edge < E; edge++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            boolean rst = false;

            // 이분 그래프 체크
            for (int vertex = 1; vertex <= V; vertex++) {
                if (colors[vertex] == 0) { // 색이 칠해지지 않은 정점에 대해서만
                    rst = isBipartiteGraph(vertex, RED); 
                }
                if (!rst) break; 
            }

            
            if (rst) {
                System.out.println("YES");
            }
            else System.out.println("NO");
        }

        br.close();
    }

    //이분 그래프 여부를 확인
    private static boolean isBipartiteGraph(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = color; 

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (colors[cur] == colors[next]) return false;

                if (colors[next] == 0) {
                    colors[next] = colors[cur] * -1;
                    queue.add(next);
                }
            }
        }
        return true; // 이분 그래프면 true
    }
}
