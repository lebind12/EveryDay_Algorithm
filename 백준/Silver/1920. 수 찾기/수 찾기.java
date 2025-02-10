import java.io.*;
import java.util.*;


public class Main {
    static int binarySearch(int start, int end, int[] array, int target) {
        int mid = (start + end) / 2;



        while (start < end) {
            if (array[mid] == target)
                return mid;
            else if (array[mid] < target) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
            mid = (start + end) / 2;
        }
        return end;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] input;

        input = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(input[i]);

        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            int idx = binarySearch(0, N, A, value);
//            System.out.println(idx);
            if (idx >= 0 && idx < N) {
                if (A[idx] == value) {
                    if (i != M-1)
                        sb.append(1).append("\n");
                    else
                        sb.append(1);
                } else {
                    if (i != M-1)
                        sb.append(0).append("\n");
                    else
                        sb.append(0);
                }

            }

            else {
                if (i != M-1)
                    sb.append(0).append("\n");
                else
                    sb.append(0);
            }
        }
        System.out.println(sb.toString());
    }
}
