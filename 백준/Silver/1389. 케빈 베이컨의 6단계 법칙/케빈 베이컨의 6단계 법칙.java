import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] dist;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1][N+1]; //1부터

        //자기는 0, 나머진 INF
        for(int i=1; i<= N; i++) {
            for(int j=1; j<= N; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for(int i=0; i< M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = dist[b][a] = 1;
        }

        //플로이드 워셜
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        //거리 합
        int minSum = INF;
        int person = -1; //존재하지 않는 번호

        for(int i=1; i<=N; i++) {
            int sum = 0;

            for(int j=1; j<=N; j++) {
                sum += dist[i][j]; //i번과 j번 간의 거리 누적
            }

            if(sum < minSum) {
                minSum = sum;
                person = i;
            }
        }
        System.out.println(person);




    }
}
