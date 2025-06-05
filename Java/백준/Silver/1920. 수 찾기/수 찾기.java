import java.util.*;
import java.io.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;

        N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> dict = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            dict.put(key, 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (dict.get(key) == null) {
                if (i == M - 1)
                    sb.append("0");
                else
                    sb.append("0").append("\n");
            } else {
                if (i == M - 1)
                    sb.append("1");
                else
                    sb.append("1").append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
