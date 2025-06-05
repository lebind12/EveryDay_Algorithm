import java.util.*;
import java.io.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        
        // TreeSet: 난이도와 문제번호로 정렬
        TreeSet<int[]> problemList = new TreeSet<>((o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];  // 난이도 같으면 문제번호 내림차순
            else
                return o2[0] - o1[0];  // 난이도 내림차순
        });
        
        // HashMap: 문제번호 -> 배열 객체 매핑 (빠른 삭제용)
        Map<Integer, int[]> problemMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[] problem = new int[]{L, P};
            
            problemList.add(problem);
            problemMap.put(P, problem);  // 문제번호로 빠른 접근
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(problemList.first()[1]);
                } else if (x == -1) {
                    sb.append(problemList.last()[1]);
                }
                sb.append("\n");
                
            } else if (command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                int[] toRemove = problemMap.get(P);  // O(1) 시간에 찾기
                if (toRemove != null) {
                    problemList.remove(toRemove);     // O(log N) 시간에 삭제
                    problemMap.remove(P);             // HashMap에서도 제거
                }
                
            } else if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int[] problem = new int[]{L, P};
                
                problemList.add(problem);
                problemMap.put(P, problem);
            }
        }
        System.out.println(sb.toString());
    }
}
