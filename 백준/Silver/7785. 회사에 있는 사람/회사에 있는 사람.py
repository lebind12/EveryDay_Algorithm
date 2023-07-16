import sys
from collections import defaultdict


input = sys.stdin.readline
N = int(input())
people = defaultdict(bool)
for _ in range(N):
    name, command = input().rstrip().split(' ')
    if command == "enter":
        people[name] = True
    else:
        people[name] = False
        
for name in sorted(people.keys(), reverse=True):
    if people[name]:
        print(name)