import java.util.*;
import java.io.*;

class Solution {
	
	static int answer;
	static int[] numbers;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			numbers = new int[N+1];
			for (int i = 0; i < N; i++) {
				numbers[i] = i;
			}
			boolean[] burger = new boolean[N];
			boolean[][] dont = new boolean[N][N];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				dont[first-1][second-1] = true;
				dont[second-1][first-1] = true;
			}
			
			subSet(0, N, burger, dont);
			
			sb.append(String.format("#%d %d\n", tc, answer));
		}
		System.out.print(sb.toString());
	}
	static void subSet(int cnt, int N, boolean[] burger, boolean[][] dont) {
		if (cnt == N) {
			answer++;
			return;
		}
		boolean check = false;
		for (int i = 0; i < N; i++) {
			if (dont[cnt][i] && burger[i]) {
				check = true;
				break;
			}
		}
		if (!check) {
			burger[cnt] = true;
			subSet(cnt+1, N, burger, dont);
			burger[cnt] = false;
		}
		subSet(cnt+1, N, burger, dont);
	}
}