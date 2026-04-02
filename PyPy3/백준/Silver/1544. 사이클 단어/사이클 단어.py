import sys


input = sys.stdin.readline
words = []

N = int(input())
for _ in range(N):
    s = input().rstrip()
    if len(words) == 0:
        words.append(s)
        continue
    s2 = s + s
    
    new = True
    for word in words:
        if len(word) * 2 == len(s2) and word in s2:
            new = False
            break
        
    if new:
        words.append(s)
    
# print(words)
print(len(words))