def solution(land):
    dp = land[0][:]  # 첫 행으로 초기화
    
    for row in range(1, len(land)):
        new_dp = [0] * 4
        for col in range(4):
            # 이전 행에서 현재 열 제외한 최대값 + 현재 칸
            new_dp[col] = land[row][col] + max(dp[i] for i in range(4) if i != col)
        dp = new_dp
    
    return max(dp)