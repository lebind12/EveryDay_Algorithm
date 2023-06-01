from collections import defaultdict

def solution(k, tangerine):
    answer = 0
    d = defaultdict(int)
    for t in tangerine:
        d[t] += 1
    m = sorted(d, key = lambda x : -d[x])
    for i in m:
        if k >= d[i]:
            k -= d[i]
            answer += 1
        else:
            break
    if k > 0:
        answer += 1
    return answer