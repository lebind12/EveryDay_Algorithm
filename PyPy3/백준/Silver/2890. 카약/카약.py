import sys
from collections import defaultdict


input = sys.stdin.readline
R, C = map(int, input().split(' '))
scores = {}

board = []
for _ in range(R):
    board.append(list(input().rstrip()))
    
rank = 1
for x in range(C-2, 0, -1):
    found = False
    for y in range(R):
        if board[y][x] != '.':
            number = board[y][x]
            if number not in scores.keys():
                scores[number] = rank
                found = True
    if found:
        rank += 1
    
for i in sorted(scores.keys()):
    print(scores[i])