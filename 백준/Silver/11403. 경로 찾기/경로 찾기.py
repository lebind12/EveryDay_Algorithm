import sys


input = sys.stdin.readline
INF = 99999999
N = int(input())
board = []
for _ in range(N):
    board.append(list(map(int, input().split(' '))))
for k in range(N):
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                board[i][j] = INF
            board[i][j] = min(board[i][j], board[i][k] + board[k][j])
answer = ""
for i in range(N):
    for j in range(N):
        if board[i][j] == INF:
            board[i][j] = 0
        else:
            board[i][j] = 1
    answer += " ".join(str(x) for x in board[i])
    answer += '\n'
print(answer)