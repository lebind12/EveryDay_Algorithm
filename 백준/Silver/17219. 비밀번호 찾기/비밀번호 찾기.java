import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> dict= new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String k = st.nextToken();
            String v = st.nextToken();
            dict.put(k, v);
        }

        for (int i = 0; i < M; i++) {
            sb.append(dict.get(br.readLine().trim())).append("\n");
        }
        System.out.println(sb.toString());
    }
}
