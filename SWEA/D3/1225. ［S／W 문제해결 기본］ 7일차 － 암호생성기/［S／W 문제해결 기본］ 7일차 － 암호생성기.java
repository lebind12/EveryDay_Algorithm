import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int test_case = Integer.parseInt(br.readLine());
			int[] numbers = new int[8];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			// 8사이클 -> 원래자리, -15.
			int minimum = Arrays.stream(numbers).min().getAsInt();
			Deque<Integer> queue = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				numbers[i] = numbers[i] - ((minimum / 15 - 1) * 15) ; 
				queue.addLast(numbers[i]);
			}
			int d = 1;
			while (true) {
				int n = queue.pollFirst();
				n = Math.max(n-d, 0);
				queue.addLast(n);
				if (n == 0)
					break;
				d = (d + 1) % 6;
				if (d == 0)
					d++;
			}
			
			for (int i = 0; i < 8; i++) {
				numbers[i] = queue.pollFirst();
			}
			
			sb.append(String.format("#%d ", test_case));
			for (int i = 0; i < 8; i++) {
				if (i != 7)
					sb.append(numbers[i]).append(" ");
				else
					sb.append(numbers[i]);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}