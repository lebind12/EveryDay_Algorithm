# XYZ 문자열
import sys


input = sys.stdin.readline
question_number = int(input())


def recursion(current, mem):
    if mem[current] != -1:
        return mem[current]
    
    front = recursion(current - 3, mem)
    back = recursion(current - 2, mem)
    
    mem[current] = front + back
    
    return front + back

def binary_search(index, mem, r):
    if index == 1:
        return 'X'
    elif index == 2:
        s = 'YZ'
        return s[r-1]
    elif index == 3:
        s = 'ZX'
        return s[r-1]
    
    # mem[index] = mem[index - 3] + mem[index - 2]
    if r > mem[index-3]:
        return binary_search(index - 2, mem, r - mem[index - 3])
    else:
        return binary_search(index - 3, mem, r)

def recursion_2(mem, current):
    if mem[current] != -1:
        return mem[current]
    
    front = recursion_2(mem, current - 3).split(' ')
    back = recursion_2(mem, current - 2).split(' ')
    mem[current] = f"{int(front[0]) + int(back[0])} {int(front[1]) + int(back[1])} {int(front[2]) + int(back[2])}"
    return mem[current]
    

if (question_number == 1): # N번째 XYZ 문자열의 길이
    a = [-1, 1, 2, 2] + ([-1] * 99)
    N = int(input())
    ret = recursion(N, a)
    print(ret)
elif (question_number == 2): # N번째 XYZ 문자열에서 k번째 문자
    a = [-1, 1, 2, 2] + ([-1] * 99)
    N = int(input())
    ret = recursion(N, a)
    k = int(input())
    
    # k가 앞에 있는지 뒤에 있는지
    print(binary_search(N, a, k))
elif (question_number == 3): # N번째 XYZ 문자열에서 특정한 문자가 몇 번 나타나는 지
    a = [-1, '1 0 0', '0 1 1', '1 0 1'] + ([-1] * 99)
    N = int(input())
    k = input().rstrip()
    recursion_2(a, N)
    
    if k == 'X':
        print(a[N].split(' ')[0])
    elif k == 'Y':
        print(a[N].split(' ')[1])
    elif k == 'Z':
        print(a[N].split(' ')[2])