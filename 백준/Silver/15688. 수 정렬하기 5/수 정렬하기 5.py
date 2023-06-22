import sys


input = sys.stdin.readline
N = int(input())
array = []
for _ in range(N):
    array.append(int(input()))
array.sort()
print("\n".join(str(x) for x in array))