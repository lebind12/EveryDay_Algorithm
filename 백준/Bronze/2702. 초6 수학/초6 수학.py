import sys


input = sys.stdin.readline
def gcd(a, b): # a > b
	if b == 0:
		return a
	else:	
		return gcd(b, a % b)

T = int(input())
for _ in range(T):
    a, b = map(int, input().split(' '))
    g = gcd(a, b)
    print(f"{a * b // g} {g}")