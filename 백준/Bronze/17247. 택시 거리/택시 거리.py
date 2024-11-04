# 택시 거리
import sys


input = sys.stdin.readline
N, M = map(int, input().split(' '))
board = []
for _ in range(N):
    board.append(list(map(int, input().split(' '))))

point_1_founded = False
point_2_founded = False

point_1 = []
point_2 = []

for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            if not point_1_founded:
                point_1 = [i, j]
                point_1_founded = True
            else:
                point_2 = [i, j]
                point_2_founded = True
                break
    if point_1_founded and point_2_founded:
        break
    
# print(point_1, point_2)
print(abs(point_1[0] - point_2[0]) + abs(point_1[1] - point_2[1]))