import sys


input = sys.stdin.readline
n, m = map(int, input().split(' '))

counts = [[[0, 0, 0], [0, 0, 0], [0, 0, 0]],
          [[0, 0, 0], [0, 0, 0], [0, 0, 0]],
          [[0, 0, 0], [0, 0, 0], [0, 0, 0]]]

for _ in range(n):
    sub, fruit, color = input().rstrip().split(' ')
    i, j, k = 0,0,0
    if sub == 'kor' : i = 0
    elif sub == 'eng': i = 1
    elif sub == 'math': i = 2
    
    if fruit == 'apple': j = 0
    elif fruit == 'pear': j = 1
    elif fruit == 'orange': j = 2
    
    if color == 'red': k = 0
    elif color == 'blue': k = 1
    elif color == 'green': k = 2
    
    counts[i][j][k] += 1
    
for _ in range(m):
    sub, fruit, color = input().rstrip().split(' ')
    i, j, k = 0,0,0
    if sub == 'kor' : i = 0
    elif sub == 'eng': i = 1
    elif sub == 'math': i = 2
    else: i = 3
    
    if fruit == 'apple': j = 0
    elif fruit == 'pear': j = 1
    elif fruit == 'orange': j = 2
    else: j = 3
    
    if color == 'red': k = 0
    elif color == 'blue': k = 1
    elif color == 'green': k = 2
    else: k = 3
    answer = 0

    if i == 3:
        for s in range(3):
            if j == 3:
                for f in range(3):
                    if k == 3:
                        for c in range(3):
                            answer += counts[s][f][c]
                    else:
                        answer += counts[s][f][k]
            else:
                if k == 3:
                    for c in range(3):
                        answer += counts[s][j][c]
                else:
                    answer += counts[s][j][k]
    else:
        if j == 3:
                for f in range(3):
                    if k == 3:
                        for c in range(3):
                            answer += counts[i][f][c]
                    else:
                        answer += counts[i][f][k]
        else:
            if k == 3:
                for c in range(3):
                    answer += counts[i][j][c]
            else:
                answer += counts[i][j][k]
    print(answer)
