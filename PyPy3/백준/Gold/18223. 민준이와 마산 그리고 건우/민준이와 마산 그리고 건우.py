import sys
import heapq

input = sys.stdin.readline
V, E, P = map(int, input().split(' '))
INF = int(1e9)
graph = [[] for _ in range(V+1)]
for _ in range(E):
    start, end, cost = map(int, input().split(' '))
    graph[start].append((cost, end))
    graph[end].append((cost, start))

# dijkstra 2번
# 1 - 마산 = 1 - 건우 + 건우 - 마산 -> SAVE HIM

dp = [INF] * (V+1)
def dijkstra(start):
    heap = []
    dp[start] = 0
    heapq.heappush(heap, (0, start))
    
    while len(heap) > 0:
        cost, cur = heapq.heappop(heap)
        
        if (cost > dp[cur]):
            continue
        
        for nextCost, next in graph[cur]:
            if nextCost + cost < dp[next]:
                dp[next] = nextCost+cost
                heapq.heappush(heap, (nextCost + cost, next))
                
dijkstra(1)
# print(dp)
MinjunToGunWoo = dp[P]
MinjunToMasan = dp[V]



dp = [INF] * (V+1)
dijkstra(P)
GunWooToMasan = dp[V]
# print(MinjunToGunWoo, GunWooToMasan, MinjunToMasan)

if (MinjunToGunWoo + GunWooToMasan == MinjunToMasan):
    print("SAVE HIM")
else:
    print("GOOD BYE")
