import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i < N+1; i++) {
            if (dp[i-3] != 0 && dp[i-5] != 0)
                dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
            else if (dp[i-3] == 0 && dp[i-5] != 0)
                dp[i] = dp[i-5] + 1;
            else if (dp[i-3] != 0 && dp[i-5] == 0)
                dp[i] = dp[i-3] + 1;
            else
                dp[i] = 0;
        }

//        System.out.println(Arrays.toString(dp));
        if (dp[N] == 0)
            System.out.println(-1);
        else
            System.out.println(dp[N]);
    }
}
