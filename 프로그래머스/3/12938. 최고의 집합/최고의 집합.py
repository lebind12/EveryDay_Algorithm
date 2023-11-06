def solution(n, s):
    answer = [s // n] * n
    if s < n:
        return [-1]
    for i in range(n-1, n-1-(s%n), -1):
        print(i)
        answer[i] += 1
    return answer