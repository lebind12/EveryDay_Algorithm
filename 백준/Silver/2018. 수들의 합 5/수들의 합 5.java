import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 2;
        int value = start;

        int answer = 0;
        while (end <= N) {
            if (value < N) {
                value += end;
                end++;
            }
            else if (value == N) {
                answer += 1;
                value -= start;
                start++;
            }
            else {
                value -= start;
                start++;
            }
        }

        while (start < end) {
            value -= start;
            if (value == N)
                answer += 1;
            start++;
        }
        
        if (N == 1)
            System.out.println(1);
        else
            System.out.println(answer);
    }
}
