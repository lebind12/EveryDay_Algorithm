import sys

def travel(N, W, dp):
    for i in range(N):
        for j in range(N):
            if not W[i][j]:
                W[i][j] = float('inf')  # 갈 수 없는 경로는 0으로 주어져서

    for i in range(1, N):
        dp[i][0] = W[i][0]

    for k in range(1, N - 1):
        for A in range(1, size):
            if count(A, N) == k:
                for i in range(1, N):
                    if not isin(i, A):
                        dp[i][A] = minimum(N, W, i, A, dp)

    dp[0][size - 1] = minimum(N, W, 0, size - 1, dp)
    
    return dp[0][size - 1]

def count(A, N):
    cnt = 0
    for n in range(1, N):
        if A & (1 << n - 1) != 0:
            cnt += 1
    return cnt

def isin(i, A):
    if A & (1 << i - 1) != 0:
        return True
    else:
        return False

def minimum(N, W, i, A, dp):
    minimum_dist = float('inf')
    for j in range(1, N):
        if isin(j, A):
            before_A = A & ~(1 << j - 1)
            dist = W[i][j] + dp[j][before_A]
            if minimum_dist > dist:
                minimum_dist = dist
    return minimum_dist

N = int(sys.stdin.readline())
W = [list((map(int, sys.stdin.readline().split()))) for _ in range(N)]
size = 2 ** (N - 1)
dp = [[float('inf')] * size for _ in range(N)]
print(travel(N, W, dp))