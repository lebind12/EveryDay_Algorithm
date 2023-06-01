import sys


input = sys.stdin.readline
test_case = int(input())
while test_case:
    n = int(input())
    words = []
    is_NO = False
    for _ in range(n):
        words.append(input().rstrip())
    words.sort()
    for i in range(n-1):
        if words[i] == words[i+1][:len(words[i])]:
            is_NO = True
            break
    if is_NO:
        print("NO")
    else:
        print("YES")
    
    test_case -= 1