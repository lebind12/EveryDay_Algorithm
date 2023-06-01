import sys


def recursion(picked : list, topick : list, start : int):
    global K
    global finished
    found = 0

    if len(picked) == K:
        for idx in range(K):
            print(picked[idx])
        finished = 1
        return
    
    for i in range(start, len(topick) + 1):
        for j in picked:
            found = 0
            if friends[i][j] == 0:
                found = 1
                break
        if finished == 1:
            return
        if found == 0:
            picked.append(i)
            recursion(picked, topick, i + 1)
            picked.remove(i)


K, N, F = map(int, sys.stdin.readline().rstrip().split(" "))
friends = [[0] * (N + 1) for _ in range(N + 1)]
finished = -1
for _ in range(F):
    a, b = map(int, sys.stdin.readline().rstrip().split(" "))
    friends[a][b] = 1
    friends[b][a] = 1

recursion([], list(range(1, N+1)), 1)
if finished == -1:
    print("-1")