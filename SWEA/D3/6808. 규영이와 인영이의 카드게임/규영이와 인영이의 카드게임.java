import java.util.*;
import java.io.*;


class Solution
{
	static int inWins = 0;
	static int gyuWins = 0;
	
	private static void perm(int cnt,
			int[] inCards, int[] gyuCards,
			int[] deck, boolean[] visited) {
		if (cnt >= 9) {
			// 대결
			int inScore = 0;
			int gyuScore = 0;
			
			for (int i = 0; i < 9; i++) {
				if (deck[i] > gyuCards[i]) {
					inScore += (gyuCards[i] + deck[i]);
				} else if (deck[i] < gyuCards[i]) {
					gyuScore += (gyuCards[i] + deck[i]);
				}
			}
			if (inScore > gyuScore)
				inWins++;
			else if (inScore < gyuScore)
				gyuWins++;
			return;
			
		} else {
			for (int i = 0; i < 9; i++) {
				if (visited[i]) continue;
				visited[i] = true;
				deck[cnt] = inCards[i];
				perm(cnt+1, inCards, gyuCards, deck, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		// System.setIn(new FileInputStream("src/s_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int[] gyuCards = new int[9];
			int[] inCards = new int[9];
			int index = 0;
			inWins = 0;
			gyuWins = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyuCards[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i < 19; i++) {
				boolean isContain = false;
				for (int j = 0; j < 9; j++) {
					if (gyuCards[j] == i) {
						isContain = true;
						break;
					}
				}
				
				if (!isContain) {
					inCards[index] = i;
					index++;
				}
			}
			
			perm(0, inCards, gyuCards, new int[9], new boolean[9]);
			
			sb.append("#").append(tc).append(" ").append(gyuWins)
			.append(" ").append(inWins).append("\n");
		}
		System.out.println(sb.toString());
	}
}