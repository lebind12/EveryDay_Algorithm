import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    // 0번부터 7번까지의 방향 델타 값.
    static int N;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1 ,-1};
    static ArrayList<FireBall>[][] board;
    static class FireBall {
        int r, c, m, d, s;
        FireBall() {}
        FireBall(int r, int c, int m, int s, int d) {
            this.r = r; this.c = c; this.m = m; this.d = d; this.s = s;
        }
        @Override
        public String toString() {
            return String.format("%d", m);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            FireBall f = new FireBall(
                r, c,
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
            board[r][c].add(f);
        }

        for (int i = 0; i < K; i++) {
            move();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < board[i][j].size(); k++) {
                    answer += board[i][j].get(k).m;
                }
            }
        }
        System.out.println(answer);
    }
    static void move() {
        // 각 좌표 별 파이어볼을 각각 d와 s만큼 이동시킨다
        // 0행과 N-1행, 0열과 N-1열은 연결되어있음
        ArrayList<FireBall>[][] newBoard = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newBoard[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < board[i][j].size(); k++) {
                    FireBall f = board[i][j].get(k);
                    int nr = f.r + dr[f.d] * f.s;
                    int nc = f.c + dc[f.d] * f.s;

                    if (nr >= N)
                        nr = nr % N;
                    else if (nr < 0) {
                        while (nr < 0)
                            nr = nr + N;
                    }
                    if (nc >= N)
                        nc = nc % N;
                    else if (nc < 0) {
                        while (nc < 0)
                            nc = nc + N;
                    }
                    
                    FireBall newFireBall = new FireBall(nr, nc, f.m, f.s, f.d);
                    newBoard[nr][nc].add(newFireBall);
                }
            }
        }

        // 이동이 끝난 뒤 2개 이상의 파이어볼 합쳐 나누기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (newBoard[i][j].size() > 1) {
                    int m = 0;
                    int s = 0;
                    int[] d = new int[newBoard[i][j].size()];
                    for (int k = 0; k < newBoard[i][j].size(); k++) {
                        FireBall f = newBoard[i][j].get(k);
                        m += f.m;
                        s += f.s;
                        d[k] = f.d;
                    }
                    m /= 5;
                    s /= newBoard[i][j].size();
                    boolean check = true; // true - 모두 일치
                    for (int k = 1; k < newBoard[i][j].size(); k++) {
                        if (d[k-1] % 2 != d[k] % 2) {
                            check = false;
                            break;
                        }
                    }
                    newBoard[i][j].clear();

                    if (m > 0) {
                        for (int k = 0; k < 4; k++) {
                            int nd = 2 * k;
                            if (!check)
                                nd++;
                            FireBall nf = new FireBall(
                                i, j, m, s, nd
                            );
                            newBoard[i][j].add(nf);
                        }
                    }
                }
            }
        }
        // 새로 완성된 보드를 연결
        board = newBoard;
    }
}
