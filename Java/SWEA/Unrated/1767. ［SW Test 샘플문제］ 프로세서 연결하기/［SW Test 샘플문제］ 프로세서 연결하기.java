import java.util.*;
import java.io.*;

public class Solution {
	static int N, answer, maxConnect, size;
	static int[][] board;
	// 상 하 좌 우
	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};
	
	static int[] coreX;
	static int[] coreY;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = 99999999;
			maxConnect = -1;
			N = Integer.parseInt(br.readLine());
			size = 0;
			coreX = new int[12];
			coreY = new int[12];
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1) {
						coreY[size] = i;
						coreX[size] = j;
						size++;
					}
				}
			}
			
			backTracking(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb.toString());
	}
	static void backTracking(int start, int coreCount, int total) {
		if (start == size) {
			if (maxConnect < coreCount) {
				answer = total;
				maxConnect = coreCount;
			}
			else if (maxConnect == coreCount){
				answer = Math.min(answer, total);
			}			
			return;
		}
		int[] curCore = new int[] {coreY[start], coreX[start]};
		if (curCore[0] == 0 || curCore[0] == N-1 || curCore[1] == 0 || curCore[1] == N-1) {
			backTracking(start+1, coreCount+1, total);
		} else {				
			for (int d = 0; d < 4; d++) {
				int length = connect(curCore, d);
				if (check(curCore, d)) {
					backTracking(start+1, coreCount+1, total + length);
				}
				disconnect(curCore, d);
			}
		}
		backTracking(start+1, coreCount, total);
	}
	
	static int connect(int[] core, int d) {
		int y = core[0] + dy[d];
		int x = core[1] + dx[d];
		
		int count = 0;
		while (y >= 0 && y < N && x >= 0 && x < N) {
			board[y][x]++;
			y += dy[d];
			x += dx[d];
			count++;
		}
		return count;
	}
	
	static boolean check(int[] core, int d) {
		int y = core[0] + dy[d];
		int x = core[1] + dx[d];
		
		while (y >= 0 && y < N && x >= 0 && x < N) {
			if (board[y][x] > 1)
				return false;
			y += dy[d];
			x += dx[d];
		}
		return true;
	}
	
	static void disconnect(int[] core, int d) {
		int y = core[0] + dy[d];
		int x = core[1] + dx[d];
		
		while (y >= 0 && y < N && x >= 0 && x < N) {
			board[y][x]--;
			y += dy[d];
			x += dx[d];
		}
	}
}
