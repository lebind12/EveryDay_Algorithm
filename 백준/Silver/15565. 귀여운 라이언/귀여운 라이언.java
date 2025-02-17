import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int index = 0;
        int answer = 999999;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v == 1) {
                arr[index] = i;
                index++;
            }
        }
        if (index < N)
            arr[index] = -1;
        // System.out.println(Arrays.toString(arr));

        if (index < K) {
            System.out.println(-1);
            return;
        }

        int start = 0;
        int end = K-1;
        int i = 0;

        while (true) {
            if (end + i >= index)
                break;
            // System.out.println(arr[end+i] - arr[start+i]+1);

            answer = Math.min(answer, arr[end+i] - arr[start+i]+1);
            i++;
        }
        System.out.println(answer);
    }
}
