# 1. 패턴의 길이가 3 이상인지 -> 입력에 제한
# 2. 수열에 중복이 있는지
# 3. 건너뛰기 불가능.

import sys


input = sys.stdin.readline
L = int(input())
array = list(map(int, input().split(' ')))
visited = [False] * 10
position = {
    1: [0, 0],
    2: [0, 1],
    3: [0, 2],
    4: [1, 0],
    5: [1, 1],
    6: [1, 2],
    7: [2, 0],
    8: [2, 1],
    9: [2, 2]
}
board = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

founded = False
for i in range(L):
    # 중복 체크
    if visited[array[i]]:
        founded = True
        break
    visited[array[i]] = True
    
    # 건너뛰기 체크
    if i > 0:
        y, x = position[array[i]]
        # 가로 건너뛰기 체크
        if x != 1: # 중간은 건너뛸 수 없다.
            if x == 0:
                if not visited[board[y][1]] and array[i-1] == board[y][2]:
                    founded = True
                    break
            elif x == 2:
                if not visited[board[y][1]] and array[i-1] == board[y][0]:
                    founded = True
                    break
        # 세로 건너뛰기 체크
        if y != 1:
            if y == 0:
                if not visited[board[1][x]] and array[i-1] == board[2][x]:
                    founded = True
                    break
            elif y == 2:
                if not visited[board[1][x]] and array[i-1] == board[0][x]:
                    founded = True
                    break
        # 대각 건너뛰기 체크
        if [y, x] in [[0, 0], [0, 2], [2, 0], [2, 2]]:
            if [y, x] == [0, 0]:
                if not visited[5] and array[i-1] == 9:
                    founded = True
                    break
            elif [y, x] == [0, 2]:
                if not visited[5] and array[i-1] == 7:
                    founded = True
                    break
            elif [y, x] == [2, 0]:
                if not visited[5] and array[i-1] == 3:
                    founded = True
                    break
            elif [y, x] == [2, 2]:
                if not visited[5] and array[i-1] == 1:
                    founded = True
                    break
                
if not founded:
    print("YES")
else:
    print("NO")