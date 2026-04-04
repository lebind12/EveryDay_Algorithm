import sys
from collections import deque


input = sys.stdin.readline
n = int(input())

stack = deque()
goal = []
answer = []

for _ in range(n):
    goal.append(int(input()))

goal_idx = 0

for i in range(1, n+1):
    if len(stack) == 0:
        stack.append(i)
        answer.append("+")
        continue
    
    while len(stack) > 0 and goal[goal_idx] == stack[-1]:
        stack.pop()
        answer.append("-")
        goal_idx += 1
        
    stack.append(i)
    answer.append("+")

while len(stack) > 0 and goal[goal_idx] == stack[-1]:
    stack.pop()
    answer.append("-")
    goal_idx += 1

# print(goal_idx)

if goal_idx != n:
    print("NO")
else:
    for i in range(len(answer)):
        print(answer[i])