import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int node, line; // node는 컴퓨터 수, line은 연결된 컴퓨터 쌍의 수
    static int[][] arr; // 인접 행렬을 저장할 배열 (각각의 컴퓨터 간 연결 정보를 저장)
    static boolean[] check; // 각 컴퓨터의 방문 여부를 저장하는 배열
    static int count = 0; // 감염된 컴퓨터의 수

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 컴퓨터 수(node)와 연결된 컴퓨터 쌍의 수(line) 입력 받기
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        // 인접 행렬 초기화
        arr = new int[node + 1][node + 1]; // 인덱스 1부터 사용하기 위해 크기 +1
        check = new boolean[node + 1]; // 방문 여부 배열 (1부터 사용하기 위해 크기 +1)

        // 두 번째 줄부터 연결된 컴퓨터들에 대한 정보를 받음
        // 예를 들어, 1 2라면 1번 컴퓨터와 2번 컴퓨터가 연결됨
        for (int i = 0; i < line; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken()); // 첫 번째 컴퓨터
            int b = Integer.parseInt(st1.nextToken()); // 두 번째 컴퓨터
            arr[a][b] = arr[b][a] = 1; // 양방향 연결 (a와 b가 서로 연결)
        }

        // 1번 컴퓨터부터 DFS를 시작하여 감염된 컴퓨터 수를 구함
        dfs(1);

        // 1번 컴퓨터를 제외한 감염된 컴퓨터 수 출력
        // count는 1번 컴퓨터를 포함한 감염된 컴퓨터의 수이므로 1을 빼서 출력
        System.out.println(count - 1);
    }

    // DFS 함수 정의 (깊이 우선 탐색)
    public static void dfs(int start) {
        check[start] = true; // 현재 컴퓨터를 방문 처리
        count++; // 현재 컴퓨터가 감염되었으므로 count 증가

        // 현재 컴퓨터와 연결된 다른 컴퓨터들을 탐색
        for (int i = 1; i <= node; i++) {
            // 현재 컴퓨터와 i번 컴퓨터가 연결되어 있고, 아직 방문하지 않았다면
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i); // 해당 컴퓨터를 방문하기 위해 DFS 재귀 호출
            }
        }
    }
}
