import java.util.*;
import java.io.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] answer = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = N; i < N + M; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(answer);

        for (int i = 0; i < N + M; i++) {
            if (i == N + M - 1)
                sb.append(answer[i]);
            else
                sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
