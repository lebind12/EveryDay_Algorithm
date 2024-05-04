def find(parent, x):
    if parent[x] == x:
        return x
    parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    rootA = find(parent, a)
    rootB = find(parent, b)

    if a == b:
        return
    if rootA < rootB:
        parent[rootB] = rootA
    else:
        parent[rootA] = rootB

V, E = map(int, input().split(' '))
array = []
answer = 0
parent = [i for i in range(V+1)]
for _ in range(E):
    array.append(list(map(int, input().split(' '))))
array.sort(key=lambda x: x[2])

for a, b, cost in array:
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        answer += cost
print(answer)