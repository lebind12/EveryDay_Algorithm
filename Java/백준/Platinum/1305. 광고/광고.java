import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[] text = br.readLine().toCharArray();

        int[] pi = new int[N];

        for (int i = 1, j = 0; i < N; i++) {
            while (j > 0 && text[i] != text[j]) {
                j = pi[j - 1];
            }

            if (text[i] == text[j]) {
                pi[i] = j + 1;
                j++;
            } else {
                pi[i] = 0;
            }
        }

        System.out.println(N - pi[N - 1]);

    }
}
