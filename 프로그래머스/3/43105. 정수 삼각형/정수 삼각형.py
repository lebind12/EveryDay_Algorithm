def solution(triangle):
    answer = 0
    prev_dp = [triangle[0][0]]
    dp = []
    height = len(triangle)
    for i in range(1, height):
        for j in range(len(triangle[i])):
            if j == 0:
                dp.append(prev_dp[0] + triangle[i][j])
            elif j == len(triangle[i]) - 1:
                dp.append(prev_dp[j-1] + triangle[i][j])
            else:
                dp.append(max(prev_dp[j-1], prev_dp[j]) + triangle[i][j])
            
        prev_dp = dp
        dp = []
    # print(prev_dp)
    answer = max(prev_dp)
    return answer