from pprint import pprint
import sys
from collections import defaultdict

input = sys.stdin.readline

n = int(input().rstrip())
m = int(input().rstrip())
board = [[sys.maxsize] * n for _ in range(n)]
for _ in range(m):
    start, end, value = map(int, input().split(' '))
    board[start-1][end-1] = min(board[start-1][end-1], value)
    
for k in range(n):
    for i in range(n):
        for j in range(n):
            if (board[i][k] != sys.maxsize and board[k][j] != sys.maxsize):
                board[i][j] = min(board[i][j], board[i][k] + board[k][j])
                
                
for i in range(len(board)):
    for j in range(len(board[i])):
        if (i == j):
            print(0, end=" ")
        elif (board[i][j] == sys.maxsize):
            print(0, end=" ")
        else:
            print(board[i][j], end=" ")
    print()