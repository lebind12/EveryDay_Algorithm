from collections import deque


dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
def solution(maps):
    answer = 1e9
    
    queue = deque()
    queue.append((0, 0, 1))
    w = len(maps[0])
    h = len(maps)
    
    visited = [[False] * w for _ in range(h)]
    visited[0][0] = True
    while queue:
        y, x, length = queue.popleft()
        if y == h-1 and x == w-1:
            answer = min(answer, length)
        
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if nx >= 0 and nx < w and ny >= 0 and ny < h:
                if not visited[ny][nx] and maps[ny][nx] == 1:
                    queue.append((ny, nx, length+1))
                    visited[ny][nx] = True
    if answer == 1e9:
        answer = -1
    return answer