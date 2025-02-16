import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1)
                break;

            int amount = 1;
            List<Integer> numbers = new ArrayList<>();
            numbers.add(1);
//            System.out.println(Math.sqrt(n)+1);
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % i == 0) {
                    if (i != (n / i)) {
                        amount += i;
                        amount += n/i;
                        numbers.add(i);
                        numbers.add((n/i));
                    } else {
                        amount += i;
                        numbers.add(i);
                    }
                }
            }
            Collections.sort(numbers);
//            System.out.println(numbers.toString());
            if (n == amount) {
                sb.append(n).append(" = ");
                for (int i = 0; i < numbers.size(); i++) {
                    if (i != numbers.size() - 1)
                        sb.append(numbers.get(i)).append(" + ");
                    else
                        sb.append(numbers.get(i)).append("\n");
                }
            } else {
                sb.append(n).append(" is NOT perfect.\n");
            }
        }
        System.out.println(sb.toString());
    }
}
