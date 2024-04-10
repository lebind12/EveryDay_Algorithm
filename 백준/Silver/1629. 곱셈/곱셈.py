A, B, C = map(int, input().split(' '))

def solution(A, B, C):
    if B == 1:
        return A % C
    r = solution(A, B // 2, C)
    r = r * r % C
    if B % 2 == 1:
        return ((r * A) % C)
    else:
        return (r)

print(solution(A, B, C))