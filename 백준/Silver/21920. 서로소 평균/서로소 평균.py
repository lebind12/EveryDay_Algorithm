def gcd(a, b): # a > b
	if b == 0:
		return a
	else:	
		return gcd(b, a % b)

N = int(input())
amount = 0
count = 0
array = list(map(int, input().split(' ')))
X = int(input())
for value in array:
    g = gcd(max(X, value), min(X, value))
    if g == 1:
        amount += value
        count += 1
        
print(round(amount / count, 6))