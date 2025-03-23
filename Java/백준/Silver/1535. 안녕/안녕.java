import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] L, J;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        L = new int[N + 1];
        J = new int[N + 1];

        dp = new int[N + 1][101];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        // 2개부터 다 골랐을 때 까지의 최대 기쁨
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < 100; j++) {
                if (L[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - L[i]] + J[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][99]);
    }
}
