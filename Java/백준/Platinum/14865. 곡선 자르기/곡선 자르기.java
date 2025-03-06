import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] inputX = new int[1_000_000];
        int[] inputY = new int[1_000_000];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            inputX[i] = Integer.parseInt(st.nextToken());
            inputY[i] = Integer.parseInt(st.nextToken());
        }

        // 아래서 위로 올라가는 시작점 찾기.
        int startIdx = 0;
        while (true) {
            int y1 = inputY[startIdx];
            int y2 = inputY[(startIdx + 1) % N];
            if (y1 < 0 && y2 > 0)
                break;
            startIdx = (startIdx + 1) % N;
        }
        int[] h = new int[2];
        int k = 0;
        List<Integer[]> xPositions = new ArrayList<>();

        for (int i = startIdx; i < startIdx + N; i++) {
            int x1 = inputX[i % N];
            int x2 = inputX[(i + 1) % N];
            int y1 = inputY[i % N];
            int y2 = inputY[(i + 1) % N];

            if ((y1 > 0 && y2 < 0) || (y1 < 0 && y2 > 0)) {
                h[k++] = x1;
                if (k == 2) {
                    xPositions.add(
                            new Integer[] { Math.min(h[0], h[1]), Math.max(h[0], h[1]) });
                    k = 0;
                }
            }
        }
        Collections.sort(xPositions, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        // for (Integer[] hill : xPositions)
        // System.out.println(
        // Arrays.toString(hill));
        int answer = 0;
        int right = 0;
        // 포함되지 않는 봉우리 개수
        for (int i = 0; i < xPositions.size(); i++) {
            Integer[] xPos = xPositions.get(i);
            if (i == 0) {
                right = xPos[1];
                answer++;
                continue;
            }
            // 시작점보다 이전 오른쪽 점이 더 작을 때
            if (right < xPos[0]) {
                right = xPos[1];
                answer++;
            } else { // 시작점이 이전 오른쪽 점보다 작을 때.
                // 그럼 이 봉우리는 포함되므로 더하지 않음.
                continue;
            }

        }
        int answer2 = 0;
        // 포함하지 않는 봉우리 개수
        for (int i = 0; i < xPositions.size(); i++) {
            Integer[] xPos = xPositions.get(i);
            if (i == 0) {
                right = xPos[1];
                answer2++;
                continue;
            }
            if (right < xPos[0]) {
                // 새로운 시작점이 이전 오른쪽 점보다 더 크다는 것은
                // 이전 봉우리가 포함하지 않는다는 뜻.
                right = xPos[1];
                answer2++;
            } else {
                // 새로운 시작점이 이전 오른쪽 점보다 작다는 것은
                // 이전 봉우리가 새로운 봉우리를 포함하고 있다는 뜻.
                // 그럼 더 안쪽 봉우리를 검사해야함. 개수는 그대로
                right = xPos[1];
            }
        }
        System.out.println(answer + " " + answer2);
    }

}
