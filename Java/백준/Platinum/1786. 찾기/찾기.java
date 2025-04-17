import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = null;

        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        int tLength = text.length;
        int pLength = pattern.length;

        int[] pi = new int[pLength];

        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                pi[i] = j + 1;
                j++;
            } else {
                pi[i] = 0;
            }
        }

        // System.out.println(Arrays.toString(pi));

        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0, j = 0; i < tLength; i++) {
            while (j > 0 && text[i] != pattern[j]) {
                j = pi[j - 1];
            }

            if (text[i] == pattern[j]) {
                if (j == pLength - 1) {
                    cnt++;
                    list.add(i - j + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        sb = new StringBuffer();
        sb.append(cnt).append("\n");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1)
                sb.append(list.get(i));
            else
                sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb.toString());

    }
}