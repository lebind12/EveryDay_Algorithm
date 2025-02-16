import java.util.*;
import java.io.*;


public class Main {

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int posX = Integer.parseInt(st.nextToken());
        int posY = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[N][N];

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{posY, posX, 0});
        visited[posY][posX] = true;

        int answer = 99999999;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int y = pos[0];
            int x = pos[1];
            int count = pos[2];

            if (y == targetY && x == targetX) {
                answer = Math.min(answer, count);
                continue;
            }

            for (int k = 0; k < 6; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (!visited[ny][nx]) {
                        queue.add(new int[]{ny, nx, count+1});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        if (answer == 99999999)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}
