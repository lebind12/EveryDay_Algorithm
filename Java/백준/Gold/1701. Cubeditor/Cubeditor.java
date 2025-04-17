import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String text = br.readLine();
        int length = text.length();
        int maximum = -1;

        for (int k = 0; k < length - 1; k++) {
            char[] subStr = text.substring(k, length).toCharArray();
            int subLength = subStr.length;
            int[] pi = new int[subLength];

            for (int i = 1, j = 0; i < subLength; i++) {
                while (j > 0 && subStr[i] != subStr[j]) {
                    j = pi[j - 1];
                }
                if (subStr[i] == subStr[j]) {
                    pi[i] = j + 1;
                    j++;
                } else {
                    pi[i] = 0;
                }
            }
            // System.out.println(Arrays.toString(pi));
            for (int i : pi)
                maximum = Math.max(maximum, i);
        }
        System.out.println(maximum);
    }
}
