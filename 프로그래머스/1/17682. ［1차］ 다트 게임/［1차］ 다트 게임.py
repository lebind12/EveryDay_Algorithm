def solution(dartResult):
    answer = 0
    numbers = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
    bonus = ['S', 'D', 'T']
    options = ['*', '#']
    scoreboard = [-1]
    INF = int(1e9)
    score = INF
    scoreboard_index = 1
    
    for i in range(len(dartResult)):
        if dartResult[i] in numbers:
            if i == 0:
                score = int(dartResult[i])
            elif i > 0 and dartResult[i-1] not in numbers:
                scoreboard.append(score)
                scoreboard_index += 1
                score = int(dartResult[i])
            elif i > 0 and dartResult[i] == '0' and dartResult[i-1] == '1':
                score = 10
        elif dartResult[i] in bonus:
            if dartResult[i] == 'D':
                score = score ** 2
            elif dartResult[i] == 'T':
                score = score ** 3
        elif dartResult[i] in options:
            if dartResult[i] == '#':
                score *= -1
            else:
                scoreboard[scoreboard_index-1] = scoreboard[scoreboard_index-1] * 2
                score *= 2
    
    scoreboard.append(score)
    answer = sum(scoreboard[1:])
    
    return answer