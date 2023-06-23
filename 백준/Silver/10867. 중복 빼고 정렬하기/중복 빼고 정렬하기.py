import sys


input = sys.stdin.readline
N = int(input())
array = list(map(int, input().split(' ')))
array.sort()
print(" ".join(str(x) for x in set(array)))