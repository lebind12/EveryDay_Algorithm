import sys
import heapq


input = sys.stdin.readline
V, E = map(int, input().split(' '))
K = int(input())

graph = [[] for _ in range(V+1)]
for _ in range(E):
    u, v, w = map(int, input().split(' '))
    graph[u].append((w, v))
    

INF = 1e9
dp = [INF] * (V+1)
visited = [False] * (V+1)

heap = []

# print(graph)
def dijkstra(start):
    global dp
    global heap
    global visited
    dp[start] = 0
    
    heapq.heappush(heap, (0, start))
    while heap:
        weight, curr = heapq.heappop(heap)
        visited[curr] = True
        
        for next_weight, next in graph[curr]:
            if not visited[next] and next_weight + weight < dp[next]:
                dp[next] = next_weight + weight
                heapq.heappush(heap, (next_weight + weight, next))
                
dijkstra(K)
for i in range(1, V+1):
    if dp[i] == INF:
        print("INF")
    else:
        print(dp[i])