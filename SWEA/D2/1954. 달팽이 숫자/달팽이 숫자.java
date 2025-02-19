import java.util.*;
import java.io.*;


class Solution
{
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int direction = 0;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		class Node {
			int x;
			int y;
			
			Node(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			sb.append("#").append(tc).append(" ").append("\n");
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			int num = 1;
			
			Deque<Node> queue = new ArrayDeque<>();
			Node start = new Node(0, 0);
			queue.add(start);
			
			if (N == 1) {
				sb.append(1).append("\n");
				continue;
			}
			else if (N==2) {
				sb.append("1 2").append("\n");
				sb.append("4 3").append("\n");
				continue;
			}
			
			while (!queue.isEmpty()) {
				Node pos = queue.poll();
				int y = pos.y;
				int x = pos.x;
				
				board[pos.y][pos.x] = num;
				num++;
				
				int ny = y + dy[direction];
				int nx = x + dx[direction];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
					direction = (direction + 1) % 4;
					num--;
					queue.add(new Node(y, x));
				} else if (board[ny][nx] != 0) {
					int check = -1;
					
					for (int i = 0; i < 4; i++) {
						int cy = y + dy[i];
						int cx = x + dx[i];
						
						if (cx >= 0 && cx < N && cy >= 0 && cx < N) {
							if (board[cy][cx] == 0) {
								check = i;
								break;
							}
						}
					}
					
					if (check != -1) {
						direction = check;
						num--;
						queue.add(new Node(y, x));
					}
				} else {
					queue.add(new Node(ny, nx));
				}
			}
			
			
			for(int[] line: board) {
				for (int i = 0; i < line.length; i++) {
					if (i < line.length - 1)
						sb.append(line[i]).append(" ");
					else sb.append(line[i]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}