import sys

input = sys.stdin.readline
N = int(input())
M = int(input())

roads = [False] * (N+1)
spots = list(map(int, input().split(' ')))

lo, hi = 0, N


while lo < hi:
    covered = True
    mid = (lo + hi) // 2
    
    if spots[0] - mid > 0:
        covered = False
    
    if covered:
        for i in range(1, M):
            if spots[i] - mid > spots[i-1] + mid:
                covered = False
                break
    if covered and spots[-1] + mid < N:
        covered = False
        
    if covered:
        hi = mid
    else:
        lo = mid + 1
        
print(lo)