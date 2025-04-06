import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 방문 배열
        boolean[] visited = new boolean[100001];
        
        // 덱을 사용하여 0-1 BFS 구현
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[] {N, 0});
        
        int answer = Integer.MAX_VALUE;
        
        while(!deque.isEmpty()) {
            int[] data = deque.pollFirst();
            int node = data[0];
            int time = data[1];
            
            // 이미 방문한 노드는 건너뛰기
            if(visited[node]) continue;
            
            // 방문 처리
            visited[node] = true;
            
            // 도착점에 도달한 경우
            if (node == K) {
                answer = Math.min(answer, time);
                break; // 최단 시간을 찾았으므로 종료
            }
            
            // 순간이동 (0초 소요) - 덱의 앞에 추가
            if (node*2 <= 100000 && !visited[node*2]) {
                deque.offerFirst(new int[] {node*2, time});
            }
            
            // 앞으로 걷기 (1초 소요) - 덱의 뒤에 추가
            if (node + 1 <= 100000 && !visited[node+1]) {
                deque.offerLast(new int[] {node+1, time+1});
            }
            
            // 뒤로 걷기 (1초 소요) - 덱의 뒤에 추가
            if (node - 1 >= 0 && !visited[node-1]) {
                deque.offerLast(new int[] {node-1, time+1});
            }
        }

        System.out.println(answer);
    }
}
