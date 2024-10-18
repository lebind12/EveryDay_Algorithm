import sys


H, W = map(int, sys.stdin.readline().split(' '))
heights = list(map(int, sys.stdin.readline().split(' ')))

answer = 0

for i in range(H):
    start = -1
    for j in range(W):
        if heights[j] > i:
            if start == -1:
                start = j
            else:
                answer += (j - start - 1)
                start = j
print(answer)