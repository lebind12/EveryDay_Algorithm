import sys


input = sys.stdin.readline
def find(parent, x):
	if parent[x] == x:
		return x
	parent[x] = find(parent, parent[x])
	return parent[x]

def union(parent, a, b):
	if a == b:
		return
	rootA = find(parent, a)
	rootB = find(parent, b)

	if rootA < rootB:
		parent[rootB] = rootA
	else:
		parent[rootA] = rootB
  
N = int(input())
M = int(input())
array = []
parent = [i for i in range(N)]
for i in range(N):
    nodes = list(map(int, input().split(' ')))
    for idx, node in enumerate(nodes):
        if node == 1:
            array.append((i, idx))
answer = "YES"            
for edge in array:
    a, b = edge
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
road = list(map(int, input().split(' ')))
root = find(parent, road[0]-1)
if len(road) > 1:
    for node in road:
        if root != find(parent, node-1):
            answer = "NO"
            break
print(answer)