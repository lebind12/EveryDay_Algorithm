import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());

        if (N % 7 == 2 || N % 7 == 0)
            System.out.println("CY");
        else
            System.out.println("SK");

    }
}
