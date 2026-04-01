import sys

input = sys.stdin.readline
N, L, W, H = map(int, input().split(' '))

# 4 * 2 * 10 직육면체 박스에 A * A * A 크기의 박스를 넣는데, N개를 전부 넣어야한다.
# 일단 A가 정수가 아님.

# floor(L/A) * floor(W/A) * floor(H/A) >= N
# 내가 그 실수범위 탐색 기법을 모른다고.

lo, hi = 0.0, max(L, W, H)

for _ in range(200):
    mid = (lo + hi) / 2
    
    count_l = int(L / mid)
    count_w = int(W / mid)
    count_h = int(H / mid)
    
    if count_l * count_w * count_h >= N:
        lo = mid
    else:
        hi = mid

print(f"{lo:.10f}")