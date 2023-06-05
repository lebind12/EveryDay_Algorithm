from collections import Counter
import sys


input = sys.stdin.readline
N, C = map(int, input().split(' '))
array = list(map(int, input().split(' ')))
# rates = defaultdict(int)
counter = Counter(array)
print(" ".join(str(x) for x in sorted(array, key=lambda a : (-counter[a], array.index(a)) )))
# print(counter)