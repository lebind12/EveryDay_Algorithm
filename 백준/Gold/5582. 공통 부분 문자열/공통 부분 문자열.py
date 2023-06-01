import sys


input = sys.stdin.readline
A = input().rstrip()
B = input().rstrip()
dp = [[0] * (len(A) + 1) for _ in range(len(B) + 1)]
maximum = 0
for i in range(1, len(B)+1):
    for j in range(1, len(A)+1):
        if A[j-1] == B[i-1]:
            dp[i][j] = dp[i-1][j-1] + 1
            maximum = max(maximum, dp[i][j])
print(maximum)