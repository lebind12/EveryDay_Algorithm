import java.io.*;
import java.util.*;

class Main {
	static int[][] board;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int N, L, R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		while (true) {
			if (merge())
				answer++;
			else
				break;
		}
		System.out.println(answer);
	}

	static boolean merge() {
		boolean check = false;

		boolean[][] visited = new boolean[N][N];
		ArrayDeque<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;

				int count = 0;
				int total = 0;
				ArrayList<int[]> changeQueue = new ArrayList<>();
				queue.offer(new int[] { i, j });
				changeQueue.add(new int[] { i, j });
				total += board[i][j];
				visited[i][j]=true;
				while (!queue.isEmpty()) {
					int[] pos = queue.poll();

					int y = pos[0];
					int x = pos[1];

					for (int k = 0; k < 4; k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];

						if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
							if (!visited[ny][nx]) {
								int abs = Math.abs(board[y][x] - board[ny][nx]);
								if ((abs >= L && abs <= R)) {
									check = true;
									queue.offer(new int[] { ny, nx });
									changeQueue.add(new int[] { ny, nx });
									total+=board[ny][nx];
									visited[ny][nx] = true;
								}

							}
						}
					}
				}


				if (changeQueue.size() > 1) {
					for (int[] pos : changeQueue) {
//						System.out.print(Arrays.toString(pos));
						board[pos[0]][pos[1]] = total / changeQueue.size();
					}
//					System.out.println();
				}
//				for(int[] line: board) System.out.println(Arrays.toString(line));
//				System.out.println();
			}
		}
		return check;
	}
}
