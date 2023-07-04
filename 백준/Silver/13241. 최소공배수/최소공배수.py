import sys


input = sys.stdin.readline
def gcd(a, b): # a > b
	if b == 0:
		return a
	else:	
		return gcd(b, a % b)

A, B = map(int, input().split(' '))
g = gcd(max(A, B), min(A, B))
print(A * B // g)