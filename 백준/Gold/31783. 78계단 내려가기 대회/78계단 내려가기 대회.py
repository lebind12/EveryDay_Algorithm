def binarySearch(arr, x, left):

    right = len(arr)
    while left < right:
        mid = (left + right) // 2
        if arr[mid] >= x:
            right = mid
        else:
            left = mid + 1
    
    return left


N = int(input())
heights = list(map(int, input().split(' '))) # sorted array
scores = [0] + list(map(int, input().split(' ')))
hards = [0] + list(map(int, input().split(' ')))     

for i in range(N):
    hards[i] += heights[i]

heights.reverse()
scores.reverse()
hards.reverse()

dp = [0] * N

# print(heights)
# print(hards)
# print(scores)

for i in range(N):
    # print(dp)
    if i != 0 and dp[i-1] >= dp[i]:
        dp[i] = dp[i-1]
        
    target_height = binarySearch(heights, hards[i], i+1)
        
    if (target_height < N):
        dp[target_height]= max(dp[i] + scores[i], dp[target_height])
print(dp[-1])