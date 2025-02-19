import java.util.*;
import java.io.*;


class Main
{
	
	private static int checkPal(String word, int left, int right, int check) {
		if (check >= 2)
			return 2;
		
		
		while (left < right) {
			if (word.charAt(left) != word.charAt(right)) {
				return Math.min(checkPal(word, left+1, right, check+1),
						checkPal(word, left, right-1, check+1)); 
			} else {
				left++;
				right--;
			}
		}
		
		return check;
		
	}
	public static void main(String args[]) throws Exception
	{
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 회문 0, 유사 회문 1, 둘다 아니면 2
			// 회문이 아닌 걸 발견하면 좌측 혹은 우측에서 넘어갈 수 있는 걸 찾아야 한다.
			String word = br.readLine();
			int length = word.length();
			int status = checkPal(word, 0, length-1, 0);
			sb.append(status).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}