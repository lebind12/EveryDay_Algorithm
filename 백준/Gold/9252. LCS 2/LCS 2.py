from pprint import pprint


A, B = list(input().rstrip()), list(input().rstrip())
dp = [[0] * (len(A) + 1) for _ in range(len(B) + 1)]
for i in range(1, len(B) + 1):
    for j in range(1, len(A) + 1):
        if A[j-1] == B[i-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
count = dp[-1][-1]
# pprint(dp)
word = ''
idx_A = len(A)
idx_B = len(B)
while count > 0:
    # print(idx_B, idx_A)
    if dp[idx_B][idx_A] == dp[idx_B][idx_A - 1]:
        while dp[idx_B][idx_A] == dp[idx_B][idx_A - 1]:
            idx_A -= 1
    elif dp[idx_B][idx_A] == dp[idx_B-1][idx_A]:
        idx_B -= 1
    else:
        word = A[idx_A - 1] + word
        idx_A -= 1
        idx_B -= 1
        count -= 1
print(dp[-1][-1])
if len(word) > 0:
    print(word)