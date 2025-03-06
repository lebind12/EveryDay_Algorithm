import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static char[][] board;
	static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			int click = 0;
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = input.charAt(j);
				}
			}
			
			// 1. i, j 탐색으로 상하좌우 지뢰가 없는 곳을 클릭,
			// 1. 0이 나올 구역을 한번에 처리한다.
			// 2. 나머지 칸의 개수를 구한다. -> 어짜피 한번한번 클릭해야하니까.
			
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && board[i][j] == '.' && check(i, j)) {
						ArrayDeque<int[]> queue = new ArrayDeque<>();
						queue.offer(new int[] {i, j});
						visited[i][j] = true;
						
						while (!queue.isEmpty()) {
							int[] pos = queue.poll();
							int y = pos[0];
							int x = pos[1];
							
							for (int k = 0; k < 8; k++) {
								int ny = y + dy[k];
								int nx = x + dx[k];
								if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
									if (!visited[ny][nx]) {
										if (check(ny, nx)) {
											queue.offer(new int[] {ny, nx});											
										}
										visited[ny][nx] = true;	
									}
								}
							}
						}
						
						click++;
					}
				}
			}
			
//			System.out.println(click);
//			for (boolean[] line: visited) System.out.println(Arrays.toString(line));
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && board[i][j] == '.')
						click++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(click).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static boolean check(int y, int x) {
		for (int k = 0; k < 8; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			
			if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				if (board[ny][nx] == '*')
					return false;
			}
		}
		
		return true;
	}
}
