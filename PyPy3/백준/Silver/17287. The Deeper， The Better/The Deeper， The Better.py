from collections import deque
import sys


input = sys.stdin.readline
scores = [0] * 10
S = list(input())

stack = deque()

for char in S:
    if char == '(' or char == '{' or char == '[':
        stack.append(char)
    elif char.isdigit():
        idx = int(char)
        amount = 0
        for brace in stack:
            if brace == '(':
                amount += 1
            elif brace == '{':
                amount += 2
            elif brace == '[':
                amount+= 3
                
        scores[idx] = max(amount, scores[idx])
    elif char == ')' or char == '}' or char == ']':
        stack.pop()
        
print(max(scores))