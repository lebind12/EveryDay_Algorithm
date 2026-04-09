import sys
import heapq

input = sys.stdin.readline
n = int(input())
m = int(input())

INF = int(1e9)

graph = [[] for _ in range(n+1)]
dist = [INF] * (n+1)
routes = [[] for _ in range(n+1)]

for _ in range(m):
    u, v, w = map(int, input().split(' '))
    graph[u].append((w, v))

def dijkstra(start):
    heap = []
    
    heapq.heappush(heap, (0, start, [start]))
    dist[start] = 0
    
    while heap:
        weight, curr_node, curr_routes = heapq.heappop(heap)
        
        if dist[curr_node] < weight:
            continue
        
        for next_cost, next_node in graph[curr_node]:
            total_cost = next_cost + weight
            if total_cost < dist[next_node]:
                dist[next_node] = total_cost
                routes[next_node] = curr_routes + [next_node]
                heapq.heappush(heap, (total_cost, next_node, curr_routes + [next_node]))
                
start, dest = map(int, input().split(' '))
dijkstra(start)
print(dist[dest])
print(len(routes[dest]))
print(" ".join(list(map(str, routes[dest]))))