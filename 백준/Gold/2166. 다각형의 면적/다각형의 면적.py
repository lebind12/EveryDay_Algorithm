import sys


input = sys.stdin.readline
N = int(input())
dots = []
for _ in range(N):
    x, y = map(float, input().split(' '))
    dots.append((x, y))
dots.append((dots[0][0], dots[0][1]))
blue_sum = 0.0
red_sum = 0.0
for i in range(1, N+1):
    x1, y1 = dots[i-1]
    x2, y2 = dots[i]
    blue_sum += (x1 * y2)
    red_sum += (y1 * x2)
print(abs((blue_sum - red_sum) / 2))