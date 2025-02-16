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
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = a[0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i])
                    dp[i] = Math.max(dp[j] + a[i], dp[i]);
            }
            if (dp[i] == 0)
                dp[i] = a[i];
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
