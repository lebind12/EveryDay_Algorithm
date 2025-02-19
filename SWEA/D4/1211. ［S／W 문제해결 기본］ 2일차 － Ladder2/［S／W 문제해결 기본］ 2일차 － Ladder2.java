import java.util.*;
import java.io.*;

class Solution {
	static int[] dy = { 0, 1, 0 };
	static int[] dx = { -1, 0, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		class Node {
			int y;
			int x;
			int count;

			Node(int y, int x, int count) {
				this.y = y;
				this.x = x;
				this.count = count;
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return String.format("[%d %d %d]", y, x, count);
			}
		}

		for (int tc = 0; tc < 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] board = new int[100][100];
			int answer = -1;
			int minimum = 9999999;

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int start = 0; start < 100; start++) {
				if (board[0][start] == 1) {
					Node sPos = new Node(0, start, 0);

					Deque<Node> queue = new ArrayDeque<>();
					boolean[][] visited = new boolean[100][100];

					queue.add(sPos);
					boolean found = false;

					while (!queue.isEmpty()) {
						Node pos = queue.poll();
						int y = pos.y;
						int x = pos.x;
						int count = pos.count;

						int ly = y + dy[0];
						int lx = x + dx[0];
						int ry = y + dy[2];
						int rx = x + dx[2];
						int by = y + dy[1];
						int bx = x + dx[1];

						// 왼쪽이 있는가? -> 오른쪽이 있는가 -> 아래가 있는가?
						if (ly >= 0 && ly < 100 && lx >= 0 && lx < 100 && !visited[ly][lx] && board[ly][lx] != 0) {
							queue.add(new Node(ly, lx, count + 1));
							visited[ly][lx] = true;
						} else if (ry >= 0 && ry < 100 && rx >= 0 && rx < 100 && !visited[ry][rx]
								&& board[ry][rx] != 0) {
							queue.add(new Node(ry, rx, count + 1));
							visited[ry][rx] = true;
						} else if (by >= 0 && by < 100 && bx >= 0 && bx < 100 && !visited[by][bx]
								&& board[by][bx] != 0) {
							if (by == 99) {
								found = true;
								if (minimum > count+1) {
									minimum = count+1;
									answer = start;
								} else if (minimum == count+1) {
									answer = Math.max(start, answer);
								}
								break;
							}else {
								queue.add(new Node(by, bx, count + 1));
								visited[by][bx] = true;
							}
						}
					}
				}
			}

			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}