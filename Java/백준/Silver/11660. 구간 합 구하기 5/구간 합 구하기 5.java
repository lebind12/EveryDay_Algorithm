import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] newBoard = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                newBoard[i][j] = board[i][j] + newBoard[i-1][j] + newBoard[i][j-1] - newBoard[i-1][j-1];
            }
        }

        // for(int[]line: board) System.out.println(Arrays.toString(line));
        // System.out.println();
        // for(int[]line: newBoard) System.out.println(Arrays.toString(line));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
    
            // System.out.println(
            //     String.format("%d %d %d %d",
            //     newBoard[x2][y2], newBoard[x2][y1-1], newBoard[x1-1][y2], newBoard[x1-1][y1-1]
            //     )

            // );

            sb.append(newBoard[x2][y2] - newBoard[x2][y1-1] - newBoard[x1-1][y2] + newBoard[x1-1][y1-1]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
