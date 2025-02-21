import java.io.*;
import java.util.*;


public class Main {
	static int N, M;
	static int[] a, b;
	
	static void perm(int cnt, int start) {
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				if (i != M-1)
					sb.append(b[i]).append(" ");
				else
					sb.append(b[i]);
			}
			System.out.println(sb.toString());
			return;
		}
		for (int i = start; i < N; i++) {
			b[cnt] = a[i];
			perm(cnt+1, i+1);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		a = new int[N];
		for (int i = 0; i < N; i++) a[i] = i+1;
		b = new int[M];
		perm(0, 0);
	}
}
