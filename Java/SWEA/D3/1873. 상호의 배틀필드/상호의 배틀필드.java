import java.io.*;
import java.util.*;

public class Solution {
    // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] board = new char[H][W];
            int[] current = {};
            
            for (int i = 0; i < H; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < W; j++) {
                    board[i][j] = line.charAt(j);
                    if (board[i][j] == '>') {
                        current = new int[] {i, j, 3};
                    } else if (board[i][j] == '^') {
                        current = new int[] {i, j, 0};
                    } else if (board[i][j] == 'v') {
                        current = new int[] {i, j, 1};
                    } else if (board[i][j] == '<'){
                        current = new int[] {i, j, 2};
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            String commands = br.readLine().trim();

            for (int i = 0; i < N; i++) {
                char c = commands.charAt(i);
                int y = current[0];
                int x = current[1];
                int d = current[2];
                int ny;
                int nx;
                
                switch (c) {
                    case 'U':
                    //Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
                    ny = y + dy[0];
                    nx = x + dx[0];

                    if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
                        if (board[ny][nx] == '.')
                        {
                            current = new int[] {ny, nx, 0};
                            board[ny][nx] = '^';
                            board[y][x] = '.';
                        } else {
                            current = new int[] {y, x, 0};
                            board[y][x] = '^';
                        }
                    } else {
                        current = new int[] {y, x, 0};
                        board[y][x] = '^';
                    }
                    break;
                    case 'D':
                    //Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
                    ny = y + dy[1];
                    nx = x + dx[1];

                    if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
                        if (board[ny][nx] == '.') {
                            current = new int[] {ny, nx, 1};
                            board[ny][nx] = 'v';
                            board[y][x] = '.';
                        } else {
                            current = new int[] {y, x, 1};
                            board[y][x] = 'v';
                        }
                    } else {
                        current = new int[] {y, x, 1};
                        board[y][x] = 'v';
                    }
                    break;
                    case 'L':
                    //Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
                    ny = y + dy[2];
                    nx = x + dx[2];

                    if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
                        if (board[ny][nx] == '.') {
                            current = new int[] {ny, nx, 2};
                            board[ny][nx] = '<';
                            board[y][x] = '.';
                        } else {
                            current = new int[] {y, x, 2};
                            board[y][x] = '<';
                        }
                    } else {
                        current = new int[] {y, x, 2};
                        board[y][x] = '<';
                    }
                    break;
                    case 'R':
                    //Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
                    ny = y + dy[3];
                    nx = x + dx[3];

                    if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
                        if (board[ny][nx] == '.') {
                            current = new int[] {ny, nx, 3};
                            board[ny][nx] = '>';
                            board[y][x] = '.';
                        } else {
                            current = new int[] {y, x, 3};
                            board[y][x] = '>';
                        }
                    } else {
                        current = new int[] {y, x, 3};
                        board[y][x] = '>';
                    }
                    break;
                    case 'S':
                    //Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
                    int by = y + dy[d];
                    int bx = x + dx[d];

                    while (by >= 0 && by < H && bx >= 0 && bx < W) {
                        if (board[by][bx] == '*'){
                            board[by][bx] = '.';
                            break;
                        } else if (board[by][bx] == '#') {
                            break;
                        } else {
                            by += dy[d];
                            bx += dx[d];
                        }
                    }
                    break;
                }
            }
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}