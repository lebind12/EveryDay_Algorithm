import sys
from collections import deque


input = sys.stdin.readline
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

N = int(input())
board = []
for _ in range(N):
    board.append(list(input().rstrip()))
visited = [[False] * N for _ in range(N)]
normal_count = 0
for i in range(N):
    for j in range(N):
        # 아직 방문하지 않은 지역이면
        if not visited[i][j]:
            # 큐 선언
            queue = deque()
            queue.append((i, j, board[i][j]))
            visited[i][j] = True
            while queue:
                y, x, color= queue.popleft()
                for k in range(4):
                    ny = y + dy[k]
                    nx = x + dx[k]
                    if nx >= 0 and nx < N and ny >= 0 and ny < N:
                        if not visited[ny][nx] and color == board[ny][nx]:
                            visited[ny][nx] = True
                            queue.append((ny, nx, color))
            normal_count += 1

visited = [[False] * N for _ in range(N)]
rg_count = 0
for i in range(N):
    for j in range(N):
        # 아직 방문하지 않은 지역이면
        if not visited[i][j]:
            # 큐 선언
            queue = deque()
            queue.append((i, j, board[i][j]))
            visited[i][j] = True
            while queue:
                y, x, color= queue.popleft()
                for k in range(4):
                    ny = y + dy[k]
                    nx = x + dx[k]
                    if nx >= 0 and nx < N and ny >= 0 and ny < N:
                        if not visited[ny][nx]:
                            if color == board[ny][nx]:
                                visited[ny][nx] = True
                                queue.append((ny, nx, color))
                            elif color in ['R', 'G'] and board[ny][nx] in ['R', 'G']:
                                visited[ny][nx] = True
                                queue.append((ny, nx, color))
            rg_count += 1
print(normal_count, rg_count)