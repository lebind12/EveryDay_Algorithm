import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int[][] board;
    static boolean[][] visited;
    static int N, M, K;
    static int answer = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 0번째 칸부터 순서대로 선택 여부를 결정
        dfs(0, 0, 0);
        System.out.println(answer);
    }
    
    static void dfs(int idx, int cnt, int sum) {
        if (cnt == K) {
            answer = Math.max(answer, sum);
            return;
        }
        
        // 남은 칸의 수가 필요한 칸의 수보다 적으면 가지치기
        if (N * M - idx < K - cnt) return;
        
        for (int i = idx; i < N * M; i++) {
            int y = i / M;
            int x = i % M;
            
            if (canSelect(y, x)) {
                // 선택
                visited[y][x] = true;
                dfs(i + 1, cnt + 1, sum + board[y][x]);
                visited[y][x] = false;
            }
        }
    }
    
    static boolean canSelect(int y, int x) {
        // 현재 칸이 이미 선택되었거나 인접한 칸이 선택되었으면 false
        if (visited[y][x]) return false;
        
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (ny >= 0 && ny < N && nx >= 0 && nx < M && visited[ny][nx]) {
                return false;
            }
        }
        return true;
    }
}
