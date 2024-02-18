import sys

def binary_search(left, right, array, value):
    pivot = (left + right) // 2        
    
    if array[pivot] == value:
        print(1)
        return
    elif value == array[right]:
        print(1)
        return
    elif pivot == left:
        print(0)
        return
    
    if value > array[pivot]:
        binary_search(pivot, right, array, value)
    else:
        binary_search(left, pivot, array, value)
    

input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split(' ')))
arr.sort()
M = int(input())
for v in list(map(int, input().split(' '))):
    binary_search(0, N-1, arr, v)