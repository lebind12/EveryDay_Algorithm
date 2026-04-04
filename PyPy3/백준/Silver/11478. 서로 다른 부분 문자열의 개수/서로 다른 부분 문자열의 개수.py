import sys


s = input().rstrip()
answer = set()

n = len(s)
for size in range(1, n+1):
    for i in range(n):
        if i + size <= n:
            answer.add(s[i:i+size])
            
print(len(answer))