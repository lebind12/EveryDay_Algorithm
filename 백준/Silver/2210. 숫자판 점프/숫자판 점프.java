import java.util.*;
import java.io.*;


class Main
{
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception
	{
		class Node {
			int y;
			int x;
			String word;
			
			Node(int y, int x, String word) {
				this.y = y;
				this.x = x;
				this.word = word;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		
		sb = new StringBuilder();
		
		int[][] board = new int[5][5];
		Set<String> wordSack = new HashSet<>(); 
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Deque<Node> queue = new ArrayDeque();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Node node = new Node(i, j, String.valueOf(board[i][j]));
				queue.add(node);
				
				while (!queue.isEmpty()) {
//					System.out.println(queue.toString());
					Node pos = queue.poll();
					
					if (pos.word.length() >= 6) {
						wordSack.add(pos.word);
						continue;
					}
					for (int k = 0; k < 4; k++) {
						int nx = pos.x + dx[k];
						int ny = pos.y + dy[k];
						if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
							Node nPos = new Node(ny, nx, pos.word+String.valueOf(board[ny][nx]));
							queue.add(nPos);
						}
					}
				}
			}
		}
		
		System.out.println(wordSack.size());
	}
}