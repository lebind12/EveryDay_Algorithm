import sys


input = sys.stdin.readline
maximum = 0
N = int(input())
array = []
for _ in range(N):
    array.append(int(input()))
array.sort()
for i in range(N):
    maximum = max(maximum, array[i] * (N-i))
print(maximum)