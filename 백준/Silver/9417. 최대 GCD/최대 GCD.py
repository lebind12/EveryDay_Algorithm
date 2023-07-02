import sys


input = sys.stdin.readline
def gcd(a, b): # a > b
	if b == 0:
		return a
	else:	
		return gcd(b, a % b)

T = int(input())
for _ in range(T):
    array = list(map(int, input().split(' ')))
    array.sort()
    length = len(array)
    max_g = -1
    if length > 1:
        for i in range(length):
            for j in range(i + 1, length):
                max_g = max(max_g, gcd(array[i], array[j]))
    print(max_g)