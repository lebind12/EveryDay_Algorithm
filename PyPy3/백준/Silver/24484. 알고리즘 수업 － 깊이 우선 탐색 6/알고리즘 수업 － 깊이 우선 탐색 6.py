import sys
from collections import deque

input = sys.stdin.readline

N, M, R = map(int, input().split(' '))
graph = [[] for _ in range(N+1)]

for _ in range(M):
    u, v = map(int, input().split(' '))
    graph[u].append(v)
    graph[v].append(u)

for i in range(N+1):
    graph[i] = sorted(graph[i])

visited = [False] * (N+1)
amount = 0
count = 0

stack = deque()
stack.append((R, 0))

while len(stack) > 0:
    curr, depth = stack.pop()
    if not visited[curr]:
        visited[curr] = True
    else:
        continue
    
    count += 1
    amount += (depth * count)
    
    for next in graph[curr]:
        if not visited[next]:
            stack.append((next, depth + 1))

print(amount)