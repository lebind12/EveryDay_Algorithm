import java.util.*;
import java.io.*;


public class Main {

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean check = true;


    static int getInt(String input) {
        return Integer.parseInt(input);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;

        st = new StringTokenizer(br.readLine());
        int N = getInt(st.nextToken());
        int M = getInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = getInt(st.nextToken());
            }
        }
        int answer = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j])
                    continue;

                Deque<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i, j});

                check = true;
                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    
                    int y = pos[0];
                    int x = pos[1];

                    for (int k = 0; k < 8; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];

                        if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                            // System.out.println(board[ny][nx] + " " + ny + " " + nx + " " + i + " " + j);
                            if (board[ny][nx] > board[i][j]) {
                                check = false;
                            }
                            if (!visited[ny][nx]) {
                                if (board[ny][nx] == board[i][j]) {
                                    queue.add(new int[] {ny, nx});
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }
                }
                if (check) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
