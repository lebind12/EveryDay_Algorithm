from collections import deque



dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
n, m = map(int, input().split(' '))
board = []
count = 0
largest = 0

for _ in range(n):
    board.append(list(map(int, input().split(' '))))

visited = [[False] * m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if board[i][j] == 1 and visited[i][j] == False:
            queue = deque()
            queue.append((i, j))
            visited[i][j] = True
            count += 1
            amount = 0
            while queue:
                y, x = queue.popleft()
                amount += 1
                
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]
                    if nx >= 0 and nx < m and ny >= 0 and ny < n and visited[ny][nx] == False:
                        if board[ny][nx] == 1:
                            queue.append((ny, nx))
                            visited[ny][nx] = True
                        
            largest = max(amount, largest)
            
print(count)
print(largest)