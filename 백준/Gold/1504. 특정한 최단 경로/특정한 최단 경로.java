import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E;
    static List<Node>[] graph;
    static final int INF = 200000000;

    static class Node {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int dist1p1 = dijkstra(1, p1);
        int distp1p2 = dijkstra(p1, p2);
        int distp2n = dijkstra(p2, N);

        int dist1p2 = dijkstra(1, p2);
        int distp2p1 = dijkstra(p2, p1);
        int distp1n = dijkstra(p1, N);

        int path1 = dist1p1 + distp1p2 + distp2n;
        int path2 = dist1p2 + distp2p1 + distp1n;

        int result = Math.min(path1, path2);

        System.out.println(result >= INF ? -1 : result);
    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n1.weight, n2.weight);
            }
        });

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentWeight = current.weight;

            if (currentWeight > dist[currentVertex]) continue;

            for (Node neighbor : graph[currentVertex]) {
                int nextVertex = neighbor.vertex;
                int edgeWeight = neighbor.weight;
                int newWeight = currentWeight + edgeWeight; // 올바른 거리 계산

                if (newWeight < dist[nextVertex]) {
                    dist[nextVertex] = newWeight;
                    pq.add(new Node(nextVertex, newWeight));
                }
            }
        }
        return dist[end];
    }
}
