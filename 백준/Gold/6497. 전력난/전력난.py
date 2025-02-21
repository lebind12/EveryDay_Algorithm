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
while True:
    m, n = map(int, input().split(' '))
    if m == 0 and n == 0:
        break
    parent = [i for i in range(m)]
    array = []
    total = 0
    cost = 0

    for _ in range(n):
        a, b, c = map(int, input().split(' '))
        array.append([a, b, c])
        total += c
    array.sort(key=lambda x : x[2])
    for a, b, c in array:
        if find(parent, a) != find(parent, b):
            union(parent, a, b)
            cost += c
    print(total - cost)