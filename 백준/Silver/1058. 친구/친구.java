import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String friends = br.readLine().strip();
            for (int j = 0; j < N; j++) {
                char c = friends.charAt(j);
                if (c == 'Y')
                    board[i][j] = true;
            }
        }

        int[] second = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (i == j) continue;
                if (board[i][j]) {
                    second[i]++;
                    second[j]++;
                }
                else {
                    for (int k = 0; k < N; k++) {
                        if (board[i][k] && board[k][j]) 
                        {
                            second[j]++;
                            second[i]++;
                            break;
                        }
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(second));

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(second[i], answer);
        }

        System.out.println(answer);
    }
}
