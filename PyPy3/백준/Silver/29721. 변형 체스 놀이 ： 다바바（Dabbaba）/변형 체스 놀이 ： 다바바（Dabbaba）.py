import sys
from collections import defaultdict

input = sys.stdin.readline

N, K = map(int, input().split(' '))
dy = [-2, 2, 0, 0]
dx = [0, 0, -2, 2]

amount = 0
visited = defaultdict(bool)
babas = []


for _ in range(K):
    y, x = map(int, input().split(' '))
    y -= 1
    x -= 1
    visited[f"{y} {x}"] = True
    babas.append((y, x))
    # 상 하 좌 우 갈 수 있는지
    
for y, x in babas:
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if (ny >= 0 and ny < N and nx >= 0 and nx < N):
            if not visited[f"{ny} {nx}"]:
                visited[f"{ny} {nx}"] = True
                amount += 1

# print(visited)
print(amount)