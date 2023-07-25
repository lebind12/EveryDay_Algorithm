import sys


input = sys.stdin.readline
S = input().rstrip()
counts = [0, 0]
# counts[int(S[0])] += 1
for i in range(0, len(S)-1):
    if S[i] == S[i+1]:
        continue
    else:
        counts[int(S[i])] += 1
counts[int(S[-1])] += 1
# print(counts)
print(min(counts))