import sys
from collections import deque


dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

input = sys.stdin.readline
N, M = map(int, input().split(' '))
board = []
for _ in range(M):
    board.append(list(input().rstrip()))
    
ally = 0
enemy = 0
visited = [[False] * N for _ in range(M)]

for i in range(M):
    for j in range(N):
        queue = deque()
        
        if visited[i][j]:
            continue
        
        is_ally = True
        
        if board[i][j] == 'W':
            is_ally = True
        else:
            is_ally = False
        
        visited[i][j] = True
        queue.append((i, j))
        
        amount = 0
        while queue:
            y, x = queue.popleft()
            amount += 1
            
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                
                if ny >= 0 and ny < M and nx >= 0 and nx < N:
                    if not visited[ny][nx]:
                        if is_ally and board[ny][nx] == 'W':
                            visited[ny][nx] = True
                            queue.append((ny, nx))
                        elif not is_ally and board[ny][nx] == 'B':
                            visited[ny][nx] = True
                            queue.append((ny, nx))
        
        if is_ally:
            ally += (amount ** 2)
        else:
            enemy += (amount ** 2)
            
print(ally, enemy)