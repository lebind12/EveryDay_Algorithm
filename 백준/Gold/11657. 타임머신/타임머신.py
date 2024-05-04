import sys
INF = int(1e9)

def bf(start):
    dist[start] = 0
    for i in range(n):
        for j in range(m):
            current = edges[j][0]
            next_node = edges[j][1]
            cost = edges[j][2]
            if dist[current] != INF and dist[next_node] > dist[current] + cost:
                dist[next_node] = dist[current] + cost
                if i == n - 1:
                    return True
    return False

n, m = map(int, sys.stdin.readline().rstrip().split(' '))
edges = []
dist = [INF] * (n + 1)
for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().rstrip().split(' '))
    edges.append((a, b, c))
    
negative_cycle = bf(1)
if negative_cycle:
    print("-1")
else:
    for i in range(2, n + 1):
        if dist[i] == INF:
            print("-1")
        else:
            print(dist[i])