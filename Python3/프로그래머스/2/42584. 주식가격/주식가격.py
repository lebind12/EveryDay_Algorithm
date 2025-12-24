def solution(prices):
    length = len(prices)
    answer = [ i for i in range (length - 1, -1, -1)]
    
    stack = [0]
    for i in range (1, length, 1):
        while stack and prices[stack[-1]] > prices[i]:
            j = stack.pop()
            answer[j] = i - j
        stack.append(i)
    return answer