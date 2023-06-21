import sys
from collections import defaultdict

input = sys.stdin.readline
dic = defaultdict(bool)
N = int(sys.stdin.readline().rstrip())
for _ in range(N):
    raw_commend = sys.stdin.readline().rstrip()
    if ' ' in raw_commend:
        commend, value = raw_commend.split(" ")
        value = int(value)
        if commend == "add":
            dic[value] = True
        elif commend == "remove":
            dic[value] = False
        elif commend == "check":
            print(1) if dic[value] else print(0)
        elif commend == "toggle":
            if dic[value]:
                dic[value] = False
            else:
                dic[value] = True
    else:
        commend = raw_commend
        if commend == "all":
            for i in range(1, 21):
                dic[i] = True
        elif commend == "empty":
            for i in range(1, 21):
                dic[i] = False