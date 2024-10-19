import sys

input = sys.stdin.readline
N, K = map(int, input().split())
array = list(map(int, input().split(' ')))
answer = 0


def recursion(array, K, N, choosed, length):
  if len(str(N)) < len(choosed):
    return 0

  if len(choosed) == length:
    v = int("".join(list(map(str, choosed))))
    if v <= N:
      return v
    else:
      return 0

  value = 0
  for i in range(K):
    choosed.append(array[i])
    value = max(value, recursion(array, K, N, choosed, length))
    choosed.pop()
  return value


if min(array) > int(str(N)[0]):
  answer = recursion(array, K, N, [], len(str(N)) - 1)
else:
  answer = recursion(array, K, N, [], len(str(N)))
print(answer)
