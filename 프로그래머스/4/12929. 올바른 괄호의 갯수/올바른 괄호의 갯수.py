def solution(n):
    dp = [1, 1]
    for i in range(2, n+1):
        amount = 0
        for j in range(i):
            amount += dp[j] * dp[i-j-1]
        dp.append(amount)
    return dp[-1]