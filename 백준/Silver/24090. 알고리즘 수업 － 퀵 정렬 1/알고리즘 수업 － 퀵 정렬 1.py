import sys


input = sys.stdin.readline
sys.setrecursionlimit(10**4)
cnt = 0

def partition(A, p, r):
    global cnt
    x = A[r]
    i = p - 1
    for j in range(p, r):
        if A[j] <= x:
            i += 1
            A[i], A[j] = A[j], A[i]
            cnt += 1
            if cnt == K:
                print(min(A[i], A[j]), max(A[i], A[j]))
                exit()
    if i + 1 != r:
        A[i+1], A[r] = A[r], A[i+1]
        cnt += 1
        if cnt == K:
            print(min(A[i+1], A[r]), max(A[i+1], A[r]))
            exit()
    return i+1
        
def quick_sort(A : list, p : int, r : int):
    if (p < r):
        q = partition(A, p, r)
        quick_sort(A, p, q - 1)
        quick_sort(A, q + 1, r)

N, K = map(int, input().split(' '))
A = list(map(int, input().split(' ')))
quick_sort(A, 0, N-1)
if K > cnt:
    print(-1)