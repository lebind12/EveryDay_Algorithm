import java.io.*;
import java.util.*;


public class Main {

    static int uc(int a, int b) {
        int tmp;

        while (b > 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int first = 0;
        int target = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i == 0)
                first = Integer.parseInt(st.nextToken());
            else {
                target = Integer.parseInt(st.nextToken());
                int gcd = uc(Math.max(first, target), Math.min(first, target));
                sb.append(String.format("%d/%d", first/gcd, target/gcd)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
