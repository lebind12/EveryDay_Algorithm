import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 1; i < N+1; i++)
            parent[i] = i;
        

        List<Integer[]> edges = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Integer start = Integer.parseInt(st.nextToken());
            Integer end = Integer.parseInt(st.nextToken());
            Integer cost = Integer.parseInt(st.nextToken());
            edges.add(new Integer[] {start, end, cost});
        }

        Collections.sort(edges, (o1, o2) -> {
            return o1[2] - o2[2];
        });
        
        int amount = 0;
        int maximum = -1;

        List<Integer> answer = new ArrayList<>();
        for (Integer[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];

            if (find(parent, start) != find(parent, end)) {
                union(parent, start, end);
                answer.add(cost);
                amount += cost;
                maximum = Math.max(cost, maximum);
            }
        }
        System.out.println(amount - maximum);
    }

    static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (a == b) return;
        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }

    static int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
