import java.util.*;
import java.io.*;


public class Main {

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int X;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command.charAt(0)-'0') {
                case 1:
                    X = Integer.parseInt(st.nextToken());
                    deque.addFirst(X);
                    break;
                case 2:
                    X = Integer.parseInt(st.nextToken());
                    deque.add(X);
                    break;
                case 3:
                    if (deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.poll()).append("\n");
                    break;
                case 4:
                    if (deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if (deque.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case 7:
                    if (deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.getFirst()).append("\n");
                    break;
                case 8:
                    if (deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.getLast()).append("\n");
                    break;
                default:
                    break;
            }
            // System.out.println(Arrays.toString(deque.toArray()));
        }
        System.out.println(sb.toString());

    }
}
