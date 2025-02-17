import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int p = 9999999;
        int l = 9999999;
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            p = Math.min(p, Integer.parseInt(st.nextToken()));
            l = Math.min(l, Integer.parseInt(st.nextToken()));
        }

        if (p > l * 6) {
            System.out.println(l * N);
        }
        else {
            System.out.println(
                Math.min((p * (N/6) + l * (N%6)),
                (p * (N/6 + 1)))
                );
        }
    }
}
