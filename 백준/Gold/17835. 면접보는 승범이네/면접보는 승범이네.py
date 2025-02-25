import sys
import heapq
N, M, K = map(int, sys.stdin.readline().split())
arr = [[] for _ in range(N+1)]
for i in range(M):
    a, b, cost = map(int, sys.stdin.readline().split())
    arr[b].append([a, cost])

targets = list(map(int, sys.stdin.readline().split()))


def dijkstra():
    h = []
    for t in targets:
        heapq.heappush(h, [0, t])
        result[t] = 0
    while h:
        cost, city = heapq.heappop(h)
        if result[city] < cost:
            continue
        for next_city, next_cost in arr[city]:
            if cost + next_cost < result[next_city]:
                result[next_city] = cost+next_cost
                heapq.heappush(h, [cost+next_cost, next_city])


max_start, max_cost = 0, 0
result = [int(1e11)] * (N+1)
dijkstra()
for i, r in enumerate(result):
    if r > max_cost and r != int(1e11):
        max_start, max_cost = i, r
print(max_start)
print(max_cost)