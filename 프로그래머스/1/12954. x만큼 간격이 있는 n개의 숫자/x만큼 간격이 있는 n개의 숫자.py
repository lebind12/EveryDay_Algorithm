def solution(x, n):
    answer = [x + (i * x) for i in range(n)]
    print(answer)
    return answer