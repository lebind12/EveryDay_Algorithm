import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int beforeX = 0;
		int beforeY = 0;
		List<Integer[]> xPositions = new ArrayList<>();
		boolean check = false; // 이전에 x축을 넘은 지점이 있는 경우 true

        // x값이 최저점일때의 y점의 최저점
        List<int[]> inputValue = new ArrayList<>();

        int minimumX = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
            inputValue.add(new int[]{x, y});
            minimumX = Math.min(minimumX, x);
        }

        int startIdx = -1;
        int minimumY = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int[] point = inputValue.get(i);
            int x = point[0];
            int y = point[1];
            if (x == minimumX) {
                if (minimumY > y) {
                    minimumY = y;
                    startIdx = i;
                }
            }
        }
 
		for (int i = 0; i < N; i++) {
            int idx = (startIdx + i) % N ;
            int x = inputValue.get(idx)[0];
            int y = inputValue.get(idx)[1];
			if (i == 0) {
				beforeY = y;
				continue;
			}
			
			// x축 교차
			if ((beforeY<0 &&y > 0) || (beforeY>0 && y < 0)) {
				if (!check) {
					check = true;
					beforeX = x;
				}
				else {
					Integer[] xPostion = {Math.min(beforeX, x), Math.max(beforeX, x)};
					xPositions.add(xPostion);
					check = false;
				}
			}
		}
		
		Collections.sort(xPositions, (o1, o2) -> {
			return o1[0] - o2[0];
		});

        // stack을 활용한다
        // 1. 스택이 비어있으면 담는다.
        // 2. 스택의 top과 현재 봉우리를 비교한다.
        // 3. top의 right보다 현재 봉우리의 left가 더 크다 -> 봉우리가 바깥쪽에 있다.
        // 3. top의 right보다 현재 봉우리의 left가 더 작다 -> 봉우리가 top 안쪽에 있다.
        // 3. 봉우리가 바깥쪽에 있으면 top은 다른 봉우리를 포함하지 않는다.
        // 3. 봉우리가 안쪽에 있으면 top이 다른 봉우리를 포함하고 있다.
        // 3. 포함되지 않는 봉우리, 즉 제일 바깥쪽에 있는 봉우리는 스택이 비워질 때 마다 증가한다.
        // 3. 포함하지 않는 봉우리, 즉 제일 안쪽에 있는 봉우리는 top과 비교하여 스택에서 top이 나갈때마다 증가한다.
        // 4. 3번을 반복하여 stack을 계속해서 비운다.
        ArrayDeque<Integer[]> stack = new ArrayDeque<>();

        int outerCount = 0;
        int innerCount = 0;
        for (int i = 0; i < xPositions.size(); i++) {
            // System.out.println(stack);
            // System.out.println(outerCount + " " + innerCount);
            Integer[] hill = xPositions.get(i);
            
            if (stack.isEmpty()) {
                stack.push(hill);
                continue;
            }
            
            Integer[] before = stack.peek();
            int beforeRight = before[1];
            int currLeft = hill[0];

            if (beforeRight < currLeft) {
                // 현재 봉우리를 포함하고 있는 제일 바깥쪽만 남기고 다 pop
                while (!stack.isEmpty()) {
                    if (stack.peek()[1] < currLeft)
                        stack.pop();
                    else
                        break;
                }
                // 스택이 비워졌는가? -> 제일 바깥쪽이 나간거
                if (stack.isEmpty()) {
                    outerCount++;
                }
                // pop해도 남았는가? -> 제일 안쪽이 나간거
                innerCount++;
                stack.push(hill);
            }
            // 이전 오른쪽보다 현재 왼쪽이 작다면 이전 봉우리가 현재 봉우리를 포함하고있음.
            else {
                stack.push(hill);
            }
        }
        // System.out.println(stack);

        outerCount++;
        innerCount++;

        sb.append(outerCount).append(" ").append(innerCount);
		System.out.println(sb.toString());
	}

}
