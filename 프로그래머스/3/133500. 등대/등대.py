import sys
from collections import deque

sys.setrecursionlimit(10**6)

answer = 0
def solution(n, lighthouse):

    edges = [[] for _ in range(n+1)]
    
    for s, e in lighthouse:
        edges[s].append(e)
        edges[e].append(s)
        
    def dfs(current, before):
        global answer
        if len(edges[current]) == 1 and edges[current][0] == before: # 리프노드
            return 1
        
        ret = 0
        for dest in edges[current]:
            if dest != before:
                ret += dfs(dest, current) # 리프노드가 아닌 노드의 주위에 불이 꺼진 노드를 찾음
        
        if ret > 0: # 불 꺼진 노드가 하나라도 있으면
            answer += 1
            return 0 # 불을 켠다.
        else:
            return 1
    
    # for i in range(1, n+1):
    #     if len(edges[i]) > 1:
    dfs(1, -1)
            # break
        
    return answer