import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//숫자 정사각형
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] square = new int[N][M];

        for (int i = 0; i < N; i++) {
            //통째로 스캔
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                //j번째 문자 꺼내서 숫자로 변환 후 배열에 저장
                square[i][j] = line.charAt(j) - '0';
            }
        }

        int maxArea = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                for(int k=1; i + k < N && j + k < M; k++) {
                    if (square[i][j] == square[i][j+k] &&
                        square[i][j] == square[i+k][j] &&
                        square[i][j] == square[i+k][j+k]) {
                        maxArea = Math.max(maxArea, (k+1) * (k+1));
                    }
                }
            }
        }
        System.out.println(maxArea);



    }
}
