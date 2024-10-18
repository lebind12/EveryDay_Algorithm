from collections import deque


def solution(n, computers):
    answer = 0
    
    visited = [False] * n
    w = len(computers[0])
    h = len(computers)
    for i in range(h):
        if not visited[i]:
            visited[i] = True
            answer += 1
            for j in range(i + 1, w):
                if computers[i][j] == 1 and not visited[j]:
                    queue = deque()
                    queue.append(j)

                    while queue:
                        node = queue.pop()
                        visited[node] = True
                        for k in range(w):
                            if computers[node][k] == 1 and not visited[k]:
                                queue.append(k)                            
    return answer