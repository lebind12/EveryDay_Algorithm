import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeSet<String> people = new TreeSet<>((o1, o2) -> {
            return o2.compareTo(o1);
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();

            if (command.equals("enter")) {
                people.add(name);
            } else {
                people.remove(name);
            }
        }

        for (String name : people) {
            System.out.println(name);
        }
    }
}
