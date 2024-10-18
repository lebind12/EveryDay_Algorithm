import sys


sys.setrecursionlimit(100000)
heights = list(map(int, [sys.stdin.readline() for _ in range(9)]))
founded = False

def recursion(chosen: list, start: int):
    global founded
    
    if founded == True:
        return
    if (len(chosen)) == 7:
        if sum(chosen) == 100:
            founded = True
            for value in sorted(chosen):
                print(value)
            return
    
    if len(chosen) > 7:
        return
    
    choosed = chosen.copy()
    for i in range(start, len(heights)):
        choosed.append(heights[i])
        recursion(choosed, i+1)
        choosed.pop()

recursion([], 0)