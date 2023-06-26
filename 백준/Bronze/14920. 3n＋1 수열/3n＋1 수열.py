import sys


input = sys.stdin.readline
n = 1
value = int(input())
while True:
    if value == 1:
        print(n)
        break
    
    if value % 2 == 0:
        value = value // 2
    else:
        value = (3 * value) + 1
    n += 1