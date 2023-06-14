N = int(input())
A = list(map(int, input().split(' ')))
B = list(map(int, input().split(' ')))

i = 1
answer = 0
while i < N:
    loc = i - 1
    new_item = A[i]
    
    while 0 <= loc and new_item < A[loc]:
        A[loc + 1] = A[loc]
        loc -= 1
        if A == B:
            answer = 1
            break
        if answer == 1:
            break
    if loc + 1 != i:
        A[loc + 1] = new_item
    
    if A == B:
        answer = 1
        break
    
    if answer == 1:
        break
    i += 1
print(answer)  