import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            
            if(r == n - 1 && c == m - 1) {
                return dist;
            }
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(maps[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr,nc,dist + 1});
                    }
                }
            }
        }
        return -1;
    }
}