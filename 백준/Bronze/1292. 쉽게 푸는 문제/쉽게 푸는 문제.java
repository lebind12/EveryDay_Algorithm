import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] numbers = new int[1001];
        int index = 1;
        int number = 1;
        while (index < 1001) {
            for (int i = 0; i < number; i++) {
                if (index >= 1001)
                    break;
                numbers[index] = number;
                index++;
            }
            number++;
        }
//        System.out.println(Arrays.toString(numbers));
        int amount = 0;
        for (int i = A; i < B+1; i++) {
            amount += numbers[i];
        }
        System.out.println(amount);
    }
}
