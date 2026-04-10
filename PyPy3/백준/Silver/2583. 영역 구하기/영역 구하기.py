from collections import deque

M, N, K = map(int, input().split(' '))
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]


board = [[0] * N for _ in range(M)]
for _ in range(K):
    # 왼쪽 아래, 오른쪽 위
    x1, y1, x2, y2 = map(int, input().split(' '))
    
    for i in range(y1, y2):
        for j in range(x1, x2):
            board[i][j] = 1
            

visited = [[False] * N for _ in range(M)]
answer = []
for i in range(M):
    for j in range(N):
        if visited[i][j]:
            continue
        
        if board[i][j] == 1:
            continue
        
        queue = deque()
        queue.append((i, j))
        visited[i][j] = True
        amount = 0
        
        while queue:
            y, x = queue.popleft()
            amount += 1
            
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                
                if ny >= 0 and ny < M and nx >= 0 and nx < N:
                    if not visited[ny][nx] and board[ny][nx] == 0:
                        queue.append((ny, nx))
                        visited[ny][nx] = True
                        

        answer.append(amount)
print(len(answer))
print(" ".join(list(map(str, sorted(answer)))))