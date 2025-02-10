import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n-m <= m)
            m = n-m;

        BigInteger answer = new BigInteger("1");

        for (int i = 0; i < m; i++) {
            answer = answer.multiply(BigInteger.valueOf(n-i));
        }

        for (int i = 0; i < m; i++) {
            answer = answer.divide(BigInteger.valueOf(m-i));
        }

        System.out.println(answer.toString());
    }
}
