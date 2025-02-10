import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            numbers[i] = i;
        }
        numbers[0] = -1;
        numbers[1] = -1;
        int count = 0;
        int target = 2;

        while (true) {
            if (numbers[target] == -1) {
                target++;
                continue;
            }
            for (int i = target; i < N+1; i++) {
                if (i % target == 0 && numbers[i] != -1) {
                    numbers[i] = -1;
                    count++;
                    if (count == M) {
                        System.out.println(i);
                        return;
                    }
                }
            }
            target += 1;
        }


    }
}
