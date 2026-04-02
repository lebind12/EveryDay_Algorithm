import sys


input = sys.stdin.readline
N, K = map(int, input().split(' '))
arr = sorted(list(map(int, input().split(' '))), reverse=True)

answer = 0
minus = 0
for i in range(K):
    answer += arr[i]
    minus += i

print(answer - minus)