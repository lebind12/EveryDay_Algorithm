def solution(want, number, discount):
    answer = 0
    start = 0
    end = 9
    length = len(discount)
    
    database = {}
    for i in range(len(want)):
        database[want[i]] = number[i]
        
    for j in range(0, 10):
        if discount[j] in database:
            database[discount[j]] -= 1
        if all([k == 0 for k in database.values()]):
            answer += 1
    
    for _ in range(length - 10):
        if discount[start] in database:
            database[discount[start]] += 1
        start += 1
        end += 1
        if discount[end] in database:
            database[discount[end]] -= 1
        if all([k == 0 for k in database.values()]):
            answer += 1
    
        # print(database)
    return answer