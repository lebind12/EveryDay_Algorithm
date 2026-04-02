import sys


arr = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]
input = sys.stdin.readline

first = input().rstrip()
second = input().rstrip()

tmp1 = []

for i in range(len(first)):
    tmp1.append(arr[ord(first[i]) - ord('A')])
    tmp1.append(arr[ord(second[i]) - ord('A')])
    

while len(tmp1) >= 3:
    tmp2 = []
    for i in range(len(tmp1) - 1):
        tmp2.append((tmp1[i] + tmp1[i+1]) % 10)
    tmp1 = tmp2
    
print("".join(list(map(str, tmp1))))