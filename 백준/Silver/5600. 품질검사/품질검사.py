import sys


input = sys.stdin.readline
a, b, c = map(int, input().split(' '))
N = int(input())
tests = []
stat = [2] * (a+b+c+1)

for _ in range(N):
  tests.append(list(map(int, input().split(' '))))

tests.sort(key=lambda x : -x[3])

for test in tests:
  i, j, k, r = test
  if r == 1:
    stat[i], stat[j], stat[k] = 1, 1, 1
  else:
    if stat[i] == 1 and stat[j] == 1:
      stat[k] = 0
    elif stat[i] == 1 and stat[k] == 1:
      stat[j] = 0
    elif stat[j] == 1 and stat[k] == 1:
      stat[i] = 0

for i in range(1, a + b + c + 1):
  print(stat[i])