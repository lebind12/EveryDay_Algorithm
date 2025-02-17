import java.util.*;
import java.io.*;


public class Main {

    static int[][] dp;

    static int isPalendrom(int S, int E, int[] a) {
        // System.out.println(S + " " + E + " " + a[S] + " " + a[E]);
        if (dp[S][E] != -1)
            return dp[S][E];
        
        if (a[S] == a[E]) {
            return dp[S][E] = isPalendrom(S+1, E-1, a);
        } else {
            dp[S][E] = 0;
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        dp  = new int[2001][2001];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int[] a = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N+1; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = 1;

            if (i > 1) {
                if (a[i-1] == a[i]) {
                    dp[i-1][i] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(isPalendrom(S, E, a)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
