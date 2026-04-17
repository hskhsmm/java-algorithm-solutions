import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V,E,K;
    static List<Node>[] graph; //그래프 저장 인접 리스트
    static int[] dist;
    static final int INF = 1000000000;

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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            //방향이니까 u -> v 간선만
            graph[u].add(new Node(v, w));
        }

        dist = new int[V+1];
        Arrays.fill(dist, INF);

        //시작 정점은 0
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.weight - n2.weight;
            }
        });

        pq.add(new Node(K, 0));

        while(!pq.isEmpty()) {

            //정점 꺼내자
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentWeight = current.weight;

            // 현재 정점까지의 거리가 기존 최단 거리보다 크다면 무시
            if (currentWeight > dist[currentVertex]) continue;

            for(Node neighbor : graph[currentVertex]) {
                int nextVertex = neighbor.vertex; //인접 정점
                int edgeWeight = neighbor.weight; //간선 가중치
                int newWeight = currentWeight + edgeWeight; //새로운 가중치

                if(newWeight < dist[nextVertex]) {
                    dist[nextVertex] = newWeight;
                    pq.add(new Node(nextVertex, newWeight)); //갱신정점 추가
                }
            }
        }
        for(int i=1; i<=V; i++) {
            if(dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }

        }
    }

}