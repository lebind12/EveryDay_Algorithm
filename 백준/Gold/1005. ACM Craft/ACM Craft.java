import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] buildTime = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
            int[] indegree = new int[N + 1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
                indegree[to]++;
            }

            int W = Integer.parseInt(br.readLine());

            // DP 배열: 각 건물을 완성하는 데 걸리는 최소 시간
            int[] dp = new int[N + 1];
            Queue<Integer> queue = new LinkedList<>();

            // 진입차수 0인 노드 큐에 삽입
            for (int i = 1; i <= N; i++) {
                dp[i] = buildTime[i];
                if (indegree[i] == 0) queue.offer(i);
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int next : graph.get(now)) {
                    if (dp[next] < dp[now] + buildTime[next]) {
                        dp[next] = dp[now] + buildTime[next];
                    }
                    indegree[next]--;
                    if (indegree[next] == 0) queue.offer(next);
                }
            }

            System.out.println(dp[W]);
        }
    }
}
