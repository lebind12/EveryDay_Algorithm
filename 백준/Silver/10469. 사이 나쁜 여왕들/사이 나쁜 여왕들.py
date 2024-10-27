import sys

dx = [0, 0, -1, 1, -1, 1, 1, -1]
dy = [-1, 1, 0, 0, -1, 1, -1, 1]
input = sys.stdin.readline
valid = True

board = []
for _ in range(8):
  board.append(list(input().rstrip()))

queen_count = 0

for i in range(8):
  for j in range(8):
    if board[i][j] == '*':
      # 가로세로 대각선에 여왕이 있는지 확인한다
      queen_count += 1
      for k in range(8):
        ny = i + dy[k]
        nx = j + dx[k]
        while ny >= 0 and ny < 8 and nx >= 0 and nx < 8:
          if board[ny][nx] == '*':
            valid = False
            break
          ny = ny + dy[k]
          nx = nx + dx[k]

if queen_count != 8:
  valid = False

if valid:
  print('valid')
else:
  print('invalid')
