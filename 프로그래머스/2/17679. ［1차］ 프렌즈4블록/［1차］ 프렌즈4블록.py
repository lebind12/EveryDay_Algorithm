# (x, y)에서 4개가 같은 블럭을 찾기
# 다 지워지고 남은 블럭들 아래로 정렬하기
# 반복
from collections import deque


dx = [0, 1, 0, 1]
dy = [0, 0, 1, 1]
queue = deque([])

# 4개가 같은 블록 찾기
def find_square(y, x, board, n, m, delete_queue):
    if board[y][x] != '-1':
        if y + 1 < m and x + 1 < n:
            if board[y][x] == board[y+1][x] and board[y][x] == board[y][x+1] and board[y][x] == board[y+1][x+1]:
                for k in range(4):
                    delete_queue.append((y+dy[k], x+dx[k]))
                return True
            else:
                return False

    return False

# 아래로 정렬시키기
def gravity(board, n, m):
    # print(board)
    for x in range(n): # 열 순회
        delete_start = -1
        queue = deque()
        for y in range(m-1, -1, -1): # 행 순회, 아래서 위로
            if board[y][x] != '-1':
                queue.append(board[y][x])
        
        for y in range(m-1, -1, -1):
            if queue:
                board[y][x] = queue.popleft()
            else:
                board[y][x] = '-1'

def solution(m, n, board):
    answer = 0
    board = list([list(board[x]) for x in range(len(board))])
    
    while True:
        again = False
        for y in range(m):
            for x in range(n):
                if find_square(y, x, board, n, m, queue):
                    again = True
        if not again:
            break
        while queue:
            j, i = queue.popleft()
            if board[j][i] != '-1':
                board[j][i] = '-1'
                answer += 1
        gravity(board, n, m)
    return answer