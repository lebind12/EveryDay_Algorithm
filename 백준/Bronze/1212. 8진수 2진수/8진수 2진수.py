import sys


input = sys.stdin.readline
N = input().rstrip()
amount = int(N, 8)
print(bin(amount)[2:])