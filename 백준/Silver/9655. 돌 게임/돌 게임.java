import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        // 3은 SK, 4 CY, 5
        if (N%2==1)
            sb.append("SK");
        else
            sb.append("CY");
        System.out.println(sb.toString());
    }
}
