import sys


input = sys.stdin.readline
G = int(input())
P = int(input())
gates = [0] * (G+1)
count = 0
for _ in range(P):
    g = int(input())
    found = True
    if gates[g] == 0:
        gates[g] += 1
        count += 1
    else:
        while g > 0 and gates[g] > 0:
            tmp = gates[g]
            gates[g] += 1
            g -= tmp
        if g == 0:
            found = False
            break
        else:
            gates[g] += 1
            count += 1	
    if not found:
        break
print(count)