import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
values = sorted(map(int, input().split(' ')))
queue = deque(values)

park, seong = 0, 0
turn = 0

while queue:
    if turn % 2 == 0:
        park += queue.pop()
    else:
        seong += queue.popleft()
    turn = (turn + 1) % 2
    
print(seong, park)