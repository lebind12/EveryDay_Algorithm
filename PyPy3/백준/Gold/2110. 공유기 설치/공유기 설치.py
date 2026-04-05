import sys


input = sys.stdin.readline
N, C = map(int, input().split(' '))

arr = []

for _ in range(N):
    arr.append(int(input()))
    
arr.sort()

# print(arr)

lo, hi = 1, arr[-1] - arr[0]
result = 0

while lo <= hi:
    mid = (lo + hi) // 2
    count = 1
    
    last_installed = arr[0]
    
    for i in range(1, N):
        if arr[i] - last_installed >= mid:
            count += 1
            last_installed = arr[i]
            
    if count >= C:
        result = mid
        lo = mid + 1
    else:
        hi = mid - 1
        
print(result)