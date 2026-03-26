import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
board = []
for _ in range(n):
    board.append(list(map(int, input().split(' '))))

queue = deque()
visited = [[False] * n for _ in range(n)]
queue.append((0, 0))
visited[0][0] = True
answer = False

ky = [0, 0, 1, -1]
kx = [1, -1, 0, 0]

while queue:
    y, x = map(int, queue.popleft())
    value = board[y][x]
    
    if y == n-1 and x == n-1:
        answer = True
        break
    
    for k in range(4):
        ny = y + (value * ky[k]) 
        nx = x + (value * kx[k])

        if ny >= 0 and ny < n and nx >= 0 and nx < n and not visited[ny][nx]:
            visited[ny][nx] = True
            queue.append((ny, nx))
    
if answer:
    print("HaruHaru")
else:
    print("Hing")