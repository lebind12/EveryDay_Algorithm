import sys


input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split(' ')))

arr.sort()
amount = arr[-1]
for i in range((len(arr)-1) // 2):
  amount = amount + (arr[(-2-i)] - arr[i])
print(amount)