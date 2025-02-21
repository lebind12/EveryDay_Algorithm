import sys

N, M = map(int, sys.stdin.readline().split(" "))
board = [[] for _ in range(N+1)]
for line_number in range(1, N+1):
    line = list(map(int, sys.stdin.readline().split(" ")))
    for idx in range(len(line) - 1):
        line[idx + 1] = line[idx] + line[idx + 1]
    line.insert(0, 0)
    board[line_number] = line
for _ in range(M):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().rstrip().split(" "))
    sum_value = 0
    for line_number in range(x1, x2+1):
        sum_value += board[line_number][y2] - board[line_number][y1-1]
    print(sum_value)