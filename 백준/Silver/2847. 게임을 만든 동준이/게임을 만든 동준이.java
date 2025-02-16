import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int maximum = scores[N-1];
        for (int i = N-2; i >= 0; i--) {
            if (maximum <= scores[i]) {
                answer += (scores[i] - (maximum - 1));
                scores[i] = maximum - 1;
            }
            maximum = scores[i];
            // System.out.println(Arrays.toString(scores));
        }

        System.out.println(answer);
    }
}
