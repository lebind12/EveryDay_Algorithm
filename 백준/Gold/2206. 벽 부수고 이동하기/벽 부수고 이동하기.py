import sys
from pprint import pprint
from collections import deque

input = sys.stdin.readline
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

N, M = map(int, input().split(' '))
board = []
for _ in range(N):
    board.append(list(map(int, list(input().rstrip()))))

shortest = []
for _ in range(N):
    line = []
    for _ in range(M):
        line.append([1_000_000, 1_000_000])
    shortest.append(line)

queue = deque()
queue.append((0, 0, 1, 1)) # 0, 0 에서 1칸 먹었음. 아직 안부쉈음
shortest[0][0][1] = 1
# visited = [[[False, False] for _ in range(M)] for _ in range(N)]
# visited[0][0][1] = True

while queue:
    y, x, l, h = queue.popleft()
    
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        
        if (ny >= 0 and ny < N and nx >= 0 and nx < M):
            if board[ny][nx] == 0:
                if shortest[ny][nx][h] > l+1:
                    queue.append((ny, nx, l+1, h))
                    shortest[ny][nx][h] = l+1
            else:
                if h > 0:
                    if shortest[ny][nx][h-1] > l+1:
                        queue.append((ny, nx, l+1, h-1))
                        shortest[ny][nx][h-1] = l+1

# print(shortest)
minimum = min(shortest[N-1][M-1])
if minimum == 1_000_000:
    print(-1)
else:
    print(minimum)