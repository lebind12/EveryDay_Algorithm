import java.util.*;
import java.io.*;


class Main
{
	static boolean[] primes = new boolean[1_000_001];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;

		primes[2] = true;
		
		for (int i = 3; i < 1_000_001; i++) {
			primes[i] = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (primes[j] && i % j == 0) {
					primes[i] = false;
					break;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			int number = Integer.parseInt(br.readLine());
			int count = 0;
			for (int i = 2; i <= number/2; i++) {
				if (primes[i] && primes[number-i])
					count++;
			}
			
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}