import sys
from collections import deque


dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
input = sys.stdin.readline
T = int(input())
for _ in range(T):
    H, W = map(int, input().split(' '))
    board = []
    for _ in range(H):
        board.append(list(input().rstrip()))
    
    amount = 0
    queue = deque()
    visited = [[False] * W for _ in range(H)]
    
    for i in range(H):
        for j in range(W):
            if not visited[i][j] and board[i][j] == '#':
                queue.append((i, j))
                visited[i][j] = True

                while len(queue) > 0:
                    y, x = queue.popleft()
                    
                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        
                        if ny >= 0 and ny < H and nx >= 0 and nx < W:
                            if not visited[ny][nx] and board[ny][nx] == '#':
                                queue.append((ny, nx))
                                visited[ny][nx] = True
                amount += 1
    print(amount)