import sys


input = sys.stdin.readline
dx = [0, 1, 0, -1] # 상, 우, 하, 좌 시계 순서대로
dy = [-1, 0, 1, 0] # d 값에 일치하게, 반시계면 idx를 -1 % 4해야함.
N, M = map(int, input().split(' '))
r, c, d = map(int, input().split(' '))
board = []
for _ in range(N):
    board.append(list(map(int, input().split(' '))))

curr = (r, c) # 현재 위치
answer = 0 # 청소하는 칸의 개수


# -1: 청소됨. 0: 청소가 안됨. 1: 벽
while True:
    y = curr[0]
    x = curr[1]
    # print(y, x)
    # 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
    if board[y][x] == 0:
        answer += 1
        board[y][x] = -1
    uncleaned = False
    for i in range(4):
        ny = curr[0] + dy[i]
        nx = curr[1] + dx[i]
        if nx >= 0 and nx < M and ny >= 0 and ny < N:
            if board[ny][nx] == 0:
                uncleaned = True
                break
    # 4칸 중 청소되지 않는 빈칸이 있는 경우
    if uncleaned:
        # 반시계 방향으로 90도 회전한다
        d -= 1
        if d < 0:
            d += 4
        # 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않는 빈 칸인 경우
        ny = y + dy[d]
        nx = x + dx[d]
        if nx >= 0 and nx < M and ny >= 0 and ny < N:
            if board[ny][nx] == 0:
                # 한 칸 전진한다.
                curr = (ny, nx)
    
    # 4칸 중 청소되지 않는 빈칸이 없는 경우
    else:
        # 바라보는 방향을 유지한 채로 한 칸 후진 할 수 있다면
        back_d = d - 2
        if back_d < 0:
            back_d += 4
        ny = y + dy[back_d]
        nx = x + dx[back_d]
        # 한칸 후진하고 1번으로 돌아간다
        if nx >= 0 and nx < M and ny >= 0 and ny < N and board[ny][nx] != 1:
            curr = (ny, nx)
        # 벽이라 후진할 수 없으면 작동을 멈춘다.
        else:
            break
print(answer)