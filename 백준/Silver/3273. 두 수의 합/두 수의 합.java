import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int start = 0;
        int end = n-1;

        int count = 0;
        while (start < end) {
            int amount = array[start] + array[end];
            if (amount == x) {
                count++;
                end--;
            }
            else if (amount < x) {
                start++;
            }
            else
                end--;
        }
        System.out.println(count);
    }
}
