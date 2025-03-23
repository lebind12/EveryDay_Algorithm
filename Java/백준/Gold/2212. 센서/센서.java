import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        Integer[] sensors = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }        
        
        Integer[] blanks = new Integer[N-1];
        Arrays.sort(sensors);

        for (int i = 0; i < N-1; i++) {
            blanks[i] = sensors[i+1] - sensors[i];
        }

        // Arrays.sort(blanks);
        Arrays.sort(blanks, Collections.reverseOrder());
        int answer = 0;
        int boundary;

        if (K > N) {
            boundary = N-1;
        }
        else {
            boundary = K-1;
        }

        for (int i = 0; i < boundary; i++) {
            answer += blanks[i];
        }
        System.out.println(sensors[N-1] - sensors[0] - answer);
    }
}
