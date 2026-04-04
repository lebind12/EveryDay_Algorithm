import sys


input = sys.stdin.readline
N = int(input())
weights = []
for _ in range(N):
    weights.append(int(input()))
    
weights = sorted(weights)

answer = 0
for i in range(N):
    answer = max(answer, weights[i] * (N-i))
    
print(answer)