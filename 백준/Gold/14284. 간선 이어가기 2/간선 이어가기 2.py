import sys
import heapq


input = sys.stdin.readline
INF = int(1e9)
n, m = map(int, input().split(' '))
graph = [[] for _ in range(n+1)]
dp = [INF] * (n+1)
for _ in range(m):
    a, b, c = map(int, input().split(' '))
    graph[a].append([c, b])
    graph[b].append([c, a])
start, end = map(int, input().split(' '))

heap = []
def dijkstra(start):
    dp[start] = 0
    heapq.heappush(heap, [0, start])

    while heap:
        weight, now = heapq.heappop(heap)
        if weight > dp[now]:
            continue
        for w, next in graph[now]:
            cost = w + weight
            if cost < dp[next]:
                dp[next] = cost
                heapq.heappush(heap, [cost, next])
dijkstra(start)
a = dp[end]
dp = [INF] * (n+1)
dijkstra(end)
b = dp[start]
print(min(a, b))