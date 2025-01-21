/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc < T+1; tc++) {
            int N = Integer.parseInt(bf.readLine());
            int[][] board = new int[N][];

            for (int i = 0; i < N; i++) {
                String[] line = bf.readLine().split(" ");
                board[i] = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            }

//            for(int[] line: board) System.out.println(Arrays.toString(line));
            int maximumCount = -1;
            for (int day = 0; day <= 100; day++) {
                int count = 0;
                Deque<int[]> queue = new ArrayDeque<>();
                boolean[][] visited = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    Arrays.fill(visited[i], false);
                }
                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < N; x++) {
                        // dfs, bfs
                        if (board[y][x] > day && !visited[y][x]) {
                            queue.push(new int[]{y, x});
                            visited[y][x] = true;

                            while(!queue.isEmpty()) {
                                int[] position = queue.poll();
                                visited[position[0]][position[1]] = true;

                                for (int k = 0; k < 4; k++) {
                                    int ny = position[0] + dy[k];
                                    int nx = position[1] + dx[k];

                                    if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                                        if (board[ny][nx] > day && !visited[ny][nx]) {
                                            queue.push(new int[]{ny, nx});
                                        }
                                    }
                                }
                            }
                            count++;
                        }
                    }
                }
                if (count == 0) break;
                maximumCount = Math.max(maximumCount, count);
            }
            sb.append("#").append(tc).append(" ").append(maximumCount).append("\n");
        }
        System.out.println(sb.toString());
        bf.close();
    }
}