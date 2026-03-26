import sys
import itertools


dad = list(input().split())
mom = list(input().split())

sack = list(set(dad + mom))
# print(sack)

for data in sorted(list(itertools.product(sack, repeat=2))):
    print(" ".join(data))
