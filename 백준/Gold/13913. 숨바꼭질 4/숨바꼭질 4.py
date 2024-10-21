from collections import deque
import sys


input = sys.stdin.readline
N, K = map(int, input().split(' '))

queue = deque()
queue.append([N, [N]])
visited = [False] * 100001
visited[N] = True
answer = []

if N > K:
    print(N - K)
    print(" ".join([str(x) for x in range(N, K-1, -1)]))
else:
    while queue:
        current, route = queue.popleft()
        
        if current == K:
            answer = route
            break
        
        next_1 = current + 1
        next_2 = current - 1
        next_3 = current * 2
        
        if next_1 < 100001 and not visited[next_1]:
            visited[next_1] = True
            queue.append([next_1, route + [next_1]])
        
        if next_2 > 0 and not visited[next_2]:
            visited[next_2] = True
            queue.append([next_2, route + [next_2]])
        
        if next_3 < 100001 and not visited[next_3]:
            visited[next_3] = True
            queue.append([next_3, route + [next_3]])
        
    print(len(answer) - 1)
    print(" ".join([str(x) for x in answer]))