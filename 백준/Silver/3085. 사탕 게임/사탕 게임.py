# C, P, Z, Y
import sys


board = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

answer = 0

N = int(sys.stdin.readline())
for _ in range(N):
    board.append(list(sys.stdin.readline().rstrip()))

# 가장 긴 연속 부분을 구하는 모듈

def get_maximum_straight():
    maximum_straight = 1
    
    # 행 연속
    straight = 1
    for j in range(N):
        straight = 1
        for i in range(1, N):
            if board[j][i-1] == board[j][i]:
                straight += 1
                maximum_straight = max(maximum_straight, straight)
            else:
                straight = 1
    
    straight = 1
    # 열 연속
    for i in range(N):
        straight = 1
        for j in range(1, N):
            if board[j-1][i] == board[j][i]:
                straight += 1
                maximum_straight = max(maximum_straight, straight)
            else:
                straight = 1
    return maximum_straight

# 순회하면서 바꾸는 모듈
for y in range(N):
    for x in range(N):
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            
            if nx >= 0 and nx < N and ny >= 0 and ny < N:
                if board[ny][nx] != board[y][x]:
                    board[ny][nx], board[y][x] = board[y][x], board[ny][nx]
                    # 긴 연속 부분 구함
                    answer = max(answer, get_maximum_straight())
                    board[ny][nx], board[y][x] = board[y][x], board[ny][nx]

print(answer)