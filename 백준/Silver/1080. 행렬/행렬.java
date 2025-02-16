import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int[][] target = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                target[i][j] = input.charAt(j) - '0';
            }
        }


        int answer = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < M-2; j++) {
                if (board[i][j] != target[i][j]) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            board[i+k][j+l] = (board[i+k][j+l] + 1) % 2;
                        }
                    }
                    answer++;
                }
            }
        }
        // for (int[] line: board) System.out.println(Arrays.toString(line));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != target[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }
}
