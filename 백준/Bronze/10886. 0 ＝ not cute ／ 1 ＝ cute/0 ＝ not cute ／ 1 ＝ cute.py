import sys


input = sys.stdin.readline
N = int(input())
is_cute = {"cute" : 0, "not_cute" : 0}
for _ in range(N):
    i = int(input())
    if i == 0:
        is_cute["not_cute"] += 1
    else:
        is_cute["cute"] += 1
if is_cute["not_cute"] > is_cute["cute"]:
    print("Junhee is not cute!")
else:
    print("Junhee is cute!")