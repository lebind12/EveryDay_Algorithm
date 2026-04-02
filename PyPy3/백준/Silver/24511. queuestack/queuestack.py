import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
# 0 이면 queue, 1 이면 stack
# 삽입 한 뒤 pop이면 queue는 원래 있던거, stack은 방금 들어간거.
A = list(map(int, input().split(' ')))
# 각 자료구조에 들어있는 원소. 현재 각각의 자료구조에는 한개의 원소가 들어가 있다.
B = list(map(int, input().split(' ')))
# 
M = int(input())
C = list(map(int, input().split(' ')))

answer = []

queue = deque()
for i in range(N):
    if A[i] == 0:
        queue.append(B[i])

for c in C:
    if queue:
        queue.appendleft(c)
        answer.append(queue.pop())
    
    else:
        answer.append(c)
    
print(" ".join(map(str, answer)))