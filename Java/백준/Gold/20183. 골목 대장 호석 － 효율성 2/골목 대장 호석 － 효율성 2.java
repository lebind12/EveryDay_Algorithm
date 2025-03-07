import java.util.*;
import java.io.*;

public class Main {
    static int N, M, A, B, answer;
    static long C;
    static long[] dp;
    static List<Integer[]>[] graph;
    static PriorityQueue<Integer[]> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        graph = new List[N + 1];
        dp = new long[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        answer = Integer.MAX_VALUE;
        pq = new PriorityQueue<>(
                (o1, o2) -> {
                    return o1[1] - o2[1];
                });

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Integer[] { cost, end });
            graph[end].add(new Integer[] { cost, start });
        }

        dijkstra(A, B);
        // System.out.println(Arrays.toString(dp));

        if (dp[B] > C)
            System.out.println(-1);
        else {
            System.out.println(answer);
        }

    }

    // 다익스트라를 돌리면서 next 노드에 도달하는 경로를 추적
    // 경로에서 사용된 최대 코스트와 코스트 합계 필요.
    static void dijkstra(int start, int end) {
        dp[start] = 0;
        pq.offer(new Integer[] { 0, start, 0 });

        while (!pq.isEmpty()) {
            Integer[] cur = pq.poll();
            int w = cur[0];
            int n = cur[1];
            int m = cur[2];

            // System.out.println(Arrays.toString(cur));

            if (dp[n] < w)
                continue;

            for (Integer[] next : graph[n]) {
                int cost = w + next[0];
                int nextNode = next[1];
                int maximumCost = Math.max(next[0], m);
                if (cost < dp[nextNode]) {
                    dp[nextNode] = cost;
                    pq.offer(new Integer[] { cost, nextNode, maximumCost });
                    if (nextNode == end && cost <= C) {
                        answer = Math.min(answer, maximumCost);
                    }
                }
            }

        }
    }
}
