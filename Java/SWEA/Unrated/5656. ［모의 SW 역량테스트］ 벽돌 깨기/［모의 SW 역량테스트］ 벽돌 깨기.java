import java.util.*;
import java.io.*;

public class Solution {
    static int N, W, H, answer;
    static int[][] boardOrigin;
    static int[][] board;

    static int[] shootingLanes;
    static int[] shootingOrder;

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;

            boardOrigin = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++)
                    boardOrigin[i][j] = Integer.parseInt(st.nextToken());
            }

            shootingLanes = new int[W];
            for (int i = 0; i < W; i++) {
                shootingLanes[i] = i;
            }
            shootingOrder = new int[N];

            perm(0);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void getNewBoard() {
        board = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                board[i][j] = boardOrigin[i][j];
            }
        }
    }

    static boolean isBound(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }

    static void gravity() {
        int[][] newBoard = new int[H][W];

        for (int j = 0; j < W; j++) {
            int newBoardIdx = H - 1;
            for (int i = H - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    newBoard[newBoardIdx][j] = board[i][j];
                    newBoardIdx--;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    static void shooting(int laneNum) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < H; i++) {
            if (board[i][laneNum] != 0) {
                queue.offer(new int[] { i, laneNum, board[i][laneNum] });
                board[i][laneNum] = 0;
                break;
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int y = pos[0];
            int x = pos[1];
            int v = pos[2];

            for (int k = 0; k < 4; k++) {
                for (int w = 1; w < v; w++) {
                    int ny = y + dy[k] * w;
                    int nx = x + dx[k] * w;

                    if (isBound(ny, nx) && board[ny][nx] > 0) {
                        queue.offer(new int[] { ny, nx, board[ny][nx] });
                        board[ny][nx] = 0;
                    }
                }
            }
        }
    }

    static void perm(int cnt) {
        if (cnt == N) {
            // System.out.println(Arrays.toString(shootingOrder));
            // 쏘는 순서 작성 끝.
            getNewBoard();
            for (int i = 0; i < N; i++) {
                // 쏘기 -> 블록 부수기
                shooting(shootingOrder[i]);
                gravity();
            }

            int count = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (board[i][j] != 0)
                        count++;
                }
            }
            // if (answer > count) {
            // System.out.println(Arrays.toString(shootingOrder));
            // for (int[] line : board)
            // System.out.println(Arrays.toString(line));
            // }
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < W; i++) {
            shootingOrder[cnt] = shootingLanes[i];
            perm(cnt + 1);
        }
    }
}