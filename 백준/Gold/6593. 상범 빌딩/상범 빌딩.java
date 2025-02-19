import java.util.*;
import java.io.*;


class Main
{
	static int[] dy = {-1, 1, 0, 0, 0, 0};
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static int[] ds = {0, 0, 0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;

		class Node {
			int s;
			int y;
			int x;
			int count;
			
			Node(int s, int y, int x, int count) {
				this.s = s;
				this.y = y;
				this.x = x;
				this.count = count;
			}
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return String.format("[%d %d %d]", s, y, x);
			}
		}
		
		sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			if (L == 0 && R == 0 && C == 0)
				break;
			
			Node start = null;
			
			char[][][] board = new char[L][R][C];
			String input;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					input = br.readLine();
					for (int k = 0; k < C; k++) {
						board[i][j][k] = input.charAt(k);
						if (board[i][j][k] == 'S')
							start = new Node(i,j,k,0);
					}
				}
				br.readLine();
			}
			
			boolean[][][] visited = new boolean[L][R][C];
			
			Deque<Node> queue = new ArrayDeque<>();
			queue.add(start);
			visited[start.s][start.y][start.x] = true;
			
			int answer = 9999999;
			
			while (!queue.isEmpty()) {
				Node cur = queue.poll();
				
				int s = cur.s;
				int y = cur.y;
				int x = cur.x;
				int count = cur.count;
				
				if (board[s][y][x] == 'E') {
					answer = Math.min(answer, cur.count);
				}
				
				for (int k = 0; k < 6; k++) {
					int ns = s + ds[k];
					int ny = y + dy[k];
					int nx = x + dx[k];
					
					if (ns >= 0 && ns < L && ny >= 0 && ny < R && nx >= 0 && nx < C) {
						if (!visited[ns][ny][nx] && board[ns][ny][nx] != '#') {
							Node nPos = new Node(ns, ny, nx, count+1);
							visited[ns][ny][nx] = true;
							queue.add(nPos);
						}
					}
				}
			}
//			for (boolean[][] b: visited) {
//				for (boolean[] l: b) {
//					sb.append(Arrays.toString(l)).append("\n");
//				}
//				sb.append("\n");
//			}
			
			if (answer == 9999999)
				sb.append("Trapped!").append("\n");
			else
				sb.append(String.format("Escaped in %d minute(s).", answer)).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}