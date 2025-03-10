import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dp;
    static List<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        dp = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new int[] { cost, end });
            graph[end].add(new int[] { cost, start });
        }
        dijkstra(1);
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }

    static void dijkstra(int start) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });

        dp[start] = 0;
        heap.offer(new int[] { 0, start });
        while (!heap.isEmpty()) {
            int[] data = heap.poll();
            int curCost = data[0];
            int curNode = data[1];

            if (dp[curNode] < curCost)
                continue;
            for (int[] next : graph[curNode]) {
                int nextCost = next[0];
                int nextNode = next[1];

                if (dp[nextNode] > curCost + nextCost) {
                    dp[nextNode] = curCost + nextCost;
                    heap.offer(new int[] { curCost + nextCost, nextNode });
                }
            }
        }
    }
}
