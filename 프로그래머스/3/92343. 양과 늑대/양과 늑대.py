def solution(info, edges):
    visited = [False] * len(info)
    answer = []
    
    def dfs(sheep, wolf):
        if sheep > wolf:
            answer.append(sheep)
        else:
            return
            
        for s, e in edges:
            if visited[s] and not visited[e]:
                visited[e] = True
                if info[e] == 1:
                    dfs(sheep, wolf+1)
                else:
                    dfs(sheep+1, wolf)
                visited[e] = False
    visited[0] = True
    dfs(1, 0)
    return max(answer)