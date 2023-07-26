import sys
from collections import deque


dx = [0, 1, 1, 1, 0, -1, -1, -1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]
input = sys.stdin.readline
while True:
    w, h = map(int, input().split(' '))
    if w == 0 and h == 0:
        break
    board = []
    for _ in range(h):
        board.append(list(map(int, input().split(' '))))
    queue = deque()
    count = 0
    for i in range(h):
        for j in range(w):
            if board[i][j] == 1:
                queue.append((i, j))
                board[i][j] = 0
                while len(queue):
                    y, x = queue.popleft()
                    for k in range(8):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if ny >= 0 and ny < h and nx >= 0 and nx < w:
                            if board[ny][nx] == 1:
                                board[ny][nx] = 0
                                queue.append((ny, nx))
                count += 1
    print(count)
    