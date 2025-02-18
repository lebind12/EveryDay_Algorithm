import java.util.*;
import java.io.*;


class Main
{
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		
		int[] d = null;
		String input;
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = input.charAt(j);
				if (board[i][j] == 'I') d = new int[]{i, j};
			}
		}
		
//		for (char[] line: board) System.out.println(Arrays.toString(line));
		
		Deque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {d[0], d[1]});
		
		boolean[][] visited = new boolean[N][M];
		visited[d[0]][d[1]] = true;
		int answer = 0;
		while (!queue.isEmpty()) {
////			for (boolean[] line: visited) System.out.println(Arrays.toString(line));
//			System.out.println();
			int[] pos = queue.poll();
			int y = pos[0];
			int x = pos[1];
			
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if (!visited[ny][nx]) {
						if (board[ny][nx] == 'O') {
							queue.add(new int[] {ny, nx});
							visited[ny][nx] = true;
						} else if (board[ny][nx] == 'P') {
							answer++;
							visited[ny][nx] = true;
							queue.add(new int[] {ny, nx});
						}
					}
				}
			}
		}
		
		if (answer == 0)
			System.out.println("TT");
		else
			System.out.println(answer);
	}
}