import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int T;
        int P;

//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            T[i] = Integer.parseInt(st.nextToken());
//            P[i] = Integer.parseInt(st.nextToken());
//        }

        int[] dp = new int[N+2];
        for (int i = 1; i < N+1; i++) {
//            System.out.println(i + " " + T[i] + " " + dp[i]);
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1], dp[i]);
            if (i + T <= N+1) {
                dp[i+T] = Math.max(dp[i] + P, dp[i+T]);
            }
//            System.out.println(Arrays.toString(dp));
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
