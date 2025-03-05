import java.util.*;
import java.io.*;

public class Main {
    static int N;
    // 좌하우상
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[][] board;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int total = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                total += board[i][j];
            }
        }

        int direction = 0;
        int[] current = {N/2, N/2};
        int value = 1;
        int step = 1;
        int count = 0;
        while (value <= N * N) {
            int y = current[0];
            int x = current[1];
            
            if (y == 0 && x == 0)
                break;

            move(y, x, direction);
            int ny = y + dy[direction];
            int nx = x + dx[direction];

            current = new int[] {ny, nx};
            count++;

            if (step == count){
                direction = (direction+1)%4;
                count = 0;

                if (direction == 0 || direction == 2)
                    step++;
            }
        }

        int remain = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                remain += board[i][j];
            }
        }
        System.out.println(total - remain);
    }

    static void move(int y, int x, int direction) {
        int ny = y + dy[direction];
        int nx = x + dx[direction];
        int remain = board[ny][nx];

        // direction == 0 -> 왼쪽이동
        int[][] area;
        if (direction == 0) {
            area = new int[][] {
                {0, -1, 55}, {-1, 0, 7}, {1, 0, 7},
                {-1, -1, 10}, {1, -1, 10}, {-1, 1, 1}, {1, 1, 1},
                {0, -2, 5}, {2, 0, 2}, {-2, 0, 2}
            };

            for (int i = 1; i < 10; i++) {
                int ay = ny + area[i][0];
                int ax = nx + area[i][1];
                int ac = area[i][2];

                if (ay >= 0 && ay < N && ax >= 0 && ax < N) {
                    remain -= (board[ny][nx] * ac / 100);
                    board[ay][ax] += (board[ny][nx] * ac / 100);
                } else {
                    remain -= (board[ny][nx] * ac / 100);
                }
            }
            
            int ay = ny + area[0][0];
            int ax = nx + area[0][1];
            if (ay >= 0 && ay < N && ax >= 0 && ax < N)
                board[ay][ax] += remain;
        } else if (direction == 1) {
            area = new int[][] {
                {1, 0, 55}, {0, -1, 7}, {0, 1, 7},
                {1, -1, 10}, {1, 1, 10}, {-1, -1, 1}, {-1, 1, 1},
                {2, 0, 5}, {0, -2, 2}, {0, 2, 2}
            };
            for (int i = 1; i < 10; i++) {
                int ay = ny + area[i][0];
                int ax = nx + area[i][1];
                int ac = area[i][2];

                if (ay >= 0 && ay < N && ax >= 0 && ax < N) {
                    remain -= (board[ny][nx] * ac / 100);
                    board[ay][ax] += (board[ny][nx] * ac / 100);
                } else {
                    remain -= (board[ny][nx] * ac / 100);
                }
            }
            int ay = ny + area[0][0];
            int ax = nx + area[0][1];
            if (ay >= 0 && ay < N && ax >= 0 && ax < N)
                board[ay][ax] += remain;
        } else if (direction == 2) {
            area = new int[][] {
                {0, 1, 55}, {-1, 0, 7}, {1, 0, 7},
                {1, 1, 10}, {-1, 1, 10}, {-1, -1, 1}, {1, -1, 1},
                {0, 2, 5}, {2, 0, 2}, {-2, 0, 2}
            };

            for (int i = 1; i < 10; i++) {
                int ay = ny + area[i][0];
                int ax = nx + area[i][1];
                int ac = area[i][2];

                if (ay >= 0 && ay < N && ax >= 0 && ax < N) {
                    remain -= (board[ny][nx] * ac / 100);
                    board[ay][ax] += (board[ny][nx] * ac / 100);
                } else {
                    remain -= (board[ny][nx] * ac / 100);
                }
            }
            int ay = ny + area[0][0];
            int ax = nx + area[0][1];
            if (ay >= 0 && ay < N && ax >= 0 && ax < N)
                board[ay][ax] += remain;
        } else { // direction == 3
            area = new int[][] {
                {-1, 0, 55}, {0, -1, 7}, {0, 1, 7},
                {-1, -1, 10}, {-1, 1, 10}, {1, 1, 1}, {1, -1 ,1},
                {-2, 0, 5}, {0, -2, 2}, {0, 2, 2}
            };

            for (int i = 1; i < 10; i++) {
                int ay = ny + area[i][0];
                int ax = nx + area[i][1];
                int ac = area[i][2];

                if (ay >= 0 && ay < N && ax >= 0 && ax < N) {
                    remain -= (board[ny][nx] * ac / 100);
                    board[ay][ax] += (board[ny][nx] * ac / 100);
                } else {
                    remain -= (board[ny][nx] * ac / 100);
                }
            }
            int ay = ny + area[0][0];
            int ax = nx + area[0][1];
            if (ay >= 0 && ay < N && ax >= 0 && ax < N)
                board[ay][ax] += remain;
        }
        
        board[ny][nx] = 0;
    }
}
