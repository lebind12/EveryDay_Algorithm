import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] inDegree;

    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int amount = Integer.parseInt(st.nextToken());
            int beforeNode = -1;
            for (int j = 0; j < amount; j++) {
                if (j == 0) {
                    beforeNode = Integer.parseInt(st.nextToken());
                    continue;
                } else {
                    int curNode = Integer.parseInt(st.nextToken());
                    graph[beforeNode].add(curNode);
                    inDegree[curNode]++;
                    beforeNode = curNode;
                }
            }
        }
        // for (List line : graph) {
        // System.out.println(line.toString());
        // }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        // System.out.println(Arrays.toString(inDegree));

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            sb.append(curNode).append("\n");

            for (int nextNode : graph[curNode]) {
                inDegree[nextNode]--;
                if (inDegree[nextNode] == 0) {
                    queue.offer(nextNode);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (inDegree[i] > 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb.toString());
        return;

    }
}
