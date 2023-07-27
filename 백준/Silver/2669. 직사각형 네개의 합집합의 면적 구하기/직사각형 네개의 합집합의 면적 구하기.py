import sys


input = sys.stdin.readline
board = [[0] * 100 for _ in range(100)]
for _ in range(4):
    min_x, min_y, max_x, max_y = map(int, input().split(' '))
    for i in range(min_y, max_y):
        for j in range(min_x, max_x):
            board[i][j] = 1
answer = 0
for i in range(100):
    for j in range(100):
        if board[i][j] == 1:
            answer += 1
print(answer)