import java.io.*;
import java.util.*;

public class Main {
    static int N=0, M=0;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        perm(0, new int[M], array, new boolean[N]);
        System.out.println(sb.toString());
    }

    static void perm(int cnt, int[] b, int[] array, boolean[] visited) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                if (i == M-1)
                    sb.append(b[i]);
                else
                    sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int tmp = -1;
        for (int i = 0; i < N; i++) {
            if (tmp != array[i]) {
                b[cnt] = array[i];
                tmp = array[i];
                perm(cnt+1, b, array, visited);
            }
        }
    }
}
