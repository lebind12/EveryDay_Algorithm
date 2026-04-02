import sys
import bisect

input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split(' ')))

minimum = min(arr)
maximum = max(arr)

# print(minimum, maximum)

if (minimum == maximum):
    print(1)
    exit()
    
minimum_pot = []
maximum_pot = []
for i in range(N):
    if arr[i] == minimum:
        minimum_pot.append(i)
    elif arr[i] == maximum:
        maximum_pot.append(i)
        

answer = 1e9
for min_idx in minimum_pot:
    lo, hi = 0, len(maximum_pot)
    
    idx = bisect.bisect_left(maximum_pot, min_idx)
    
    # while lo < hi:
    #     mid = (lo + hi) // 2
    #     if min_idx < maximum_pot[mid]:
    #         hi = mid
    #     else:
    #         lo = mid+1
            
    # print(arr[lo], arr[min_idx])
    
    if idx < len(maximum_pot):
        answer = min(answer, maximum_pot[idx] - min_idx + 1)
    
    if idx > 0:
        answer = min(answer, min_idx - maximum_pot[idx - 1] + 1)
    
print(answer)