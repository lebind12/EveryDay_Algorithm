import sys



N = int(sys.stdin.readline().rstrip())
def set(board : list, y : int, x : int, delta : int):
    # delta == -1 => 1을 0으로
    # delta == 1 => 0을 1로
    # x, y 좌표를 받아서 대각선, 위아래, 좌우 칠하기
    # 좌우
    for i in range(N):
        board[y][i] += delta
    # 위아래
    for i in range(N):
        board[i][x] += delta
    # 우상대각
    for i in range(N):
        if y-i >= 0 and x+i < N:
            board[y-i][x+i] += delta
    # 우하대각
    for i in range(N):
        if y+i < N and x+i < N:
            board[y+i][x+i] += delta
    # 좌하대각
    for i in range(N):
        if y+i < N and x-i >= 0:
            board[y+i][x-i] += delta
    # 좌상대각
    for i in range(N):
        if y-i >= 0 and x-i >= 0:
            board[y-i][x-i] += delta
    # x, y에 총 6번 칠해졌으니까 5번은 빼줌
    board[y][x] -= delta * 5
        
def recursive(board : list, set_line : int):
    # 맨 위에서 하나씩 놔둬봄.
    # 그럼 맨 라인을 제외한 나머지 라인에서 계산해야함 -> 하지만 대각선, 수직 라인에 표시를 해줘야함
    # set이 퀸이 공격 가능한 범위에 1을 더해서 표시함. 공격 안받는 곳은 0
    # print(board)
    
    if set_line == N-1: # 기저조건. 마지막 줄일 때
        if 0 in board[set_line]: # 퀸을 놓을 공간이 있는 경우
            return 1
        else:
            return 0 # 없으면 안씀
    
    ret = 0
    for i in range(N): # 좌상단부터
        if board[set_line][i] == 0: # 퀸을 둘 수 있으면
            set(board, set_line, i, 1) # (0, i) 에 퀸을 둠
            ret += recursive(board, set_line + 1) # 맨 윗줄을 제외하고 다시 둠
            set(board, set_line, i, -1) # 퀸을 뺌
    return ret

board = [[0] * N for _ in range(N)]
print(recursive(board, 0))